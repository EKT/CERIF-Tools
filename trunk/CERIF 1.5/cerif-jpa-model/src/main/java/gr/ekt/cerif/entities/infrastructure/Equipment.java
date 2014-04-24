/**
 * 
 */
package gr.ekt.cerif.entities.infrastructure;

import java.util.List;
import java.util.Set;

import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.Equipment_Equipment;
import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents an equipment second level entity.
 */
@Entity
@Table(name="cfEquip")
public class Equipment implements CerifInfrastructureEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -240908659483900668L;	
	
	/**
	 * The equipment id.
	 */
	@Id
	@Column(name="cfEquipId")
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
	@OneToMany(mappedBy="equipment")
	private Set<EquipmentName> names;
	
	@OneToMany(mappedBy="equipment")
	private Set<EquipmentKeyword> keywords;
	
	@OneToMany(mappedBy="equipment")
	private Set<EquipmentDescription> descriptions;

	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="equipment")
	private Set<Project_Equipment> projects_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<Person_Equipment> persons_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<ResultPublication_Equipment> resultPublications_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Service> equipments_services;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Funding> equipments_fundings;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Class> classes;
	
	@OneToMany(mappedBy="equipment")
	private Set<OrganisationUnit_Equipment> organisationUnits_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Medium> equipments_medium;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_PostalAddress> equipments_postalAddresses;
	
	@OneToMany(mappedBy="equipment1")
	private Set<Equipment_Equipment> equipment_equipment1;
	
	@OneToMany(mappedBy="equipment2")
	private Set<Equipment_Equipment> equipment_equipment2;
	
	@OneToMany(mappedBy="equipment")
	private Set<Facility_Equipment> facilities_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Event> equipments_events;
	
	@OneToMany(mappedBy="equipment")
	private Set<ResultPatent_Equipment> resultPatents_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<ResultProduct_Equipment> resultProducts_equipments;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Indicator> equipments_indicators;
	
	@OneToMany(mappedBy="equipment")
	private Set<Equipment_Measurement> equipments_measurements;
	
	
	/**
	 * FederatedIdentifier entities related to Equipment instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;	
	
	// ---------------------------------------------------------------------- //

	/**
	 * Default Constructor
	 */
	public Equipment() { 
		
	}
	
	/**
	 * 
	 * @param acronym
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public Equipment(String acronym, String uri,
			Set<EquipmentName> names, Set<EquipmentKeyword> keywords,
			Set<EquipmentDescription> descriptions) {
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
	 * @return the names
	 */
	public Set<EquipmentName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<EquipmentName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<EquipmentKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<EquipmentKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<EquipmentDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<EquipmentDescription> descriptions) {
		this.descriptions = descriptions;
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
	 * @return the resultPublications_equipments
	 */
	public Set<ResultPublication_Equipment> getResultPublications_equipments() {
		return resultPublications_equipments;
	}
	
	/**
	 * @param resultPublications_equipments the resultPublications_equipments to set
	 */
	public void setResultPublications_equipments(
			Set<ResultPublication_Equipment> resultPublications_equipments) {
		this.resultPublications_equipments = resultPublications_equipments;
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
	 * @return the classes
	 */
	public Set<Equipment_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<Equipment_Class> classes) {
		this.classes = classes;
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
	 * @return the equipments_medium
	 */
	public Set<Equipment_Medium> getEquipments_medium() {
		return equipments_medium;
	}

	/**
	 * @param equipments_medium the equipments_medium to set
	 */
	public void setEquipments_medium(Set<Equipment_Medium> equipments_medium) {
		this.equipments_medium = equipments_medium;
	}

	/**
	 * @return the equipments_postalAddresses
	 */
	public Set<Equipment_PostalAddress> getEquipments_postalAddresses() {
		return equipments_postalAddresses;
	}

	/**
	 * @param equipments_postalAddresses the equipments_postalAddresses to set
	 */
	public void setEquipments_postalAddresses(
			Set<Equipment_PostalAddress> equipments_postalAddresses) {
		this.equipments_postalAddresses = equipments_postalAddresses;
	}

	/**
	 * @return the equipment_equipment1
	 */
	public Set<Equipment_Equipment> getEquipment_equipment1() {
		return equipment_equipment1;
	}

	/**
	 * @param equipment_equipment1 the equipment_equipment1 to set
	 */
	public void setEquipment_equipment1(
			Set<Equipment_Equipment> equipment_equipment1) {
		this.equipment_equipment1 = equipment_equipment1;
	}

	/**
	 * @return the equipment_equipment2
	 */
	public Set<Equipment_Equipment> getEquipment_equipment2() {
		return equipment_equipment2;
	}

	/**
	 * @param equipment_equipment2 the equipment_equipment2 to set
	 */
	public void setEquipment_equipment2(
			Set<Equipment_Equipment> equipment_equipment2) {
		this.equipment_equipment2 = equipment_equipment2;
	}

	/**
	 * @return the facilities_equipments
	 */
	public Set<Facility_Equipment> getFacilities_equipments() {
		return facilities_equipments;
	}

	/**
	 * @param facilities_equipments the facilities_equipments to set
	 */
	public void setFacilities_equipments(
			Set<Facility_Equipment> facilities_equipments) {
		this.facilities_equipments = facilities_equipments;
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
	 * @return the resultPatents_equipments
	 */
	public Set<ResultPatent_Equipment> getResultPatents_equipments() {
		return resultPatents_equipments;
	}

	/**
	 * @param resultPatents_equipments the resultPatents_equipments to set
	 */
	public void setResultPatents_equipments(
			Set<ResultPatent_Equipment> resultPatents_equipments) {
		this.resultPatents_equipments = resultPatents_equipments;
	}

	/**
	 * @return the resultProducts_equipments
	 */
	public Set<ResultProduct_Equipment> getResultProducts_equipments() {
		return resultProducts_equipments;
	}

	/**
	 * @param resultProducts_equipments the resultProducts_equipments to set
	 */
	public void setResultProducts_equipments(
			Set<ResultProduct_Equipment> resultProducts_equipments) {
		this.resultProducts_equipments = resultProducts_equipments;
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
	 * @return the equipments_measurements
	 */
	public Set<Equipment_Measurement> getEquipments_measurements() {
		return equipments_measurements;
	}

	/**
	 * @param equipments_measurements the equipments_measurements to set
	 */
	public void setEquipments_measurements(
			Set<Equipment_Measurement> equipments_measurements) {
		this.equipments_measurements = equipments_measurements;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", acronym=" + acronym + ", uri=" + uri
				+ ", uuid=" + uuid + "]";
	}


}
