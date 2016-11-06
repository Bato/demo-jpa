package eu.mh.jpa.domain;

import javax.persistence.Column;

/**
 * Example of an Embeddable object annotations
 * 
 * @author mh.bato
 *
 */
public class EmploymentPeriod {

	  @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmploymentPeriod [startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	@Column(name="START_DATE")
	  private java.sql.Date startDate;

	  @Column(name="END_DATE")
	  private java.sql.Date endDate;
}
