/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Class_ClassId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="cfClass_Class")
@IdClass(Class_ClassId.class)
public class Class_Class implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4534975883109829233L;
	
	/**
	 * The first class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId1")
	private Class theClass1;
	
	/**
	 * The second class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId2")
	private Class theClass2;
	
	/**
	 * The Class.
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
}
