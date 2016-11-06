package eu.mh.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Example of an Embedded object annotations
 * 
 * https://en.wikibooks.org/wiki/Java_Persistence/Embeddables
 * 
 * @author mh.bato
 *
 */
@Entity
public class Employee {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)		  
	  private Long id;
	  
	  
	  @Column
	  String firstname;

	  @Column
	  String lastname;

	  @Embedded
	  private EmploymentPeriod period;
	  
	  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public EmploymentPeriod getPeriod() {
		return period;
	}

	public void setPeriod(EmploymentPeriod period) {
		this.period = period;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", period=");
		builder.append(period);
		builder.append("]");
		return builder.toString();
	}

	  
}
