/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents an indicator second level entity.
 * 
 */
@Entity
@Table(name="cfIndic")
public class Indicator implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2859095654662437486L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfIndicId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

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
	@OneToMany(mappedBy="indicator")
	private Set<IndicatorName> indicatorNames;
	
	@OneToMany(mappedBy="indicator")
	private Set<IndicatorKeyword> indicatorKeywords;
	
	@OneToMany(mappedBy="indicator")
	private Set<IndicatorDescription> indicatorDescriptions;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="indicator")
	private Set<ResultPatent_Indicator> resultPatents_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<ResultProduct_Indicator> resultProducts_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<ResultPublication_Indicator> resultPublications_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Service_Indicator> services_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Equipment_Indicator> equipments_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Medium_Indicator> mediums_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Indicator_Measurement> indicators_measurements;
	
	@OneToMany(mappedBy="indicator")
	private Set<Indicator_Class> indicators_classes;
	
	@OneToMany(mappedBy="indicator")
	private Set<Person_Indicator> persons_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<OrganisationUnit_Indicator> organisationUnits_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Project_Indicator> projects_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Facility_Indicator> facilities_indicators;
	
	@OneToMany(mappedBy="indicator")
	private Set<Event_Indicator> events_indicators;
	
	@OneToMany(mappedBy="indicator1")
	private Set<Indicator_Indicator> indicators_indicators1;
	
	@OneToMany(mappedBy="indicator2")
	private Set<Indicator_Indicator> indicators_indicators2;
	
	@OneToMany(mappedBy="indicator")
	private Set<Funding_Indicator> fundings_indicators;

	
	/**
	 * FederatedIdentifier entities related to OrganisationUnit instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//


	/**
	 * Default Constructor
	 */
	public Indicator() {
		
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
	 * Returns the URI.
	 * @return the URI.
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the URI.
	 * @param uri the URI.
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
	 * @return the indicatorNames
	 */
	public Set<IndicatorName> getIndicatorNames() {
		return indicatorNames;
	}

	/**
	 * @param indicatorNames the indicatorNames to set
	 */
	public void setIndicatorNames(Set<IndicatorName> indicatorNames) {
		this.indicatorNames = indicatorNames;
	}

	/**
	 * @return the indicatorKeywords
	 */
	public Set<IndicatorKeyword> getIndicatorKeywords() {
		return indicatorKeywords;
	}

	/**
	 * @param indicatorKeywords the indicatorKeywords to set
	 */
	public void setIndicatorKeywords(Set<IndicatorKeyword> indicatorKeywords) {
		this.indicatorKeywords = indicatorKeywords;
	}

	/**
	 * @return the indicatorDescriptions
	 */
	public Set<IndicatorDescription> getIndicatorDescriptions() {
		return indicatorDescriptions;
	}

	/**
	 * @param indicatorDescriptions the indicatorDescriptions to set
	 */
	public void setIndicatorDescriptions(
			Set<IndicatorDescription> indicatorDescriptions) {
		this.indicatorDescriptions = indicatorDescriptions;
	}

	/**
	 * @return the resultPatents_indicators
	 */
	public Set<ResultPatent_Indicator> getResultPatents_indicators() {
		return resultPatents_indicators;
	}
	
	/**
	 * @param resultPatents_indicators the resultPatents_indicators to set
	 */
	public void setResultPatents_indicators(
			Set<ResultPatent_Indicator> resultPatents_indicators) {
		this.resultPatents_indicators = resultPatents_indicators;
	}
	
	/**
	 * @return the resultProducts_indicators
	 */
	public Set<ResultProduct_Indicator> getResultProducts_indicators() {
		return resultProducts_indicators;
	}
	
	/**
	 * @param resultProducts_indicators the resultProducts_indicators to set
	 */
	public void setResultProducts_indicators(
			Set<ResultProduct_Indicator> resultProducts_indicators) {
		this.resultProducts_indicators = resultProducts_indicators;
	}

	/**
	 * @return the resultPublications_indicators
	 */
	public Set<ResultPublication_Indicator> getResultPublications_indicators() {
		return resultPublications_indicators;
	}
	
	/**
	 * @param resultPublications_indicators the resultPublications_indicators to set
	 */
	public void setResultPublications_indicators(
			Set<ResultPublication_Indicator> resultPublications_indicators) {
		this.resultPublications_indicators = resultPublications_indicators;
	}

	/**
	 * @return the services_indicators
	 */
	public Set<Service_Indicator> getServices_indicators() {
		return services_indicators;
	}

	/**
	 * @param services_indicators the services_indicators to set
	 */
	public void setServices_indicators(Set<Service_Indicator> services_indicators) {
		this.services_indicators = services_indicators;
	}

	/**
	 * @return the equipments_indicators
	 */
	public Set<Equipment_Indicator> getEquipments_indicators() {
		return equipments_indicators;
	}

	/**
	 * @param equipments_indicators the equipments_indicators to set
	 */
	public void setEquipments_indicators(
			Set<Equipment_Indicator> equipments_indicators) {
		this.equipments_indicators = equipments_indicators;
	}

	/**
	 * @return the mediums_indicators
	 */
	public Set<Medium_Indicator> getMediums_indicators() {
		return mediums_indicators;
	}

	/**
	 * @param mediums_indicators the mediums_indicators to set
	 */
	public void setMediums_indicators(Set<Medium_Indicator> mediums_indicators) {
		this.mediums_indicators = mediums_indicators;
	}

	/**
	 * @return the indicators_measurements
	 */
	public Set<Indicator_Measurement> getIndicators_measurements() {
		return indicators_measurements;
	}

	/**
	 * @param indicators_measurements the indicators_measurements to set
	 */
	public void setIndicators_measurements(
			Set<Indicator_Measurement> indicators_measurements) {
		this.indicators_measurements = indicators_measurements;
	}

	/**
	 * @return the indicators_classes
	 */
	public Set<Indicator_Class> getIndicators_classes() {
		return indicators_classes;
	}

	/**
	 * @param indicators_classes the indicators_classes to set
	 */
	public void setIndicators_classes(Set<Indicator_Class> indicators_classes) {
		this.indicators_classes = indicators_classes;
	}

	/**
	 * @return the persons_indicators
	 */
	public Set<Person_Indicator> getPersons_indicators() {
		return persons_indicators;
	}

	/**
	 * @param persons_indicators the persons_indicators to set
	 */
	public void setPersons_indicators(Set<Person_Indicator> persons_indicators) {
		this.persons_indicators = persons_indicators;
	}

	/**
	 * @return the organisationUnits_indicators
	 */
	public Set<OrganisationUnit_Indicator> getOrganisationUnits_indicators() {
		return organisationUnits_indicators;
	}

	/**
	 * @param organisationUnits_indicators the organisationUnits_indicators to set
	 */
	public void setOrganisationUnits_indicators(
			Set<OrganisationUnit_Indicator> organisationUnits_indicators) {
		this.organisationUnits_indicators = organisationUnits_indicators;
	}

	/**
	 * @return the projects_indicators
	 */
	public Set<Project_Indicator> getProjects_indicators() {
		return projects_indicators;
	}

	/**
	 * @param projects_indicators the projects_indicators to set
	 */
	public void setProjects_indicators(Set<Project_Indicator> projects_indicators) {
		this.projects_indicators = projects_indicators;
	}

	/**
	 * @return the facilities_indicators
	 */
	public Set<Facility_Indicator> getFacilities_indicators() {
		return facilities_indicators;
	}

	/**
	 * @param facilities_indicators the facilities_indicators to set
	 */
	public void setFacilities_indicators(
			Set<Facility_Indicator> facilities_indicators) {
		this.facilities_indicators = facilities_indicators;
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
	 * @return the indicators_indicators1
	 */
	public Set<Indicator_Indicator> getIndicators_indicators1() {
		return indicators_indicators1;
	}

	/**
	 * @param indicators_indicators1 the indicators_indicators1 to set
	 */
	public void setIndicators_indicators1(
			Set<Indicator_Indicator> indicators_indicators1) {
		this.indicators_indicators1 = indicators_indicators1;
	}

	/**
	 * @return the indicators_indicators2
	 */
	public Set<Indicator_Indicator> getIndicators_indicators2() {
		return indicators_indicators2;
	}

	/**
	 * @param indicators_indicators2 the indicators_indicators2 to set
	 */
	public void setIndicators_indicators2(
			Set<Indicator_Indicator> indicators_indicators2) {
		this.indicators_indicators2 = indicators_indicators2;
	}

	/**
	 * @return the fundings_indicators
	 */
	public Set<Funding_Indicator> getFundings_indicators() {
		return fundings_indicators;
	}

	/**
	 * @param fundings_indicators the fundings_indicators to set
	 */
	public void setFundings_indicators(Set<Funding_Indicator> fundings_indicators) {
		this.fundings_indicators = fundings_indicators;
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
		Indicator other = (Indicator) obj;
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
		return "Indicator [id=" + id + ", uri=" + uri + ", uuid=" + uuid + "]";
	}


}
