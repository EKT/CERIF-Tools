/**
 * 
 */
package gr.ekt.cerif.pk.project;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

public class Project_OrganisationUnitId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8810720141425328717L;

	/**
	 * The project.
	 */
	private Project project;
	
	/**
	 * The organisation unit.
	 */
	private OrganisationUnit organisationUnit;
	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	private Date startDate;
		
	/**
	 * The end date.
	 */
	private Date endDate;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the organisationUnit
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * @param organisationUnit the organisationUnit to set
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
	}

	public Class getTheClass() {
		return theClass;
	}
	
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
	
}
