/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;
import gr.ekt.cerif.features.multilingual.CurrencyName;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a currency second level entity.
 * 
 */
@Entity
@Table(name="cfCurrency")
public class Currency implements CerifSecondLevelEntity {
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 87304389612480632L;

	/**
	 * The currency code.
	 */
	@Id
	@Column(name="cfCurrCode", length=5)
	private String code;

	@Column(name="cfNumCurrCode", length=3)
	private String numeric;
	
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
	@OneToMany(mappedBy="currency")
	private Set<CurrencyName> currencyNames;
	
	@OneToMany(mappedBy="currency")
	private Set<CurrencyEntityName> entityNames;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit> organisationUnits;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_ResultProducts;
	
	@OneToMany(mappedBy="currency")
	private Set<Funding> fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Equipment> projects_equipments;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Facility> projects_facilities;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Service> projects_services;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Funding> projects_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Currency_Class> currencies_classes;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_Equipment> organisationUnits_equipments;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_ExpertiseAndSkills> organisationUnits_expertiseAndSkills;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_Facility> organisationUnits_facilities;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_Funding> organisationUnits_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_Service> organisationUnits_services;
	
	@OneToMany(mappedBy="currency")
	private Set<Person_Equipment> persons_equipments;
	
	@OneToMany(mappedBy="currency")
	private Set<Person_ExpertiseAndSkills> persons_expertiseAndSkills;
	
	@OneToMany(mappedBy="currency")
	private Set<Person_Facility> persons_facilities;
	
	@OneToMany(mappedBy="currency")
	private Set<Person_Funding> persons_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Person_ResultProduct> persons_resultProducts;
	
	@OneToMany(mappedBy="currency")
	private Set<Person_Service> persons_services;
	
	@OneToMany(mappedBy="currency")
	private Set<ResultPatent_Funding> resultPatents_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<ResultProduct_Funding> resultProducts_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<ResultPublication_Funding> resultPublications_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Equipment_Funding> equipments_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Event_Funding> events_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Facility_Funding> facilities_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Funding_Indicator> fundings_indicators;
	
	@OneToMany(mappedBy="currency")
	private Set<Funding_Measurement> fundings_measurements;
	
	@OneToMany(mappedBy="currency")
	private Set<Medium_Funding> mediums_fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Service_Funding> services_fundings;

	
	//----------------------------------------------------------------------------------------------//
	
	/**
	 * Default Constructor
	 */
	public Currency(){
		
	}
	
	/**
	 * Returns the code.
	 * @return the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * @param code the code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the numeric
	 */
	public String getNumeric() {
		return numeric;
	}

	/**
	 * @param numeric the numeric to set
	 */
	public void setNumeric(String numeric) {
		this.numeric = numeric;
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
	 * @return the currencyNames
	 */
	public Set<CurrencyName> getCurrencyNames() {
		return currencyNames;
	}

	/**
	 * @param currencyNames the currencyNames to set
	 */
	public void setCurrencyNames(Set<CurrencyName> currencyNames) {
		this.currencyNames = currencyNames;
	}

	/**
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(Set<OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}

	/**
	 * @return the organisationUnits_ResultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnits_ResultProducts() {
		return organisationUnits_ResultProducts;
	}

	/**
	 * @param organisationUnits_ResultProducts the organisationUnits_ResultProducts to set
	 */
	public void setOrganisationUnits_ResultProducts(
			Set<OrganisationUnit_ResultProduct> organisationUnits_ResultProducts) {
		this.organisationUnits_ResultProducts = organisationUnits_ResultProducts;
	}

	/**
	 * @return the fundings
	 */
	public Set<Funding> getFundings() {
		return fundings;
	}

	/**
	 * @param fundings the fundings to set
	 */
	public void setFundings(Set<Funding> fundings) {
		this.fundings = fundings;
	}

	/**
	 * @return the projects_equipments
	 */
	public Set<Project_Equipment> getProjects_equipments() {
		return projects_equipments;
	}

	/**
	 * @param projects_equipments the projects_equipments to set
	 */
	public void setProjects_equipments(Set<Project_Equipment> projects_equipments) {
		this.projects_equipments = projects_equipments;
	}

	/**
	 * @return the projects_facilities
	 */
	public Set<Project_Facility> getProjects_facilities() {
		return projects_facilities;
	}

	/**
	 * @param projects_facilities the projects_facilities to set
	 */
	public void setProjects_facilities(Set<Project_Facility> projects_facilities) {
		this.projects_facilities = projects_facilities;
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
	 * @return the projects_fundings
	 */
	public Set<Project_Funding> getProjects_fundings() {
		return projects_fundings;
	}

	/**
	 * @param projects_fundings the projects_fundings to set
	 */
	public void setProjects_fundings(Set<Project_Funding> projects_fundings) {
		this.projects_fundings = projects_fundings;
	}

	/**
	 * @return the entityNames
	 */
	public Set<CurrencyEntityName> getEntityNames() {
		return entityNames;
	}

	/**
	 * @param entityNames the entityNames to set
	 */
	public void setEntityNames(Set<CurrencyEntityName> entityNames) {
		this.entityNames = entityNames;
	}

	/**
	 * @return the currencies_classes
	 */
	public Set<Currency_Class> getCurrencies_classes() {
		return currencies_classes;
	}

	/**
	 * @param currencies_classes the currencies_classes to set
	 */
	public void setCurrencies_classes(Set<Currency_Class> currencies_classes) {
		this.currencies_classes = currencies_classes;
	}

	
	/**
	 * @return the organisationUnits_equipments
	 */
	public Set<OrganisationUnit_Equipment> getOrganisationUnits_equipments() {
		return organisationUnits_equipments;
	}

	/**
	 * @param organisationUnits_equipments the organisationUnits_equipments to set
	 */
	public void setOrganisationUnits_equipments(
			Set<OrganisationUnit_Equipment> organisationUnits_equipments) {
		this.organisationUnits_equipments = organisationUnits_equipments;
	}

	/**
	 * @return the organisationUnits_expertiseAndSkills
	 */
	public Set<OrganisationUnit_ExpertiseAndSkills> getOrganisationUnits_expertiseAndSkills() {
		return organisationUnits_expertiseAndSkills;
	}

	/**
	 * @param organisationUnits_expertiseAndSkills the organisationUnits_expertiseAndSkills to set
	 */
	public void setOrganisationUnits_expertiseAndSkills(
			Set<OrganisationUnit_ExpertiseAndSkills> organisationUnits_expertiseAndSkills) {
		this.organisationUnits_expertiseAndSkills = organisationUnits_expertiseAndSkills;
	}

	/**
	 * @return the organisationUnits_facilities
	 */
	public Set<OrganisationUnit_Facility> getOrganisationUnits_facilities() {
		return organisationUnits_facilities;
	}

	/**
	 * @param organisationUnits_facilities the organisationUnits_facilities to set
	 */
	public void setOrganisationUnits_facilities(
			Set<OrganisationUnit_Facility> organisationUnits_facilities) {
		this.organisationUnits_facilities = organisationUnits_facilities;
	}

	/**
	 * @return the organisationUnits_fundings
	 */
	public Set<OrganisationUnit_Funding> getOrganisationUnits_fundings() {
		return organisationUnits_fundings;
	}

	/**
	 * @param organisationUnits_fundings the organisationUnits_fundings to set
	 */
	public void setOrganisationUnits_fundings(
			Set<OrganisationUnit_Funding> organisationUnits_fundings) {
		this.organisationUnits_fundings = organisationUnits_fundings;
	}

	/**
	 * @return the organisationUnits_resultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnits_resultProducts() {
		return organisationUnits_resultProducts;
	}

	/**
	 * @param organisationUnits_resultProducts the organisationUnits_resultProducts to set
	 */
	public void setOrganisationUnits_resultProducts(
			Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts) {
		this.organisationUnits_resultProducts = organisationUnits_resultProducts;
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
	 * @return the persons_equipments
	 */
	public Set<Person_Equipment> getPersons_equipments() {
		return persons_equipments;
	}

	/**
	 * @param persons_equipments the persons_equipments to set
	 */
	public void setPersons_equipments(Set<Person_Equipment> persons_equipments) {
		this.persons_equipments = persons_equipments;
	}

	/**
	 * @return the persons_expertiseAndSkills
	 */
	public Set<Person_ExpertiseAndSkills> getPersons_expertiseAndSkills() {
		return persons_expertiseAndSkills;
	}

	/**
	 * @param persons_expertiseAndSkills the persons_expertiseAndSkills to set
	 */
	public void setPersons_expertiseAndSkills(
			Set<Person_ExpertiseAndSkills> persons_expertiseAndSkills) {
		this.persons_expertiseAndSkills = persons_expertiseAndSkills;
	}

	/**
	 * @return the persons_facilities
	 */
	public Set<Person_Facility> getPersons_facilities() {
		return persons_facilities;
	}

	/**
	 * @param persons_facilities the persons_facilities to set
	 */
	public void setPersons_facilities(Set<Person_Facility> persons_facilities) {
		this.persons_facilities = persons_facilities;
	}

	/**
	 * @return the persons_fundings
	 */
	public Set<Person_Funding> getPersons_fundings() {
		return persons_fundings;
	}

	/**
	 * @param persons_fundings the persons_fundings to set
	 */
	public void setPersons_fundings(Set<Person_Funding> persons_fundings) {
		this.persons_fundings = persons_fundings;
	}

	/**
	 * @return the persons_resultProducts
	 */
	public Set<Person_ResultProduct> getPersons_resultProducts() {
		return persons_resultProducts;
	}

	/**
	 * @param persons_resultProducts the persons_resultProducts to set
	 */
	public void setPersons_resultProducts(
			Set<Person_ResultProduct> persons_resultProducts) {
		this.persons_resultProducts = persons_resultProducts;
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
	 * @return the resultPatents_fundings
	 */
	public Set<ResultPatent_Funding> getResultPatents_fundings() {
		return resultPatents_fundings;
	}

	/**
	 * @param resultPatents_fundings the resultPatents_fundings to set
	 */
	public void setResultPatents_fundings(
			Set<ResultPatent_Funding> resultPatents_fundings) {
		this.resultPatents_fundings = resultPatents_fundings;
	}

	/**
	 * @return the resultProducts_fundings
	 */
	public Set<ResultProduct_Funding> getResultProducts_fundings() {
		return resultProducts_fundings;
	}

	/**
	 * @param resultProducts_fundings the resultProducts_fundings to set
	 */
	public void setResultProducts_fundings(
			Set<ResultProduct_Funding> resultProducts_fundings) {
		this.resultProducts_fundings = resultProducts_fundings;
	}

	/**
	 * @return the resultPublications_fundings
	 */
	public Set<ResultPublication_Funding> getResultPublications_fundings() {
		return resultPublications_fundings;
	}

	/**
	 * @param resultPublications_fundings the resultPublications_fundings to set
	 */
	public void setResultPublications_fundings(
			Set<ResultPublication_Funding> resultPublications_fundings) {
		this.resultPublications_fundings = resultPublications_fundings;
	}

	/**
	 * @return the equipments_fundings
	 */
	public Set<Equipment_Funding> getEquipments_fundings() {
		return equipments_fundings;
	}

	/**
	 * @param equipments_fundings the equipments_fundings to set
	 */
	public void setEquipments_fundings(Set<Equipment_Funding> equipments_fundings) {
		this.equipments_fundings = equipments_fundings;
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
	 * @return the facilities_fundings
	 */
	public Set<Facility_Funding> getFacilities_fundings() {
		return facilities_fundings;
	}

	/**
	 * @param facilities_fundings the facilities_fundings to set
	 */
	public void setFacilities_fundings(Set<Facility_Funding> facilities_fundings) {
		this.facilities_fundings = facilities_fundings;
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
	 * @return the fundings_measurements
	 */
	public Set<Funding_Measurement> getFundings_measurements() {
		return fundings_measurements;
	}

	/**
	 * @param fundings_measurements the fundings_measurements to set
	 */
	public void setFundings_measurements(
			Set<Funding_Measurement> fundings_measurements) {
		this.fundings_measurements = fundings_measurements;
	}

	/**
	 * @return the mediums_fundings
	 */
	public Set<Medium_Funding> getMediums_fundings() {
		return mediums_fundings;
	}

	/**
	 * @param mediums_fundings the mediums_fundings to set
	 */
	public void setMediums_fundings(Set<Medium_Funding> mediums_fundings) {
		this.mediums_fundings = mediums_fundings;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Currency [code=" + code + ", numeric=" + numeric + ", uri="
				+ uri + ", uuid=" + uuid + "]";
	}


	
}
