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
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.person.Person_PrizeId;

/**
 * 
 */
@Entity
@Table(name="cfPers_Prize")
@IdClass(Person_PrizeId.class)
public class Person_Prize implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 3214237859342907L;

	/**
	 * The person.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPersId")
	private Person person;
	
	/**
	 * The prize.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPrizeId")
	private Prize prize;
	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * The prize date.
	 */
	@Column (name="cfPrizeDate")
	private Date prizeDate;

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the prize
	 */
	public Prize getPrize() {
		return prize;
	}

	/**
	 * @param prize the prize to set
	 */
	public void setPrize(Prize prize) {
		this.prize = prize;
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

	/**
	 * @return the prizeDate
	 */
	public Date getPrizeDate() {
		return prizeDate;
	}

	/**
	 * @param prizeDate the prizeDate to set
	 */
	public void setPrizeDate(Date prizeDate) {
		this.prizeDate = prizeDate;
	}
}
