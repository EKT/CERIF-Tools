/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Facility_FacilityId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4460414852468803636L;

	/**
	 * The first facility.
	 */
	private Facility facility1;
	
	/**
	 * The second facility.
	 */
	private Facility facility2;
	
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
	 * @return the facility1
	 */
	public Facility getFacility1() {
		return facility1;
	}

	/**
	 * @param facility1 the facility1 to set
	 */
	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	/**
	 * @return the facility2
	 */
	public Facility getFacility2() {
		return facility2;
	}

	/**
	 * @param facility2 the facility2 to set
	 */
	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
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
