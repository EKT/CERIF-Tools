/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
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
 * Links a project with an organization unit.
 * 
 */
@Entity
@Table(name="cfProj_Proj", uniqueConstraints=@UniqueConstraint(columnNames={"cfProjId1", "cfProjId2", "cfClassId", "cfStartDate", "cfEndDate"}) )
public class Project_Project implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8816705520013381180L;	

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The project.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfProjId1")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Project project1;
	
	/**
	 * The project connected to
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfProjId2")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Project project2;
	
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
	 * Default Constructor
	 */
	public Project_Project() {
		
	}
	
	/**
	 * 
	 * @param project1
	 * @param project2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Project_Project(Project project1, Project project2,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.project1 = project1;
		this.project2 = project2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
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

	/**
	 * @return the project1
	 */
	public Project getProject1() {
		return project1;
	}

	/**
	 * @param project1 the project1 to set
	 */
	public void setProject1(Project project1) {
		this.project1 = project1;
	}

	/**
	 * @return the project2
	 */
	public Project getProject2() {
		return project2;
	}

	/**
	 * @param project2 the project2 to set
	 */
	public void setProject2(Project project2) {
		this.project2 = project2;
	}
	
	/**
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the fraction.
	 * @return the fraction.
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * Sets the fraction.
	 * @param fraction the fraction.
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}	

	/**
	 * Returns the class.
	 * @return the class.
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * Sets the class.
	 * @param theClass the class.
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project_Project [id=" + id + ", project1=" + project1
				+ ", project2=" + project2 + ", theClass=" + theClass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fraction=" + fraction + "]";
	}
	
	
}
