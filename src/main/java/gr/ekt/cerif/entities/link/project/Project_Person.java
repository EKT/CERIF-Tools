/**
 * 
 */
package gr.ekt.cerif.entities.link.project;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.project.Project_PersonId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Links a project with an organization unit.
 * 
 */
@Entity
@Table(name="cfProj_Pers")
@IdClass(Project_PersonId.class)
public class Project_Person implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3052891621307942145L;

	/**
	 * The project.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfProjId")
	private Project project;
	
	/**
	 * The organisation unit.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPersId")
	private Person person;
	
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
	 * Returns the person.
	 * @return the person.
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 * @param person the person.
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	
}
