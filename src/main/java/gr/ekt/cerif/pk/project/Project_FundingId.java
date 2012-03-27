/**
 * 
 */
package gr.ekt.cerif.pk.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

public class Project_FundingId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3263566367339301201L;

	/**
	 * The project.
	 */
	private Project project;
	
	/**
	 * The funding connected to
	 */	
	private Funding funding;
	
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
	 * @return the funding
	 */
	public Funding getFunding() {
		return funding;
	}

	/**
	 * @param funding the funding to set
	 */
	public void setFunding(Funding funding) {
		this.funding = funding;
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
