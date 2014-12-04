/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Represents an event second level entity.
 * 
 */
@Entity
@Table(name="cfEvent")
public class Event implements CerifSecondLevelEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1669435471604238900L;	
	
	/**
	 * The event unique identifier.
	 */
	@Id
	@Column(name="cfEventId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The country code.
	 */
	@ManyToOne
	@JoinColumn(name="cfCountryCode", nullable=false)
	private Country country;
	
	/**
	 * The city/town.
	 */
	@Column(name="cfCityTown")
	private String cityTown;
	
	/**
	 * The city/town.
	 */
	@Column(name="cfFeeOrFree", nullable=false)
	private String feeOrFree;
	
	/**
	 * The start date.
	 */
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="event")
	private Set<EventName> eventNames;
	
	@OneToMany(mappedBy="event")
	private Set<EventKeyword> eventKeywords;
	
	@OneToMany(mappedBy="event")
	private Set<EventDescription> eventDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="event")
	private Set<Project_Event> projects_events;
	
	@OneToMany(mappedBy="event")
	private Set<Person_Event> persons_events;
	
	@OneToMany(mappedBy="event")
	private Set<ResultPublication_Event> resultPublications_events;
	
	@OneToMany(mappedBy="event")
	private Set<Event_Class> events_classes;
	
	@OneToMany(mappedBy="event")
	private Set<OrganisationUnit_Event> organisationUnits_events;
	
	@OneToMany(mappedBy="event")
	private Set<Service_Event> services_events;
	
	@OneToMany(mappedBy="event")
	private Set<Equipment_Event> equipments_events;
	
	@OneToMany(mappedBy="event")
	private Set<Event_Medium> events_mediums;
	
	@OneToMany(mappedBy="event")
	private Set<Event_Indicator> events_indicators;
	
	@OneToMany(mappedBy="event")
	private Set<Event_Measurement> events_measurements;
	
	@OneToMany(mappedBy="event1")
	private Set<Event_Event> events_events1;
	
	@OneToMany(mappedBy="event2")
	private Set<Event_Event> events_events2;
	
	@OneToMany(mappedBy="event")
	private Set<Facility_Event> facilities_events;
	
	@OneToMany(mappedBy="event")
	private Set<Event_Funding> events_fundings;
	
	
	/**
	 * FederatedIdentifier entities related to Event instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//
	

	/**
	 * Default Constructor
	 */
	public Event() {
		
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
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the cityTown
	 */
	public String getCityTown() {
		return cityTown;
	}

	/**
	 * @param cityTown the cityTown to set
	 */
	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	/**
	 * @return the feeOrFree
	 */
	public String getFeeOrFree() {
		return feeOrFree;
	}

	/**
	 * @param feeOrFree the feeOrFree to set
	 */
	public void setFeeOrFree(String feeOrFree) {
		this.feeOrFree = feeOrFree;
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
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the eventNames
	 */
	public Set<EventName> getEventNames() {
		return eventNames;
	}

	/**
	 * @param eventNames the eventNames to set
	 */
	public void setEventNames(Set<EventName> eventNames) {
		this.eventNames = eventNames;
	}

	/**
	 * @return the eventKeywords
	 */
	public Set<EventKeyword> getEventKeywords() {
		return eventKeywords;
	}

	/**
	 * @param eventKeywords the eventKeywords to set
	 */
	public void setEventKeywords(Set<EventKeyword> eventKeywords) {
		this.eventKeywords = eventKeywords;
	}

	/**
	 * @return the eventDescriptions
	 */
	public Set<EventDescription> getEventDescriptions() {
		return eventDescriptions;
	}

	/**
	 * @param eventDescriptions the eventDescriptions to set
	 */
	public void setEventDescriptions(Set<EventDescription> eventDescriptions) {
		this.eventDescriptions = eventDescriptions;
	}

	/**
	 * @return the projects_events
	 */
	public Set<Project_Event> getProjects_events() {
		return projects_events;
	}

	/**
	 * @param projects_events the projects_events to set
	 */
	public void setProjects_events(Set<Project_Event> projects_events) {
		this.projects_events = projects_events;
	}
	
	/**
	 * @return the persons_events
	 */
	public Set<Person_Event> getPersons_events() {
		return persons_events;
	}
	
	/**
	 * @param persons_events the persons_events to set
	 */
	public void setPersons_events(Set<Person_Event> persons_events) {
		this.persons_events = persons_events;
	}
	
	/**
	 * @return the resultPublications_events
	 */
	public Set<ResultPublication_Event> getResultPublications_events() {
		return resultPublications_events;
	}
	
	/**
	 * @param resultPublications_events the resultPublications_events to set
	 */
	public void setResultPublications_events(
			Set<ResultPublication_Event> resultPublications_events) {
		this.resultPublications_events = resultPublications_events;
	}
	
	/**
	 * @return the events_classes
	 */
	public Set<Event_Class> getEvents_classes() {
		return events_classes;
	}

	/**
	 * @param events_classes the events_classes to set
	 */
	public void setEvents_classes(Set<Event_Class> events_classes) {
		this.events_classes = events_classes;
	}

	/**
	 * @return the services_events
	 */
	public Set<Service_Event> getServices_events() {
		return services_events;
	}

	/**
	 * @param services_events the services_events to set
	 */
	public void setServices_events(Set<Service_Event> services_events) {
		this.services_events = services_events;
	}

	/**
	 * @return the equipments_events
	 */
	public Set<Equipment_Event> getEquipments_events() {
		return equipments_events;
	}

	/**
	 * @param equipments_events the equipments_events to set
	 */
	public void setEquipments_events(Set<Equipment_Event> equipments_events) {
		this.equipments_events = equipments_events;
	}

	/**
	 * @return the events_mediums
	 */
	public Set<Event_Medium> getEvents_mediums() {
		return events_mediums;
	}

	/**
	 * @param events_mediums the events_mediums to set
	 */
	public void setEvents_mediums(Set<Event_Medium> events_mediums) {
		this.events_mediums = events_mediums;
	}

	/**
	 * @return the events_indicators
	 */
	public Set<Event_Indicator> getEvents_indicators() {
		return events_indicators;
	}

	/**
	 * @param events_indicators the events_indicators to set
	 */
	public void setEvents_indicators(Set<Event_Indicator> events_indicators) {
		this.events_indicators = events_indicators;
	}

	/**
	 * @return the events_measurements
	 */
	public Set<Event_Measurement> getEvents_measurements() {
		return events_measurements;
	}

	/**
	 * @param events_measurements the events_measurements to set
	 */
	public void setEvents_measurements(Set<Event_Measurement> events_measurements) {
		this.events_measurements = events_measurements;
	}

	/**
	 * @return the events_events1
	 */
	public Set<Event_Event> getEvents_events1() {
		return events_events1;
	}

	/**
	 * @param events_events1 the events_events1 to set
	 */
	public void setEvents_events1(Set<Event_Event> events_events1) {
		this.events_events1 = events_events1;
	}

	/**
	 * @return the events_events2
	 */
	public Set<Event_Event> getEvents_events2() {
		return events_events2;
	}

	/**
	 * @param events_events2 the events_events2 to set
	 */
	public void setEvents_events2(Set<Event_Event> events_events2) {
		this.events_events2 = events_events2;
	}

	/**
	 * @return the organisationUnits_events
	 */
	public Set<OrganisationUnit_Event> getOrganisationUnits_events() {
		return organisationUnits_events;
	}

	/**
	 * @param organisationUnits_events the organisationUnits_events to set
	 */
	public void setOrganisationUnits_events(
			Set<OrganisationUnit_Event> organisationUnits_events) {
		this.organisationUnits_events = organisationUnits_events;
	}

	/**
	 * @return the facilities_events
	 */
	public Set<Facility_Event> getFacilities_events() {
		return facilities_events;
	}

	/**
	 * @param facilities_events the facilities_events to set
	 */
	public void setFacilities_events(Set<Facility_Event> facilities_events) {
		this.facilities_events = facilities_events;
	}

	/**
	 * @return the events_fundings
	 */
	public Set<Event_Funding> getEvents_fundings() {
		return events_fundings;
	}

	/**
	 * @param events_fundings the events_fundings to set
	 */
	public void setEvents_fundings(Set<Event_Funding> events_fundings) {
		this.events_fundings = events_fundings;
	}

	/**
	 * @return the federatedIdentifiers
	 */
	public List<FederatedIdentifier> getFederatedIdentifiers() {
		return federatedIdentifiers;
	}

	/**
	 * @param federatedIdentifiers the federatedIdentifiers to set
	 */
	public void setFederatedIdentifiers(
			List<FederatedIdentifier> federatedIdentifiers) {
		this.federatedIdentifiers = federatedIdentifiers;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [id=" + id + ", country=" + country + ", cityTown="
				+ cityTown + ", feeOrFree=" + feeOrFree + ", startDate="
				+ startDate + ", endDate=" + endDate + ", uri=" + uri
				+ ", uuid=" + uuid + "]";
	}


}
