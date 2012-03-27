/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.pk.ClassScheme_ClassSchemeId;

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
@Table(name="cfClassScheme_ClassScheme")
@IdClass(ClassScheme_ClassSchemeId.class)
public class ClassScheme_ClassScheme implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2855044663638508241L;
	
	
	/**
	 * The first class scheme.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassSchemeId1")	
	private ClassScheme classScheme1;
	
	/**
	 * The second class scheme.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassSchemeId2")	
	private ClassScheme classScheme2;
	
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
	 * @return the classScheme1
	 */
	public ClassScheme getClassScheme1() {
		return classScheme1;
	}

	/**
	 * @param classScheme1 the classScheme1 to set
	 */
	public void setClassScheme1(ClassScheme classScheme1) {
		this.classScheme1 = classScheme1;
	}

	/**
	 * @return the classScheme2
	 */
	public ClassScheme getClassScheme2() {
		return classScheme2;
	}

	/**
	 * @param classScheme2 the classScheme2 to set
	 */
	public void setClassScheme2(ClassScheme classScheme2) {
		this.classScheme2 = classScheme2;
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
