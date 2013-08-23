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
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;

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
	
	@OneToMany(mappedBy="service")
	private Set<ServiceName> names;
	
	@OneToMany(mappedBy="service")
	private Set<ServiceDescription> descriptions;
	
	@OneToMany(mappedBy="service")
	private Set<ServiceKeyword> keywords;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Class> services_classes;
	
	@OneToMany(mappedBy="service")
	private Set<OrganisationUnit_Service> organisationUnit_services;
	
	@OneToMany(mappedBy="service")
	private Set<Person_Service> persons_services;
	
	@OneToMany(mappedBy="service")
	private Set<Project_Service> projects_services;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Funding> services_fundings;
	
	@OneToMany(mappedBy="service")
	private Set<Service_Medium> services_mediums;
	
	@OneToMany(mappedBy="service")
	private Set<Service_PostalAddress> services_postalAdresses;
	
	@OneToMany(mappedBy="service1")
	private Set<Service_Service> services_services1;
	
	@OneToMany(mappedBy="service2")
	private Set<Service_Service> services_services2;
	
	@OneToMany(mappedBy="service")
	private Set<Facility_Service> facilities_services;
	
	@OneToMany(mappedBy="service")
	private Set<Equipment_Service> equipment_services;
	
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
	public Service(String acronym, String uri, Set<ServiceName> names,
			Set<ServiceKeyword> keywords, Set<ServiceDescription> descriptions) {
		this.acronym = acronym;
		this.uri = uri;
		this.names = names;
		this.keywords = keywords;
		this.descriptions = descriptions;
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
	 * @return the names
	 */
	public Set<ServiceName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<ServiceName> names) {
		this.names = names;
	}

	/**
	 * @return the descriptions
	 */
	public Set<ServiceDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<ServiceDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the keywords
	 */
	public Set<ServiceKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<ServiceKeyword> keywords) {
		this.keywords = keywords;
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
	 * @return the organisationUnit_services
	 */
	public Set<OrganisationUnit_Service> getOrganisationUnit_services() {
		return organisationUnit_services;
	}

	/**
	 * @param organisationUnit_services the organisationUnit_services to set
	 */
	public void setOrganisationUnit_services(
			Set<OrganisationUnit_Service> organisationUnit_services) {
		this.organisationUnit_services = organisationUnit_services;
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
	 * @return the services_postalAdresses
	 */
	public Set<Service_PostalAddress> getServices_postalAdresses() {
		return services_postalAdresses;
	}

	/**
	 * @param services_postalAdresses the services_postalAdresses to set
	 */
	public void setServices_postalAdresses(
			Set<Service_PostalAddress> services_postalAdresses) {
		this.services_postalAdresses = services_postalAdresses;
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
	 * @return the equipment_services
	 */
	public Set<Equipment_Service> getEquipment_services() {
		return equipment_services;
	}

	/**
	 * @param equipment_services the equipment_services to set
	 */
	public void setEquipment_services(Set<Equipment_Service> equipment_services) {
		this.equipment_services = equipment_services;
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
}
