/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Event_EventId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4875063409068599444L;

	/**
	 * The first event. 
	 */
	private Event event1;
	
	/**
	 * The second event. 
	 */
	private Event event2;
	
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
	 * @return the event1
	 */
	public Event getEvent1() {
		return event1;
	}

	/**
	 * @param event1 the event1 to set
	 */
	public void setEvent1(Event event1) {
		this.event1 = event1;
	}

	/**
	 * @return the event2
	 */
	public Event getEvent2() {
		return event2;
	}

	/**
	 * @param event2 the event2 to set
	 */
	public void setEvent2(Event event2) {
		this.event2 = event2;
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
