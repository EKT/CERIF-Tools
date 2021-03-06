/**
 * 
 */
package gr.ekt.cerif.entities.infrastructure;

import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.Service_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;

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
 * Represents a service second level entity.
 */
@Entity
@Table(name="cfSrv")
public class Service implements CerifInfrastructureEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8420804898605631508L;
	
	/**
	 * The service id.
	 */
	@Id
	@Column(name="cfSrvId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The acronym.
	 */
	@Column(name="cfAcro")
	private String acronym;
	
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
	@OneToMany(mappedBy="service")
	private Set<ServiceName> serviceNames;
	
	@OneToMany(mappedBy="service")
	private Set<ServiceDescription> serviceDescriptions;
	
	@OneToMany(mappedBy="service")
	private Set<ServiceKeyword> serviceKeywords;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="service")
	private Set<Service_Class> services_classes;
	
	@OneToMany(mappedBy="service")
	private Set<OrganisationUnit_Service> organisationUnits_services;
	
	@OneToMany(mappedBy="service")
	private Set<Person_Service> persons_services;
	
	@OneToMany(mappedBy="service")
	private Set<Project_Service> projects_services;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Funding> services_fundings;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Medium> services_mediums;
	
	@OneToMany(mappedBy="service")
	private Set<Service_PostalAddress> services_postalAddresses;
	
	@OneToMany(mappedBy="service1")
	private Set<Service_Service> services_services1;
	
	@OneToMany(mappedBy="service2")
	private Set<Service_Service> services_services2;
	
	@OneToMany(mappedBy="service")
	private Set<Facility_Service> facilities_services;
	
	@OneToMany(mappedBy="service")
	private Set<Equipment_Service> equipments_services;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Event> services_events;
	
	@OneToMany(mappedBy="service")
	private Set<ResultPublication_Service> resultPublications_services;
	
	@OneToMany(mappedBy="service")
	private Set<ResultPatent_Service> resultPatents_services;
	
	@OneToMany(mappedBy="service")
	private Set<ResultProduct_Service> resultProducts_services;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Indicator> services_indicators;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Measurement> services_measurements;
	
	@OneToMany(mappedBy="service")
	private Set<Service_FederatedIdentifier> services_federatedIdentifiers;
	
	
	/**
	 * FederatedIdentifier entities related to Service instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;	
	
	// ---------------------------------------------------------------------- //

	/**
	 * Default Constructor
	 */
	public Service() {
		
	}
	
	/**
	 * 
	 * @param acronym
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Service(String acronym, String uri, Set<ServiceName> serviceNames,
			Set<ServiceKeyword> serviceKeywords, Set<ServiceDescription> serviceDescriptions) {
		this.acronym = acronym;
		this.uri = uri;
		this.serviceNames = serviceNames;
		this.serviceKeywords = serviceKeywords;
		this.serviceDescriptions = serviceDescriptions;
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
	 * @return the acronym
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * @param acronym the acronym to set
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
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
	 * @return the serviceNames
	 */
	public Set<ServiceName> getServiceNames() {
		return serviceNames;
	}

	/**
	 * @param serviceNames the serviceNames to set
	 */
	public void setServiceNames(Set<ServiceName> serviceNames) {
		this.serviceNames = serviceNames;
	}

	/**
	 * @return the serviceDescriptions
	 */
	public Set<ServiceDescription> getServiceDescriptions() {
		return serviceDescriptions;
	}

	/**
	 * @param serviceDescriptions the serviceDescriptions to set
	 */
	public void setServiceDescriptions(Set<ServiceDescription> serviceDescriptions) {
		this.serviceDescriptions = serviceDescriptions;
	}

	/**
	 * @return the serviceKeywords
	 */
	public Set<ServiceKeyword> getServiceKeywords() {
		return serviceKeywords;
	}

	/**
	 * @param serviceKeywords the serviceKeywords to set
	 */
	public void setServiceKeywords(Set<ServiceKeyword> serviceKeywords) {
		this.serviceKeywords = serviceKeywords;
	}

	/**
	 * @return the services_classes
	 */
	public Set<Service_Class> getServices_classes() {
		return services_classes;
	}

	/**
	 * @param services_classes the services_classes to set
	 */
	public void setServices_classes(Set<Service_Class> services_classes) {
		this.services_classes = services_classes;
	}

	/**
	 * @return the organisationUnits_services
	 */
	public Set<OrganisationUnit_Service> getOrganisationUnits_services() {
		return organisationUnits_services;
	}

	/**
	 * @param organisationUnits_services the organisationUnits_services to set
	 */
	public void setOrganisationUnits_services(
			Set<OrganisationUnit_Service> organisationUnits_services) {
		this.organisationUnits_services = organisationUnits_services;
	}

	/**
	 * @return the persons_services
	 */
	public Set<Person_Service> getPersons_services() {
		return persons_services;
	}

	/**
	 * @param persons_services the persons_services to set
	 */
	public void setPersons_services(Set<Person_Service> persons_services) {
		this.persons_services = persons_services;
	}

	/**
	 * @return the projects_services
	 */
	public Set<Project_Service> getProjects_services() {
		return projects_services;
	}

	/**
	 * @param projects_services the projects_services to set
	 */
	public void setProjects_services(Set<Project_Service> projects_services) {
		this.projects_services = projects_services;
	}

	/**
	 * @return the services_fundings
	 */
	public Set<Service_Funding> getServices_fundings() {
		return services_fundings;
	}

	/**
	 * @param services_fundings the services_fundings to set
	 */
	public void setServices_fundings(Set<Service_Funding> services_fundings) {
		this.services_fundings = services_fundings;
	}

	/**
	 * @return the services_mediums
	 */
	public Set<Service_Medium> getServices_mediums() {
		return services_mediums;
	}

	/**
	 * @param services_mediums the services_mediums to set
	 */
	public void setServices_mediums(Set<Service_Medium> services_mediums) {
		this.services_mediums = services_mediums;
	}

	/**
	 * @return the services_services1
	 */
	public Set<Service_Service> getServices_services1() {
		return services_services1;
	}

	/**
	 * @param services_services1 the services_services1 to set
	 */
	public void setServices_services1(Set<Service_Service> services_services1) {
		this.services_services1 = services_services1;
	}

	/**
	 * @return the services_services2
	 */
	public Set<Service_Service> getServices_services2() {
		return services_services2;
	}

	/**
	 * @param services_services2 the services_services2 to set
	 */
	public void setServices_services2(Set<Service_Service> services_services2) {
		this.services_services2 = services_services2;
	}

	/**
	 * @return the facilities_services
	 */
	public Set<Facility_Service> getFacilities_services() {
		return facilities_services;
	}

	/**
	 * @param facilities_services the facilities_services to set
	 */
	public void setFacilities_services(Set<Facility_Service> facilities_services) {
		this.facilities_services = facilities_services;
	}

	/**
	 * @return the equipments_services
	 */
	public Set<Equipment_Service> getEquipments_services() {
		return equipments_services;
	}

	/**
	 * @param equipments_services the equipments_services to set
	 */
	public void setEquipments_services(Set<Equipment_Service> equipments_services) {
		this.equipments_services = equipments_services;
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
	 * @return the resultPublications_services
	 */
	public Set<ResultPublication_Service> getResultPublications_services() {
		return resultPublications_services;
	}

	/**
	 * @param resultPublications_services the resultPublications_services to set
	 */
	public void setResultPublications_services(
			Set<ResultPublication_Service> resultPublications_services) {
		this.resultPublications_services = resultPublications_services;
	}

	/**
	 * @return the resultPatents_services
	 */
	public Set<ResultPatent_Service> getResultPatents_services() {
		return resultPatents_services;
	}

	/**
	 * @param resultPatents_services the resultPatents_services to set
	 */
	public void setResultPatents_services(
			Set<ResultPatent_Service> resultPatents_services) {
		this.resultPatents_services = resultPatents_services;
	}

	/**
	 * @return the resultProducts_services
	 */
	public Set<ResultProduct_Service> getResultProducts_services() {
		return resultProducts_services;
	}

	/**
	 * @param resultProducts_services the resultProducts_services to set
	 */
	public void setResultProducts_services(
			Set<ResultProduct_Service> resultProducts_services) {
		this.resultProducts_services = resultProducts_services;
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
	 * @return the services_measurements
	 */
	public Set<Service_Measurement> getServices_measurements() {
		return services_measurements;
	}

	/**
	 * @param services_measurements the services_measurements to set
	 */
	public void setServices_measurements(
			Set<Service_Measurement> services_measurements) {
		this.services_measurements = services_measurements;
	}

	/**
	 * @return the services_federatedIdentifiers
	 */
	public Set<Service_FederatedIdentifier> getServices_federatedIdentifiers() {
		return services_federatedIdentifiers;
	}

	/**
	 * @param services_federatedIdentifiers the services_federatedIdentifiers to set
	 */
	public void setServices_federatedIdentifiers(
			Set<Service_FederatedIdentifier> services_federatedIdentifiers) {
		this.services_federatedIdentifiers = services_federatedIdentifiers;
	}

	/**
	 * @return the services_postalAddresses
	 */
	public Set<Service_PostalAddress> getServices_postalAddresses() {
		return services_postalAddresses;
	}

	/**
	 * @param services_postalAddresses the services_postalAddresses to set
	 */
	public void setServices_postalAddresses(
			Set<Service_PostalAddress> services_postalAddresses) {
		this.services_postalAddresses = services_postalAddresses;
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
		Service other = (Service) obj;
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
		return "Service [id=" + id + ", acronym=" + acronym + ", uri=" + uri
				+ ", uuid=" + uuid + "]";
	}

	
}
