/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

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
@Table(name="cfClass_Class" , uniqueConstraints=@UniqueConstraint(columnNames={"cfClassId1","cfClassId2","cfClassId", "cfStartDate", "cfEndDate"}))
public class Class_Class implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4534975883109829233L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first class.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassId1")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass1;
	
	/**
	 * The second class.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassId2")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass2;
	
	/**
	 * The Class.
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
	 * Default Constructor
	 */
	public Class_Class() {
		
	}
	
	/**
	 * 
	 * @param theClass1
	 * @param theClass2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Class_Class(Class theClass1, Class theClass2, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.theClass1 = theClass1;
		this.theClass2 = theClass2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the theClass1
	 */
	public Class getTheClass1() {
		return theClass1;
	}

	/**
	 * @param theClass1 the theClass1 to set
	 */
	public void setTheClass1(Class theClass1) {
		this.theClass1 = theClass1;
	}

	/**
	 * @return the theClass2
	 */
	public Class getTheClass2() {
		return theClass2;
	}

	/**
	 * @param theClass2 the theClass2 to set
	 */
	public void setTheClass2(Class theClass2) {
		this.theClass2 = theClass2;
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
}
