/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
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
 * Links a project with an organization unit.
 * 
 */
@Entity
@Table(name="cfProj_OrgUnit", uniqueConstraints=@UniqueConstraint(columnNames={"cfProjId", "cfOrgUnitId", "cfClassId", "cfStartDate", "cfEndDate"}) )
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Project_OrganisationUnit implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3186734945489123417L;

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
	@JoinColumn(name="cfProjId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Project project;
	
	/**
	 * The organisation unit.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfOrgUnitId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private OrganisationUnit organisationUnit;
	
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
	public Project_OrganisationUnit() {
		
	}
	
	/**
	 * 
	 * @param project
	 * @param organisationUnit
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Project_OrganisationUnit(Project project,
			OrganisationUnit organisationUnit, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.project = project;
		this.organisationUnit = organisationUnit;
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
	 * Returns the organisation.
	 * @return the organisation.
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * Sets the organisation.
	 * @param organisationUnit the organisation.
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
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
	 * Returns the project.
	 * @return the project.
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 * @param project the project.
	 */
	public void setProject(Project project) {
		this.project = project;
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
		return "Project_OrganisationUnit [id=" + id + ", project=" + project
				+ ", organisationUnit=" + organisationUnit + ", theClass="
				+ theClass + ", startDate=" + startDate + ", endDate="
				+ endDate + ", fraction=" + fraction + "]";
	}
	
	
}
