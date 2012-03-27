/**
 * 
 */
package gr.ekt.cerif.entities.link.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.person.Person_PersonId;

/**
 * 
 */
@Entity
@Table(name="cfPers_Pers")
@IdClass(Person_PersonId.class)
public class Person_Person implements CerifLinkEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -54329051360347895L;
	
	/**
	 * The first person.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPersId1")
	private Person person1;

	/**
	 * The second person.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPersId2")
	private Person person2;

	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@Id
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Id
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	/**
	 * @return the person1
	 */
	public Person getPerson1() {
		return person1;
	}

	/**
	 * @param person1 the person1 to set
	 */
	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	/**
	 * @return the person2
	 */
	public Person getPerson2() {
		return person2;
	}

	/**
	 * @param person2 the person2 to set
	 */
	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}
}

