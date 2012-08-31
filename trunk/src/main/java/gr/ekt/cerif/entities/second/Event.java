/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Represents an event second level entity.
 * 
 */
@Entity
@Table(name="cfEvent")
public class Event implements CerifSecondLevelEntity{

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
	@ManyToOne(cascade=CascadeType.ALL)
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
	 * The link entities of projects and events.
	 */
	@OneToMany(mappedBy="event")
	private Set<Project_Event> projects_events;
	
	@OneToMany(mappedBy="event")
	private Set<EventName> names;
	
	@OneToMany(mappedBy="event")
	private Set<EventKeyword> keywords;
	
	@OneToMany(mappedBy="event")
	private Set<EventDescription> descriptions;

	@OneToMany(mappedBy="event")
	private Set<Person_Event> persons_events;
	
	@OneToMany(mappedBy="event")
	private Set<ResultPublication_Event> resultPublications_events;
	
	@OneToMany(mappedBy="event")
	private Set<Event_Class> classes;
	
	@OneToMany(mappedBy="event")
	private Set<OrganisationUnit_Event> organisationUnit_events;
	

	/**
	 * Default Constructor
	 */
	public Event() {
		
	}
	
	/**
	 * 
	 * @param country
	 * @param cityTown
	 * @param feeOrFree
	 * @param startDate
	 * @param endDate
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 * @param classes
	 */
	public Event(Country country, String cityTown, String feeOrFree,
			Date startDate, Date endDate, String uri, Set<EventName> names,
			Set<EventKeyword> keywords, Set<EventDescription> descriptions,
			Set<Event_Class> classes, Set<OrganisationUnit_Event> organisationUnit_events) {
		this.country = country;
		this.cityTown = cityTown;
		this.feeOrFree = feeOrFree;
		this.startDate = startDate;
		this.endDate = endDate;
		this.uri = uri;
		this.names = names;
		this.keywords = keywords;
		this.descriptions = descriptions;
		this.classes = classes;
		this.organisationUnit_events = organisationUnit_events;
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
	 * @return the names
	 */
	public Set<EventName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<EventName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<EventKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<EventKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<EventDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<EventDescription> descriptions) {
		this.descriptions = descriptions;
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
	 * @return the classes
	 */
	public Set<Event_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Event_Class> classes) {
		this.classes = classes;
	}
	
	/**
	 * @return the organisationUnit_events
	 */
	public Set<OrganisationUnit_Event> getOrganisationUnit_Event() {
		return organisationUnit_events;
	}

	/**
	 * @param organisationUnit_events the organisationUnit_events to set
	 */
	public void setOrganisationUnit_Event(Set<OrganisationUnit_Event> organisationUnit_events) {
		this.organisationUnit_events = organisationUnit_events;
	}


}
