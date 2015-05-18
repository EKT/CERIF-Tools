package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;

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

@Entity
@Table(name="cfPersName_Class", uniqueConstraints=@UniqueConstraint(columnNames={"cfPersNameId", "cfClassId", "cfStartDate", "cfEndDate"}) )
public class PersonName_Class implements ICerifClassEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4357871277926125518L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The person name.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPersNameId")
	private PersonName personName;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
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
	 * @param personName
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public PersonName_Class(PersonName personName, Class theClass,
			Date startDate, Date endDate) {
		super();
		this.personName = personName;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * Default Constructor
	 */
	public PersonName_Class() {
		super();
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
	 * @return the personName
	 */
	public PersonName getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(PersonName personName) {
		this.personName = personName;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonName_Class [id=" + id + ", personName=" + personName
				+ ", theClass=" + theClass + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fraction=" + fraction + "]";
	}

	
}
