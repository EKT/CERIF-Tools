/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.project.Project_PrizeAwardId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Links a project with a prize award.
 * 
 */
@Entity
@Table(name="cfProj_Prize")
@IdClass(Project_PrizeAwardId.class)
public class Project_PrizeAward implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7934613965896425349L;

	/**
	 * The project.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfProjId")
	private Project project;
	
	/**
	 * The prize award.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPrizeId")
	private Prize prizeAward;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")
	private Class theClass;
		
	/**
	 * The prize date.
	 */
	@Id
	@Column (name="cfPrizeDate")
	private Date prizeDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	
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

}
