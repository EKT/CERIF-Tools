/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Project_MeasurementId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257878320655302436L;

	/**
	 * The project.
	 */
	private Project project;
	
	/**
	 * The measurement.
	 */
	private Measurement measurement;
	
	/**
	 * The Class.
	 */
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
	 * @return the measurement
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * @param measuremnt the measurement to set
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
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
