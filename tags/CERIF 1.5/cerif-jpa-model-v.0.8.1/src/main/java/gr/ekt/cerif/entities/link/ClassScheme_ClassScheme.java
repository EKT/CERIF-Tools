/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

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
@Table(name="cfClassScheme_ClassScheme", uniqueConstraints=@UniqueConstraint(columnNames={"cfClassSchemeId1","cfClassSchemeId2","cfClassId", "cfStartDate", "cfEndDate"}))
public class ClassScheme_ClassScheme implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2855044663638508241L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	/**
	 * The first class scheme.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassSchemeId1")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ClassScheme classScheme1;
	
	/**
	 * The second class scheme.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassSchemeId2")	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ClassScheme classScheme2;
	
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
	public ClassScheme_ClassScheme() {
		
	}
	
	/**
	 * 
	 * @param classScheme1
	 * @param classScheme2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ClassScheme_ClassScheme(ClassScheme classScheme1,
			ClassScheme classScheme2, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.classScheme1 = classScheme1;
		this.classScheme2 = classScheme2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassScheme_ClassScheme [id=" + id + ", classScheme1="
				+ classScheme1 + ", classScheme2=" + classScheme2
				+ ", theClass=" + theClass + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fraction=" + fraction + "]";
	}

	
}
