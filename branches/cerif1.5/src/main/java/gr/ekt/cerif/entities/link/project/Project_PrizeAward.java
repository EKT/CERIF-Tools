/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Prize;
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

/**
 * Links a project with a prize award.
 * 
 */
@Entity
@Table(name="cfProj_Prize", uniqueConstraints=@UniqueConstraint(columnNames={"cfProjId","cfPrizeId","cfClassId","cfPrizeDate"}))
public class Project_PrizeAward implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7934613965896425349L;

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
	private Project project;
	
	/**
	 * The prize award.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPrizeId")
	private Prize prizeAward;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
	private Class theClass;
		
	/**
	 * The prize date.
	 */
	@NotNull
	@Column (name="cfPrizeDate")
	private Date prizeDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	
	/**
	 * Default Constructor
	 */
	public Project_PrizeAward() {
		
	}
	
	/**
	 * 
	 * @param project
	 * @param prizeAward
	 * @param theClass
	 * @param prizeDate
	 * @param fraction
	 */
	public Project_PrizeAward(Project project, Prize prizeAward,
			Class theClass, Date prizeDate, Double fraction) {
		this.project = project;
		this.prizeAward = prizeAward;
		this.theClass = theClass;
		this.prizeDate = prizeDate;
		this.fraction = fraction;
	}

	/**
	 * Returns the prize date.
	 * @return the prize date.
	 */
	public Date getPrizeDate() {
		return prizeDate;
	}

	/**
	 * Sets the prize date.
	 * @param prizeDate the prize date.
	 */
	public void setPrizeDate(Date prizeDate) {
		this.prizeDate = prizeDate;
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

	public Prize getPrizeAward() {
		return prizeAward;
	}

	public void setPrizeAward(Prize prizeAward) {
		this.prizeAward = prizeAward;
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
