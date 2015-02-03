/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
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
@Table(name="cfExpSkills_Class", uniqueConstraints=@UniqueConstraint(columnNames={"cfExpSkillsId", "cfClassId", "cfStartDate", "cfEndDate"}))
public class ExpertiseAndSkills_Class implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5732063884882746913L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The expertise and skills.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfExpSkillsId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ExpertiseAndSkills expertiseAndSkills;
	
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
	public ExpertiseAndSkills_Class() { 
		
	}
	
	/**
	 * 
	 * @param expertiseAndSkills
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public ExpertiseAndSkills_Class(ExpertiseAndSkills expertiseAndSkills,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.expertiseAndSkills = expertiseAndSkills;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the expertiseAndSkills
	 */
	public ExpertiseAndSkills getExpertiseAndSkills() {
		return expertiseAndSkills;
	}

	/**
	 * @param expertiseAndSkills the expertiseAndSkills to set
	 */
	public void setExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills) {
		this.expertiseAndSkills = expertiseAndSkills;
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
		return "ExpertiseAndSkills_Class [id=" + id + ", expertiseAndSkills="
				+ expertiseAndSkills + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + "]";
	}

	
}
