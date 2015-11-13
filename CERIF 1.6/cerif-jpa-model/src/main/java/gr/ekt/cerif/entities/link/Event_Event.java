/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * 
 */
@Entity
@Table(name="cfEvent_Event", uniqueConstraints=@UniqueConstraint(columnNames={"cfEventId1","cfEventId2", "cfClassId", "cfStartDate", "cfEndDate"}))
public class Event_Event implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3612321328579120871L;
	
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The event. 
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfEventId1")
	private Event event1;
	
	/**
	 * The event. 
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfEventId2")
	private Event event2;
	
	/**
	 * The Class.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	/**
	 * Default Constructor
	 */
	public Event_Event() {
		
	}
	
	/**
	 * 
	 * @param event1
	 * @param event2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public Event_Event(Event event1, Event event2, Class theClass,
			Date startDate, Date endDate) {
		this.event1 = event1;
		this.event2 = event2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}

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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event_Event [id=" + id + ", event1=" + event1 + ", event2="
				+ event2 + ", theClass=" + theClass + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	
}
