/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Measurement_MeasurementId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6456948637624339915L;

	/**
	 * The first measurement.
	 */
	private Measurement measurement1;

	/**
	 * The second measurement.
	 */
	private Measurement measurement2;
	
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
	 * @return the measurement1
	 */
	public Measurement getMeasurement1() {
		return measurement1;
	}

	/**
	 * @param measurement1 the measurement1 to set
	 */
	public void setMeasurement1(Measurement measurement1) {
		this.measurement1 = measurement1;
	}

	/**
	 * @return the measurement2
	 */
	public Measurement getMeasurement2() {
		return measurement2;
	}

	/**
	 * @param measurement2 the measurement2 to set
	 */
	public void setMeasurement2(Measurement measurement2) {
		this.measurement2 = measurement2;
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
