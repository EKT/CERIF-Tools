/**
 * 
 */
package gr.ekt.cerif.pk.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

public class Project_ProjectId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8810720141425328717L;

	/**
	 * The project.
	 */
	private Project project1;
	
	/**
	 * The project connected to
	 */	
	private Project project2;
	
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
