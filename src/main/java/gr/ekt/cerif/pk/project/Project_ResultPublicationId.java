/**
 * 
 */
package gr.ekt.cerif.pk.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

public class Project_ResultPublicationId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8181748121651304507L;

	/**
	 * The project.
	 */
	private Project project;
	
	/**
	 * The result Publication connected to
	 */	
	private ResultPublication resultPublication;
	
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
