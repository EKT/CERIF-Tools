/**
 * 
 */
package gr.ekt.cerif.features.semantics;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.entities.link.ClassScheme_ClassScheme;
import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.entities.link.Country_Class;
import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.link.CurriculumVitae_Class;
import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.Equipment_Equipment;
import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.link.Event_Medium;
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
import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.GeographicBoundingBox_Measurement;
import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.link.Language_Class;
import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.PostalAddress_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.Service_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Country;
import gr.ekt.cerif.entities.link.person.Person_CurriculumVitae;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassTerm;

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
 * Represents a classification semantic.
 * 
 */
@Entity
@Table(name="cfClass")
public class Class implements CerifSemanticFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3602671648727049566L;

	/**
	 * The classification unique identifier.
	 */
	@Id
	@Column (name = "cfClassId")
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
	private ClassScheme scheme;

	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="theClass")
	private Set<Project_OrganisationUnit> project_organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultProduct> persons_resultProducts;	
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultPatent> persons_resultPatents;	
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Funding> persons_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Service> persons_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Equipment> persons_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Class> resultProducts_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Class> persons_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Language> persons_languges;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Country> persons_countries;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_CurriculumVitae> persons_curriculumVitaes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ExpertiseAndSkills> person_expertiseAndSkills;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Facility> persons_facilities;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Event> persons_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Indicator> persons_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Medium> persons_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Measurement> persons_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Prize> persons_prizes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Qualification> persons_qualifications;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_GeographicBoundingBox> resultProducts_geographicBoundingBoxes;
	
	@OneToMany(mappedBy="theClass")
	private Set<PostalAddress_GeographicBoundingBox> postalAddresses_geographicBoundingBoxes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Project> projects_projects;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Class> projects_classes;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Equipment> projects_equipments;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Event> projects_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Indicator> projects_indicators;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Facility> projects_facilities;

	@OneToMany(mappedBy="theClass")
	private Set<Project_Funding> projects_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Medium> projects_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Project_Measurement> projects_measurements;

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
	private Set<OrganisationUnit_Facility> organisationUnits_facilities;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ExpertiseAndSkills> organisationUnits_expertiseAndSkills;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Funding> organisationUnits_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Indicator> organisationUnits_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Measurement> organisationUnits_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Medium> organisationUnits_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Prize> organisationUnits_prizes;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Equipment> organisationUnits_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits_organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_PostalAddress> organisationUnits_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Event> organisationUnits_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Service> organisationUnits_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultPublication> organisationUnits_resultPublications;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_Class> organisationUnits_classes;	
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Class> resultPublications_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Facility> resultPublications_facilities;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Citation> resultPublications_citations;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Indicator> resultPublications_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Equipment> resultPublications_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Metrics> resultPublications_metrics;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Measurement> resultPublications_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Service> resultPublications_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Medium> resultPublications_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Funding> resultPublications_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Funding> resultPatents_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Indicator> resultPatents_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Equipment> resultPatents_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Measurement> resultPatents_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Service> resultPatents_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Facility> resultPatents_facilities;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_ResultPatent> resultPatents_resultPatents;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Funding> resultProducts_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Facility> resultProducts_facilities;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Measurement> resultProducts_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Service> resultProducts_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Indicator> resultProducts_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Equipment> resultProducts_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_ResultProduct> resultProducts_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_ResultPatent> resultProducts_resultPatents;
	
	@OneToMany(mappedBy="theClass")
	private Set<ElectronicAddress_Class> electronicAddresses_classes;
	
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
	private Set<Funding_Class> fundings_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Class> equipments_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Equipment> equipments_equipments;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Indicator> equipments_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_PostalAddress> equipments_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Medium> equipments_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Measurement> equipments_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Funding> equipments_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Event> equipments_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Equipment_Service> equipments_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<Event_Class> events_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Event_Event> events_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Event_Indicator> events_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Event_Medium> events_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Event_Measurement> events_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Indicator> fundings_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Medium_Funding> mediums_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Medium_Measurement> mediums_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Medium_Indicator> mediums_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Measurement> fundings_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Funding_Funding> fundings_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<Citation_Class> citations_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Citation_Medium> citations_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<FederatedIdentifier_Class> federatedIdentifiers_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<FederatedIdentifier> inFedFederatedIdentifiers;
	
	@OneToMany(mappedBy="theClass")
	private Set<PostalAddress_Class> postalAddresses_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Class> services_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Service> services_services;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Event> services_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Indicator> services_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_PostalAddress> services_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Medium> services_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_FederatedIdentifier> services_federatedIdentifiers;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Measurement> services_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Service_Funding> services_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<ExpertiseAndSkills_Class> expertiseAndSkills_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<GeographicBoundingBox_Class> geographicBoundingBoxes_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<GeographicBoundingBox_GeographicBoundingBox> geographicBoundingBoxes_geographicBoundingBoxes;
	
	@OneToMany(mappedBy="theClass")
	private Set<GeographicBoundingBox_Measurement> geographicBoundingBoxes_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Indicator_Class> indicators_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Indicator_Indicator> indicators_indicators;
	
	@OneToMany(mappedBy="theClass")
	private Set<Indicator_Measurement> indicators_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<CurriculumVitae_Class> curriculumVitaes_classes;
	
	@OneToMany(mappedBy="theClass1")
	private Set<Class_Class> class_class1;
	
	@OneToMany(mappedBy="theClass2")
	private Set<Class_Class> class_class2;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassScheme_Class> classSchemes_classes;
	
	@OneToMany(mappedBy="relatedClass")
	private Set<ClassScheme_Class> relatedClassSchemes_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Metrics_Class> metrics_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Prize_Class> prizes_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Qualification_Class> qualifications_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Measurement_Class> measurements_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Measurement_Measurement> measurements_measurements;
	
	@OneToMany(mappedBy="theClass")
	private Set<Medium_Class> mediums_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Medium_Medium> mediums_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Currency_Class> currencies_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Language_Class> languages_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<Country_Class> countries_classes;
	
	@OneToMany(mappedBy="theClass")
	private Set<OrganisationUnit_ResultPatent> organisationUnits_resultPatents;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultProduct_Medium> resultProducts_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<Event_Funding> events_fundings;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPatent_Medium> resultPatents_mediums;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassScheme_ClassScheme> classSchemes_classSchemes;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_ResultPublication> resultPublications_resultPublications;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_ResultProduct> resultPublications_resultProducts;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_ResultPatent> resultPublications_resultPatents;
	
	@OneToMany(mappedBy="theClass")
	private Set<ResultPublication_Event> resultPublications_events;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_Person> persons_persons;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ElectronicAddress> persons_electronicAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_PostalAddress> persons_postalAddresses;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_ResultPublication> persons_resultPublications;
	
	@OneToMany(mappedBy="theClass")
	private Set<Person_OrganisationUnit> persons_organisationUnits;
	
	@OneToMany(mappedBy="theClass")
	private Set<PersonName_Person> personNames_persons;
	
	@OneToMany(mappedBy="theClass")
	private Set<PersonName_Class> personNames_classes;
	
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="theClass")
	private Set<ClassDescription> classDescriptions;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassTerm> classTerms;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassEx> classExs;
	
	@OneToMany(mappedBy="theClass")
	private Set<ClassDefinition> classDefinitions;
	
	
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
	 * @param startDate
	 * @param endDate
	 * @param scheme
	 */
	public Class(Date startDate, Date endDate, ClassScheme scheme) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.scheme = scheme;
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
	 * @return the languages_classes
	 */
	public Set<Language_Class> getLanguages_classes() {
		return languages_classes;
	}

	/**
	 * @param languages_classes the languages_classes to set
	 */
	public void setLanguages_classes(Set<Language_Class> languages_classes) {
		this.languages_classes = languages_classes;
	}

	/**
	 * @return the countries_classes
	 */
	public Set<Country_Class> getCountries_classes() {
		return countries_classes;
	}

	/**
	 * @param countries_classes the countries_classes to set
	 */
	public void setCountries_classes(Set<Country_Class> countries_classes) {
		this.countries_classes = countries_classes;
	}

	/**
	 * @return the resultProducts_classes
	 */
	public Set<ResultProduct_Class> getResultProducts_classes() {
		return resultProducts_classes;
	}

	/**
	 * @param resultProducts_classes the resultProducts_classes to set
	 */
	public void setResultProducts_classes(
			Set<ResultProduct_Class> resultProducts_classes) {
		this.resultProducts_classes = resultProducts_classes;
	}

	/**
	 * @return the persons_classes
	 */
	public Set<Person_Class> getPersons_classes() {
		return persons_classes;
	}

	/**
	 * @param persons_classes the persons_classes to set
	 */
	public void setPersons_classes(Set<Person_Class> persons_classes) {
		this.persons_classes = persons_classes;
	}

	/**
	 * @return the projects_projects
	 */
	public Set<Project_Project> getProjects_projects() {
		return projects_projects;
	}

	/**
	 * @param projects_projects the projects_projects to set
	 */
	public void setProjects_projects(Set<Project_Project> projects_projects) {
		this.projects_projects = projects_projects;
	}

	/**
	 * @return the organisationUnits_organisationUnits
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits_organisationUnits() {
		return organisationUnits_organisationUnits;
	}

	/**
	 * @param organisationUnits_organisationUnits the organisationUnits_organisationUnits to set
	 */
	public void setOrganisationUnits_organisationUnits(
			Set<OrganisationUnit_OrganisationUnit> organisationUnits_organisationUnits) {
		this.organisationUnits_organisationUnits = organisationUnits_organisationUnits;
	}

	/**
	 * @return the electronicAddresses_classes
	 */
	public Set<ElectronicAddress_Class> getElectronicAddresses_classes() {
		return electronicAddresses_classes;
	}

	/**
	 * @param electronicAddresses_classes the electronicAddresses_classes to set
	 */
	public void setElectronicAddresses_classes(
			Set<ElectronicAddress_Class> electronicAddresses_classes) {
		this.electronicAddresses_classes = electronicAddresses_classes;
	}

	/**
	 * @return the fundings_classes
	 */
	public Set<Funding_Class> getFundings_classes() {
		return fundings_classes;
	}

	/**
	 * @param fundings_classes the fundings_classes to set
	 */
	public void setFundings_classes(Set<Funding_Class> fundings_classes) {
		this.fundings_classes = fundings_classes;
	}

	/**
	 * @return the equipments_classes
	 */
	public Set<Equipment_Class> getEquipments_classes() {
		return equipments_classes;
	}

	/**
	 * @param equipments_classes the equipments_classes to set
	 */
	public void setEquipments_classes(Set<Equipment_Class> equipments_classes) {
		this.equipments_classes = equipments_classes;
	}

	/**
	 * @return the citations_classes
	 */
	public Set<Citation_Class> getCitations_classes() {
		return citations_classes;
	}

	/**
	 * @param citations_classes the citations_classes to set
	 */
	public void setCitations_classes(Set<Citation_Class> citations_classes) {
		this.citations_classes = citations_classes;
	}

	/**
	 * @return the postalAddresses_classes
	 */
	public Set<PostalAddress_Class> getPostalAddresses_classes() {
		return postalAddresses_classes;
	}

	/**
	 * @param postalAddresses_classes the postalAddresses_classes to set
	 */
	public void setPostalAddresses_classes(
			Set<PostalAddress_Class> postalAddresses_classes) {
		this.postalAddresses_classes = postalAddresses_classes;
	}

	/**
	 * @return the expertiseAndSkills_classes
	 */
	public Set<ExpertiseAndSkills_Class> getExpertiseAndSkills_classes() {
		return expertiseAndSkills_classes;
	}

	/**
	 * @param expertiseAndSkills_classes the expertiseAndSkills_classes to set
	 */
	public void setExpertiseAndSkills_classes(
			Set<ExpertiseAndSkills_Class> expertiseAndSkills_classes) {
		this.expertiseAndSkills_classes = expertiseAndSkills_classes;
	}

	/**
	 * @return the geographicBoundingBoxes_classes
	 */
	public Set<GeographicBoundingBox_Class> getGeographicBoundingBoxes_classes() {
		return geographicBoundingBoxes_classes;
	}

	/**
	 * @param geographicBoundingBoxes_classes the geographicBoundingBoxes_classes to set
	 */
	public void setGeographicBoundingBoxes_classes(
			Set<GeographicBoundingBox_Class> geographicBoundingBoxes_classes) {
		this.geographicBoundingBoxes_classes = geographicBoundingBoxes_classes;
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
	 * @return the mediums_measurements
	 */
	public Set<Medium_Measurement> getMediums_measurements() {
		return mediums_measurements;
	}

	/**
	 * @param mediums_measurements the mediums_measurements to set
	 */
	public void setMediums_measurements(Set<Medium_Measurement> mediums_measurements) {
		this.mediums_measurements = mediums_measurements;
	}

	/**
	 * @return the metrics_classes
	 */
	public Set<Metrics_Class> getMetrics_classes() {
		return metrics_classes;
	}

	/**
	 * @param metrics_classes the metrics_classes to set
	 */
	public void setMetrics_classes(Set<Metrics_Class> metrics_classes) {
		this.metrics_classes = metrics_classes;
	}

	/**
	 * @return the prizes_classes
	 */
	public Set<Prize_Class> getPrizes_classes() {
		return prizes_classes;
	}

	/**
	 * @param prizes_classes the prizes_classes to set
	 */
	public void setPrizes_classes(Set<Prize_Class> prizes_classes) {
		this.prizes_classes = prizes_classes;
	}

	/**
	 * @return the qualifications_classes
	 */
	public Set<Qualification_Class> getQualifications_classes() {
		return qualifications_classes;
	}

	/**
	 * @param qualifications_classes the qualifications_classes to set
	 */
	public void setQualifications_classes(
			Set<Qualification_Class> qualifications_classes) {
		this.qualifications_classes = qualifications_classes;
	}

	/**
	 * @return the measurements_classes
	 */
	public Set<Measurement_Class> getMeasurements_classes() {
		return measurements_classes;
	}

	/**
	 * @param measurements_classes the measurements_classes to set
	 */
	public void setMeasurements_classes(Set<Measurement_Class> measurements_classes) {
		this.measurements_classes = measurements_classes;
	}

	/**
	 * @return the citations_mediums
	 */
	public Set<Citation_Medium> getCitations_mediums() {
		return citations_mediums;
	}

	/**
	 * @param citations_mediums the citations_mediums to set
	 */
	public void setCitations_mediums(Set<Citation_Medium> citations_mediums) {
		this.citations_mediums = citations_mediums;
	}

	/**
	 * @return the resultPublications_citations
	 */
	public Set<ResultPublication_Citation> getResultPublications_citations() {
		return resultPublications_citations;
	}

	/**
	 * @param resultPublications_citations the resultPublications_citations to set
	 */
	public void setResultPublications_citations(
			Set<ResultPublication_Citation> resultPublications_citations) {
		this.resultPublications_citations = resultPublications_citations;
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
	 * @return the resultProducts_geographicBoundingBoxes
	 */
	public Set<ResultProduct_GeographicBoundingBox> getResultProducts_geographicBoundingBoxes() {
		return resultProducts_geographicBoundingBoxes;
	}

	/**
	 * @param resultProducts_geographicBoundingBoxes the resultProducts_geographicBoundingBoxes to set
	 */
	public void setResultProducts_geographicBoundingBoxes(
			Set<ResultProduct_GeographicBoundingBox> resultProducts_geographicBoundingBoxes) {
		this.resultProducts_geographicBoundingBoxes = resultProducts_geographicBoundingBoxes;
	}

	/**
	 * @return the postalAddresses_geographicBoundingBoxes
	 */
	public Set<PostalAddress_GeographicBoundingBox> getPostalAddresses_geographicBoundingBoxes() {
		return postalAddresses_geographicBoundingBoxes;
	}

	/**
	 * @param postalAddresses_geographicBoundingBoxes the postalAddresses_geographicBoundingBoxes to set
	 */
	public void setPostalAddresses_geographicBoundingBoxes(
			Set<PostalAddress_GeographicBoundingBox> postalAddresses_geographicBoundingBoxes) {
		this.postalAddresses_geographicBoundingBoxes = postalAddresses_geographicBoundingBoxes;
	}

	/**
	 * @return the organisationUnits_resultPatents
	 */
	public Set<OrganisationUnit_ResultPatent> getOrganisationUnits_resultPatents() {
		return organisationUnits_resultPatents;
	}

	/**
	 * @param organisationUnits_resultPatents the organisationUnits_resultPatents to set
	 */
	public void setOrganisationUnits_resultPatents(
			Set<OrganisationUnit_ResultPatent> organisationUnits_resultPatents) {
		this.organisationUnits_resultPatents = organisationUnits_resultPatents;
	}

	/**
	 * @return the resultProducts_mediums
	 */
	public Set<ResultProduct_Medium> getResultProducts_mediums() {
		return resultProducts_mediums;
	}

	/**
	 * @param resultProducts_mediums the resultProducts_mediums to set
	 */
	public void setResultProducts_mediums(
			Set<ResultProduct_Medium> resultProducts_mediums) {
		this.resultProducts_mediums = resultProducts_mediums;
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
	 * @return the resultPatents_mediums
	 */
	public Set<ResultPatent_Medium> getResultPatents_mediums() {
		return resultPatents_mediums;
	}

	/**
	 * @param resultPatents_mediums the resultPatents_mediums to set
	 */
	public void setResultPatents_mediums(
			Set<ResultPatent_Medium> resultPatents_mediums) {
		this.resultPatents_mediums = resultPatents_mediums;
	}

	/**
	 * @return the persons_resultPatents
	 */
	public Set<Person_ResultPatent> getPersons_resultPatents() {
		return persons_resultPatents;
	}

	/**
	 * @param persons_resultPatents the persons_resultPatents to set
	 */
	public void setPersons_resultPatents(
			Set<Person_ResultPatent> persons_resultPatents) {
		this.persons_resultPatents = persons_resultPatents;
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
	 * @return the persons_languges
	 */
	public Set<Person_Language> getPersons_languges() {
		return persons_languges;
	}

	/**
	 * @param persons_languges the persons_languges to set
	 */
	public void setPersons_languges(Set<Person_Language> persons_languges) {
		this.persons_languges = persons_languges;
	}

	/**
	 * @return the persons_countries
	 */
	public Set<Person_Country> getPersons_countries() {
		return persons_countries;
	}

	/**
	 * @param persons_countries the persons_countries to set
	 */
	public void setPersons_countries(Set<Person_Country> persons_countries) {
		this.persons_countries = persons_countries;
	}

	/**
	 * @return the persons_curriculumVitaes
	 */
	public Set<Person_CurriculumVitae> getPersons_curriculumVitaes() {
		return persons_curriculumVitaes;
	}

	/**
	 * @param persons_curriculumVitaes the persons_curriculumVitaes to set
	 */
	public void setPersons_curriculumVitaes(
			Set<Person_CurriculumVitae> persons_curriculumVitaes) {
		this.persons_curriculumVitaes = persons_curriculumVitaes;
	}

	/**
	 * @return the curriculumVitaes_classes
	 */
	public Set<CurriculumVitae_Class> getCurriculumVitaes_classes() {
		return curriculumVitaes_classes;
	}

	/**
	 * @param curriculumVitaes_classes the curriculumVitaes_classes to set
	 */
	public void setCurriculumVitaes_classes(
			Set<CurriculumVitae_Class> curriculumVitaes_classes) {
		this.curriculumVitaes_classes = curriculumVitaes_classes;
	}

	/**
	 * @return the person_expertiseAndSkills
	 */
	public Set<Person_ExpertiseAndSkills> getPerson_expertiseAndSkills() {
		return person_expertiseAndSkills;
	}

	/**
	 * @param person_expertiseAndSkills the person_expertiseAndSkills to set
	 */
	public void setPerson_expertiseAndSkills(
			Set<Person_ExpertiseAndSkills> person_expertiseAndSkills) {
		this.person_expertiseAndSkills = person_expertiseAndSkills;
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
	 * @return the persons_mediums
	 */
	public Set<Person_Medium> getPersons_mediums() {
		return persons_mediums;
	}

	/**
	 * @param persons_mediums the persons_mediums to set
	 */
	public void setPersons_mediums(Set<Person_Medium> persons_mediums) {
		this.persons_mediums = persons_mediums;
	}

	/**
	 * @return the persons_prizes
	 */
	public Set<Person_Prize> getPersons_prizes() {
		return persons_prizes;
	}

	/**
	 * @param persons_prizes the persons_prizes to set
	 */
	public void setPersons_prizes(Set<Person_Prize> persons_prizes) {
		this.persons_prizes = persons_prizes;
	}

	/**
	 * @return the persons_qualifications
	 */
	public Set<Person_Qualification> getPersons_qualifications() {
		return persons_qualifications;
	}

	/**
	 * @param persons_qualifications the persons_qualifications to set
	 */
	public void setPersons_qualifications(
			Set<Person_Qualification> persons_qualifications) {
		this.persons_qualifications = persons_qualifications;
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
	 * @return the projects_mediums
	 */
	public Set<Project_Medium> getProjects_mediums() {
		return projects_mediums;
	}

	/**
	 * @param projects_mediums the projects_mediums to set
	 */
	public void setProjects_mediums(Set<Project_Medium> projects_mediums) {
		this.projects_mediums = projects_mediums;
	}

	/**
	 * @return the projects_measurements
	 */
	public Set<Project_Measurement> getProjects_measurements() {
		return projects_measurements;
	}

	/**
	 * @param projects_measurements the projects_measurements to set
	 */
	public void setProjects_measurements(
			Set<Project_Measurement> projects_measurements) {
		this.projects_measurements = projects_measurements;
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
	 * @return the organisationUnits_measurements
	 */
	public Set<OrganisationUnit_Measurement> getOrganisationUnits_measurements() {
		return organisationUnits_measurements;
	}

	/**
	 * @param organisationUnits_measurements the organisationUnits_measurements to set
	 */
	public void setOrganisationUnits_measurements(
			Set<OrganisationUnit_Measurement> organisationUnits_measurements) {
		this.organisationUnits_measurements = organisationUnits_measurements;
	}

	/**
	 * @return the organisationUnits_mediums
	 */
	public Set<OrganisationUnit_Medium> getOrganisationUnits_mediums() {
		return organisationUnits_mediums;
	}

	/**
	 * @param organisationUnits_mediums the organisationUnits_mediums to set
	 */
	public void setOrganisationUnits_mediums(
			Set<OrganisationUnit_Medium> organisationUnits_mediums) {
		this.organisationUnits_mediums = organisationUnits_mediums;
	}

	/**
	 * @return the organisationUnits_prizes
	 */
	public Set<OrganisationUnit_Prize> getOrganisationUnits_prizes() {
		return organisationUnits_prizes;
	}

	/**
	 * @param organisationUnits_prizes the organisationUnits_prizes to set
	 */
	public void setOrganisationUnits_prizes(
			Set<OrganisationUnit_Prize> organisationUnits_prizes) {
		this.organisationUnits_prizes = organisationUnits_prizes;
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
	 * @return the resultPublications_facilities
	 */
	public Set<ResultPublication_Facility> getResultPublications_facilities() {
		return resultPublications_facilities;
	}

	/**
	 * @param resultPublications_facilities the resultPublications_facilities to set
	 */
	public void setResultPublications_facilities(
			Set<ResultPublication_Facility> resultPublications_facilities) {
		this.resultPublications_facilities = resultPublications_facilities;
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
	 * @return the resultPublications_metrics
	 */
	public Set<ResultPublication_Metrics> getResultPublications_metrics() {
		return resultPublications_metrics;
	}

	/**
	 * @param resultPublications_metrics the resultPublications_metrics to set
	 */
	public void setResultPublications_metrics(
			Set<ResultPublication_Metrics> resultPublications_metrics) {
		this.resultPublications_metrics = resultPublications_metrics;
	}

	/**
	 * @return the resultPublications_measurements
	 */
	public Set<ResultPublication_Measurement> getResultPublications_measurements() {
		return resultPublications_measurements;
	}

	/**
	 * @param resultPublications_measurements the resultPublications_measurements to set
	 */
	public void setResultPublications_measurements(
			Set<ResultPublication_Measurement> resultPublications_measurements) {
		this.resultPublications_measurements = resultPublications_measurements;
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
	 * @return the resultPublications_mediums
	 */
	public Set<ResultPublication_Medium> getResultPublications_mediums() {
		return resultPublications_mediums;
	}

	/**
	 * @param resultPublications_mediums the resultPublications_mediums to set
	 */
	public void setResultPublications_mediums(
			Set<ResultPublication_Medium> resultPublications_mediums) {
		this.resultPublications_mediums = resultPublications_mediums;
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
	 * @return the resultPatents_measurements
	 */
	public Set<ResultPatent_Measurement> getResultPatents_measurements() {
		return resultPatents_measurements;
	}

	/**
	 * @param resultPatents_measurements the resultPatents_measurements to set
	 */
	public void setResultPatents_measurements(
			Set<ResultPatent_Measurement> resultPatents_measurements) {
		this.resultPatents_measurements = resultPatents_measurements;
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
	 * @return the resultPatents_facilities
	 */
	public Set<ResultPatent_Facility> getResultPatents_facilities() {
		return resultPatents_facilities;
	}

	/**
	 * @param resultPatents_facilities the resultPatents_facilities to set
	 */
	public void setResultPatents_facilities(
			Set<ResultPatent_Facility> resultPatents_facilities) {
		this.resultPatents_facilities = resultPatents_facilities;
	}

	/**
	 * @return the resultPatents_resultPatents
	 */
	public Set<ResultPatent_ResultPatent> getResultPatents_resultPatents() {
		return resultPatents_resultPatents;
	}

	/**
	 * @param resultPatents_resultPatents the resultPatents_resultPatents to set
	 */
	public void setResultPatents_resultPatents(
			Set<ResultPatent_ResultPatent> resultPatents_resultPatents) {
		this.resultPatents_resultPatents = resultPatents_resultPatents;
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
	 * @return the resultProducts_facilities
	 */
	public Set<ResultProduct_Facility> getResultProducts_facilities() {
		return resultProducts_facilities;
	}

	/**
	 * @param resultProducts_facilities the resultProducts_facilities to set
	 */
	public void setResultProducts_facilities(
			Set<ResultProduct_Facility> resultProducts_facilities) {
		this.resultProducts_facilities = resultProducts_facilities;
	}

	/**
	 * @return the resultProducts_measurements
	 */
	public Set<ResultProduct_Measurement> getResultProducts_measurements() {
		return resultProducts_measurements;
	}

	/**
	 * @param resultProducts_measurements the resultProducts_measurements to set
	 */
	public void setResultProducts_measurements(
			Set<ResultProduct_Measurement> resultProducts_measurements) {
		this.resultProducts_measurements = resultProducts_measurements;
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
	 * @return the resultProducts_resultProducts
	 */
	public Set<ResultProduct_ResultProduct> getResultProducts_resultProducts() {
		return resultProducts_resultProducts;
	}

	/**
	 * @param resultProducts_resultProducts the resultProducts_resultProducts to set
	 */
	public void setResultProducts_resultProducts(
			Set<ResultProduct_ResultProduct> resultProducts_resultProducts) {
		this.resultProducts_resultProducts = resultProducts_resultProducts;
	}
	
	/**
	 * Returns the resultProducts_resultPatents.
	 * @return the resultProducts_resultPatents.
	 */
	public Set<ResultProduct_ResultPatent> getResultProducts_resultPatents() {
		return resultProducts_resultPatents;
	}

	/**
	 * Sets the resultProducts_resultPatents.
	 * @param resultProducts_resultPatents the resultProducts_resultPatents.
	 */
	public void setResultProducts_resultPatents(
			Set<ResultProduct_ResultPatent> resultProducts_resultPatents) {
		this.resultProducts_resultPatents = resultProducts_resultPatents;
	}

	/**
	 * Returns the geographicBoundingBoxes_measurements.
	 * @return the geographicBoundingBoxes_measurements.
	 */
	public Set<GeographicBoundingBox_Measurement> getGeographicBoundingBoxes_measurements() {
		return geographicBoundingBoxes_measurements;
	}

	/**
	 * Sets the geographicBoundingBoxes_measurements.
	 * @param geographicBoundingBoxes_measurements the geographicBoundingBoxes_measurements.
	 */
	public void setGeographicBoundingBoxes_measurements(
			Set<GeographicBoundingBox_Measurement> geographicBoundingBoxes_measurements) {
		this.geographicBoundingBoxes_measurements = geographicBoundingBoxes_measurements;
	}

	/**
	 * @return the equipments_equipments
	 */
	public Set<Equipment_Equipment> getEquipments_equipments() {
		return equipments_equipments;
	}

	/**
	 * @param equipments_equipments the equipments_equipments to set
	 */
	public void setEquipments_equipments(
			Set<Equipment_Equipment> equipments_equipments) {
		this.equipments_equipments = equipments_equipments;
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
	 * @return the equipments_mediums
	 */
	public Set<Equipment_Medium> getEquipments_mediums() {
		return equipments_mediums;
	}

	/**
	 * @param equipments_mediums the equipments_mediums to set
	 */
	public void setEquipments_mediums(Set<Equipment_Medium> equipments_mediums) {
		this.equipments_mediums = equipments_mediums;
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
	 * @return the events_events
	 */
	public Set<Event_Event> getEvents_events() {
		return events_events;
	}

	/**
	 * @param events_events the events_events to set
	 */
	public void setEvents_events(Set<Event_Event> events_events) {
		this.events_events = events_events;
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
	 * @return the services_services
	 */
	public Set<Service_Service> getServices_services() {
		return services_services;
	}

	/**
	 * @param services_services the services_services to set
	 */
	public void setServices_services(Set<Service_Service> services_services) {
		this.services_services = services_services;
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
	 * @return the indicators_indicators
	 */
	public Set<Indicator_Indicator> getIndicators_indicators() {
		return indicators_indicators;
	}

	/**
	 * @param indicators_indicators the indicators_indicators to set
	 */
	public void setIndicators_indicators(
			Set<Indicator_Indicator> indicators_indicators) {
		this.indicators_indicators = indicators_indicators;
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
	 * @return the measurements_measurements
	 */
	public Set<Measurement_Measurement> getMeasurements_measurements() {
		return measurements_measurements;
	}

	/**
	 * @param measurements_measurements the measurements_measurements to set
	 */
	public void setMeasurements_measurements(
			Set<Measurement_Measurement> measurements_measurements) {
		this.measurements_measurements = measurements_measurements;
	}

	/**
	 * @return the mediums_mediums
	 */
	public Set<Medium_Medium> getMediums_mediums() {
		return mediums_mediums;
	}

	/**
	 * @param mediums_mediums the mediums_mediums to set
	 */
	public void setMediums_mediums(Set<Medium_Medium> mediums_mediums) {
		this.mediums_mediums = mediums_mediums;
	}

	/**
	 * @return the classSchemes_classSchemes
	 */
	public Set<ClassScheme_ClassScheme> getClassSchemes_classSchemes() {
		return classSchemes_classSchemes;
	}

	/**
	 * @param classSchemes_classSchemes the classSchemes_classSchemes to set
	 */
	public void setClassSchemes_classSchemes(
			Set<ClassScheme_ClassScheme> classSchemes_classSchemes) {
		this.classSchemes_classSchemes = classSchemes_classSchemes;
	}

	/**
	 * @return the resultPublications_resultPublications
	 */
	public Set<ResultPublication_ResultPublication> getResultPublications_resultPublications() {
		return resultPublications_resultPublications;
	}

	/**
	 * @param resultPublications_resultPublications the resultPublications_resultPublications to set
	 */
	public void setResultPublications_resultPublications(
			Set<ResultPublication_ResultPublication> resultPublications_resultPublications) {
		this.resultPublications_resultPublications = resultPublications_resultPublications;
	}

	/**
	 * @return the resultPublications_resultProducts
	 */
	public Set<ResultPublication_ResultProduct> getResultPublications_resultProducts() {
		return resultPublications_resultProducts;
	}

	/**
	 * @param resultPublications_resultProducts the resultPublications_resultProducts to set
	 */
	public void setResultPublications_resultProducts(
			Set<ResultPublication_ResultProduct> resultPublications_resultProducts) {
		this.resultPublications_resultProducts = resultPublications_resultProducts;
	}

	/**
	 * @return the resultPublications_resultPatents
	 */
	public Set<ResultPublication_ResultPatent> getResultPublications_resultPatents() {
		return resultPublications_resultPatents;
	}

	/**
	 * @param resultPublications_resultPatents the resultPublications_resultPatents to set
	 */
	public void setResultPublications_resultPatents(
			Set<ResultPublication_ResultPatent> resultPublications_resultPatents) {
		this.resultPublications_resultPatents = resultPublications_resultPatents;
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
	 * @return the persons_persons
	 */
	public Set<Person_Person> getPersons_persons() {
		return persons_persons;
	}

	/**
	 * @param persons_persons the persons_persons to set
	 */
	public void setPersons_persons(Set<Person_Person> persons_persons) {
		this.persons_persons = persons_persons;
	}

	/**
	 * @return the persons_electronicAddresses
	 */
	public Set<Person_ElectronicAddress> getPersons_electronicAddresses() {
		return persons_electronicAddresses;
	}

	/**
	 * @param persons_electronicAddresses the persons_electronicAddresses to set
	 */
	public void setPersons_electronicAddresses(
			Set<Person_ElectronicAddress> persons_electronicAddresses) {
		this.persons_electronicAddresses = persons_electronicAddresses;
	}

	/**
	 * @return the persons_postalAddresses
	 */
	public Set<Person_PostalAddress> getPersons_postalAddresses() {
		return persons_postalAddresses;
	}

	/**
	 * @param persons_postalAddresses the persons_postalAddresses to set
	 */
	public void setPersons_postalAddresses(
			Set<Person_PostalAddress> persons_postalAddresses) {
		this.persons_postalAddresses = persons_postalAddresses;
	}

	/**
	 * @return the persons_resultPublications
	 */
	public Set<Person_ResultPublication> getPersons_resultPublications() {
		return persons_resultPublications;
	}

	/**
	 * @param persons_resultPublications the persons_resultPublications to set
	 */
	public void setPersons_resultPublications(
			Set<Person_ResultPublication> persons_resultPublications) {
		this.persons_resultPublications = persons_resultPublications;
	}

	/**
	 * @return the persons_organisationUnits
	 */
	public Set<Person_OrganisationUnit> getPersons_organisationUnits() {
		return persons_organisationUnits;
	}

	/**
	 * @param persons_organisationUnits the persons_organisationUnits to set
	 */
	public void setPersons_organisationUnits(
			Set<Person_OrganisationUnit> persons_organisationUnits) {
		this.persons_organisationUnits = persons_organisationUnits;
	}

	/**
	 * @return the geographicBoundingBoxes_geographicBoundingBoxes
	 */
	public Set<GeographicBoundingBox_GeographicBoundingBox> getGeographicBoundingBoxes_geographicBoundingBoxes() {
		return geographicBoundingBoxes_geographicBoundingBoxes;
	}

	/**
	 * @param geographicBoundingBoxes_geographicBoundingBoxes the geographicBoundingBoxes_geographicBoundingBoxes to set
	 */
	public void setGeographicBoundingBoxes_geographicBoundingBoxes(
			Set<GeographicBoundingBox_GeographicBoundingBox> geographicBoundingBoxes_geographicBoundingBoxes) {
		this.geographicBoundingBoxes_geographicBoundingBoxes = geographicBoundingBoxes_geographicBoundingBoxes;
	}

	/**
	 * @return the classSchemes_classes
	 */
	public Set<ClassScheme_Class> getClassSchemes_classes() {
		return classSchemes_classes;
	}

	/**
	 * @param classSchemes_classes the classSchemes_classes to set
	 */
	public void setClassSchemes_classes(Set<ClassScheme_Class> classSchemes_classes) {
		this.classSchemes_classes = classSchemes_classes;
	}

	/**
	 * @return the relatedClassSchemes_classes
	 */
	public Set<ClassScheme_Class> getRelatedClassSchemes_classes() {
		return relatedClassSchemes_classes;
	}

	/**
	 * @param relatedClassSchemes_classes the relatedClassSchemes_classes to set
	 */
	public void setRelatedClassSchemes_classes(
			Set<ClassScheme_Class> relatedClassSchemes_classes) {
		this.relatedClassSchemes_classes = relatedClassSchemes_classes;
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
	 * @return the persons_measurements
	 */
	public Set<Person_Measurement> getPersons_measurements() {
		return persons_measurements;
	}

	/**
	 * @param persons_measurements the persons_measurements to set
	 */
	public void setPersons_measurements(Set<Person_Measurement> persons_measurements) {
		this.persons_measurements = persons_measurements;
	}

	/**
	 * @return the personNames_persons
	 */
	public Set<PersonName_Person> getPersonNames_persons() {
		return personNames_persons;
	}

	/**
	 * @param personNames_persons the personNames_persons to set
	 */
	public void setPersonNames_persons(Set<PersonName_Person> personNames_persons) {
		this.personNames_persons = personNames_persons;
	}

	/**
	 * @return the personNames_classes
	 */
	public Set<PersonName_Class> getPersonNames_classes() {
		return personNames_classes;
	}

	/**
	 * @param personNames_classes the personNames_classes to set
	 */
	public void setPersonNames_classes(Set<PersonName_Class> personNames_classes) {
		this.personNames_classes = personNames_classes;
	}

	/**
	 * @return the classDescriptions
	 */
	public Set<ClassDescription> getClassDescriptions() {
		return classDescriptions;
	}

	/**
	 * @param classDescriptions the classDescriptions to set
	 */
	public void setClassDescriptions(Set<ClassDescription> classDescriptions) {
		this.classDescriptions = classDescriptions;
	}

	/**
	 * @return the classTerms
	 */
	public Set<ClassTerm> getClassTerms() {
		return classTerms;
	}

	/**
	 * @param classTerms the classTerms to set
	 */
	public void setClassTerms(Set<ClassTerm> classTerms) {
		this.classTerms = classTerms;
	}

	/**
	 * @return the classExs
	 */
	public Set<ClassEx> getClassExs() {
		return classExs;
	}

	/**
	 * @param classExs the classExs to set
	 */
	public void setClassExs(Set<ClassEx> classExs) {
		this.classExs = classExs;
	}

	/**
	 * @return the classDefinitions
	 */
	public Set<ClassDefinition> getClassDefinitions() {
		return classDefinitions;
	}

	/**
	 * @param classDefinitions the classDefinitions to set
	 */
	public void setClassDefinitions(Set<ClassDefinition> classDefinitions) {
		this.classDefinitions = classDefinitions;
	}

	/**
	 * @return the federatedIdentifiers_classes
	 */
	public Set<FederatedIdentifier_Class> getFederatedIdentifiers_classes() {
		return federatedIdentifiers_classes;
	}

	/**
	 * @param federatedIdentifiers_classes the federatedIdentifiers_classes to set
	 */
	public void setFederatedIdentifiers_classes(
			Set<FederatedIdentifier_Class> federatedIdentifiers_classes) {
		this.federatedIdentifiers_classes = federatedIdentifiers_classes;
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
	 * @return the inFedFederatedIdentifiers
	 */
	public Set<FederatedIdentifier> getInFedFederatedIdentifiers() {
		return inFedFederatedIdentifiers;
	}

	/**
	 * @param inFedFederatedIdentifiers the inFedFederatedIdentifiers to set
	 */
	public void setInFedFederatedIdentifiers(
			Set<FederatedIdentifier> inFedFederatedIdentifiers) {
		this.inFedFederatedIdentifiers = inFedFederatedIdentifiers;
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
				+ endDate + ", uri=" + uri + ", uuid=" + uuid + "]";
	}

	
}