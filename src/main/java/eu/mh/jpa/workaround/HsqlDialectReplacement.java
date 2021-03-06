package eu.mh.jpa.workaround;

import org.hibernate.boot.Metadata;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.mapping.Table;
import org.hibernate.tool.schema.spi.Exporter;

/**
 * Workaround.
 * 
 * @see https://hibernate.onjira.com/browse/HHH-7002
 * 
 */
public class HsqlDialectReplacement extends HSQLDialect {

	@Override
	public String getDropTableString(String tableName) {
		// Append CASCADE to formatted DROP TABLE string
		final String superDrop = super.getDropTableString(tableName);
		return superDrop + " cascade";
	}

	@Override
	public boolean dropConstraints() {
		// Do not explicitly drop constraints, use DROP TABLE ... CASCADE
		return false;
	}

	@Override
	public Exporter<Table> getTableExporter() {
		// Must override TableExporter because it also formulates DROP TABLE
		// strings
		synchronized (this) {
			if (null == overrideExporter) {
				overrideExporter = new HsqlExporter(super.getTableExporter());
			}
		}

		return overrideExporter;
	}

	private Exporter<Table> overrideExporter = null;

	private static class HsqlExporter implements Exporter<Table> {
		HsqlExporter(Exporter<Table> impl) {
			this.impl = impl;
		}

		@Override
		public String[] getSqlCreateStrings(Table exportable, Metadata metadata) {
			return impl.getSqlCreateStrings(exportable, metadata);
		}

		@Override
		public String[] getSqlDropStrings(Table exportable, Metadata metadata) {
			final String[] implDrop = impl.getSqlDropStrings(exportable, metadata);
			final String[] dropStrings = new String[implDrop.length];
			for (int i = 0; i < implDrop.length; ++i) {
				dropStrings[i] = implDrop[i] + " cascade";
			}
			return dropStrings;
		}

		private final Exporter<Table> impl;
	};
}