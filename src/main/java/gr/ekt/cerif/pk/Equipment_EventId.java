/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Equipment_EventId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4311270417062150419L;

	/**
	 * The equipment.
	 */
	private Equipment equipment;
	
	/**
	 * The event. 
	 */
	private Event event;
	
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
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
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
