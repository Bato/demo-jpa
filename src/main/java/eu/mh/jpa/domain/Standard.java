package eu.mh.jpa.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

import org.hibernate.annotations.BatchSize;

/**
 * collection table
 * Storing a Map<String,String> using JPA
 * 
 * JPA 2.0 supports collections of primitives through the @ElementCollection annotation
 * @author mh.bato
 *
 */
@Entity(name = "standard")
public class Standard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;


	@Column( unique = true, nullable = false, length = 50)
	private String name;

	@Column( nullable = false, length = 50)
	private String institution;
	
	@Column( nullable = false, length = 50)
	private String released;
	
	@Column( nullable = false)
	boolean isWithdrawn = false;
	


	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "standards_titles", joinColumns = @JoinColumn(name = "standard_id") )
	@MapKeyColumn(name = "language", length = 2)
	@Column(name="title", length=100)
	private Map<String, String> titles = new HashMap<String, String>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="standards_abstracts", joinColumns = @JoinColumn(name = "standard_id") )
	@MapKeyColumn(name="language", length = 2)
	@Column(name="abstract", length=255)
	@BatchSize(size = 20)
	private Map<String, String> abstracts = new HashMap<String, String>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	public Map<String, String> getTitles() {
		return titles;
	}

	public void setTitles(Map<String, String> titles) {
		this.titles = titles;
	}

	public Map<String, String> getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(Map<String, String> customValues) {
		this.abstracts = customValues;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public boolean isWithdrawn() {
		return isWithdrawn;
	}

	public void setWithdrawn(boolean isWithdrawn) {
		this.isWithdrawn = isWithdrawn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CollectionTableExample [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", institution=");
		builder.append(institution);
		builder.append(", released=");
		builder.append(released);
		builder.append(", isWithdrawn=");
		builder.append(isWithdrawn);
		builder.append(", titles=");
		builder.append(titles);
		builder.append(", abstracts=");
		builder.append(abstracts);
		builder.append("]");
		return builder.toString();
	}
	



}
