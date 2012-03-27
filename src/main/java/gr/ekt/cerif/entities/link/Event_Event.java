/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Event_EventId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="cfEvent_Event")
@IdClass(Event_EventId.class)
public class Event_Event implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3612321328579120871L;
	
	/**
	 * The event. 
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfEventId1")
	private Event event1;
	
	/**
	 * The event. 
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfEventId2")
	private Event event2;
	
	/**
	 * The Class.
	 */
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
