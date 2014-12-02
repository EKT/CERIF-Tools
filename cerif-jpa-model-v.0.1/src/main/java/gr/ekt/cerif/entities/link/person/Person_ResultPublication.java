/**
 * 
 */
package gr.ekt.cerif.entities.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 */
@Entity
@Table(name="cfPers_ResPubl", uniqueConstraints=@UniqueConstraint(columnNames={"cfPersId", "cfResPublId", "cfClassId", "cfStartDate", "cfEndDate"}) )
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Person_ResultPublication implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1234789053289068689L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The person.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPersId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Person person;
	
	/**
	 * The result publication.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfResPublId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultPublication resultPublication;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * The copyright.
	 */
	@Column(name="cfCopyright")
	private String copyright;

	/**
	 * Default Constructor
	 */
	public Person_ResultPublication(){
		
	}
	
	/**
	 * 
	 * @param person
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param copyright
	 */
	public Person_ResultPublication(Person person,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate, Double fraction, String copyright) {
		this.person = person;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.copyright = copyright;
	}
	
	/**
	 * 
	 * @param person
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * 
	 */
	public Person_ResultPublication(Person person,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.person = person;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}
	
	/**
	 * @param person
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public Person_ResultPublication(Person person,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate) {
		this.person = person;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the resultPublication
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * @param resultPublication the resultPublication to set
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
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

	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person_ResultPublication [id=" + id + ", person=" + person
				+ ", resultPublication=" + resultPublication + ", theClass="
				+ theClass + ", startDate=" + startDate + ", endDate="
				+ endDate + ", fraction=" + fraction + ", copyright="
				+ copyright + "]";
	}

	
}