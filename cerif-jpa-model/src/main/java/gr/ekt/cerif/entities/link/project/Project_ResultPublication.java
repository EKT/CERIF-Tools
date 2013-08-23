/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.Project;
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
 * Links a project with a result publication.
 * 
 */
@Entity
@Table(name="cfProj_ResPubl", uniqueConstraints=@UniqueConstraint(columnNames={"cfProjId","cfResPublId","cfClassId","cfStartDate","cfEndDate"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Project_ResultPublication implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 1627049422091063641L;
	
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
	private Double copyright;

	/**
	 * Default Constructor
	 */
	public Project_ResultPublication() {
		
	}
	
	/**
	 * 
	 * @param project
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param copyright
	 */
	public Project_ResultPublication(Project project,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate, Double fraction, Double copyright) {
		this.project = project;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.copyright = copyright;
	}
	
	/**
	 * 
	 * @param project
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public Project_ResultPublication(Project project,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate) {
		this.project = project;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * 
	 * @param project
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Project_ResultPublication(Project project,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.project = project;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
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
	
	/**
	 * Returns the copyright.
	 * @return the copyright.
	 */
	public Double getCopyright() {
		return copyright;
	}

	/**
	 * Sets the copyright.
	 * @param copyright the copyright.
	 */
	public void setCopyright(Double copyright) {
		this.copyright = copyright;
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
