/**
 * 
 */
package gr.ekt.cerif.features.semantics;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.entities.link.Cv_Class;
import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.ExpertiseAndSkills_Class;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassTerm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a classification semantic.
 * 
 */
@Entity
@Table(name="cfClass")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Class implements CerifSemanticFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3602671648727049566L;

	/**
	 * The classification unique identifier.
	 */
	@Id
	@Column(name="cfClassId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The start date.
	 */
	@Column(name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column(name="cfEndDate")
	private Date endDate;
	
	/**
	 * The URI.
	 */
	@Column(name="cfUri")
	private String uri;
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	/**
	 * The classification scheme.
	 */
	@ManyToOne
	@JoinColumn (name = "cfClassSchemeId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ClassScheme scheme;

	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="theClass")
	private Set<Project_OrganisationUnit> project_organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultProduct> person_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultProduct> orgUnit_resultProducts;	
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Class> resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Class> persons;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_GeographicBoundingBox> resultProduct_GeographicBoundingBoxes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Project> projects;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Class> projects_classes;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Equipment> projects_equipments;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Event> projects_events;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Facility> projects_facilities;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Funding> projects_fundings;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Prize> projects_prizes;

	@OneToMany(mappedBy="theClass")
	private Set<Project_ResultPatent> projects_resultPatents;

	@OneToMany(mappedBy="theClass")
	private Set<Project_ResultPublication> projects_resultPublications;

	@OneToMany(mappedBy="theClass")
	private Set<Project_ResultProduct> projects_resultProducts;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Service> projects_services;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Person> projects_persons;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Class> resultPatents_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Class> organisationUnits_classes;	
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Class> resultPublications_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<ElectronicAddress_Class> electronicAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Class> facilities_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Equipment> facilities_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Event> facilities_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Facility> facilities_facilities;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Funding> facilities_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Indicator> facilities_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Measurement> facilities_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Medium> facilities_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_PostalAddress> facilities_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Facility_Service> facilities_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Class> fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Class> equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Indicator> fundings_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Measurement> fundings_measurement;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Funding> fundings_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Citation_Class> citations;
	
	@OneToMany(mappedBy="theClass")
	private Set<FederatedIdentifier_Class> federeratedIdentifier_class;
	
	@OneToMany(mappedBy="theClass")
	private Set<FederatedIdentifier> federeratedIdentifier;
	
	@OneToMany(mappedBy="theClass")
	private Set<PostalAddress_Class> postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Class> services_Classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<ExpertiseAndSkills_Class> expertiseAndSkills;
	
	@OneToMany(mappedBy="theClass")
	private Set<GeographicBoundingBox_Class> geographicBoundingBoxes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Indicator_Class> indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Cv_Class> cvs;
	
	@OneToMany(mappedBy="theClass1")
	private Set<Class_Class> class_class1;
	
	@OneToMany(mappedBy="theClass2")
	private Set<Class_Class> class_class2;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassScheme_Class> classScheme_classes;
	
	@OneToMany(mappedBy="relatedClass")
	private Set<ClassScheme_Class> relatedClassScheme_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Metrics_Class> metrics;
	
	@OneToMany(mappedBy="theClass")
	private Set<Prize_Class> prizes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Qualification_Class> qualifications;
	
	@OneToMany(mappedBy="theClass")
	private Set<Measurement_Class> measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Medium_Class> mediums_classes;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="theClass")
	private Set<ClassDescription> descriptions;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassTerm> terms;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassEx> exs;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassDefinition> definitions;
	
	
	/**
	 * FederatedIdentifier entities related to Class instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;	
	
	// ---------------------------------------------------------------------- //
	
	
	/**
	 * Default Constructor
	 */
	public Class(){
		
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param uri
	 * @param scheme
	 * @param descriptions
	 * @param terms
	 * @param exs
	 * @param definitions
	 */
	public Class(String uri){
		this.uri = uri;
	}
	
	/**
	 * 
	 * @param uri
	 * @param scheme
	 */
	public Class(String uri, ClassScheme scheme){
		this.uri = uri;
		this.scheme = scheme;
	}
	
	public Class(Date startDate, Date endDate, String uri,
			ClassScheme scheme,
			Set<ClassDescription> descriptions, Set<ClassTerm> terms,
			Set<ClassEx> exs, Set<ClassDefinition> definitions) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.uri = uri;
		this.scheme = scheme;
		this.descriptions = descriptions;
		this.terms = terms;
		this.exs = exs;
		this.definitions = definitions;

	}

	/**
	 * Returns the unique identifier.
	 * @return the unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier.
	 * @param id the unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * Returns the scheme.
	 * @return the scheme.
	 */
	public ClassScheme getScheme() {
		return scheme;
	}

	/**
	 * Sets the scheme.
	 * @param scheme the scheme.
	 */
	public void setScheme(ClassScheme scheme) {
		this.scheme = scheme;
	}

	/**
	 * @return the person_resultProducts
	 */
	public Set<Person_ResultProduct> getPerson_resultProducts() {
		return person_resultProducts;
	}

	/**
	 * @param person_resultProducts the person_resultProducts to set
	 */
	public void setPerson_resultProducts(
			Set<Person_ResultProduct> person_resultProducts) {
		this.person_resultProducts = person_resultProducts;
	}
	/**
	 * Returns the project_organisation links.
	 * @return the project_organisation links.
	 */
	public Set<Project_OrganisationUnit> getProject_organisationUnits() {
		return project_organisationUnits;
	}
	
	/**
	 * Sets the project_organisation links.
	 * @param project_organisationUnits the project_organisation links.
	 */
	public void setProject_organisationUnits(Set<Project_OrganisationUnit> project_organisationUnits) {
		this.project_organisationUnits = project_organisationUnits;
	}
	
	/**
	 * @return the resultProducts
	 */
	public Set<ResultProduct_Class> getResultProducts() {
		return resultProducts;
	}

	/**
	 * @param resultProducts the resultProducts to set
	 */
	public void setResultProducts(Set<ResultProduct_Class> resultProducts) {
		this.resultProducts = resultProducts;
	}

	/**
	 * @return the persons
	 */
	public Set<Person_Class> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(Set<Person_Class> persons) {
		this.persons = persons;
	}

	/**
	 * Returns the orgUnit_resultProducts.
	 * @return the orgUnit_resultProducts.
	 */
	public Set<Person_ResultProduct> getOrgUnit_resultProducts() {
		return orgUnit_resultProducts;
	}

	/**
	 * Sets the orgUnit_resultProducts.
	 * @param orgUnit_resultProducts the orgUnit_resultProducts.
	 */
	public void setOrgUnit_resultProducts(Set<Person_ResultProduct> orgUnit_resultProducts) {
		this.orgUnit_resultProducts = orgUnit_resultProducts;
	}

	/**
	 * Returns the resultProduct_GeographicBoundingBoxes.
	 * @return the resultProduct_GeographicBoundingBoxes.
	 */
	public Set<ResultProduct_GeographicBoundingBox> getResultProduct_GeographicBoundingBoxes() {
		return resultProduct_GeographicBoundingBoxes;
	}
	
	/**
	 * Sets the resultProduct_GeographicBoundingBoxes.
	 * @param resultProduct_GeographicBoundingBoxes the resultProduct_GeographicBoundingBoxes.
	 */
	public void setResultProduct_GeographicBoundingBoxes(
			Set<ResultProduct_GeographicBoundingBox> resultProduct_GeographicBoundingBoxes) {
		this.resultProduct_GeographicBoundingBoxes = resultProduct_GeographicBoundingBoxes;
	}
	
	/**
	 * @return the organisationUnits_electronicAddresses
	 */
	public Set<OrganisationUnit_ElectronicAddress> getOrganisationUnits_electronicAddresses() {
		return organisationUnits_electronicAddresses;
	}

	/**
	 * @param organisationUnits_electronicAddresses the organisationUnits_electronicAddresses to set
	 */
	public void setOrganisationUnits_electronicAddresses(
			Set<OrganisationUnit_ElectronicAddress> organisationUnits_electronicAddresses) {
		this.organisationUnits_electronicAddresses = organisationUnits_electronicAddresses;
	}

	public Set<ClassDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ClassDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<ClassTerm> getTerms() {
		return terms;
	}

	public void setTerms(Set<ClassTerm> terms) {
		this.terms = terms;
	}

	public Set<ClassEx> getExs() {
		return exs;
	}

	public void setExs(Set<ClassEx> exs) {
		this.exs = exs;
	}

	/**
	 * @return the class_class1
	 */
	public Set<Class_Class> getClass_class1() {
		return class_class1;
	}

	/**
	 * @param class_class1 the class_class1 to set
	 */
	public void setClass_class1(Set<Class_Class> class_class1) {
		this.class_class1 = class_class1;
	}

	/**
	 * @return the class_class2
	 */
	public Set<Class_Class> getClass_class2() {
		return class_class2;
	}

	/**
	 * @param class_class2 the class_class2 to set
	 */
	public void setClass_class2(Set<Class_Class> class_class2) {
		this.class_class2 = class_class2;
	}

	public Set<ClassDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(Set<ClassDefinition> definitions) {
		this.definitions = definitions;
	}

	/**
	 * @return the electronicAddresses
	 */
	public Set<ElectronicAddress_Class> getElectronicAddresses() {
		return electronicAddresses;
	}

	/**
	 * @param electronicAddresses the electronicAddresses to set
	 */
	public void setElectronicAddresses(
			Set<ElectronicAddress_Class> electronicAddresses) {
		this.electronicAddresses = electronicAddresses;
	}

	/**
	 * @return the geographicBoundingBoxes
	 */
	public Set<GeographicBoundingBox_Class> getGeographicBoundingBoxes() {
		return geographicBoundingBoxes;
	}

	/**
	 * @param geographicBoundingBoxes the geographicBoundingBoxes to set
	 */
	public void setGeographicBoundingBoxes(
			Set<GeographicBoundingBox_Class> geographicBoundingBoxes) {
		this.geographicBoundingBoxes = geographicBoundingBoxes;
	}

	/**
	 * @return the projects
	 */
	public Set<Project_Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<Project_Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the projects_classes
	 */
	public Set<Project_Class> getProjects_classes() {
		return projects_classes;
	}

	/**
	 * @param projects_classes the projects_classes to set
	 */
	public void setProjects_classes(Set<Project_Class> projects_classes) {
		this.projects_classes = projects_classes;
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
	 * @return the projects_prizes
	 */
	public Set<Project_Prize> getProjects_prizes() {
		return projects_prizes;
	}

	/**
	 * @param projects_prizes the projects_prizes to set
	 */
	public void setProjects_prizes(Set<Project_Prize> projects_prizes) {
		this.projects_prizes = projects_prizes;
	}

	/**
	 * @return the projects_resultPatents
	 */
	public Set<Project_ResultPatent> getProjects_resultPatents() {
		return projects_resultPatents;
	}

	/**
	 * @param projects_resultPatents the projects_resultPatents to set
	 */
	public void setProjects_resultPatents(Set<Project_ResultPatent> projects_resultPatents) {
		this.projects_resultPatents = projects_resultPatents;
	}

	/**
	 * @return the projects_resultPublications
	 */
	public Set<Project_ResultPublication> getProjects_resultPublications() {
		return projects_resultPublications;
	}

	/**
	 * @param projects_resultPublications the projects_resultPublications to set
	 */
	public void setProjects_resultPublications(
			Set<Project_ResultPublication> projects_resultPublications) {
		this.projects_resultPublications = projects_resultPublications;
	}

	/**
	 * @return the projects_resultProducts
	 */
	public Set<Project_ResultProduct> getProjects_resultProducts() {
		return projects_resultProducts;
	}

	/**
	 * @param projects_resultProducts the projects_resultProducts to set
	 */
	public void setProjects_resultProducts(Set<Project_ResultProduct> projects_resultProducts) {
		this.projects_resultProducts = projects_resultProducts;
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
	 * @return the projects_persons
	 */
	public Set<Project_Person> getProjects_persons() {
		return projects_persons;
	}

	/**
	 * @param projects_persons the projects_persons to set
	 */
	public void setProjects_persons(Set<Project_Person> projects_persons) {
		this.projects_persons = projects_persons;
	}

	/**
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(Set<OrganisationUnit_OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}

	/**
	 * @return the organisationUnits_resultPublications
	 */
	public Set<OrganisationUnit_ResultPublication> getOrganisationUnits_resultPublications() {
		return organisationUnits_resultPublications;
	}

	/**
	 * @param organisationUnits_resultPublications the organisationUnits_resultPublications to set
	 */
	public void setOrganisationUnits_resultPublications(
			Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications) {
		this.organisationUnits_resultPublications = organisationUnits_resultPublications;
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
	 * @return the resultPatents_classes
	 */
	public Set<ResultPatent_Class> getResultPatents_classes() {
		return resultPatents_classes;
	}
	
	/**
	 * @param resultPatents_classes the resultPatents_classes to set
	 */
	public void setResultPatents_classes(
			Set<ResultPatent_Class> resultPatents_classes) {
		this.resultPatents_classes = resultPatents_classes;
	}
	
	/**
	 * @return the resultPublications_classes
	 */
	public Set<ResultPublication_Class> getResultPublications_classes() {
		return resultPublications_classes;
	}
	
	/**
	 * @param resultPublications_classes the resultPublications_classes to set
	 */
	public void setResultPublications_classes(
			Set<ResultPublication_Class> resultPublications_classes) {
		this.resultPublications_classes = resultPublications_classes;
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
	 * @return the facilities_facilities
	 */
	public Set<Facility_Facility> getFacilities_facilities() {
		return facilities_facilities;
	}

	/**
	 * @param facilities_facilities the facilities_facilities to set
	 */
	public void setFacilities_facilities(
			Set<Facility_Facility> facilities_facilities) {
		this.facilities_facilities = facilities_facilities;
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
	 * @return the facilities_measurements
	 */
	public Set<Facility_Measurement> getFacilities_measurements() {
		return facilities_measurements;
	}

	/**
	 * @param facilities_measurements the facilities_measurements to set
	 */
	public void setFacilities_measurements(
			Set<Facility_Measurement> facilities_measurements) {
		this.facilities_measurements = facilities_measurements;
	}

	/**
	 * @return the facilities_mediums
	 */
	public Set<Facility_Medium> getFacilities_mediums() {
		return facilities_mediums;
	}

	/**
	 * @param facilities_mediums the facilities_mediums to set
	 */
	public void setFacilities_mediums(Set<Facility_Medium> facilities_mediums) {
		this.facilities_mediums = facilities_mediums;
	}

	/**
	 * @return the facilities_postalAddresses
	 */
	public Set<Facility_PostalAddress> getFacilities_postalAddresses() {
		return facilities_postalAddresses;
	}

	/**
	 * @param facilities_postalAddresses the facilities_postalAddresses to set
	 */
	public void setFacilities_postalAddresses(
			Set<Facility_PostalAddress> facilities_postalAddresses) {
		this.facilities_postalAddresses = facilities_postalAddresses;
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
	 * @return the fundings
	 */
	public Set<Funding_Class> getFundings() {
		return fundings;
	}

	/**
	 * @param fundings the fundings to set
	 */
	public void setFundings(Set<Funding_Class> fundings) {
		this.fundings = fundings;
	}
	
	/**
	 * @return the equipments
	 */
	public Set<Equipment_Class> getEquipments() {
		return equipments;
	}

	/**
	 * @param equipments the equipments to set
	 */
	public void setEquipments(Set<Equipment_Class> equipments) {
		this.equipments = equipments;
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
	 * @return the fundings_measurement
	 */
	public Set<Funding_Measurement> getFundings_measurement() {
		return fundings_measurement;
	}

	/**
	 * @param fundings_measurement the fundings_measurement to set
	 */
	public void setFundings_measurement(
			Set<Funding_Measurement> fundings_measurement) {
		this.fundings_measurement = fundings_measurement;
	}

	/**
	 * @return the fundings_fundings
	 */
	public Set<Funding_Funding> getFundings_fundings() {
		return fundings_fundings;
	}

	/**
	 * @param fundings_fundings the fundings_fundings to set
	 */
	public void setFundings_fundings(Set<Funding_Funding> fundings_fundings) {
		this.fundings_fundings = fundings_fundings;
	}

	/**
	 * @return the organisationUnits_classes
	 */
	public Set<OrganisationUnit_Class> getOrganisationUnits_classes() {
		return organisationUnits_classes;
	}

	/**
	 * @param organisationUnits_classes the organisationUnits_classes to set
	 */
	public void setOrganisationUnits_classes(
			Set<OrganisationUnit_Class> organisationUnits_classes) {
		this.organisationUnits_classes = organisationUnits_classes;
	}

	public Set<OrganisationUnit_PostalAddress> getOrganisationUnits_postalAddresses() {
		return organisationUnits_postalAddresses;
	}

	public void setOrganisationUnits_postalAddresses(
			Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses) {
		this.organisationUnits_postalAddresses = organisationUnits_postalAddresses;
	}

	public Set<Citation_Class> getCitations() {
		return citations;
	}

	public void setCitations(Set<Citation_Class> citations) {
		this.citations = citations;
	}

	public Set<FederatedIdentifier_Class> getFedereratedIdentifier_class() {
		return federeratedIdentifier_class;
	}

	public void setFedereratedIdentifier_class(
			Set<FederatedIdentifier_Class> federeratedIdentifier_class) {
		this.federeratedIdentifier_class = federeratedIdentifier_class;
	}

	public Set<FederatedIdentifier> getFedereratedIdentifier() {
		return federeratedIdentifier;
	}

	public void setFedereratedIdentifier(
			Set<FederatedIdentifier> federeratedIdentifier) {
		this.federeratedIdentifier = federeratedIdentifier;
	}

	/**
	 * @return the postalAddresses
	 */
	public Set<PostalAddress_Class> getPostalAddresses() {
		return postalAddresses;
	}

	/**
	 * @param postalAddresses the postalAddresses to set
	 */
	public void setPostalAddresses(Set<PostalAddress_Class> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}

	/**
	 * @return the services_Classes
	 */
	public Set<Service_Class> getServices_Classes() {
		return services_Classes;
	}

	/**
	 * @param services_Classes the services_Classes to set
	 */
	public void setServices_Classes(Set<Service_Class> services_Classes) {
		this.services_Classes = services_Classes;
	}

	/**
	 * @return the indicators
	 */
	public Set<Indicator_Class> getIndicators() {
		return indicators;
	}

	/**
	 * @param indicators the indicators to set
	 */
	public void setIndicators(Set<Indicator_Class> indicators) {
		this.indicators = indicators;
	}

	/**
	 * @return the expertiseAndSkills
	 */
	public Set<ExpertiseAndSkills_Class> getExpertiseAndSkills() {
		return expertiseAndSkills;
	}

	/**
	 * @param expertiseAndSkills the expertiseAndSkills to set
	 */
	public void setExpertiseAndSkills(
			Set<ExpertiseAndSkills_Class> expertiseAndSkills) {
		this.expertiseAndSkills = expertiseAndSkills;
	}

	/**
	 * @return the cvs
	 */
	public Set<Cv_Class> getCvs() {
		return cvs;
	}

	/**
	 * @param cvs the cvs to set
	 */
	public void setCvs(Set<Cv_Class> cvs) {
		this.cvs = cvs;
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

	/**
	 * @return the classScheme_classes
	 */
	public Set<ClassScheme_Class> getClassScheme_classes() {
		return classScheme_classes;
	}

	/**
	 * @param classScheme_classes the classScheme_classes to set
	 */
	public void setClassScheme_classes(Set<ClassScheme_Class> classScheme_classes) {
		this.classScheme_classes = classScheme_classes;
	}

	/**
	 * @return the relatedClassScheme_classes
	 */
	public Set<ClassScheme_Class> getRelatedClassScheme_classes() {
		return relatedClassScheme_classes;
	}

	/**
	 * @param relatedClassScheme_classes the relatedClassScheme_classes to set
	 */
	public void setRelatedClassScheme_classes(
			Set<ClassScheme_Class> relatedClassScheme_classes) {
		this.relatedClassScheme_classes = relatedClassScheme_classes;
	}

	/**
	 * @return the metrics
	 */
	public Set<Metrics_Class> getMetrics() {
		return metrics;
	}

	/**
	 * @param metrics the metrics to set
	 */
	public void setMetrics(Set<Metrics_Class> metrics) {
		this.metrics = metrics;
	}

	/**
	 * @return the prizes
	 */
	public Set<Prize_Class> getPrizes() {
		return prizes;
	}

	/**
	 * @param prizes the prizes to set
	 */
	public void setPrizes(Set<Prize_Class> prizes) {
		this.prizes = prizes;
	}

	/**
	 * @return the qualifications
	 */
	public Set<Qualification_Class> getQualifications() {
		return qualifications;
	}

	/**
	 * @param qualifications the qualifications to set
	 */
	public void setQualifications(Set<Qualification_Class> qualifications) {
		this.qualifications = qualifications;
	}

	/**
	 * @return the measurements
	 */
	public Set<Measurement_Class> getMeasurements() {
		return measurements;
	}

	/**
	 * @param measurements the measurements to set
	 */
	public void setMeasurements(Set<Measurement_Class> measurements) {
		this.measurements = measurements;
	}
	
	/**
	 * @return the facilities_classes
	 */
	public Set<Facility_Class> getFacilities_classes() {
		return facilities_classes;
	}

	/**
	 * @param facilities_classes the facilities_classes to set
	 */
	public void setFacilities_classes(Set<Facility_Class> facilities_classes) {
		this.facilities_classes = facilities_classes;
	}

	/**
	 * @return the mediums_classes
	 */
	public Set<Medium_Class> getMediums_classes() {
		return mediums_classes;
	}

	/**
	 * @param mediums_classes the mediums_classes to set
	 */
	public void setMediums_classes(Set<Medium_Class> mediums_classes) {
		this.mediums_classes = mediums_classes;
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
		Class other = (Class) obj;
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
		return "Class [id=" + id + ", startDate=" + startDate + ", endDate="
				+ endDate + ", uri=" + uri + "]";
	}	
	
	
}