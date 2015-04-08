/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.CurriculumVitae;
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
@Table(name="cfCV_Class", uniqueConstraints=@UniqueConstraint(columnNames={"cfCVId", "cfClassId", "cfStartDate", "cfEndDate"}))
public class CurriculumVitae_Class implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9131289991723282407L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The CV.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfCVId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private CurriculumVitae curriculumVitae;
	
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
	public CurriculumVitae_Class() {
		
	}
	
	/**
	 * 
	 * @param curriculumVitae
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public CurriculumVitae_Class(CurriculumVitae curriculumVitae, Class theClass, Date startDate, Date endDate,
			Double fraction) {
		this.curriculumVitae = curriculumVitae;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the curriculumVitae
	 */
	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}

	/**
	 * @param curriculumVitae the curriculumVitae to set
	 */
	public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
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
		return "Cv_Class [id=" + id + ", curriculumVitae=" + curriculumVitae + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + "]";
	}
	
	
}
