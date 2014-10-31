/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.entities.link.ClassScheme_ClassScheme;
import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.entities.link.Country_Class;
import gr.ekt.cerif.entities.link.Currency_Class;
import gr.ekt.cerif.entities.link.Cv_Class;
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
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_DublinCore;
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
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_DublinCore;
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
import gr.ekt.cerif.entities.link.project.Project_DublinCore;
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
import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;
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
import gr.ekt.cerif.services.link.citation.LinkCitationClassRepository;
import gr.ekt.cerif.services.link.citation.LinkCitationMediumRepository;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeClassRepository;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeClassSchemeRepository;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeOrganisationUnitRepository;
import gr.ekt.cerif.services.link.country.LinkCountryClassRepository;
import gr.ekt.cerif.services.link.currency.LinkCurrencyClassRepository;
import gr.ekt.cerif.services.link.cv.LinkCvClassRepository;
import gr.ekt.cerif.services.link.electronicaddress.LinkElectronicAddressClassRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentClassRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentEquipmentRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentEventRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentFundingRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentIndicatorRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentMeasurementRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentMediumRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentPostalAddressRepository;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentServiceRepository;
import gr.ekt.cerif.services.link.event.LinkEventClassRepository;
import gr.ekt.cerif.services.link.event.LinkEventEventRepository;
import gr.ekt.cerif.services.link.event.LinkEventFundingRepository;
import gr.ekt.cerif.services.link.event.LinkEventIndicatorRepository;
import gr.ekt.cerif.services.link.event.LinkEventMeasurementRepository;
import gr.ekt.cerif.services.link.event.LinkEventMediumRepository;
import gr.ekt.cerif.services.link.expertiseandskills.LinkExpertiseAndSkillsClassRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityClassRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityEquipmentRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityEventRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFacilityRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFundingRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityIndicatorRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityMeasurementRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityMediumRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityPostalAddressRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityServiceRepository;
import gr.ekt.cerif.services.link.federatedidentifier.LinkFederatedIdentifierClassRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingClassRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingFundingRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingIndicatorRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingMeasurementRepository;
import gr.ekt.cerif.services.link.geographicboundingbox.LinkGeographicBoundingBoxClassRepository;
import gr.ekt.cerif.services.link.geographicboundingbox.LinkGeographicBoundingBoxGeographicBoundingBoxRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorClassRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorIndicatorRepository;
import gr.ekt.cerif.services.link.indicator.LinkIndicatorMeasurementRepository;
import gr.ekt.cerif.services.link.language.LinkLanguageClassRepository;
import gr.ekt.cerif.services.link.measurement.LinkMeasurementClassRepository;
import gr.ekt.cerif.services.link.measurement.LinkMeasurementMeasurementRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumClassRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumFundingRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumIndicatorRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumMeasurementRepository;
import gr.ekt.cerif.services.link.medium.LinkMediumMediumRepository;
import gr.ekt.cerif.services.link.metrics.LinkMetricsClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitDublinCoreRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitElectronicAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitEquipmentRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitEventRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitExpertiseAndSkillsRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFacilityRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFundingRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitIndicatorRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitMeasurementRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitMediumRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitOrganisationUnitRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPrizeRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPatentRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultProductRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPublicationRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitServiceRepository;
import gr.ekt.cerif.services.link.person.LinkPersonClassRepository;
import gr.ekt.cerif.services.link.person.LinkPersonCountryRepository;
import gr.ekt.cerif.services.link.person.LinkPersonCvRepository;
import gr.ekt.cerif.services.link.person.LinkPersonDublinCoreRepository;
import gr.ekt.cerif.services.link.person.LinkPersonElectronicAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonEquipmentRepository;
import gr.ekt.cerif.services.link.person.LinkPersonEventRepository;
import gr.ekt.cerif.services.link.person.LinkPersonExpertiseAndSkillsRepository;
import gr.ekt.cerif.services.link.person.LinkPersonFacilityRepository;
import gr.ekt.cerif.services.link.person.LinkPersonFundingRepository;
import gr.ekt.cerif.services.link.person.LinkPersonIndicatorRepository;
import gr.ekt.cerif.services.link.person.LinkPersonLanguageRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMeasurementRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMediumRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPersonRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPostalAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPrizeRepository;
import gr.ekt.cerif.services.link.person.LinkPersonQualificationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPatentRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultProductRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPublicationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonServiceRepository;
import gr.ekt.cerif.services.link.postaladdress.LinkPostalAddressClassRepository;
import gr.ekt.cerif.services.link.postaladdress.LinkPostalAddressGeographicBoundingBoxRepository;
import gr.ekt.cerif.services.link.prize.LinkPrizeClassRepository;
import gr.ekt.cerif.services.link.project.LinkProjectClassRepository;
import gr.ekt.cerif.services.link.project.LinkProjectDublinCoreRepository;
import gr.ekt.cerif.services.link.project.LinkProjectEquipmentRepository;
import gr.ekt.cerif.services.link.project.LinkProjectEventRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFacilityRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFundingRepository;
import gr.ekt.cerif.services.link.project.LinkProjectIndicatorRepository;
import gr.ekt.cerif.services.link.project.LinkProjectMeasurementRepository;
import gr.ekt.cerif.services.link.project.LinkProjectMediumRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPrizeRepository;
import gr.ekt.cerif.services.link.project.LinkProjectProjectRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPatentRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultProductRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPublicationRepository;
import gr.ekt.cerif.services.link.project.LinkProjectServiceRepository;
import gr.ekt.cerif.services.link.qualification.LinkQualificationClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentResultPatentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPatentServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductCountryRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductGeographicBoundingBoxRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductResultProductRepository;
import gr.ekt.cerif.services.link.result.LinkResultProductServiceRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationCitationRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationDublinCoreRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEquipmentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEventRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationFacilityRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationFundingRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationIndicatorRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMeasurementRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMetricsRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultPatentRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultProductRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationResultPublicationRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationServiceRepository;
import gr.ekt.cerif.services.link.service.LinkServiceClassRepository;
import gr.ekt.cerif.services.link.service.LinkServiceEventRepository;
import gr.ekt.cerif.services.link.service.LinkServiceFederatedIdentifierRepository;
import gr.ekt.cerif.services.link.service.LinkServiceFundingRepository;
import gr.ekt.cerif.services.link.service.LinkServiceIndicatorRepository;
import gr.ekt.cerif.services.link.service.LinkServiceMeasurementRepository;
import gr.ekt.cerif.services.link.service.LinkServiceMediumRepository;
import gr.ekt.cerif.services.link.service.LinkServicePostalAddressRepository;
import gr.ekt.cerif.services.link.service.LinkServiceServiceRepository;
import gr.ekt.cerif.services.link.theclass.LinkClassClassRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF Link Entities.
 * 
 */
@Component
public class LinkPersistenceService {	
	
	@Autowired
	private LinkCitationClassRepository citationClassRepository;

	@Autowired
	private LinkCitationMediumRepository citationMediumRepository;

	@Autowired
	private LinkClassClassRepository classClassRepository;

	@Autowired
	private LinkClassSchemeClassSchemeRepository classSchemeClassSchemeRepository;
	
	@Autowired
	private LinkClassSchemeClassRepository classSchemeClassRepository;
	
	@Autowired
	private LinkClassSchemeOrganisationUnitRepository classSchemeOrganisationUnitRepository;

	@Autowired
	private LinkCountryClassRepository countryClassRepository;

	@Autowired
	private LinkCurrencyClassRepository currencyClassRepository;

	@Autowired
	private LinkCvClassRepository cvClassRepository;

	@Autowired
	private LinkElectronicAddressClassRepository electronicAddressClassRepository;

	@Autowired
	private LinkEquipmentClassRepository equipmentClassRepository;

	@Autowired
	private LinkEquipmentEquipmentRepository equipmentEquipmentRepository;

	@Autowired
	private LinkEquipmentEventRepository equipmentEventRepository;

	@Autowired
	private LinkEquipmentFundingRepository equipmentFundingRepository;

	@Autowired
	private LinkEquipmentIndicatorRepository equipmentIndicatorRepository;

	@Autowired
	private LinkEquipmentMeasurementRepository equipmentMeasurementRepository;

	@Autowired
	private LinkEquipmentMediumRepository equipmentMediumRepository;

	@Autowired
	private LinkEquipmentPostalAddressRepository equipmentPostalAddressRepository;

	@Autowired
	private LinkEquipmentServiceRepository equipmentServiceRepository;

	@Autowired
	private LinkEventClassRepository eventClassRepository;

	@Autowired
	private LinkEventEventRepository eventEventRepository;

	@Autowired
	private LinkEventFundingRepository eventFundingRepository;

	@Autowired
	private LinkEventIndicatorRepository eventIndicatorRepository;

	@Autowired
	private LinkEventMeasurementRepository eventMeasurementRepository;

	@Autowired
	private LinkEventMediumRepository eventMediumRepository;

	@Autowired
	private LinkExpertiseAndSkillsClassRepository expertiseAndSkillsClassRepository;

	@Autowired
	private LinkFacilityClassRepository facilityClassRepository;

	@Autowired
	private LinkFacilityEquipmentRepository facilityEquipmentRepository;

	@Autowired
	private LinkFacilityEventRepository facilityEventRepository;

	@Autowired
	private LinkFacilityFacilityRepository facilityFacilityRepository;

	@Autowired
	private LinkFacilityFundingRepository facilityFundingRepository;

	@Autowired
	private LinkFacilityIndicatorRepository facilityIndicatorRepository;

	@Autowired
	private LinkFacilityMeasurementRepository facilityMeasurementRepository;

	@Autowired
	private LinkFacilityMediumRepository facilityMediumRepository;

	@Autowired
	private LinkFacilityPostalAddressRepository facilityPostalAddressRepository;

	@Autowired
	private LinkFacilityServiceRepository facilityServiceRepository;

	@Autowired
	private LinkFederatedIdentifierClassRepository federatedIdentifierClassRepository;

	@Autowired
	private LinkFundingClassRepository fundingClassRepository;

	@Autowired
	private LinkFundingFundingRepository fundingFundingRepository;

	@Autowired
	private LinkFundingIndicatorRepository fundingIndicatorRepository;

	@Autowired
	private LinkFundingMeasurementRepository fundingMeasurementRepository;

	@Autowired
	private LinkGeographicBoundingBoxClassRepository geographicBoundingBoxClassRepository;

	@Autowired
	private LinkGeographicBoundingBoxGeographicBoundingBoxRepository geographicBoundingBoxGeographicBoundingBoxRepository;

	@Autowired
	private LinkIndicatorClassRepository indicatorClassRepository;

	@Autowired
	private LinkIndicatorIndicatorRepository indicatorIndicatorRepository;

	@Autowired
	private LinkIndicatorMeasurementRepository indicatorMeasurementRepository;

	@Autowired
	private LinkLanguageClassRepository languageClassRepository;

	@Autowired
	private LinkMeasurementClassRepository measurementClassRepository;

	@Autowired
	private LinkMeasurementMeasurementRepository measurementMeasurementRepository;

	@Autowired
	private LinkMediumClassRepository mediumClassRepository;

	@Autowired
	private LinkMediumFundingRepository mediumFundingRepository;

	@Autowired
	private LinkMediumIndicatorRepository mediumIndicatorRepository;

	@Autowired
	private LinkMediumMeasurementRepository mediumMeasurementRepository;

	@Autowired
	private LinkMediumMediumRepository mediumMediumRepository;

	@Autowired
	private LinkMetricsClassRepository metricsClassRepository;

	@Autowired
	private LinkOrganisationUnitClassRepository organisationUnitClassRepository;

	@Autowired
	private LinkOrganisationUnitDublinCoreRepository organisationUnitDublinCoreRepository;

	@Autowired
	private LinkOrganisationUnitElectronicAddressRepository organisationUnitElectronicAddressRepository;

	@Autowired
	private LinkOrganisationUnitEquipmentRepository organisationUnitEquipmentRepository;

	@Autowired
	private LinkOrganisationUnitEventRepository organisationUnitEventRepository;

	@Autowired
	private LinkOrganisationUnitExpertiseAndSkillsRepository organisationUnitExpertiseAndSkillsRepository;

	@Autowired
	private LinkOrganisationUnitFacilityRepository organisationUnitFacilityRepository;

	@Autowired
	private LinkOrganisationUnitFundingRepository organisationUnitFundingRepository;

	@Autowired
	private LinkOrganisationUnitIndicatorRepository organisationUnitIndicatorRepository;

	@Autowired
	private LinkOrganisationUnitMeasurementRepository organisationUnitMeasurementRepository;

	@Autowired
	private LinkOrganisationUnitMediumRepository organisationUnitMediumRepository;

	@Autowired
	private LinkOrganisationUnitOrganisationUnitRepository organisationUnitOrganisationUnitRepository;

	@Autowired
	private LinkOrganisationUnitPostalAddressRepository organisationUnitPostalAddressRepository;

	@Autowired
	private LinkOrganisationUnitPrizeRepository organisationUnitPrizeRepository;

	@Autowired
	private LinkOrganisationUnitResultPatentRepository organisationUnitResultPatentRepository;

	@Autowired
	private LinkOrganisationUnitResultProductRepository organisationUnitResultProductRepository;

	@Autowired
	private LinkOrganisationUnitResultPublicationRepository organisationUnitResultPublicationRepository;

	@Autowired
	private LinkOrganisationUnitServiceRepository organisationUnitServiceRepository;

	@Autowired
	private LinkPersonClassRepository personClassRepository;

	@Autowired
	private LinkPersonCountryRepository personCountryRepository;

	@Autowired
	private LinkPersonCvRepository personCvRepository;

	@Autowired
	private LinkPersonDublinCoreRepository personDublinCoreRepository;

	@Autowired
	private LinkPersonElectronicAddressRepository personElectronicAddressRepository;

	@Autowired
	private LinkPersonEquipmentRepository personEquipmentRepository;

	@Autowired
	private LinkPersonEventRepository personEventRepository;

	@Autowired
	private LinkPersonExpertiseAndSkillsRepository personExpertiseAndSkillsRepository;

	@Autowired
	private LinkPersonFacilityRepository personFacilityRepository;

	@Autowired
	private LinkPersonFundingRepository personFundingRepository;

	@Autowired
	private LinkPersonIndicatorRepository personIndicatorRepository;

	@Autowired
	private LinkPersonLanguageRepository personLanguageRepository;

	@Autowired
	private LinkPersonMeasurementRepository personMeasurementRepository;

	@Autowired
	private LinkPersonMediumRepository personMediumRepository;

	@Autowired
	private LinkPersonOrganisationUnitRepository personOrganisationUnitRepository;

	@Autowired
	private LinkPersonPersonRepository personPersonRepository;

	@Autowired
	private LinkPersonPostalAddressRepository personPostalAddressRepository;

	@Autowired
	private LinkPersonPrizeRepository personPrizeRepository;

	@Autowired
	private LinkPersonQualificationRepository personQualificationRepository;

	@Autowired
	private LinkPersonResultPatentRepository personResultPatentRepository;

	@Autowired
	private LinkPersonResultProductRepository personResultProductRepository;

	@Autowired
	private LinkPersonResultPublicationRepository personResultPublicationRepository;

	@Autowired
	private LinkPersonServiceRepository personServiceRepository;

	@Autowired
	private LinkPostalAddressClassRepository postalAddressClassRepository;

	@Autowired
	private LinkPostalAddressGeographicBoundingBoxRepository postalAddressGeographicBoundingBoxRepository;

	@Autowired
	private LinkPrizeClassRepository prizeClassRepository;

	@Autowired
	private LinkProjectClassRepository projectClassRepository;

	@Autowired
	private LinkProjectDublinCoreRepository projectDublinCoreRepository;

	@Autowired
	private LinkProjectEquipmentRepository projectEquipmentRepository;

	@Autowired
	private LinkProjectEventRepository projectEventRepository;

	@Autowired
	private LinkProjectFacilityRepository projectFacilityRepository;

	@Autowired
	private LinkProjectFundingRepository projectFundingRepository;

	@Autowired
	private LinkProjectIndicatorRepository projectIndicatorRepository;

	@Autowired
	private LinkProjectMeasurementRepository projectMeasurementRepository;

	@Autowired
	private LinkProjectMediumRepository projectMediumRepository;

	@Autowired
	private LinkProjectOrganisationUnitRepository projectOrganisationUnitRepository;

	@Autowired
	private LinkProjectPersonRepository projectPersonRepository;

	@Autowired
	private LinkProjectPrizeRepository projectPrizeRepository;

	@Autowired
	private LinkProjectProjectRepository projectProjectRepository;

	@Autowired
	private LinkProjectResultPatentRepository projectResultPatentRepository;

	@Autowired
	private LinkProjectResultProductRepository projectResultProductRepository;

	@Autowired
	private LinkProjectResultPublicationRepository projectResultPublicationRepository;

	@Autowired
	private LinkProjectServiceRepository projectServiceRepository;

	@Autowired
	private LinkQualificationClassRepository qualificationClassRepository;

	@Autowired
	private LinkResultPatentClassRepository resultPatentClassRepository;

	@Autowired
	private LinkResultPatentEquipmentRepository resultPatentEquipmentRepository;

	@Autowired
	private LinkResultPatentFacilityRepository resultPatentFacilityRepository;

	@Autowired
	private LinkResultPatentFundingRepository resultPatentFundingRepository;

	@Autowired
	private LinkResultPatentIndicatorRepository resultPatentIndicatorRepository;

	@Autowired
	private LinkResultPatentMeasurementRepository resultPatentMeasurementRepository;

	@Autowired
	private LinkResultPatentMediumRepository resultPatentMediumRepository;

	@Autowired
	private LinkResultPatentResultPatentRepository resultPatentResultPatentRepository;

	@Autowired
	private LinkResultPatentServiceRepository resultPatentServiceRepository;

	@Autowired
	private LinkResultProductClassRepository resultProductClassRepository;

	@Autowired
	private LinkResultProductCountryRepository resultProductCountryRepository;

	@Autowired
	private LinkResultProductEquipmentRepository resultProductEquipmentRepository;

	@Autowired
	private LinkResultProductFacilityRepository resultProductFacilityRepository;

	@Autowired
	private LinkResultProductFundingRepository resultProductFundingRepository;

	@Autowired
	private LinkResultProductGeographicBoundingBoxRepository resultProductGeographicBoundingBoxRepository;

	@Autowired
	private LinkResultProductIndicatorRepository resultProductIndicatorRepository;

	@Autowired
	private LinkResultProductMeasurementRepository resultProductMeasurementRepository;

	@Autowired
	private LinkResultProductMediumRepository resultProductMediumRepository;

	@Autowired
	private LinkResultProductResultProductRepository resultProductResultProductRepository;

	@Autowired
	private LinkResultProductServiceRepository resultProductServiceRepository;
	
	@Autowired
	private LinkResultPublicationCitationRepository resultPublicationCitationRepository;

	@Autowired
	private LinkResultPublicationClassRepository resultPublicationClassRepository;

	@Autowired
	private LinkResultPublicationDublinCoreRepository resultPublicationDublinCoreRepository;

	@Autowired
	private LinkResultPublicationEquipmentRepository resultPublicationEquipmentRepository;

	@Autowired
	private LinkResultPublicationEventRepository resultPublicationEventRepository;

	@Autowired
	private LinkResultPublicationFacilityRepository resultPublicationFacilityRepository;

	@Autowired
	private LinkResultPublicationFundingRepository resultPublicationFundingRepository;

	@Autowired
	private LinkResultPublicationIndicatorRepository resultPublicationIndicatorRepository;

	@Autowired
	private LinkResultPublicationMeasurementRepository resultPublicationMeasurementRepository;

	@Autowired
	private LinkResultPublicationMediumRepository resultPublicationMediumRepository;

	@Autowired
	private LinkResultPublicationMetricsRepository resultPublicationMetricsRepository;

	@Autowired
	private LinkResultPublicationResultPatentRepository resultPublicationResultPatentRepository;

	@Autowired
	private LinkResultPublicationResultProductRepository resultPublicationResultProductRepository;

	@Autowired
	private LinkResultPublicationResultPublicationRepository resultPublicationResultPublicationRepository;

	@Autowired
	private LinkResultPublicationServiceRepository resultPublicationServiceRepository;

	@Autowired
	private LinkServiceClassRepository serviceClassRepository;

	@Autowired
	private LinkServiceEventRepository serviceEventRepository;

	@Autowired
	private LinkServiceFederatedIdentifierRepository serviceFederatedIdentifierRepository;

	@Autowired
	private LinkServiceFundingRepository serviceFundingRepository;

	@Autowired
	private LinkServiceIndicatorRepository serviceIndicatorRepository;

	@Autowired
	private LinkServiceMeasurementRepository serviceMeasurementRepository;

	@Autowired
	private LinkServiceMediumRepository serviceMediumRepository;

	@Autowired
	private LinkServicePostalAddressRepository servicePostalAddressRepository;

	@Autowired
	private LinkServiceServiceRepository serviceServiceRepository;

	
	
	/**
	 * Delete the provided link entity.
	 * @TODO For Every Entity implement Delete
	 * @param entity The link entity.
	 */
	public void delete(CerifLinkEntity entity) {
		if (entity instanceof Citation_Class) {
		    citationClassRepository.delete((Citation_Class) entity);
		} else if (entity instanceof Citation_Medium) {
		    citationMediumRepository.delete((Citation_Medium) entity);
		} else if (entity instanceof Class_Class) {
		    classClassRepository.delete((Class_Class) entity);
		} else if (entity instanceof ClassScheme_ClassScheme) {
		    classSchemeClassSchemeRepository.delete((ClassScheme_ClassScheme) entity);
		} else if (entity instanceof ClassScheme_Class) {
		    classSchemeClassRepository.delete((ClassScheme_Class) entity);
		} else if (entity instanceof ClassScheme_OrganisationUnit) {
		    classSchemeOrganisationUnitRepository.delete((ClassScheme_OrganisationUnit) entity);
		} else if (entity instanceof Country_Class) {
		    countryClassRepository.delete((Country_Class) entity);
		} else if (entity instanceof Currency_Class) {
		    currencyClassRepository.delete((Currency_Class) entity);
		} else if (entity instanceof Cv_Class) {
		    cvClassRepository.delete((Cv_Class) entity);
		} else if (entity instanceof ElectronicAddress_Class) {
		    electronicAddressClassRepository.delete((ElectronicAddress_Class) entity);
		} else if (entity instanceof Equipment_Class) {
		    equipmentClassRepository.delete((Equipment_Class) entity);
		} else if (entity instanceof Equipment_Equipment) {
		    equipmentEquipmentRepository.delete((Equipment_Equipment) entity);
		} else if (entity instanceof Equipment_Event) {
		    equipmentEventRepository.delete((Equipment_Event) entity);
		} else if (entity instanceof Equipment_Funding) {
		    equipmentFundingRepository.delete((Equipment_Funding) entity);
		} else if (entity instanceof Equipment_Indicator) {
		    equipmentIndicatorRepository.delete((Equipment_Indicator) entity);
		} else if (entity instanceof Equipment_Measurement) {
		    equipmentMeasurementRepository.delete((Equipment_Measurement) entity);
		} else if (entity instanceof Equipment_Medium) {
		    equipmentMediumRepository.delete((Equipment_Medium) entity);
		} else if (entity instanceof Equipment_PostalAddress) {
		    equipmentPostalAddressRepository.delete((Equipment_PostalAddress) entity);
		} else if (entity instanceof Equipment_Service) {
		    equipmentServiceRepository.delete((Equipment_Service) entity);
		} else if (entity instanceof Event_Class) {
		    eventClassRepository.delete((Event_Class) entity);
		} else if (entity instanceof Event_Event) {
		    eventEventRepository.delete((Event_Event) entity);
		} else if (entity instanceof Event_Funding) {
		    eventFundingRepository.delete((Event_Funding) entity);
		} else if (entity instanceof Event_Indicator) {
		    eventIndicatorRepository.delete((Event_Indicator) entity);
		} else if (entity instanceof Event_Measurement) {
		    eventMeasurementRepository.delete((Event_Measurement) entity);
		} else if (entity instanceof Event_Medium) {
		    eventMediumRepository.delete((Event_Medium) entity);
		} else if (entity instanceof ExpertiseAndSkills_Class) {
		    expertiseAndSkillsClassRepository.delete((ExpertiseAndSkills_Class) entity);
		} else if (entity instanceof Facility_Class) {
		    facilityClassRepository.delete((Facility_Class) entity);
		} else if (entity instanceof Facility_Equipment) {
		    facilityEquipmentRepository.delete((Facility_Equipment) entity);
		} else if (entity instanceof Facility_Event) {
		    facilityEventRepository.delete((Facility_Event) entity);
		} else if (entity instanceof Facility_Facility) {
		    facilityFacilityRepository.delete((Facility_Facility) entity);
		} else if (entity instanceof Facility_Funding) {
		    facilityFundingRepository.delete((Facility_Funding) entity);
		} else if (entity instanceof Facility_Indicator) {
		    facilityIndicatorRepository.delete((Facility_Indicator) entity);
		} else if (entity instanceof Facility_Measurement) {
		    facilityMeasurementRepository.delete((Facility_Measurement) entity);
		} else if (entity instanceof Facility_Medium) {
		    facilityMediumRepository.delete((Facility_Medium) entity);
		} else if (entity instanceof Facility_PostalAddress) {
		    facilityPostalAddressRepository.delete((Facility_PostalAddress) entity);
		} else if (entity instanceof Facility_Service) {
		    facilityServiceRepository.delete((Facility_Service) entity);
		} else if (entity instanceof FederatedIdentifier_Class) {
		    federatedIdentifierClassRepository.delete((FederatedIdentifier_Class) entity);
		} else if (entity instanceof Funding_Class) {
		    fundingClassRepository.delete((Funding_Class) entity);
		} else if (entity instanceof Funding_Funding) {
		    fundingFundingRepository.delete((Funding_Funding) entity);
		} else if (entity instanceof Funding_Indicator) {
		    fundingIndicatorRepository.delete((Funding_Indicator) entity);
		} else if (entity instanceof Funding_Measurement) {
		    fundingMeasurementRepository.delete((Funding_Measurement) entity);
		} else if (entity instanceof GeographicBoundingBox_Class) {
		    geographicBoundingBoxClassRepository.delete((GeographicBoundingBox_Class) entity);
		} else if (entity instanceof GeographicBoundingBox_GeographicBoundingBox) {
		    geographicBoundingBoxGeographicBoundingBoxRepository.delete((GeographicBoundingBox_GeographicBoundingBox) entity);
		} else if (entity instanceof Indicator_Class) {
		    indicatorClassRepository.delete((Indicator_Class) entity);
		} else if (entity instanceof Indicator_Indicator) {
		    indicatorIndicatorRepository.delete((Indicator_Indicator) entity);
		} else if (entity instanceof Indicator_Measurement) {
		    indicatorMeasurementRepository.delete((Indicator_Measurement) entity);
		} else if (entity instanceof Language_Class) {
		    languageClassRepository.delete((Language_Class) entity);
		} else if (entity instanceof Measurement_Class) {
		    measurementClassRepository.delete((Measurement_Class) entity);
		} else if (entity instanceof Measurement_Measurement) {
		    measurementMeasurementRepository.delete((Measurement_Measurement) entity);
		} else if (entity instanceof Medium_Class) {
		    mediumClassRepository.delete((Medium_Class) entity);
		} else if (entity instanceof Medium_Funding) {
		    mediumFundingRepository.delete((Medium_Funding) entity);
		} else if (entity instanceof Medium_Indicator) {
		    mediumIndicatorRepository.delete((Medium_Indicator) entity);
		} else if (entity instanceof Medium_Measurement) {
		    mediumMeasurementRepository.delete((Medium_Measurement) entity);
		} else if (entity instanceof Medium_Medium) {
		    mediumMediumRepository.delete((Medium_Medium) entity);
		} else if (entity instanceof Metrics_Class) {
		    metricsClassRepository.delete((Metrics_Class) entity);
		} else if (entity instanceof OrganisationUnit_Class) {
		    organisationUnitClassRepository.delete((OrganisationUnit_Class) entity);
		} else if (entity instanceof OrganisationUnit_DublinCore) {
		    organisationUnitDublinCoreRepository.delete((OrganisationUnit_DublinCore) entity);
		} else if (entity instanceof OrganisationUnit_ElectronicAddress) {
		    organisationUnitElectronicAddressRepository.delete((OrganisationUnit_ElectronicAddress) entity);
		} else if (entity instanceof OrganisationUnit_Equipment) {
		    organisationUnitEquipmentRepository.delete((OrganisationUnit_Equipment) entity);
		} else if (entity instanceof OrganisationUnit_Event) {
		    organisationUnitEventRepository.delete((OrganisationUnit_Event) entity);
		} else if (entity instanceof OrganisationUnit_ExpertiseAndSkills) {
		    organisationUnitExpertiseAndSkillsRepository.delete((OrganisationUnit_ExpertiseAndSkills) entity);
		} else if (entity instanceof OrganisationUnit_Facility) {
		    organisationUnitFacilityRepository.delete((OrganisationUnit_Facility) entity);
		} else if (entity instanceof OrganisationUnit_Funding) {
		    organisationUnitFundingRepository.delete((OrganisationUnit_Funding) entity);
		} else if (entity instanceof OrganisationUnit_Indicator) {
		    organisationUnitIndicatorRepository.delete((OrganisationUnit_Indicator) entity);
		} else if (entity instanceof OrganisationUnit_Measurement) {
		    organisationUnitMeasurementRepository.delete((OrganisationUnit_Measurement) entity);
		} else if (entity instanceof OrganisationUnit_Medium) {
		    organisationUnitMediumRepository.delete((OrganisationUnit_Medium) entity);
		} else if (entity instanceof OrganisationUnit_OrganisationUnit) {
		    organisationUnitOrganisationUnitRepository.delete((OrganisationUnit_OrganisationUnit) entity);
		} else if (entity instanceof OrganisationUnit_PostalAddress) {
		    organisationUnitPostalAddressRepository.delete((OrganisationUnit_PostalAddress) entity);
		} else if (entity instanceof OrganisationUnit_Prize) {
		    organisationUnitPrizeRepository.delete((OrganisationUnit_Prize) entity);
		} else if (entity instanceof OrganisationUnit_ResultPatent) {
		    organisationUnitResultPatentRepository.delete((OrganisationUnit_ResultPatent) entity);
		} else if (entity instanceof OrganisationUnit_ResultProduct) {
		    organisationUnitResultProductRepository.delete((OrganisationUnit_ResultProduct) entity);
		} else if (entity instanceof OrganisationUnit_ResultPublication) {
		    organisationUnitResultPublicationRepository.delete((OrganisationUnit_ResultPublication) entity);
		} else if (entity instanceof OrganisationUnit_Service) {
		    organisationUnitServiceRepository.delete((OrganisationUnit_Service) entity);
		} else if (entity instanceof Person_Class) {
		    personClassRepository.delete((Person_Class) entity);
		} else if (entity instanceof Person_Country) {
		    personCountryRepository.delete((Person_Country) entity);
		} else if (entity instanceof Person_Cv) {
		    personCvRepository.delete((Person_Cv) entity);
		} else if (entity instanceof Person_DublinCore) {
		    personDublinCoreRepository.delete((Person_DublinCore) entity);
		} else if (entity instanceof Person_ElectronicAddress) {
		    personElectronicAddressRepository.delete((Person_ElectronicAddress) entity);
		} else if (entity instanceof Person_Equipment) {
		    personEquipmentRepository.delete((Person_Equipment) entity);
		} else if (entity instanceof Person_Event) {
		    personEventRepository.delete((Person_Event) entity);
		} else if (entity instanceof Person_ExpertiseAndSkills) {
		    personExpertiseAndSkillsRepository.delete((Person_ExpertiseAndSkills) entity);
		} else if (entity instanceof Person_Facility) {
		    personFacilityRepository.delete((Person_Facility) entity);
		} else if (entity instanceof Person_Funding) {
		    personFundingRepository.delete((Person_Funding) entity);
		} else if (entity instanceof Person_Indicator) {
		    personIndicatorRepository.delete((Person_Indicator) entity);
		} else if (entity instanceof Person_Language) {
		    personLanguageRepository.delete((Person_Language) entity);
		} else if (entity instanceof Person_Measurement) {
		    personMeasurementRepository.delete((Person_Measurement) entity);
		} else if (entity instanceof Person_Medium) {
		    personMediumRepository.delete((Person_Medium) entity);
		} else if (entity instanceof Person_OrganisationUnit) {
		    personOrganisationUnitRepository.delete((Person_OrganisationUnit) entity);
		} else if (entity instanceof Person_Person) {
		    personPersonRepository.delete((Person_Person) entity);
		} else if (entity instanceof Person_PostalAddress) {
		    personPostalAddressRepository.delete((Person_PostalAddress) entity);
		} else if (entity instanceof Person_Prize) {
		    personPrizeRepository.delete((Person_Prize) entity);
		} else if (entity instanceof Person_Qualification) {
		    personQualificationRepository.delete((Person_Qualification) entity);
		} else if (entity instanceof Person_ResultPatent) {
		    personResultPatentRepository.delete((Person_ResultPatent) entity);
		} else if (entity instanceof Person_ResultProduct) {
		    personResultProductRepository.delete((Person_ResultProduct) entity);
		} else if (entity instanceof Person_ResultPublication) {
		    personResultPublicationRepository.delete((Person_ResultPublication) entity);
		} else if (entity instanceof Person_Service) {
		    personServiceRepository.delete((Person_Service) entity);
		} else if (entity instanceof PostalAddress_Class) {
		    postalAddressClassRepository.delete((PostalAddress_Class) entity);
		} else if (entity instanceof PostalAddress_GeographicBoundingBox) {
		    postalAddressGeographicBoundingBoxRepository.delete((PostalAddress_GeographicBoundingBox) entity);
		} else if (entity instanceof Prize_Class) {
		    prizeClassRepository.delete((Prize_Class) entity);
		} else if (entity instanceof Project_Class) {
		    projectClassRepository.delete((Project_Class) entity);
		} else if (entity instanceof Project_DublinCore) {
		    projectDublinCoreRepository.delete((Project_DublinCore) entity);
		} else if (entity instanceof Project_Equipment) {
		    projectEquipmentRepository.delete((Project_Equipment) entity);
		} else if (entity instanceof Project_Event) {
		    projectEventRepository.delete((Project_Event) entity);
		} else if (entity instanceof Project_Facility) {
		    projectFacilityRepository.delete((Project_Facility) entity);
		} else if (entity instanceof Project_Funding) {
		    projectFundingRepository.delete((Project_Funding) entity);
		} else if (entity instanceof Project_Indicator) {
		    projectIndicatorRepository.delete((Project_Indicator) entity);
		} else if (entity instanceof Project_Measurement) {
		    projectMeasurementRepository.delete((Project_Measurement) entity);
		} else if (entity instanceof Project_Medium) {
		    projectMediumRepository.delete((Project_Medium) entity);
		} else if (entity instanceof Project_OrganisationUnit) {
		    projectOrganisationUnitRepository.delete((Project_OrganisationUnit) entity);
		} else if (entity instanceof Project_Person) {
		    projectPersonRepository.delete((Project_Person) entity);
		} else if (entity instanceof Project_Prize) {
		    projectPrizeRepository.delete((Project_Prize) entity);
		} else if (entity instanceof Project_Project) {
		    projectProjectRepository.delete((Project_Project) entity);
		} else if (entity instanceof Project_ResultPatent) {
		    projectResultPatentRepository.delete((Project_ResultPatent) entity);
		} else if (entity instanceof Project_ResultProduct) {
		    projectResultProductRepository.delete((Project_ResultProduct) entity);
		} else if (entity instanceof Project_ResultPublication) {
		    projectResultPublicationRepository.delete((Project_ResultPublication) entity);
		} else if (entity instanceof Project_Service) {
		    projectServiceRepository.delete((Project_Service) entity);
		} else if (entity instanceof Qualification_Class) {
		    qualificationClassRepository.delete((Qualification_Class) entity);
		} else if (entity instanceof ResultPatent_Class) {
		    resultPatentClassRepository.delete((ResultPatent_Class) entity);
		} else if (entity instanceof ResultPatent_Equipment) {
		    resultPatentEquipmentRepository.delete((ResultPatent_Equipment) entity);
		} else if (entity instanceof ResultPatent_Facility) {
		    resultPatentFacilityRepository.delete((ResultPatent_Facility) entity);
		} else if (entity instanceof ResultPatent_Funding) {
		    resultPatentFundingRepository.delete((ResultPatent_Funding) entity);
		} else if (entity instanceof ResultPatent_Indicator) {
		    resultPatentIndicatorRepository.delete((ResultPatent_Indicator) entity);
		} else if (entity instanceof ResultPatent_Measurement) {
		    resultPatentMeasurementRepository.delete((ResultPatent_Measurement) entity);
		} else if (entity instanceof ResultPatent_Medium) {
		    resultPatentMediumRepository.delete((ResultPatent_Medium) entity);
		} else if (entity instanceof ResultPatent_ResultPatent) {
		    resultPatentResultPatentRepository.delete((ResultPatent_ResultPatent) entity);
		} else if (entity instanceof ResultPatent_Service) {
		    resultPatentServiceRepository.delete((ResultPatent_Service) entity);
		} else if (entity instanceof ResultProduct_Class) {
		    resultProductClassRepository.delete((ResultProduct_Class) entity);
		} else if (entity instanceof ResultProduct_Country) {
		    resultProductCountryRepository.delete((ResultProduct_Country) entity);
		} else if (entity instanceof ResultProduct_Equipment) {
		    resultProductEquipmentRepository.delete((ResultProduct_Equipment) entity);
		} else if (entity instanceof ResultProduct_Facility) {
		    resultProductFacilityRepository.delete((ResultProduct_Facility) entity);
		} else if (entity instanceof ResultProduct_Funding) {
		    resultProductFundingRepository.delete((ResultProduct_Funding) entity);
		} else if (entity instanceof ResultProduct_GeographicBoundingBox) {
		    resultProductGeographicBoundingBoxRepository.delete((ResultProduct_GeographicBoundingBox) entity);
		} else if (entity instanceof ResultProduct_Indicator) {
		    resultProductIndicatorRepository.delete((ResultProduct_Indicator) entity);
		} else if (entity instanceof ResultProduct_Measurement) {
		    resultProductMeasurementRepository.delete((ResultProduct_Measurement) entity);
		} else if (entity instanceof ResultProduct_Medium) {
		    resultProductMediumRepository.delete((ResultProduct_Medium) entity);
		} else if (entity instanceof ResultProduct_ResultProduct) {
		    resultProductResultProductRepository.delete((ResultProduct_ResultProduct) entity);
		} else if (entity instanceof ResultProduct_Service) {
		    resultProductServiceRepository.delete((ResultProduct_Service) entity);
		} else if (entity instanceof ResultPublication_Citation) {
		    resultPublicationCitationRepository.delete((ResultPublication_Citation) entity);
		} else if (entity instanceof ResultPublication_Class) {
		    resultPublicationClassRepository.delete((ResultPublication_Class) entity);
		} else if (entity instanceof ResultPublication_DublinCore) {
		    resultPublicationDublinCoreRepository.delete((ResultPublication_DublinCore) entity);
		} else if (entity instanceof ResultPublication_Equipment) {
		    resultPublicationEquipmentRepository.delete((ResultPublication_Equipment) entity);
		} else if (entity instanceof ResultPublication_Event) {
		    resultPublicationEventRepository.delete((ResultPublication_Event) entity);
		} else if (entity instanceof ResultPublication_Facility) {
		    resultPublicationFacilityRepository.delete((ResultPublication_Facility) entity);
		} else if (entity instanceof ResultPublication_Funding) {
		    resultPublicationFundingRepository.delete((ResultPublication_Funding) entity);
		} else if (entity instanceof ResultPublication_Indicator) {
		    resultPublicationIndicatorRepository.delete((ResultPublication_Indicator) entity);
		} else if (entity instanceof ResultPublication_Measurement) {
		    resultPublicationMeasurementRepository.delete((ResultPublication_Measurement) entity);
		} else if (entity instanceof ResultPublication_Medium) {
		    resultPublicationMediumRepository.delete((ResultPublication_Medium) entity);
		} else if (entity instanceof ResultPublication_Metrics) {
		    resultPublicationMetricsRepository.delete((ResultPublication_Metrics) entity);
		} else if (entity instanceof ResultPublication_ResultPatent) {
		    resultPublicationResultPatentRepository.delete((ResultPublication_ResultPatent) entity);
		} else if (entity instanceof ResultPublication_ResultProduct) {
		    resultPublicationResultProductRepository.delete((ResultPublication_ResultProduct) entity);
		} else if (entity instanceof ResultPublication_ResultPublication) {
		    resultPublicationResultPublicationRepository.delete((ResultPublication_ResultPublication) entity);
		} else if (entity instanceof ResultPublication_Service) {
		    resultPublicationServiceRepository.delete((ResultPublication_Service) entity);
		} else if (entity instanceof Service_Class) {
		    serviceClassRepository.delete((Service_Class) entity);
		} else if (entity instanceof Service_Event) {
		    serviceEventRepository.delete((Service_Event) entity);
		} else if (entity instanceof Service_FederatedIdentifier) {
		    serviceFederatedIdentifierRepository.delete((Service_FederatedIdentifier) entity);
		} else if (entity instanceof Service_Funding) {
		    serviceFundingRepository.delete((Service_Funding) entity);
		} else if (entity instanceof Service_Indicator) {
		    serviceIndicatorRepository.delete((Service_Indicator) entity);
		} else if (entity instanceof Service_Measurement) {
		    serviceMeasurementRepository.delete((Service_Measurement) entity);
		} else if (entity instanceof Service_Medium) {
		    serviceMediumRepository.delete((Service_Medium) entity);
		} else if (entity instanceof Service_PostalAddress) {
		    servicePostalAddressRepository.delete((Service_PostalAddress) entity);
		} else if (entity instanceof Service_Service) {
		    serviceServiceRepository.delete((Service_Service) entity);

		} else {
			throw new IllegalArgumentException(String.format("Invalid link entity provided. %s", entity));
		}
	}
	
	/**
	 * Saves the provided link entity.
	 * @param entity The link entity.
	 */
	public CerifLinkEntity save(CerifLinkEntity entity) {
		if (entity instanceof Citation_Class) {
		    entity = citationClassRepository.save((Citation_Class) entity);
		} else if (entity instanceof Citation_Medium) {
		    entity = citationMediumRepository.save((Citation_Medium) entity);
		} else if (entity instanceof Class_Class) {
		    entity = classClassRepository.save((Class_Class) entity);
		} else if (entity instanceof ClassScheme_ClassScheme) {
		    entity = classSchemeClassSchemeRepository.save((ClassScheme_ClassScheme) entity);
		} else if (entity instanceof ClassScheme_OrganisationUnit) {
		    entity = classSchemeOrganisationUnitRepository.save((ClassScheme_OrganisationUnit) entity);
		} else if (entity instanceof ClassScheme_Class) {
		    entity = classSchemeClassRepository.save((ClassScheme_Class) entity);
		} else if (entity instanceof Country_Class) {
		    entity = countryClassRepository.save((Country_Class) entity);
		} else if (entity instanceof Currency_Class) {
		    entity = currencyClassRepository.save((Currency_Class) entity);
		} else if (entity instanceof Cv_Class) {
		    entity = cvClassRepository.save((Cv_Class) entity);
		} else if (entity instanceof ElectronicAddress_Class) {
		    entity = electronicAddressClassRepository.save((ElectronicAddress_Class) entity);
		} else if (entity instanceof Equipment_Class) {
		    entity = equipmentClassRepository.save((Equipment_Class) entity);
		} else if (entity instanceof Equipment_Equipment) {
		    entity = equipmentEquipmentRepository.save((Equipment_Equipment) entity);
		} else if (entity instanceof Equipment_Event) {
		    entity = equipmentEventRepository.save((Equipment_Event) entity);
		} else if (entity instanceof Equipment_Funding) {
		    entity = equipmentFundingRepository.save((Equipment_Funding) entity);
		} else if (entity instanceof Equipment_Indicator) {
		    entity = equipmentIndicatorRepository.save((Equipment_Indicator) entity);
		} else if (entity instanceof Equipment_Measurement) {
		    entity = equipmentMeasurementRepository.save((Equipment_Measurement) entity);
		} else if (entity instanceof Equipment_Medium) {
		    entity = equipmentMediumRepository.save((Equipment_Medium) entity);
		} else if (entity instanceof Equipment_PostalAddress) {
		    entity = equipmentPostalAddressRepository.save((Equipment_PostalAddress) entity);
		} else if (entity instanceof Equipment_Service) {
		    entity = equipmentServiceRepository.save((Equipment_Service) entity);
		} else if (entity instanceof Event_Class) {
		    entity = eventClassRepository.save((Event_Class) entity);
		} else if (entity instanceof Event_Event) {
		    entity = eventEventRepository.save((Event_Event) entity);
		} else if (entity instanceof Event_Funding) {
		    entity = eventFundingRepository.save((Event_Funding) entity);
		} else if (entity instanceof Event_Indicator) {
		    entity = eventIndicatorRepository.save((Event_Indicator) entity);
		} else if (entity instanceof Event_Measurement) {
		    entity = eventMeasurementRepository.save((Event_Measurement) entity);
		} else if (entity instanceof Event_Medium) {
		    entity = eventMediumRepository.save((Event_Medium) entity);
		} else if (entity instanceof ExpertiseAndSkills_Class) {
		    entity = expertiseAndSkillsClassRepository.save((ExpertiseAndSkills_Class) entity);
		} else if (entity instanceof Facility_Class) {
		    entity = facilityClassRepository.save((Facility_Class) entity);
		} else if (entity instanceof Facility_Equipment) {
		    entity = facilityEquipmentRepository.save((Facility_Equipment) entity);
		} else if (entity instanceof Facility_Event) {
		    entity = facilityEventRepository.save((Facility_Event) entity);
		} else if (entity instanceof Facility_Facility) {
		    entity = facilityFacilityRepository.save((Facility_Facility) entity);
		} else if (entity instanceof Facility_Funding) {
		    entity = facilityFundingRepository.save((Facility_Funding) entity);
		} else if (entity instanceof Facility_Indicator) {
		    entity = facilityIndicatorRepository.save((Facility_Indicator) entity);
		} else if (entity instanceof Facility_Measurement) {
		    entity = facilityMeasurementRepository.save((Facility_Measurement) entity);
		} else if (entity instanceof Facility_Medium) {
		    entity = facilityMediumRepository.save((Facility_Medium) entity);
		} else if (entity instanceof Facility_PostalAddress) {
		    entity = facilityPostalAddressRepository.save((Facility_PostalAddress) entity);
		} else if (entity instanceof Facility_Service) {
		    entity = facilityServiceRepository.save((Facility_Service) entity);
		} else if (entity instanceof FederatedIdentifier_Class) {
		    entity = federatedIdentifierClassRepository.save((FederatedIdentifier_Class) entity);
		} else if (entity instanceof Funding_Class) {
		    entity = fundingClassRepository.save((Funding_Class) entity);
		} else if (entity instanceof Funding_Funding) {
		    entity = fundingFundingRepository.save((Funding_Funding) entity);
		} else if (entity instanceof Funding_Indicator) {
		    entity = fundingIndicatorRepository.save((Funding_Indicator) entity);
		} else if (entity instanceof Funding_Measurement) {
		    entity = fundingMeasurementRepository.save((Funding_Measurement) entity);
		} else if (entity instanceof GeographicBoundingBox_Class) {
		    entity = geographicBoundingBoxClassRepository.save((GeographicBoundingBox_Class) entity);
		} else if (entity instanceof GeographicBoundingBox_GeographicBoundingBox) {
		    entity = geographicBoundingBoxGeographicBoundingBoxRepository.save((GeographicBoundingBox_GeographicBoundingBox) entity);
		} else if (entity instanceof Indicator_Class) {
		    entity = indicatorClassRepository.save((Indicator_Class) entity);
		} else if (entity instanceof Indicator_Indicator) {
		    entity = indicatorIndicatorRepository.save((Indicator_Indicator) entity);
		} else if (entity instanceof Indicator_Measurement) {
		    entity = indicatorMeasurementRepository.save((Indicator_Measurement) entity);
		} else if (entity instanceof Language_Class) {
		    entity = languageClassRepository.save((Language_Class) entity);
		} else if (entity instanceof Measurement_Class) {
		    entity = measurementClassRepository.save((Measurement_Class) entity);
		} else if (entity instanceof Measurement_Measurement) {
		    entity = measurementMeasurementRepository.save((Measurement_Measurement) entity);
		} else if (entity instanceof Medium_Class) {
		    entity = mediumClassRepository.save((Medium_Class) entity);
		} else if (entity instanceof Medium_Funding) {
		    entity = mediumFundingRepository.save((Medium_Funding) entity);
		} else if (entity instanceof Medium_Indicator) {
		    entity = mediumIndicatorRepository.save((Medium_Indicator) entity);
		} else if (entity instanceof Medium_Measurement) {
		    entity = mediumMeasurementRepository.save((Medium_Measurement) entity);
		} else if (entity instanceof Medium_Medium) {
		    entity = mediumMediumRepository.save((Medium_Medium) entity);
		} else if (entity instanceof Metrics_Class) {
		    entity = metricsClassRepository.save((Metrics_Class) entity);
		} else if (entity instanceof OrganisationUnit_Class) {
		    entity = organisationUnitClassRepository.save((OrganisationUnit_Class) entity);
		} else if (entity instanceof OrganisationUnit_DublinCore) {
		    entity = organisationUnitDublinCoreRepository.save((OrganisationUnit_DublinCore) entity);
		} else if (entity instanceof OrganisationUnit_ElectronicAddress) {
		    entity = organisationUnitElectronicAddressRepository.save((OrganisationUnit_ElectronicAddress) entity);
		} else if (entity instanceof OrganisationUnit_Equipment) {
		    entity = organisationUnitEquipmentRepository.save((OrganisationUnit_Equipment) entity);
		} else if (entity instanceof OrganisationUnit_Event) {
		    entity = organisationUnitEventRepository.save((OrganisationUnit_Event) entity);
		} else if (entity instanceof OrganisationUnit_ExpertiseAndSkills) {
		    entity = organisationUnitExpertiseAndSkillsRepository.save((OrganisationUnit_ExpertiseAndSkills) entity);
		} else if (entity instanceof OrganisationUnit_Facility) {
		    entity = organisationUnitFacilityRepository.save((OrganisationUnit_Facility) entity);
		} else if (entity instanceof OrganisationUnit_Funding) {
		    entity = organisationUnitFundingRepository.save((OrganisationUnit_Funding) entity);
		} else if (entity instanceof OrganisationUnit_Indicator) {
		    entity = organisationUnitIndicatorRepository.save((OrganisationUnit_Indicator) entity);
		} else if (entity instanceof OrganisationUnit_Measurement) {
		    entity = organisationUnitMeasurementRepository.save((OrganisationUnit_Measurement) entity);
		} else if (entity instanceof OrganisationUnit_Medium) {
		    entity = organisationUnitMediumRepository.save((OrganisationUnit_Medium) entity);
		} else if (entity instanceof OrganisationUnit_OrganisationUnit) {
		    entity = organisationUnitOrganisationUnitRepository.save((OrganisationUnit_OrganisationUnit) entity);
		} else if (entity instanceof OrganisationUnit_PostalAddress) {
		    entity = organisationUnitPostalAddressRepository.save((OrganisationUnit_PostalAddress) entity);
		} else if (entity instanceof OrganisationUnit_Prize) {
		    entity = organisationUnitPrizeRepository.save((OrganisationUnit_Prize) entity);
		} else if (entity instanceof OrganisationUnit_ResultPatent) {
		    entity = organisationUnitResultPatentRepository.save((OrganisationUnit_ResultPatent) entity);
		} else if (entity instanceof OrganisationUnit_ResultProduct) {
		    entity = organisationUnitResultProductRepository.save((OrganisationUnit_ResultProduct) entity);
		} else if (entity instanceof OrganisationUnit_ResultPublication) {
		    entity = organisationUnitResultPublicationRepository.save((OrganisationUnit_ResultPublication) entity);
		} else if (entity instanceof OrganisationUnit_Service) {
		    entity = organisationUnitServiceRepository.save((OrganisationUnit_Service) entity);
		} else if (entity instanceof Person_Class) {
		    entity = personClassRepository.save((Person_Class) entity);
		} else if (entity instanceof Person_Country) {
		    entity = personCountryRepository.save((Person_Country) entity);
		} else if (entity instanceof Person_Cv) {
		    entity = personCvRepository.save((Person_Cv) entity);
		} else if (entity instanceof Person_DublinCore) {
		    entity = personDublinCoreRepository.save((Person_DublinCore) entity);
		} else if (entity instanceof Person_ElectronicAddress) {
		    entity = personElectronicAddressRepository.save((Person_ElectronicAddress) entity);
		} else if (entity instanceof Person_Equipment) {
		    entity = personEquipmentRepository.save((Person_Equipment) entity);
		} else if (entity instanceof Person_Event) {
		    entity = personEventRepository.save((Person_Event) entity);
		} else if (entity instanceof Person_ExpertiseAndSkills) {
		    entity = personExpertiseAndSkillsRepository.save((Person_ExpertiseAndSkills) entity);
		} else if (entity instanceof Person_Facility) {
		    entity = personFacilityRepository.save((Person_Facility) entity);
		} else if (entity instanceof Person_Funding) {
		    entity = personFundingRepository.save((Person_Funding) entity);
		} else if (entity instanceof Person_Indicator) {
		    entity = personIndicatorRepository.save((Person_Indicator) entity);
		} else if (entity instanceof Person_Language) {
		    entity = personLanguageRepository.save((Person_Language) entity);
		} else if (entity instanceof Person_Measurement) {
		    entity = personMeasurementRepository.save((Person_Measurement) entity);
		} else if (entity instanceof Person_Medium) {
		    entity = personMediumRepository.save((Person_Medium) entity);
		} else if (entity instanceof Person_OrganisationUnit) {
		    entity = personOrganisationUnitRepository.save((Person_OrganisationUnit) entity);
		} else if (entity instanceof Person_Person) {
		    entity = personPersonRepository.save((Person_Person) entity);
		} else if (entity instanceof Person_PostalAddress) {
		    entity = personPostalAddressRepository.save((Person_PostalAddress) entity);
		} else if (entity instanceof Person_Prize) {
		    entity = personPrizeRepository.save((Person_Prize) entity);
		} else if (entity instanceof Person_Qualification) {
		    entity = personQualificationRepository.save((Person_Qualification) entity);
		} else if (entity instanceof Person_ResultPatent) {
		    entity = personResultPatentRepository.save((Person_ResultPatent) entity);
		} else if (entity instanceof Person_ResultProduct) {
		    entity = personResultProductRepository.save((Person_ResultProduct) entity);
		} else if (entity instanceof Person_ResultPublication) {
		    entity = personResultPublicationRepository.save((Person_ResultPublication) entity);
		} else if (entity instanceof Person_Service) {
		    entity = personServiceRepository.save((Person_Service) entity);
		} else if (entity instanceof PostalAddress_Class) {
		    entity = postalAddressClassRepository.save((PostalAddress_Class) entity);
		} else if (entity instanceof PostalAddress_GeographicBoundingBox) {
		    entity = postalAddressGeographicBoundingBoxRepository.save((PostalAddress_GeographicBoundingBox) entity);
		} else if (entity instanceof Prize_Class) {
		    entity = prizeClassRepository.save((Prize_Class) entity);
		} else if (entity instanceof Project_Class) {
		    entity = projectClassRepository.save((Project_Class) entity);
		} else if (entity instanceof Project_DublinCore) {
		    entity = projectDublinCoreRepository.save((Project_DublinCore) entity);
		} else if (entity instanceof Project_Equipment) {
		    entity = projectEquipmentRepository.save((Project_Equipment) entity);
		} else if (entity instanceof Project_Event) {
		    entity = projectEventRepository.save((Project_Event) entity);
		} else if (entity instanceof Project_Facility) {
		    entity = projectFacilityRepository.save((Project_Facility) entity);
		} else if (entity instanceof Project_Funding) {
		    entity = projectFundingRepository.save((Project_Funding) entity);
		} else if (entity instanceof Project_Indicator) {
		    entity = projectIndicatorRepository.save((Project_Indicator) entity);
		} else if (entity instanceof Project_Measurement) {
		    entity = projectMeasurementRepository.save((Project_Measurement) entity);
		} else if (entity instanceof Project_Medium) {
		    entity = projectMediumRepository.save((Project_Medium) entity);
		} else if (entity instanceof Project_OrganisationUnit) {
		    entity = projectOrganisationUnitRepository.save((Project_OrganisationUnit) entity);
		} else if (entity instanceof Project_Person) {
		    entity = projectPersonRepository.save((Project_Person) entity);
		} else if (entity instanceof Project_Prize) {
		    entity = projectPrizeRepository.save((Project_Prize) entity);
		} else if (entity instanceof Project_Project) {
		    entity = projectProjectRepository.save((Project_Project) entity);
		} else if (entity instanceof Project_ResultPatent) {
		    entity = projectResultPatentRepository.save((Project_ResultPatent) entity);
		} else if (entity instanceof Project_ResultProduct) {
		    entity = projectResultProductRepository.save((Project_ResultProduct) entity);
		} else if (entity instanceof Project_ResultPublication) {
		    entity = projectResultPublicationRepository.save((Project_ResultPublication) entity);
		} else if (entity instanceof Project_Service) {
		    entity = projectServiceRepository.save((Project_Service) entity);
		} else if (entity instanceof Qualification_Class) {
		    entity = qualificationClassRepository.save((Qualification_Class) entity);
		} else if (entity instanceof ResultPatent_Class) {
		    entity = resultPatentClassRepository.save((ResultPatent_Class) entity);
		} else if (entity instanceof ResultPatent_Equipment) {
		    entity = resultPatentEquipmentRepository.save((ResultPatent_Equipment) entity);
		} else if (entity instanceof ResultPatent_Facility) {
		    entity = resultPatentFacilityRepository.save((ResultPatent_Facility) entity);
		} else if (entity instanceof ResultPatent_Funding) {
		    entity = resultPatentFundingRepository.save((ResultPatent_Funding) entity);
		} else if (entity instanceof ResultPatent_Indicator) {
		    entity = resultPatentIndicatorRepository.save((ResultPatent_Indicator) entity);
		} else if (entity instanceof ResultPatent_Measurement) {
		    entity = resultPatentMeasurementRepository.save((ResultPatent_Measurement) entity);
		} else if (entity instanceof ResultPatent_Medium) {
		    entity = resultPatentMediumRepository.save((ResultPatent_Medium) entity);
		} else if (entity instanceof ResultPatent_ResultPatent) {
		    entity = resultPatentResultPatentRepository.save((ResultPatent_ResultPatent) entity);
		} else if (entity instanceof ResultPatent_Service) {
		    entity = resultPatentServiceRepository.save((ResultPatent_Service) entity);
		} else if (entity instanceof ResultProduct_Class) {
		    entity = resultProductClassRepository.save((ResultProduct_Class) entity);
		} else if (entity instanceof ResultProduct_Country) {
		    entity = resultProductCountryRepository.save((ResultProduct_Country) entity);
		} else if (entity instanceof ResultProduct_Equipment) {
		    entity = resultProductEquipmentRepository.save((ResultProduct_Equipment) entity);
		} else if (entity instanceof ResultProduct_Facility) {
		    entity = resultProductFacilityRepository.save((ResultProduct_Facility) entity);
		} else if (entity instanceof ResultProduct_Funding) {
		    entity = resultProductFundingRepository.save((ResultProduct_Funding) entity);
		} else if (entity instanceof ResultProduct_GeographicBoundingBox) {
		    entity = resultProductGeographicBoundingBoxRepository.save((ResultProduct_GeographicBoundingBox) entity);
		} else if (entity instanceof ResultProduct_Indicator) {
		    entity = resultProductIndicatorRepository.save((ResultProduct_Indicator) entity);
		} else if (entity instanceof ResultProduct_Measurement) {
		    entity = resultProductMeasurementRepository.save((ResultProduct_Measurement) entity);
		} else if (entity instanceof ResultProduct_Medium) {
		    entity = resultProductMediumRepository.save((ResultProduct_Medium) entity);
		} else if (entity instanceof ResultProduct_ResultProduct) {
		    entity = resultProductResultProductRepository.save((ResultProduct_ResultProduct) entity);
		} else if (entity instanceof ResultProduct_Service) {
		    entity = resultProductServiceRepository.save((ResultProduct_Service) entity);
		} else if (entity instanceof ResultPublication_Citation) {
		    entity = resultPublicationCitationRepository.save((ResultPublication_Citation) entity);
		} else if (entity instanceof ResultPublication_Class) {
		    entity = resultPublicationClassRepository.save((ResultPublication_Class) entity);
		} else if (entity instanceof ResultPublication_DublinCore) {
		    entity = resultPublicationDublinCoreRepository.save((ResultPublication_DublinCore) entity);
		} else if (entity instanceof ResultPublication_Equipment) {
		    entity = resultPublicationEquipmentRepository.save((ResultPublication_Equipment) entity);
		} else if (entity instanceof ResultPublication_Event) {
		    entity = resultPublicationEventRepository.save((ResultPublication_Event) entity);
		} else if (entity instanceof ResultPublication_Facility) {
		    entity = resultPublicationFacilityRepository.save((ResultPublication_Facility) entity);
		} else if (entity instanceof ResultPublication_Funding) {
		    entity = resultPublicationFundingRepository.save((ResultPublication_Funding) entity);
		} else if (entity instanceof ResultPublication_Indicator) {
		    entity = resultPublicationIndicatorRepository.save((ResultPublication_Indicator) entity);
		} else if (entity instanceof ResultPublication_Measurement) {
		    entity = resultPublicationMeasurementRepository.save((ResultPublication_Measurement) entity);
		} else if (entity instanceof ResultPublication_Medium) {
		    entity = resultPublicationMediumRepository.save((ResultPublication_Medium) entity);
		} else if (entity instanceof ResultPublication_Metrics) {
		    entity = resultPublicationMetricsRepository.save((ResultPublication_Metrics) entity);
		} else if (entity instanceof ResultPublication_ResultPatent) {
		    entity = resultPublicationResultPatentRepository.save((ResultPublication_ResultPatent) entity);
		} else if (entity instanceof ResultPublication_ResultProduct) {
		    entity = resultPublicationResultProductRepository.save((ResultPublication_ResultProduct) entity);
		} else if (entity instanceof ResultPublication_ResultPublication) {
		    entity = resultPublicationResultPublicationRepository.save((ResultPublication_ResultPublication) entity);
		} else if (entity instanceof ResultPublication_Service) {
		    entity = resultPublicationServiceRepository.save((ResultPublication_Service) entity);
		} else if (entity instanceof Service_Class) {
		    entity = serviceClassRepository.save((Service_Class) entity);
		} else if (entity instanceof Service_Event) {
		    entity = serviceEventRepository.save((Service_Event) entity);
		} else if (entity instanceof Service_FederatedIdentifier) {
		    entity = serviceFederatedIdentifierRepository.save((Service_FederatedIdentifier) entity);
		} else if (entity instanceof Service_Funding) {
		    entity = serviceFundingRepository.save((Service_Funding) entity);
		} else if (entity instanceof Service_Indicator) {
		    entity = serviceIndicatorRepository.save((Service_Indicator) entity);
		} else if (entity instanceof Service_Measurement) {
		    entity = serviceMeasurementRepository.save((Service_Measurement) entity);
		} else if (entity instanceof Service_Medium) {
		    entity = serviceMediumRepository.save((Service_Medium) entity);
		} else if (entity instanceof Service_PostalAddress) {
		    entity = servicePostalAddressRepository.save((Service_PostalAddress) entity);
		} else if (entity instanceof Service_Service) {
		    entity = serviceServiceRepository.save((Service_Service) entity);

		} else {
			throw new IllegalArgumentException(String.format("Invalid link entity provided. %s", entity));
		}
		
		return entity;
	}

	/**
	 * Deletes the provided link entities.
	 * @TODO For Every Entity implement Delete
	 * @param entity The link entities.
	 */
	@SuppressWarnings("unchecked")
	public void delete(List<? extends CerifLinkEntity> entityList) {
		
		final CerifLinkEntity entity = (CerifLinkEntity)entityList.get(0);
		
		if (entity instanceof Citation_Class) {
		    citationClassRepository.delete((List<Citation_Class>) entityList);
		} else if (entity instanceof Citation_Medium) {
		    citationMediumRepository.delete((List<Citation_Medium>) entityList);
		} else if (entity instanceof Class_Class) {
		    classClassRepository.delete((List<Class_Class>) entityList);
		} else if (entity instanceof ClassScheme_ClassScheme) {
		    classSchemeClassSchemeRepository.delete((List<ClassScheme_ClassScheme>) entityList);
		} else if (entity instanceof ClassScheme_Class) {
		    classSchemeClassRepository.delete((List<ClassScheme_Class>) entityList);
		} else if (entity instanceof ClassScheme_OrganisationUnit) {
		    classSchemeOrganisationUnitRepository.delete((List<ClassScheme_OrganisationUnit>) entityList);
		} else if (entity instanceof Country_Class) {
		    countryClassRepository.delete((List<Country_Class>) entityList);
		} else if (entity instanceof Currency_Class) {
		    currencyClassRepository.delete((List<Currency_Class>) entityList);
		} else if (entity instanceof Cv_Class) {
		    cvClassRepository.delete((List<Cv_Class>) entityList);
		} else if (entity instanceof ElectronicAddress_Class) {
		    electronicAddressClassRepository.delete((List<ElectronicAddress_Class>) entityList);
		} else if (entity instanceof Equipment_Class) {
		    equipmentClassRepository.delete((List<Equipment_Class>) entityList);
		} else if (entity instanceof Equipment_Equipment) {
		    equipmentEquipmentRepository.delete((List<Equipment_Equipment>) entityList);
		} else if (entity instanceof Equipment_Event) {
		    equipmentEventRepository.delete((List<Equipment_Event>) entityList);
		} else if (entity instanceof Equipment_Funding) {
		    equipmentFundingRepository.delete((List<Equipment_Funding>) entityList);
		} else if (entity instanceof Equipment_Indicator) {
		    equipmentIndicatorRepository.delete((List<Equipment_Indicator>) entityList);
		} else if (entity instanceof Equipment_Measurement) {
		    equipmentMeasurementRepository.delete((List<Equipment_Measurement>) entityList);
		} else if (entity instanceof Equipment_Medium) {
		    equipmentMediumRepository.delete((List<Equipment_Medium>) entityList);
		} else if (entity instanceof Equipment_PostalAddress) {
		    equipmentPostalAddressRepository.delete((List<Equipment_PostalAddress>) entityList);
		} else if (entity instanceof Equipment_Service) {
		    equipmentServiceRepository.delete((List<Equipment_Service>) entityList);
		} else if (entity instanceof Event_Class) {
		    eventClassRepository.delete((List<Event_Class>) entityList);
		} else if (entity instanceof Event_Event) {
		    eventEventRepository.delete((List<Event_Event>) entityList);
		} else if (entity instanceof Event_Funding) {
		    eventFundingRepository.delete((List<Event_Funding>) entityList);
		} else if (entity instanceof Event_Indicator) {
		    eventIndicatorRepository.delete((List<Event_Indicator>) entityList);
		} else if (entity instanceof Event_Measurement) {
		    eventMeasurementRepository.delete((List<Event_Measurement>) entityList);
		} else if (entity instanceof Event_Medium) {
		    eventMediumRepository.delete((List<Event_Medium>) entityList);
		} else if (entity instanceof ExpertiseAndSkills_Class) {
		    expertiseAndSkillsClassRepository.delete((List<ExpertiseAndSkills_Class>) entityList);
		} else if (entity instanceof Facility_Class) {
		    facilityClassRepository.delete((List<Facility_Class>) entityList);
		} else if (entity instanceof Facility_Equipment) {
		    facilityEquipmentRepository.delete((List<Facility_Equipment>) entityList);
		} else if (entity instanceof Facility_Event) {
		    facilityEventRepository.delete((List<Facility_Event>) entityList);
		} else if (entity instanceof Facility_Facility) {
		    facilityFacilityRepository.delete((List<Facility_Facility>) entityList);
		} else if (entity instanceof Facility_Funding) {
		    facilityFundingRepository.delete((List<Facility_Funding>) entityList);
		} else if (entity instanceof Facility_Indicator) {
		    facilityIndicatorRepository.delete((List<Facility_Indicator>) entityList);
		} else if (entity instanceof Facility_Measurement) {
		    facilityMeasurementRepository.delete((List<Facility_Measurement>) entityList);
		} else if (entity instanceof Facility_Medium) {
		    facilityMediumRepository.delete((List<Facility_Medium>) entityList);
		} else if (entity instanceof Facility_PostalAddress) {
		    facilityPostalAddressRepository.delete((List<Facility_PostalAddress>) entityList);
		} else if (entity instanceof Facility_Service) {
		    facilityServiceRepository.delete((List<Facility_Service>) entityList);
		} else if (entity instanceof FederatedIdentifier_Class) {
		    federatedIdentifierClassRepository.delete((List<FederatedIdentifier_Class>) entityList);
		} else if (entity instanceof Funding_Class) {
		    fundingClassRepository.delete((List<Funding_Class>) entityList);
		} else if (entity instanceof Funding_Funding) {
		    fundingFundingRepository.delete((List<Funding_Funding>) entityList);
		} else if (entity instanceof Funding_Indicator) {
		    fundingIndicatorRepository.delete((List<Funding_Indicator>) entityList);
		} else if (entity instanceof Funding_Measurement) {
		    fundingMeasurementRepository.delete((List<Funding_Measurement>) entityList);
		} else if (entity instanceof GeographicBoundingBox_Class) {
		    geographicBoundingBoxClassRepository.delete((List<GeographicBoundingBox_Class>) entityList);
		} else if (entity instanceof GeographicBoundingBox_GeographicBoundingBox) {
		    geographicBoundingBoxGeographicBoundingBoxRepository.delete((List<GeographicBoundingBox_GeographicBoundingBox>) entityList);
		} else if (entity instanceof Indicator_Class) {
		    indicatorClassRepository.delete((List<Indicator_Class>) entityList);
		} else if (entity instanceof Indicator_Indicator) {
		    indicatorIndicatorRepository.delete((List<Indicator_Indicator>) entityList);
		} else if (entity instanceof Indicator_Measurement) {
		    indicatorMeasurementRepository.delete((List<Indicator_Measurement>) entityList);
		} else if (entity instanceof Language_Class) {
		    languageClassRepository.delete((List<Language_Class>) entityList);
		} else if (entity instanceof Measurement_Class) {
		    measurementClassRepository.delete((List<Measurement_Class>) entityList);
		} else if (entity instanceof Measurement_Measurement) {
		    measurementMeasurementRepository.delete((List<Measurement_Measurement>) entityList);
		} else if (entity instanceof Medium_Class) {
		    mediumClassRepository.delete((List<Medium_Class>) entityList);
		} else if (entity instanceof Medium_Funding) {
		    mediumFundingRepository.delete((List<Medium_Funding>) entityList);
		} else if (entity instanceof Medium_Indicator) {
		    mediumIndicatorRepository.delete((List<Medium_Indicator>) entityList);
		} else if (entity instanceof Medium_Measurement) {
		    mediumMeasurementRepository.delete((List<Medium_Measurement>) entityList);
		} else if (entity instanceof Medium_Medium) {
		    mediumMediumRepository.delete((List<Medium_Medium>) entityList);
		} else if (entity instanceof Metrics_Class) {
		    metricsClassRepository.delete((List<Metrics_Class>) entityList);
		} else if (entity instanceof OrganisationUnit_Class) {
		    organisationUnitClassRepository.delete((List<OrganisationUnit_Class>) entityList);
		} else if (entity instanceof OrganisationUnit_DublinCore) {
		    organisationUnitDublinCoreRepository.delete((List<OrganisationUnit_DublinCore>) entityList);
		} else if (entity instanceof OrganisationUnit_ElectronicAddress) {
		    organisationUnitElectronicAddressRepository.delete((List<OrganisationUnit_ElectronicAddress>) entityList);
		} else if (entity instanceof OrganisationUnit_Equipment) {
		    organisationUnitEquipmentRepository.delete((List<OrganisationUnit_Equipment>) entityList);
		} else if (entity instanceof OrganisationUnit_Event) {
		    organisationUnitEventRepository.delete((List<OrganisationUnit_Event>) entityList);
		} else if (entity instanceof OrganisationUnit_ExpertiseAndSkills) {
		    organisationUnitExpertiseAndSkillsRepository.delete((List<OrganisationUnit_ExpertiseAndSkills>) entityList);
		} else if (entity instanceof OrganisationUnit_Facility) {
		    organisationUnitFacilityRepository.delete((List<OrganisationUnit_Facility>) entityList);
		} else if (entity instanceof OrganisationUnit_Funding) {
		    organisationUnitFundingRepository.delete((List<OrganisationUnit_Funding>) entityList);
		} else if (entity instanceof OrganisationUnit_Indicator) {
		    organisationUnitIndicatorRepository.delete((List<OrganisationUnit_Indicator>) entityList);
		} else if (entity instanceof OrganisationUnit_Measurement) {
		    organisationUnitMeasurementRepository.delete((List<OrganisationUnit_Measurement>) entityList);
		} else if (entity instanceof OrganisationUnit_Medium) {
			organisationUnitMediumRepository.delete((List<OrganisationUnit_Medium>) entityList);
		} else if (entity instanceof OrganisationUnit_OrganisationUnit) {
		    organisationUnitOrganisationUnitRepository.delete((List<OrganisationUnit_OrganisationUnit>) entityList);
		} else if (entity instanceof OrganisationUnit_PostalAddress) {
		    organisationUnitPostalAddressRepository.delete((List<OrganisationUnit_PostalAddress>) entityList);
		} else if (entity instanceof OrganisationUnit_Prize) {
		    organisationUnitPrizeRepository.delete((List<OrganisationUnit_Prize>) entityList);
		} else if (entity instanceof OrganisationUnit_ResultPatent) {
		    organisationUnitResultPatentRepository.delete((List<OrganisationUnit_ResultPatent>) entityList);
		} else if (entity instanceof OrganisationUnit_ResultProduct) {
		    organisationUnitResultProductRepository.delete((List<OrganisationUnit_ResultProduct>) entityList);
		} else if (entity instanceof OrganisationUnit_ResultPublication) {
		    organisationUnitResultPublicationRepository.delete((List<OrganisationUnit_ResultPublication>) entityList);
		} else if (entity instanceof OrganisationUnit_Service) {
		    organisationUnitServiceRepository.delete((List<OrganisationUnit_Service>) entityList);
		} else if (entity instanceof Person_Class) {
		    personClassRepository.delete((List<Person_Class>) entityList);
		} else if (entity instanceof Person_Country) {
		    personCountryRepository.delete((List<Person_Country>) entityList);
		} else if (entity instanceof Person_Cv) {
		    personCvRepository.delete((List<Person_Cv>) entityList);
		} else if (entity instanceof Person_DublinCore) {
		    personDublinCoreRepository.delete((List<Person_DublinCore>) entityList);
		} else if (entity instanceof Person_ElectronicAddress) {
		    personElectronicAddressRepository.delete((List<Person_ElectronicAddress>) entityList);
		} else if (entity instanceof Person_Equipment) {
		    personEquipmentRepository.delete((List<Person_Equipment>) entityList);
		} else if (entity instanceof Person_Event) {
		    personEventRepository.delete((List<Person_Event>) entityList);
		} else if (entity instanceof Person_ExpertiseAndSkills) {
		    personExpertiseAndSkillsRepository.delete((List<Person_ExpertiseAndSkills>) entityList);
		} else if (entity instanceof Person_Facility) {
		    personFacilityRepository.delete((List<Person_Facility>) entityList);
		} else if (entity instanceof Person_Funding) {
		    personFundingRepository.delete((List<Person_Funding>) entityList);
		} else if (entity instanceof Person_Indicator) {
		    personIndicatorRepository.delete((List<Person_Indicator>) entityList);
		} else if (entity instanceof Person_Language) {
		    personLanguageRepository.delete((List<Person_Language>) entityList);
		} else if (entity instanceof Person_Measurement) {
		    personMeasurementRepository.delete((List<Person_Measurement>) entityList);
		} else if (entity instanceof Person_Medium) {
		    personMediumRepository.delete((List<Person_Medium>) entityList);
		} else if (entity instanceof Person_OrganisationUnit) {
		    personOrganisationUnitRepository.delete((List<Person_OrganisationUnit>) entityList);
		} else if (entity instanceof Person_Person) {
		    personPersonRepository.delete((List<Person_Person>) entityList);
		} else if (entity instanceof Person_PostalAddress) {
		    personPostalAddressRepository.delete((List<Person_PostalAddress>) entityList);
		} else if (entity instanceof Person_Prize) {
		    personPrizeRepository.delete((List<Person_Prize>) entityList);
		} else if (entity instanceof Person_Qualification) {
		    personQualificationRepository.delete((List<Person_Qualification>) entityList);
		} else if (entity instanceof Person_ResultPatent) {
		    personResultPatentRepository.delete((List<Person_ResultPatent>) entityList);
		} else if (entity instanceof Person_ResultProduct) {
		    personResultProductRepository.delete((List<Person_ResultProduct>) entityList);
		} else if (entity instanceof Person_ResultPublication) {
		    personResultPublicationRepository.delete((List<Person_ResultPublication>) entityList);
		} else if (entity instanceof Person_Service) {
		    personServiceRepository.delete((List<Person_Service>) entityList);
		} else if (entity instanceof PostalAddress_Class) {
		    postalAddressClassRepository.delete((List<PostalAddress_Class>) entityList);
		} else if (entity instanceof PostalAddress_GeographicBoundingBox) {
		    postalAddressGeographicBoundingBoxRepository.delete((List<PostalAddress_GeographicBoundingBox>) entityList);
		} else if (entity instanceof Prize_Class) {
		    prizeClassRepository.delete((List<Prize_Class>) entityList);
		} else if (entity instanceof Project_Class) {
		    projectClassRepository.delete((List<Project_Class>) entityList);
		} else if (entity instanceof Project_DublinCore) {
		    projectDublinCoreRepository.delete((List<Project_DublinCore>) entityList);
		} else if (entity instanceof Project_Equipment) {
		    projectEquipmentRepository.delete((List<Project_Equipment>) entityList);
		} else if (entity instanceof Project_Event) {
		    projectEventRepository.delete((List<Project_Event>) entityList);
		} else if (entity instanceof Project_Facility) {
		    projectFacilityRepository.delete((List<Project_Facility>) entityList);
		} else if (entity instanceof Project_Funding) {
		    projectFundingRepository.delete((List<Project_Funding>) entityList);
		} else if (entity instanceof Project_Indicator) {
		    projectIndicatorRepository.delete((List<Project_Indicator>) entityList);
		} else if (entity instanceof Project_Measurement) {
		    projectMeasurementRepository.delete((List<Project_Measurement>) entityList);
		} else if (entity instanceof Project_Medium) {
		    projectMediumRepository.delete((List<Project_Medium>) entityList);
		} else if (entity instanceof Project_OrganisationUnit) {
		    projectOrganisationUnitRepository.delete((List<Project_OrganisationUnit>) entityList);
		} else if (entity instanceof Project_Person) {
		    projectPersonRepository.delete((List<Project_Person>) entityList);
		} else if (entity instanceof Project_Prize) {
		    projectPrizeRepository.delete((List<Project_Prize>) entityList);
		} else if (entity instanceof Project_Project) {
		    projectProjectRepository.delete((List<Project_Project>) entityList);
		} else if (entity instanceof Project_ResultPatent) {
		    projectResultPatentRepository.delete((List<Project_ResultPatent>) entityList);
		} else if (entity instanceof Project_ResultProduct) {
		    projectResultProductRepository.delete((List<Project_ResultProduct>) entityList);
		} else if (entity instanceof Project_ResultPublication) {
		    projectResultPublicationRepository.delete((List<Project_ResultPublication>) entityList);
		} else if (entity instanceof Project_Service) {
		    projectServiceRepository.delete((List<Project_Service>) entityList);
		} else if (entity instanceof Qualification_Class) {
		    qualificationClassRepository.delete((List<Qualification_Class>) entityList);
		} else if (entity instanceof ResultPatent_Class) {
		    resultPatentClassRepository.delete((List<ResultPatent_Class>) entityList);
		} else if (entity instanceof ResultPatent_Equipment) {
		    resultPatentEquipmentRepository.delete((List<ResultPatent_Equipment>) entityList);
		} else if (entity instanceof ResultPatent_Facility) {
		    resultPatentFacilityRepository.delete((List<ResultPatent_Facility>) entityList);
		} else if (entity instanceof ResultPatent_Funding) {
		    resultPatentFundingRepository.delete((List<ResultPatent_Funding>) entityList);
		} else if (entity instanceof ResultPatent_Indicator) {
		    resultPatentIndicatorRepository.delete((List<ResultPatent_Indicator>) entityList);
		} else if (entity instanceof ResultPatent_Measurement) {
		    resultPatentMeasurementRepository.delete((List<ResultPatent_Measurement>) entityList);
		} else if (entity instanceof ResultPatent_Medium) {
		    resultPatentMediumRepository.delete((List<ResultPatent_Medium>) entityList);
		} else if (entity instanceof ResultPatent_ResultPatent) {
		    resultPatentResultPatentRepository.delete((List<ResultPatent_ResultPatent>) entityList);
		} else if (entity instanceof ResultPatent_Service) {
		    resultPatentServiceRepository.delete((List<ResultPatent_Service>) entityList);
		} else if (entity instanceof ResultProduct_Class) {
		    resultProductClassRepository.delete((List<ResultProduct_Class>) entityList);
		} else if (entity instanceof ResultProduct_Country) {
		    resultProductCountryRepository.delete((List<ResultProduct_Country>) entityList);
		} else if (entity instanceof ResultProduct_Equipment) {
		    resultProductEquipmentRepository.delete((List<ResultProduct_Equipment>) entityList);
		} else if (entity instanceof ResultProduct_Facility) {
		    resultProductFacilityRepository.delete((List<ResultProduct_Facility>) entityList);
		} else if (entity instanceof ResultProduct_Funding) {
		    resultProductFundingRepository.delete((List<ResultProduct_Funding>) entityList);
		} else if (entity instanceof ResultProduct_GeographicBoundingBox) {
		    resultProductGeographicBoundingBoxRepository.delete((List<ResultProduct_GeographicBoundingBox>) entityList);
		} else if (entity instanceof ResultProduct_Indicator) {
		    resultProductIndicatorRepository.delete((List<ResultProduct_Indicator>) entityList);
		} else if (entity instanceof ResultProduct_Measurement) {
		    resultProductMeasurementRepository.delete((List<ResultProduct_Measurement>) entityList);
		} else if (entity instanceof ResultProduct_Medium) {
		    resultProductMediumRepository.delete((List<ResultProduct_Medium>) entityList);
		} else if (entity instanceof ResultProduct_ResultProduct) {
		    resultProductResultProductRepository.delete((List<ResultProduct_ResultProduct>) entityList);
		} else if (entity instanceof ResultProduct_Service) {
		    resultProductServiceRepository.delete((List<ResultProduct_Service>) entityList);
		} else if (entity instanceof ResultPublication_Citation) {
		    resultPublicationCitationRepository.delete((List<ResultPublication_Citation>) entityList);
		} else if (entity instanceof ResultPublication_Class) {
		    resultPublicationClassRepository.delete((List<ResultPublication_Class>) entityList);
		} else if (entity instanceof ResultPublication_DublinCore) {
		    resultPublicationDublinCoreRepository.delete((List<ResultPublication_DublinCore>) entityList);
		} else if (entity instanceof ResultPublication_Equipment) {
		    resultPublicationEquipmentRepository.delete((List<ResultPublication_Equipment>) entityList);
		} else if (entity instanceof ResultPublication_Event) {
		    resultPublicationEventRepository.delete((List<ResultPublication_Event>) entityList);
		} else if (entity instanceof ResultPublication_Facility) {
		    resultPublicationFacilityRepository.delete((List<ResultPublication_Facility>) entityList);
		} else if (entity instanceof ResultPublication_Funding) {
		    resultPublicationFundingRepository.delete((List<ResultPublication_Funding>) entityList);
		} else if (entity instanceof ResultPublication_Indicator) {
		    resultPublicationIndicatorRepository.delete((List<ResultPublication_Indicator>) entityList);
		} else if (entity instanceof ResultPublication_Measurement) {
		    resultPublicationMeasurementRepository.delete((List<ResultPublication_Measurement>) entityList);
		} else if (entity instanceof ResultPublication_Medium) {
		    resultPublicationMediumRepository.delete((List<ResultPublication_Medium>) entityList);
		} else if (entity instanceof ResultPublication_Metrics) {
		    resultPublicationMetricsRepository.delete((List<ResultPublication_Metrics>) entityList);
		} else if (entity instanceof ResultPublication_ResultPatent) {
		    resultPublicationResultPatentRepository.delete((List<ResultPublication_ResultPatent>) entityList);
		} else if (entity instanceof ResultPublication_ResultProduct) {
		    resultPublicationResultProductRepository.delete((List<ResultPublication_ResultProduct>) entityList);
		} else if (entity instanceof ResultPublication_ResultPublication) {
		    resultPublicationResultPublicationRepository.delete((List<ResultPublication_ResultPublication>) entityList);
		} else if (entity instanceof ResultPublication_Service) {
		    resultPublicationServiceRepository.delete((List<ResultPublication_Service>) entityList);
		} else if (entity instanceof Service_Class) {
		    serviceClassRepository.delete((List<Service_Class>) entityList);
		} else if (entity instanceof Service_Event) {
		    serviceEventRepository.delete((List<Service_Event>) entityList);
		} else if (entity instanceof Service_FederatedIdentifier) {
		    serviceFederatedIdentifierRepository.delete((List<Service_FederatedIdentifier>) entityList);
		} else if (entity instanceof Service_Funding) {
		    serviceFundingRepository.delete((List<Service_Funding>) entityList);
		} else if (entity instanceof Service_Indicator) {
		    serviceIndicatorRepository.delete((List<Service_Indicator>) entityList);
		} else if (entity instanceof Service_Measurement) {
		    serviceMeasurementRepository.delete((List<Service_Measurement>) entityList);
		} else if (entity instanceof Service_Medium) {
		    serviceMediumRepository.delete((List<Service_Medium>) entityList);
		} else if (entity instanceof Service_PostalAddress) {
		    servicePostalAddressRepository.delete((List<Service_PostalAddress>) entityList);
		} else if (entity instanceof Service_Service) {
		    serviceServiceRepository.delete((List<Service_Service>) entityList);

		} else {
			throw new IllegalArgumentException(String.format("Invalid list of link entities provided. %s", entity));
		}
	
	}
	
	/**
	 * Saves the provided link entities.
	 * @param entity The link entities.
	 */
	@SuppressWarnings("unchecked")
	public Iterable <? extends CerifLinkEntity> save(Iterable <? extends CerifLinkEntity> entityList) {
		
		final CerifLinkEntity entity = (CerifLinkEntity)entityList.iterator().next();
		
		if (entity instanceof Citation_Class) {
		    entityList = citationClassRepository.save((List<Citation_Class>) entityList);
		} else if (entity instanceof Citation_Medium) {
		    entityList = citationMediumRepository.save((List<Citation_Medium>) entityList);
		} else if (entity instanceof Class_Class) {
		    entityList = classClassRepository.save((List<Class_Class>) entityList);
		} else if (entity instanceof ClassScheme_ClassScheme) {
		    entityList = classSchemeClassSchemeRepository.save((List<ClassScheme_ClassScheme>) entityList);
		} else if (entity instanceof ClassScheme_Class) {
		    entityList = classSchemeClassRepository.save((List<ClassScheme_Class>) entityList);
		} else if (entity instanceof ClassScheme_OrganisationUnit) {
		    entityList = classSchemeOrganisationUnitRepository.save((List<ClassScheme_OrganisationUnit>) entityList);
		} else if (entity instanceof Country_Class) {
		    entityList = countryClassRepository.save((List<Country_Class>) entityList);
		} else if (entity instanceof Currency_Class) {
		    entityList = currencyClassRepository.save((List<Currency_Class>) entityList);
		} else if (entity instanceof Cv_Class) {
		    entityList = cvClassRepository.save((List<Cv_Class>) entityList);
		} else if (entity instanceof ElectronicAddress_Class) {
		    entityList = electronicAddressClassRepository.save((List<ElectronicAddress_Class>) entityList);
		} else if (entity instanceof Equipment_Class) {
		    entityList = equipmentClassRepository.save((List<Equipment_Class>) entityList);
		} else if (entity instanceof Equipment_Equipment) {
		    entityList = equipmentEquipmentRepository.save((List<Equipment_Equipment>) entityList);
		} else if (entity instanceof Equipment_Event) {
		    entityList = equipmentEventRepository.save((List<Equipment_Event>) entityList);
		} else if (entity instanceof Equipment_Funding) {
		    entityList = equipmentFundingRepository.save((List<Equipment_Funding>) entityList);
		} else if (entity instanceof Equipment_Indicator) {
		    entityList = equipmentIndicatorRepository.save((List<Equipment_Indicator>) entityList);
		} else if (entity instanceof Equipment_Measurement) {
		    entityList = equipmentMeasurementRepository.save((List<Equipment_Measurement>) entityList);
		} else if (entity instanceof Equipment_Medium) {
		    entityList = equipmentMediumRepository.save((List<Equipment_Medium>) entityList);
		} else if (entity instanceof Equipment_PostalAddress) {
		    entityList = equipmentPostalAddressRepository.save((List<Equipment_PostalAddress>) entityList);
		} else if (entity instanceof Equipment_Service) {
		    entityList = equipmentServiceRepository.save((List<Equipment_Service>) entityList);
		} else if (entity instanceof Event_Class) {
		    entityList = eventClassRepository.save((List<Event_Class>) entityList);
		} else if (entity instanceof Event_Event) {
		    entityList = eventEventRepository.save((List<Event_Event>) entityList);
		} else if (entity instanceof Event_Funding) {
		    entityList = eventFundingRepository.save((List<Event_Funding>) entityList);
		} else if (entity instanceof Event_Indicator) {
		    entityList = eventIndicatorRepository.save((List<Event_Indicator>) entityList);
		} else if (entity instanceof Event_Measurement) {
		    entityList = eventMeasurementRepository.save((List<Event_Measurement>) entityList);
		} else if (entity instanceof Event_Medium) {
		    entityList = eventMediumRepository.save((List<Event_Medium>) entityList);
		} else if (entity instanceof ExpertiseAndSkills_Class) {
		    entityList = expertiseAndSkillsClassRepository.save((List<ExpertiseAndSkills_Class>) entityList);
		} else if (entity instanceof Facility_Class) {
		    entityList = facilityClassRepository.save((List<Facility_Class>) entityList);
		} else if (entity instanceof Facility_Equipment) {
		    entityList = facilityEquipmentRepository.save((List<Facility_Equipment>) entityList);
		} else if (entity instanceof Facility_Event) {
		    entityList = facilityEventRepository.save((List<Facility_Event>) entityList);
		} else if (entity instanceof Facility_Facility) {
		    entityList = facilityFacilityRepository.save((List<Facility_Facility>) entityList);
		} else if (entity instanceof Facility_Funding) {
		    entityList = facilityFundingRepository.save((List<Facility_Funding>) entityList);
		} else if (entity instanceof Facility_Indicator) {
		    entityList = facilityIndicatorRepository.save((List<Facility_Indicator>) entityList);
		} else if (entity instanceof Facility_Measurement) {
		    entityList = facilityMeasurementRepository.save((List<Facility_Measurement>) entityList);
		} else if (entity instanceof Facility_Medium) {
		    entityList = facilityMediumRepository.save((List<Facility_Medium>) entityList);
		} else if (entity instanceof Facility_PostalAddress) {
		    entityList = facilityPostalAddressRepository.save((List<Facility_PostalAddress>) entityList);
		} else if (entity instanceof Facility_Service) {
		    entityList = facilityServiceRepository.save((List<Facility_Service>) entityList);
		} else if (entity instanceof FederatedIdentifier_Class) {
		    entityList = federatedIdentifierClassRepository.save((List<FederatedIdentifier_Class>) entityList);
		} else if (entity instanceof Funding_Class) {
		    entityList = fundingClassRepository.save((List<Funding_Class>) entityList);
		} else if (entity instanceof Funding_Funding) {
		    entityList = fundingFundingRepository.save((List<Funding_Funding>) entityList);
		} else if (entity instanceof Funding_Indicator) {
		    entityList = fundingIndicatorRepository.save((List<Funding_Indicator>) entityList);
		} else if (entity instanceof Funding_Measurement) {
		    entityList = fundingMeasurementRepository.save((List<Funding_Measurement>) entityList);
		} else if (entity instanceof GeographicBoundingBox_Class) {
		    entityList = geographicBoundingBoxClassRepository.save((List<GeographicBoundingBox_Class>) entityList);
		} else if (entity instanceof GeographicBoundingBox_GeographicBoundingBox) {
		    entityList = geographicBoundingBoxGeographicBoundingBoxRepository.save((List<GeographicBoundingBox_GeographicBoundingBox>) entityList);
		} else if (entity instanceof Indicator_Class) {
		    entityList = indicatorClassRepository.save((List<Indicator_Class>) entityList);
		} else if (entity instanceof Indicator_Indicator) {
		    entityList = indicatorIndicatorRepository.save((List<Indicator_Indicator>) entityList);
		} else if (entity instanceof Indicator_Measurement) {
		    entityList = indicatorMeasurementRepository.save((List<Indicator_Measurement>) entityList);
		} else if (entity instanceof Language_Class) {
		    entityList = languageClassRepository.save((List<Language_Class>) entityList);
		} else if (entity instanceof Measurement_Class) {
		    entityList = measurementClassRepository.save((List<Measurement_Class>) entityList);
		} else if (entity instanceof Measurement_Measurement) {
		    entityList = measurementMeasurementRepository.save((List<Measurement_Measurement>) entityList);
		} else if (entity instanceof Medium_Class) {
		    entityList = mediumClassRepository.save((List<Medium_Class>) entityList);
		} else if (entity instanceof Medium_Funding) {
		    entityList = mediumFundingRepository.save((List<Medium_Funding>) entityList);
		} else if (entity instanceof Medium_Indicator) {
		    entityList = mediumIndicatorRepository.save((List<Medium_Indicator>) entityList);
		} else if (entity instanceof Medium_Measurement) {
		    entityList = mediumMeasurementRepository.save((List<Medium_Measurement>) entityList);
		} else if (entity instanceof Medium_Medium) {
		    entityList = mediumMediumRepository.save((List<Medium_Medium>) entityList);
		} else if (entity instanceof Metrics_Class) {
		    entityList = metricsClassRepository.save((List<Metrics_Class>) entityList);
		} else if (entity instanceof OrganisationUnit_Class) {
		    entityList = organisationUnitClassRepository.save((List<OrganisationUnit_Class>) entityList);
		} else if (entity instanceof OrganisationUnit_DublinCore) {
		    entityList = organisationUnitDublinCoreRepository.save((List<OrganisationUnit_DublinCore>) entityList);
		} else if (entity instanceof OrganisationUnit_ElectronicAddress) {
		    entityList = organisationUnitElectronicAddressRepository.save((List<OrganisationUnit_ElectronicAddress>) entityList);
		} else if (entity instanceof OrganisationUnit_Equipment) {
		    entityList = organisationUnitEquipmentRepository.save((List<OrganisationUnit_Equipment>) entityList);
		} else if (entity instanceof OrganisationUnit_Event) {
		    entityList = organisationUnitEventRepository.save((List<OrganisationUnit_Event>) entityList);
		} else if (entity instanceof OrganisationUnit_ExpertiseAndSkills) {
		    entityList = organisationUnitExpertiseAndSkillsRepository.save((List<OrganisationUnit_ExpertiseAndSkills>) entityList);
		} else if (entity instanceof OrganisationUnit_Facility) {
		    entityList = organisationUnitFacilityRepository.save((List<OrganisationUnit_Facility>) entityList);
		} else if (entity instanceof OrganisationUnit_Funding) {
		    entityList = organisationUnitFundingRepository.save((List<OrganisationUnit_Funding>) entityList);
		} else if (entity instanceof OrganisationUnit_Indicator) {
		    entityList = organisationUnitIndicatorRepository.save((List<OrganisationUnit_Indicator>) entityList);
		} else if (entity instanceof OrganisationUnit_Measurement) {
		    entityList = organisationUnitMeasurementRepository.save((List<OrganisationUnit_Measurement>) entityList);
		} else if (entity instanceof OrganisationUnit_Medium) {
		    entityList = organisationUnitMediumRepository.save((List<OrganisationUnit_Medium>) entityList);
		} else if (entity instanceof OrganisationUnit_OrganisationUnit) {
		    entityList = organisationUnitOrganisationUnitRepository.save((List<OrganisationUnit_OrganisationUnit>) entityList);
		} else if (entity instanceof OrganisationUnit_PostalAddress) {
		    entityList = organisationUnitPostalAddressRepository.save((List<OrganisationUnit_PostalAddress>) entityList);
		} else if (entity instanceof OrganisationUnit_Prize) {
		    entityList = organisationUnitPrizeRepository.save((List<OrganisationUnit_Prize>) entityList);
		} else if (entity instanceof OrganisationUnit_ResultPatent) {
		    entityList = organisationUnitResultPatentRepository.save((List<OrganisationUnit_ResultPatent>) entityList);
		} else if (entity instanceof OrganisationUnit_ResultProduct) {
		    entityList = organisationUnitResultProductRepository.save((List<OrganisationUnit_ResultProduct>) entityList);
		} else if (entity instanceof OrganisationUnit_ResultPublication) {
		    entityList = organisationUnitResultPublicationRepository.save((List<OrganisationUnit_ResultPublication>) entityList);
		} else if (entity instanceof OrganisationUnit_Service) {
		    entityList = organisationUnitServiceRepository.save((List<OrganisationUnit_Service>) entityList);
		} else if (entity instanceof Person_Class) {
		    entityList = personClassRepository.save((List<Person_Class>) entityList);
		} else if (entity instanceof Person_Country) {
		    entityList = personCountryRepository.save((List<Person_Country>) entityList);
		} else if (entity instanceof Person_Cv) {
		    entityList = personCvRepository.save((List<Person_Cv>) entityList);
		} else if (entity instanceof Person_DublinCore) {
		    entityList = personDublinCoreRepository.save((List<Person_DublinCore>) entityList);
		} else if (entity instanceof Person_ElectronicAddress) {
		    entityList = personElectronicAddressRepository.save((List<Person_ElectronicAddress>) entityList);
		} else if (entity instanceof Person_Equipment) {
		    entityList = personEquipmentRepository.save((List<Person_Equipment>) entityList);
		} else if (entity instanceof Person_Event) {
		    entityList = personEventRepository.save((List<Person_Event>) entityList);
		} else if (entity instanceof Person_ExpertiseAndSkills) {
		    entityList = personExpertiseAndSkillsRepository.save((List<Person_ExpertiseAndSkills>) entityList);
		} else if (entity instanceof Person_Facility) {
		    entityList = personFacilityRepository.save((List<Person_Facility>) entityList);
		} else if (entity instanceof Person_Funding) {
		    entityList = personFundingRepository.save((List<Person_Funding>) entityList);
		} else if (entity instanceof Person_Indicator) {
		    entityList = personIndicatorRepository.save((List<Person_Indicator>) entityList);
		} else if (entity instanceof Person_Language) {
		    entityList = personLanguageRepository.save((List<Person_Language>) entityList);
		} else if (entity instanceof Person_Measurement) {
		    entityList = personMeasurementRepository.save((List<Person_Measurement>) entityList);
		} else if (entity instanceof Person_Medium) {
		    entityList = personMediumRepository.save((List<Person_Medium>) entityList);
		} else if (entity instanceof Person_OrganisationUnit) {
		    entityList = personOrganisationUnitRepository.save((List<Person_OrganisationUnit>) entityList);
		} else if (entity instanceof Person_Person) {
		    entityList = personPersonRepository.save((List<Person_Person>) entityList);
		} else if (entity instanceof Person_PostalAddress) {
		    entityList = personPostalAddressRepository.save((List<Person_PostalAddress>) entityList);
		} else if (entity instanceof Person_Prize) {
		    entityList = personPrizeRepository.save((List<Person_Prize>) entityList);
		} else if (entity instanceof Person_Qualification) {
		    entityList = personQualificationRepository.save((List<Person_Qualification>) entityList);
		} else if (entity instanceof Person_ResultPatent) {
		    entityList = personResultPatentRepository.save((List<Person_ResultPatent>) entityList);
		} else if (entity instanceof Person_ResultProduct) {
		    entityList = personResultProductRepository.save((List<Person_ResultProduct>) entityList);
		} else if (entity instanceof Person_ResultPublication) {
		    entityList = personResultPublicationRepository.save((List<Person_ResultPublication>) entityList);
		} else if (entity instanceof Person_Service) {
		    entityList = personServiceRepository.save((List<Person_Service>) entityList);
		} else if (entity instanceof PostalAddress_Class) {
		    entityList = postalAddressClassRepository.save((List<PostalAddress_Class>) entityList);
		} else if (entity instanceof PostalAddress_GeographicBoundingBox) {
		    entityList = postalAddressGeographicBoundingBoxRepository.save((List<PostalAddress_GeographicBoundingBox>) entityList);
		} else if (entity instanceof Prize_Class) {
		    entityList = prizeClassRepository.save((List<Prize_Class>) entityList);
		} else if (entity instanceof Project_Class) {
		    entityList = projectClassRepository.save((List<Project_Class>) entityList);
		} else if (entity instanceof Project_DublinCore) {
		    entityList = projectDublinCoreRepository.save((List<Project_DublinCore>) entityList);
		} else if (entity instanceof Project_Equipment) {
		    entityList = projectEquipmentRepository.save((List<Project_Equipment>) entityList);
		} else if (entity instanceof Project_Event) {
		    entityList = projectEventRepository.save((List<Project_Event>) entityList);
		} else if (entity instanceof Project_Facility) {
		    entityList = projectFacilityRepository.save((List<Project_Facility>) entityList);
		} else if (entity instanceof Project_Funding) {
		    entityList = projectFundingRepository.save((List<Project_Funding>) entityList);
		} else if (entity instanceof Project_Indicator) {
		    entityList = projectIndicatorRepository.save((List<Project_Indicator>) entityList);
		} else if (entity instanceof Project_Measurement) {
		    entityList = projectMeasurementRepository.save((List<Project_Measurement>) entityList);
		} else if (entity instanceof Project_Medium) {
		    entityList = projectMediumRepository.save((List<Project_Medium>) entityList);
		} else if (entity instanceof Project_OrganisationUnit) {
		    entityList = projectOrganisationUnitRepository.save((List<Project_OrganisationUnit>) entityList);
		} else if (entity instanceof Project_Person) {
		    entityList = projectPersonRepository.save((List<Project_Person>) entityList);
		} else if (entity instanceof Project_Prize) {
		    entityList = projectPrizeRepository.save((List<Project_Prize>) entityList);
		} else if (entity instanceof Project_Project) {
		    entityList = projectProjectRepository.save((List<Project_Project>) entityList);
		} else if (entity instanceof Project_ResultPatent) {
		    entityList = projectResultPatentRepository.save((List<Project_ResultPatent>) entityList);
		} else if (entity instanceof Project_ResultProduct) {
		    entityList = projectResultProductRepository.save((List<Project_ResultProduct>) entityList);
		} else if (entity instanceof Project_ResultPublication) {
		    entityList = projectResultPublicationRepository.save((List<Project_ResultPublication>) entityList);
		} else if (entity instanceof Project_Service) {
		    entityList = projectServiceRepository.save((List<Project_Service>) entityList);
		} else if (entity instanceof Qualification_Class) {
		    entityList = qualificationClassRepository.save((List<Qualification_Class>) entityList);
		} else if (entity instanceof ResultPatent_Class) {
		    entityList = resultPatentClassRepository.save((List<ResultPatent_Class>) entityList);
		} else if (entity instanceof ResultPatent_Equipment) {
		    entityList = resultPatentEquipmentRepository.save((List<ResultPatent_Equipment>) entityList);
		} else if (entity instanceof ResultPatent_Facility) {
		    entityList = resultPatentFacilityRepository.save((List<ResultPatent_Facility>) entityList);
		} else if (entity instanceof ResultPatent_Funding) {
		    entityList = resultPatentFundingRepository.save((List<ResultPatent_Funding>) entityList);
		} else if (entity instanceof ResultPatent_Indicator) {
		    entityList = resultPatentIndicatorRepository.save((List<ResultPatent_Indicator>) entityList);
		} else if (entity instanceof ResultPatent_Measurement) {
		    entityList = resultPatentMeasurementRepository.save((List<ResultPatent_Measurement>) entityList);
		} else if (entity instanceof ResultPatent_Medium) {
		    entityList = resultPatentMediumRepository.save((List<ResultPatent_Medium>) entityList);
		} else if (entity instanceof ResultPatent_ResultPatent) {
		    entityList = resultPatentResultPatentRepository.save((List<ResultPatent_ResultPatent>) entityList);
		} else if (entity instanceof ResultPatent_Service) {
		    entityList = resultPatentServiceRepository.save((List<ResultPatent_Service>) entityList);
		} else if (entity instanceof ResultProduct_Class) {
		    entityList = resultProductClassRepository.save((List<ResultProduct_Class>) entityList);
		} else if (entity instanceof ResultProduct_Country) {
		    entityList = resultProductCountryRepository.save((List<ResultProduct_Country>) entityList);
		} else if (entity instanceof ResultProduct_Equipment) {
		    entityList = resultProductEquipmentRepository.save((List<ResultProduct_Equipment>) entityList);
		} else if (entity instanceof ResultProduct_Facility) {
		    entityList = resultProductFacilityRepository.save((List<ResultProduct_Facility>) entityList);
		} else if (entity instanceof ResultProduct_Funding) {
		    entityList = resultProductFundingRepository.save((List<ResultProduct_Funding>) entityList);
		} else if (entity instanceof ResultProduct_GeographicBoundingBox) {
		    entityList = resultProductGeographicBoundingBoxRepository.save((List<ResultProduct_GeographicBoundingBox>) entityList);
		} else if (entity instanceof ResultProduct_Indicator) {
		    entityList = resultProductIndicatorRepository.save((List<ResultProduct_Indicator>) entityList);
		} else if (entity instanceof ResultProduct_Measurement) {
		    entityList = resultProductMeasurementRepository.save((List<ResultProduct_Measurement>) entityList);
		} else if (entity instanceof ResultProduct_Medium) {
		    entityList = resultProductMediumRepository.save((List<ResultProduct_Medium>) entityList);
		} else if (entity instanceof ResultProduct_ResultProduct) {
		    entityList = resultProductResultProductRepository.save((List<ResultProduct_ResultProduct>) entityList);
		} else if (entity instanceof ResultProduct_Service) {
		    entityList = resultProductServiceRepository.save((List<ResultProduct_Service>) entityList);
		} else if (entity instanceof ResultPublication_Citation) {
		    entityList = resultPublicationCitationRepository.save((List<ResultPublication_Citation>) entityList);
		} else if (entity instanceof ResultPublication_Class) {
		    entityList = resultPublicationClassRepository.save((List<ResultPublication_Class>) entityList);
		} else if (entity instanceof ResultPublication_DublinCore) {
		    entityList = resultPublicationDublinCoreRepository.save((List<ResultPublication_DublinCore>) entityList);
		} else if (entity instanceof ResultPublication_Equipment) {
		    entityList = resultPublicationEquipmentRepository.save((List<ResultPublication_Equipment>) entityList);
		} else if (entity instanceof ResultPublication_Event) {
		    entityList = resultPublicationEventRepository.save((List<ResultPublication_Event>) entityList);
		} else if (entity instanceof ResultPublication_Facility) {
		    entityList = resultPublicationFacilityRepository.save((List<ResultPublication_Facility>) entityList);
		} else if (entity instanceof ResultPublication_Funding) {
		    entityList = resultPublicationFundingRepository.save((List<ResultPublication_Funding>) entityList);
		} else if (entity instanceof ResultPublication_Indicator) {
		    entityList = resultPublicationIndicatorRepository.save((List<ResultPublication_Indicator>) entityList);
		} else if (entity instanceof ResultPublication_Measurement) {
		    entityList = resultPublicationMeasurementRepository.save((List<ResultPublication_Measurement>) entityList);
		} else if (entity instanceof ResultPublication_Medium) {
		    entityList = resultPublicationMediumRepository.save((List<ResultPublication_Medium>) entityList);
		} else if (entity instanceof ResultPublication_Metrics) {
		    entityList = resultPublicationMetricsRepository.save((List<ResultPublication_Metrics>) entityList);
		} else if (entity instanceof ResultPublication_ResultPatent) {
		    entityList = resultPublicationResultPatentRepository.save((List<ResultPublication_ResultPatent>) entityList);
		} else if (entity instanceof ResultPublication_ResultProduct) {
		    entityList = resultPublicationResultProductRepository.save((List<ResultPublication_ResultProduct>) entityList);
		} else if (entity instanceof ResultPublication_ResultPublication) {
		    entityList = resultPublicationResultPublicationRepository.save((List<ResultPublication_ResultPublication>) entityList);
		} else if (entity instanceof ResultPublication_Service) {
		    entityList = resultPublicationServiceRepository.save((List<ResultPublication_Service>) entityList);
		} else if (entity instanceof Service_Class) {
		    entityList = serviceClassRepository.save((List<Service_Class>) entityList);
		} else if (entity instanceof Service_Event) {
		    entityList = serviceEventRepository.save((List<Service_Event>) entityList);
		} else if (entity instanceof Service_FederatedIdentifier) {
		    entityList = serviceFederatedIdentifierRepository.save((List<Service_FederatedIdentifier>) entityList);
		} else if (entity instanceof Service_Funding) {
		    entityList = serviceFundingRepository.save((List<Service_Funding>) entityList);
		} else if (entity instanceof Service_Indicator) {
		    entityList = serviceIndicatorRepository.save((List<Service_Indicator>) entityList);
		} else if (entity instanceof Service_Measurement) {
		    entityList = serviceMeasurementRepository.save((List<Service_Measurement>) entityList);
		} else if (entity instanceof Service_Medium) {
		    entityList = serviceMediumRepository.save((List<Service_Medium>) entityList);
		} else if (entity instanceof Service_PostalAddress) {
		    entityList = servicePostalAddressRepository.save((List<Service_PostalAddress>) entityList);
		} else if (entity instanceof Service_Service) {
		    entityList = serviceServiceRepository.save((List<Service_Service>) entityList);

		} else {
			throw new IllegalArgumentException(String.format("Invalid list of link entities provided. %s", entityList));
		}
		return entityList;
	}

	/**
	 * @return the citationClassRepository
	 */
	public LinkCitationClassRepository getCitationClassRepository() {
		return citationClassRepository;
	}

	/**
	 * @return the citationMediumRepository
	 */
	public LinkCitationMediumRepository getCitationMediumRepository() {
		return citationMediumRepository;
	}

	/**
	 * @return the classClassRepository
	 */
	public LinkClassClassRepository getClassClassRepository() {
		return classClassRepository;
	}

	/**
	 * @return the classSchemeClassSchemeRepository
	 */
	public LinkClassSchemeClassSchemeRepository getClassSchemeClassSchemeRepository() {
		return classSchemeClassSchemeRepository;
	}

	/**
	 * @return the classSchemeClassRepository
	 */
	public LinkClassSchemeClassRepository getClassSchemeClassRepository() {
		return classSchemeClassRepository;
	}

	/**
	 * @return the classSchemeOrganisationUnitRepository
	 */
	public LinkClassSchemeOrganisationUnitRepository getClassSchemeOrganisationUnitRepository() {
		return classSchemeOrganisationUnitRepository;
	}

	/**
	 * @return the countryClassRepository
	 */
	public LinkCountryClassRepository getCountryClassRepository() {
		return countryClassRepository;
	}

	/**
	 * @return the currencyClassRepository
	 */
	public LinkCurrencyClassRepository getCurrencyClassRepository() {
		return currencyClassRepository;
	}

	/**
	 * @return the cvClassRepository
	 */
	public LinkCvClassRepository getCvClassRepository() {
		return cvClassRepository;
	}

	/**
	 * @return the electronicAddressClassRepository
	 */
	public LinkElectronicAddressClassRepository getElectronicAddressClassRepository() {
		return electronicAddressClassRepository;
	}

	/**
	 * @return the equipmentClassRepository
	 */
	public LinkEquipmentClassRepository getEquipmentClassRepository() {
		return equipmentClassRepository;
	}

	/**
	 * @return the equipmentEquipmentRepository
	 */
	public LinkEquipmentEquipmentRepository getEquipmentEquipmentRepository() {
		return equipmentEquipmentRepository;
	}

	/**
	 * @return the equipmentEventRepository
	 */
	public LinkEquipmentEventRepository getEquipmentEventRepository() {
		return equipmentEventRepository;
	}

	/**
	 * @return the equipmentFundingRepository
	 */
	public LinkEquipmentFundingRepository getEquipmentFundingRepository() {
		return equipmentFundingRepository;
	}

	/**
	 * @return the equipmentIndicatorRepository
	 */
	public LinkEquipmentIndicatorRepository getEquipmentIndicatorRepository() {
		return equipmentIndicatorRepository;
	}

	/**
	 * @return the equipmentMeasurementRepository
	 */
	public LinkEquipmentMeasurementRepository getEquipmentMeasurementRepository() {
		return equipmentMeasurementRepository;
	}

	/**
	 * @return the equipmentMediumRepository
	 */
	public LinkEquipmentMediumRepository getEquipmentMediumRepository() {
		return equipmentMediumRepository;
	}

	/**
	 * @return the equipmentPostalAddressRepository
	 */
	public LinkEquipmentPostalAddressRepository getEquipmentPostalAddressRepository() {
		return equipmentPostalAddressRepository;
	}

	/**
	 * @return the equipmentServiceRepository
	 */
	public LinkEquipmentServiceRepository getEquipmentServiceRepository() {
		return equipmentServiceRepository;
	}

	/**
	 * @return the eventClassRepository
	 */
	public LinkEventClassRepository getEventClassRepository() {
		return eventClassRepository;
	}

	/**
	 * @return the eventEventRepository
	 */
	public LinkEventEventRepository getEventEventRepository() {
		return eventEventRepository;
	}

	/**
	 * @return the eventFundingRepository
	 */
	public LinkEventFundingRepository getEventFundingRepository() {
		return eventFundingRepository;
	}

	/**
	 * @return the eventIndicatorRepository
	 */
	public LinkEventIndicatorRepository getEventIndicatorRepository() {
		return eventIndicatorRepository;
	}

	/**
	 * @return the eventMeasurementRepository
	 */
	public LinkEventMeasurementRepository getEventMeasurementRepository() {
		return eventMeasurementRepository;
	}

	/**
	 * @return the eventMediumRepository
	 */
	public LinkEventMediumRepository getEventMediumRepository() {
		return eventMediumRepository;
	}

	/**
	 * @return the expertiseAndSkillsClassRepository
	 */
	public LinkExpertiseAndSkillsClassRepository getExpertiseAndSkillsClassRepository() {
		return expertiseAndSkillsClassRepository;
	}

	/**
	 * @return the facilityClassRepository
	 */
	public LinkFacilityClassRepository getFacilityClassRepository() {
		return facilityClassRepository;
	}

	/**
	 * @return the facilityEquipmentRepository
	 */
	public LinkFacilityEquipmentRepository getFacilityEquipmentRepository() {
		return facilityEquipmentRepository;
	}

	/**
	 * @return the facilityEventRepository
	 */
	public LinkFacilityEventRepository getFacilityEventRepository() {
		return facilityEventRepository;
	}

	/**
	 * @return the facilityFacilityRepository
	 */
	public LinkFacilityFacilityRepository getFacilityFacilityRepository() {
		return facilityFacilityRepository;
	}

	/**
	 * @return the facilityFundingRepository
	 */
	public LinkFacilityFundingRepository getFacilityFundingRepository() {
		return facilityFundingRepository;
	}

	/**
	 * @return the facilityIndicatorRepository
	 */
	public LinkFacilityIndicatorRepository getFacilityIndicatorRepository() {
		return facilityIndicatorRepository;
	}

	/**
	 * @return the facilityMeasurementRepository
	 */
	public LinkFacilityMeasurementRepository getFacilityMeasurementRepository() {
		return facilityMeasurementRepository;
	}

	/**
	 * @return the facilityMediumRepository
	 */
	public LinkFacilityMediumRepository getFacilityMediumRepository() {
		return facilityMediumRepository;
	}

	/**
	 * @return the facilityPostalAddressRepository
	 */
	public LinkFacilityPostalAddressRepository getFacilityPostalAddressRepository() {
		return facilityPostalAddressRepository;
	}

	/**
	 * @return the facilityServiceRepository
	 */
	public LinkFacilityServiceRepository getFacilityServiceRepository() {
		return facilityServiceRepository;
	}

	/**
	 * @return the federatedIdentifierClassRepository
	 */
	public LinkFederatedIdentifierClassRepository getFederatedIdentifierClassRepository() {
		return federatedIdentifierClassRepository;
	}

	/**
	 * @return the fundingClassRepository
	 */
	public LinkFundingClassRepository getFundingClassRepository() {
		return fundingClassRepository;
	}

	/**
	 * @return the fundingFundingRepository
	 */
	public LinkFundingFundingRepository getFundingFundingRepository() {
		return fundingFundingRepository;
	}

	/**
	 * @return the fundingIndicatorRepository
	 */
	public LinkFundingIndicatorRepository getFundingIndicatorRepository() {
		return fundingIndicatorRepository;
	}

	/**
	 * @return the fundingMeasurementRepository
	 */
	public LinkFundingMeasurementRepository getFundingMeasurementRepository() {
		return fundingMeasurementRepository;
	}

	/**
	 * @return the geographicBoundingBoxClassRepository
	 */
	public LinkGeographicBoundingBoxClassRepository getGeographicBoundingBoxClassRepository() {
		return geographicBoundingBoxClassRepository;
	}

	/**
	 * @return the geographicBoundingBoxGeographicBoundingBoxRepository
	 */
	public LinkGeographicBoundingBoxGeographicBoundingBoxRepository getGeographicBoundingBoxGeographicBoundingBoxRepository() {
		return geographicBoundingBoxGeographicBoundingBoxRepository;
	}

	/**
	 * @return the indicatorClassRepository
	 */
	public LinkIndicatorClassRepository getIndicatorClassRepository() {
		return indicatorClassRepository;
	}

	/**
	 * @return the indicatorIndicatorRepository
	 */
	public LinkIndicatorIndicatorRepository getIndicatorIndicatorRepository() {
		return indicatorIndicatorRepository;
	}

	/**
	 * @return the indicatorMeasurementRepository
	 */
	public LinkIndicatorMeasurementRepository getIndicatorMeasurementRepository() {
		return indicatorMeasurementRepository;
	}

	/**
	 * @return the languageClassRepository
	 */
	public LinkLanguageClassRepository getLanguageClassRepository() {
		return languageClassRepository;
	}

	/**
	 * @return the measurementClassRepository
	 */
	public LinkMeasurementClassRepository getMeasurementClassRepository() {
		return measurementClassRepository;
	}

	/**
	 * @return the measurementMeasurementRepository
	 */
	public LinkMeasurementMeasurementRepository getMeasurementMeasurementRepository() {
		return measurementMeasurementRepository;
	}

	/**
	 * @return the mediumClassRepository
	 */
	public LinkMediumClassRepository getMediumClassRepository() {
		return mediumClassRepository;
	}

	/**
	 * @return the mediumFundingRepository
	 */
	public LinkMediumFundingRepository getMediumFundingRepository() {
		return mediumFundingRepository;
	}

	/**
	 * @return the mediumIndicatorRepository
	 */
	public LinkMediumIndicatorRepository getMediumIndicatorRepository() {
		return mediumIndicatorRepository;
	}

	/**
	 * @return the mediumMeasurementRepository
	 */
	public LinkMediumMeasurementRepository getMediumMeasurementRepository() {
		return mediumMeasurementRepository;
	}

	/**
	 * @return the mediumMediumRepository
	 */
	public LinkMediumMediumRepository getMediumMediumRepository() {
		return mediumMediumRepository;
	}

	/**
	 * @return the metricsClassRepository
	 */
	public LinkMetricsClassRepository getMetricsClassRepository() {
		return metricsClassRepository;
	}

	/**
	 * @return the organisationUnitClassRepository
	 */
	public LinkOrganisationUnitClassRepository getOrganisationUnitClassRepository() {
		return organisationUnitClassRepository;
	}

	/**
	 * @return the organisationUnitDublinCoreRepository
	 */
	public LinkOrganisationUnitDublinCoreRepository getOrganisationUnitDublinCoreRepository() {
		return organisationUnitDublinCoreRepository;
	}

	/**
	 * @return the organisationUnitElectronicAddressRepository
	 */
	public LinkOrganisationUnitElectronicAddressRepository getOrganisationUnitElectronicAddressRepository() {
		return organisationUnitElectronicAddressRepository;
	}

	/**
	 * @return the organisationUnitEquipmentRepository
	 */
	public LinkOrganisationUnitEquipmentRepository getOrganisationUnitEquipmentRepository() {
		return organisationUnitEquipmentRepository;
	}

	/**
	 * @return the organisationUnitEventRepository
	 */
	public LinkOrganisationUnitEventRepository getOrganisationUnitEventRepository() {
		return organisationUnitEventRepository;
	}

	/**
	 * @return the organisationUnitExpertiseAndSkillsRepository
	 */
	public LinkOrganisationUnitExpertiseAndSkillsRepository getOrganisationUnitExpertiseAndSkillsRepository() {
		return organisationUnitExpertiseAndSkillsRepository;
	}

	/**
	 * @return the organisationUnitFacilityRepository
	 */
	public LinkOrganisationUnitFacilityRepository getOrganisationUnitFacilityRepository() {
		return organisationUnitFacilityRepository;
	}

	/**
	 * @return the organisationUnitFundingRepository
	 */
	public LinkOrganisationUnitFundingRepository getOrganisationUnitFundingRepository() {
		return organisationUnitFundingRepository;
	}

	/**
	 * @return the organisationUnitIndicatorRepository
	 */
	public LinkOrganisationUnitIndicatorRepository getOrganisationUnitIndicatorRepository() {
		return organisationUnitIndicatorRepository;
	}

	/**
	 * @return the organisationUnitMeasurementRepository
	 */
	public LinkOrganisationUnitMeasurementRepository getOrganisationUnitMeasurementRepository() {
		return organisationUnitMeasurementRepository;
	}

	/**
	 * @return the organisationUnitMediumRepository
	 */
	public LinkOrganisationUnitMediumRepository getOrganisationUnitMediumRepository() {
		return organisationUnitMediumRepository;
	}

	/**
	 * @return the organisationUnitOrganisationUnitRepository
	 */
	public LinkOrganisationUnitOrganisationUnitRepository getOrganisationUnitOrganisationUnitRepository() {
		return organisationUnitOrganisationUnitRepository;
	}

	/**
	 * @return the organisationUnitPostalAddressRepository
	 */
	public LinkOrganisationUnitPostalAddressRepository getOrganisationUnitPostalAddressRepository() {
		return organisationUnitPostalAddressRepository;
	}

	/**
	 * @return the organisationUnitPrizeRepository
	 */
	public LinkOrganisationUnitPrizeRepository getOrganisationUnitPrizeRepository() {
		return organisationUnitPrizeRepository;
	}

	/**
	 * @return the organisationUnitResultPatentRepository
	 */
	public LinkOrganisationUnitResultPatentRepository getOrganisationUnitResultPatentRepository() {
		return organisationUnitResultPatentRepository;
	}

	/**
	 * @return the organisationUnitResultProductRepository
	 */
	public LinkOrganisationUnitResultProductRepository getOrganisationUnitResultProductRepository() {
		return organisationUnitResultProductRepository;
	}

	/**
	 * @return the organisationUnitResultPublicationRepository
	 */
	public LinkOrganisationUnitResultPublicationRepository getOrganisationUnitResultPublicationRepository() {
		return organisationUnitResultPublicationRepository;
	}

	/**
	 * @return the organisationUnitServiceRepository
	 */
	public LinkOrganisationUnitServiceRepository getOrganisationUnitServiceRepository() {
		return organisationUnitServiceRepository;
	}

	/**
	 * @return the personClassRepository
	 */
	public LinkPersonClassRepository getPersonClassRepository() {
		return personClassRepository;
	}

	/**
	 * @return the personCountryRepository
	 */
	public LinkPersonCountryRepository getPersonCountryRepository() {
		return personCountryRepository;
	}

	/**
	 * @return the personCvRepository
	 */
	public LinkPersonCvRepository getPersonCvRepository() {
		return personCvRepository;
	}

	/**
	 * @return the personDublinCoreRepository
	 */
	public LinkPersonDublinCoreRepository getPersonDublinCoreRepository() {
		return personDublinCoreRepository;
	}

	/**
	 * @return the personElectronicAddressRepository
	 */
	public LinkPersonElectronicAddressRepository getPersonElectronicAddressRepository() {
		return personElectronicAddressRepository;
	}

	/**
	 * @return the personEquipmentRepository
	 */
	public LinkPersonEquipmentRepository getPersonEquipmentRepository() {
		return personEquipmentRepository;
	}

	/**
	 * @return the personEventRepository
	 */
	public LinkPersonEventRepository getPersonEventRepository() {
		return personEventRepository;
	}

	/**
	 * @return the personExpertiseAndSkillsRepository
	 */
	public LinkPersonExpertiseAndSkillsRepository getPersonExpertiseAndSkillsRepository() {
		return personExpertiseAndSkillsRepository;
	}

	/**
	 * @return the personFacilityRepository
	 */
	public LinkPersonFacilityRepository getPersonFacilityRepository() {
		return personFacilityRepository;
	}

	/**
	 * @return the personFundingRepository
	 */
	public LinkPersonFundingRepository getPersonFundingRepository() {
		return personFundingRepository;
	}

	/**
	 * @return the personIndicatorRepository
	 */
	public LinkPersonIndicatorRepository getPersonIndicatorRepository() {
		return personIndicatorRepository;
	}

	/**
	 * @return the personLanguageRepository
	 */
	public LinkPersonLanguageRepository getPersonLanguageRepository() {
		return personLanguageRepository;
	}

	/**
	 * @return the personMeasurementRepository
	 */
	public LinkPersonMeasurementRepository getPersonMeasurementRepository() {
		return personMeasurementRepository;
	}

	/**
	 * @return the personMediumRepository
	 */
	public LinkPersonMediumRepository getPersonMediumRepository() {
		return personMediumRepository;
	}

	/**
	 * @return the personOrganisationUnitRepository
	 */
	public LinkPersonOrganisationUnitRepository getPersonOrganisationUnitRepository() {
		return personOrganisationUnitRepository;
	}

	/**
	 * @return the personPersonRepository
	 */
	public LinkPersonPersonRepository getPersonPersonRepository() {
		return personPersonRepository;
	}

	/**
	 * @return the personPostalAddressRepository
	 */
	public LinkPersonPostalAddressRepository getPersonPostalAddressRepository() {
		return personPostalAddressRepository;
	}

	/**
	 * @return the personPrizeRepository
	 */
	public LinkPersonPrizeRepository getPersonPrizeRepository() {
		return personPrizeRepository;
	}

	/**
	 * @return the personQualificationRepository
	 */
	public LinkPersonQualificationRepository getPersonQualificationRepository() {
		return personQualificationRepository;
	}

	/**
	 * @return the personResultPatentRepository
	 */
	public LinkPersonResultPatentRepository getPersonResultPatentRepository() {
		return personResultPatentRepository;
	}

	/**
	 * @return the personResultProductRepository
	 */
	public LinkPersonResultProductRepository getPersonResultProductRepository() {
		return personResultProductRepository;
	}

	/**
	 * @return the personResultPublicationRepository
	 */
	public LinkPersonResultPublicationRepository getPersonResultPublicationRepository() {
		return personResultPublicationRepository;
	}

	/**
	 * @return the personServiceRepository
	 */
	public LinkPersonServiceRepository getPersonServiceRepository() {
		return personServiceRepository;
	}

	/**
	 * @return the postalAddressClassRepository
	 */
	public LinkPostalAddressClassRepository getPostalAddressClassRepository() {
		return postalAddressClassRepository;
	}

	/**
	 * @return the postalAddressGeographicBoundingBoxRepository
	 */
	public LinkPostalAddressGeographicBoundingBoxRepository getPostalAddressGeographicBoundingBoxRepository() {
		return postalAddressGeographicBoundingBoxRepository;
	}

	/**
	 * @return the prizeClassRepository
	 */
	public LinkPrizeClassRepository getPrizeClassRepository() {
		return prizeClassRepository;
	}

	/**
	 * @return the projectClassRepository
	 */
	public LinkProjectClassRepository getProjectClassRepository() {
		return projectClassRepository;
	}

	/**
	 * @return the projectDublinCoreRepository
	 */
	public LinkProjectDublinCoreRepository getProjectDublinCoreRepository() {
		return projectDublinCoreRepository;
	}

	/**
	 * @return the projectEquipmentRepository
	 */
	public LinkProjectEquipmentRepository getProjectEquipmentRepository() {
		return projectEquipmentRepository;
	}

	/**
	 * @return the projectEventRepository
	 */
	public LinkProjectEventRepository getProjectEventRepository() {
		return projectEventRepository;
	}

	/**
	 * @return the projectFacilityRepository
	 */
	public LinkProjectFacilityRepository getProjectFacilityRepository() {
		return projectFacilityRepository;
	}

	/**
	 * @return the projectFundingRepository
	 */
	public LinkProjectFundingRepository getProjectFundingRepository() {
		return projectFundingRepository;
	}

	/**
	 * @return the projectIndicatorRepository
	 */
	public LinkProjectIndicatorRepository getProjectIndicatorRepository() {
		return projectIndicatorRepository;
	}

	/**
	 * @return the projectMeasurementRepository
	 */
	public LinkProjectMeasurementRepository getProjectMeasurementRepository() {
		return projectMeasurementRepository;
	}

	/**
	 * @return the projectMediumRepository
	 */
	public LinkProjectMediumRepository getProjectMediumRepository() {
		return projectMediumRepository;
	}

	/**
	 * @return the projectOrganisationUnitRepository
	 */
	public LinkProjectOrganisationUnitRepository getProjectOrganisationUnitRepository() {
		return projectOrganisationUnitRepository;
	}

	/**
	 * @return the projectPersonRepository
	 */
	public LinkProjectPersonRepository getProjectPersonRepository() {
		return projectPersonRepository;
	}

	/**
	 * @return the projectPrizeRepository
	 */
	public LinkProjectPrizeRepository getProjectPrizeRepository() {
		return projectPrizeRepository;
	}

	/**
	 * @return the projectProjectRepository
	 */
	public LinkProjectProjectRepository getProjectProjectRepository() {
		return projectProjectRepository;
	}

	/**
	 * @return the projectResultPatentRepository
	 */
	public LinkProjectResultPatentRepository getProjectResultPatentRepository() {
		return projectResultPatentRepository;
	}

	/**
	 * @return the projectResultProductRepository
	 */
	public LinkProjectResultProductRepository getProjectResultProductRepository() {
		return projectResultProductRepository;
	}

	/**
	 * @return the projectResultPublicationRepository
	 */
	public LinkProjectResultPublicationRepository getProjectResultPublicationRepository() {
		return projectResultPublicationRepository;
	}

	/**
	 * @return the projectServiceRepository
	 */
	public LinkProjectServiceRepository getProjectServiceRepository() {
		return projectServiceRepository;
	}

	/**
	 * @return the qualificationClassRepository
	 */
	public LinkQualificationClassRepository getQualificationClassRepository() {
		return qualificationClassRepository;
	}

	/**
	 * @return the resultPatentClassRepository
	 */
	public LinkResultPatentClassRepository getResultPatentClassRepository() {
		return resultPatentClassRepository;
	}

	/**
	 * @return the resultPatentEquipmentRepository
	 */
	public LinkResultPatentEquipmentRepository getResultPatentEquipmentRepository() {
		return resultPatentEquipmentRepository;
	}

	/**
	 * @return the resultPatentFacilityRepository
	 */
	public LinkResultPatentFacilityRepository getResultPatentFacilityRepository() {
		return resultPatentFacilityRepository;
	}

	/**
	 * @return the resultPatentFundingRepository
	 */
	public LinkResultPatentFundingRepository getResultPatentFundingRepository() {
		return resultPatentFundingRepository;
	}

	/**
	 * @return the resultPatentIndicatorRepository
	 */
	public LinkResultPatentIndicatorRepository getResultPatentIndicatorRepository() {
		return resultPatentIndicatorRepository;
	}

	/**
	 * @return the resultPatentMeasurementRepository
	 */
	public LinkResultPatentMeasurementRepository getResultPatentMeasurementRepository() {
		return resultPatentMeasurementRepository;
	}

	/**
	 * @return the resultPatentMediumRepository
	 */
	public LinkResultPatentMediumRepository getResultPatentMediumRepository() {
		return resultPatentMediumRepository;
	}

	/**
	 * @return the resultPatentResultPatentRepository
	 */
	public LinkResultPatentResultPatentRepository getResultPatentResultPatentRepository() {
		return resultPatentResultPatentRepository;
	}

	/**
	 * @return the resultPatentServiceRepository
	 */
	public LinkResultPatentServiceRepository getResultPatentServiceRepository() {
		return resultPatentServiceRepository;
	}

	/**
	 * @return the resultProductClassRepository
	 */
	public LinkResultProductClassRepository getResultProductClassRepository() {
		return resultProductClassRepository;
	}

	/**
	 * @return the resultProductCountryRepository
	 */
	public LinkResultProductCountryRepository getResultProductCountryRepository() {
		return resultProductCountryRepository;
	}

	/**
	 * @return the resultProductEquipmentRepository
	 */
	public LinkResultProductEquipmentRepository getResultProductEquipmentRepository() {
		return resultProductEquipmentRepository;
	}

	/**
	 * @return the resultProductFacilityRepository
	 */
	public LinkResultProductFacilityRepository getResultProductFacilityRepository() {
		return resultProductFacilityRepository;
	}

	/**
	 * @return the resultProductFundingRepository
	 */
	public LinkResultProductFundingRepository getResultProductFundingRepository() {
		return resultProductFundingRepository;
	}

	/**
	 * @return the resultProductGeographicBoundingBoxRepository
	 */
	public LinkResultProductGeographicBoundingBoxRepository getResultProductGeographicBoundingBoxRepository() {
		return resultProductGeographicBoundingBoxRepository;
	}

	/**
	 * @return the resultProductIndicatorRepository
	 */
	public LinkResultProductIndicatorRepository getResultProductIndicatorRepository() {
		return resultProductIndicatorRepository;
	}

	/**
	 * @return the resultProductMeasurementRepository
	 */
	public LinkResultProductMeasurementRepository getResultProductMeasurementRepository() {
		return resultProductMeasurementRepository;
	}

	/**
	 * @return the resultProductMediumRepository
	 */
	public LinkResultProductMediumRepository getResultProductMediumRepository() {
		return resultProductMediumRepository;
	}

	/**
	 * @return the resultProductResultProductRepository
	 */
	public LinkResultProductResultProductRepository getResultProductResultProductRepository() {
		return resultProductResultProductRepository;
	}

	/**
	 * @return the resultProductServiceRepository
	 */
	public LinkResultProductServiceRepository getResultProductServiceRepository() {
		return resultProductServiceRepository;
	}

	/**
	 * @return the resultPublicationCitationRepository
	 */
	public LinkResultPublicationCitationRepository getResultPublicationCitationRepository() {
		return resultPublicationCitationRepository;
	}

	/**
	 * @return the resultPublicationClassRepository
	 */
	public LinkResultPublicationClassRepository getResultPublicationClassRepository() {
		return resultPublicationClassRepository;
	}

	/**
	 * @return the resultPublicationDublinCoreRepository
	 */
	public LinkResultPublicationDublinCoreRepository getResultPublicationDublinCoreRepository() {
		return resultPublicationDublinCoreRepository;
	}

	/**
	 * @return the resultPublicationEquipmentRepository
	 */
	public LinkResultPublicationEquipmentRepository getResultPublicationEquipmentRepository() {
		return resultPublicationEquipmentRepository;
	}

	/**
	 * @return the resultPublicationEventRepository
	 */
	public LinkResultPublicationEventRepository getResultPublicationEventRepository() {
		return resultPublicationEventRepository;
	}

	/**
	 * @return the resultPublicationFacilityRepository
	 */
	public LinkResultPublicationFacilityRepository getResultPublicationFacilityRepository() {
		return resultPublicationFacilityRepository;
	}

	/**
	 * @return the resultPublicationFundingRepository
	 */
	public LinkResultPublicationFundingRepository getResultPublicationFundingRepository() {
		return resultPublicationFundingRepository;
	}

	/**
	 * @return the resultPublicationIndicatorRepository
	 */
	public LinkResultPublicationIndicatorRepository getResultPublicationIndicatorRepository() {
		return resultPublicationIndicatorRepository;
	}

	/**
	 * @return the resultPublicationMeasurementRepository
	 */
	public LinkResultPublicationMeasurementRepository getResultPublicationMeasurementRepository() {
		return resultPublicationMeasurementRepository;
	}

	/**
	 * @return the resultPublicationMediumRepository
	 */
	public LinkResultPublicationMediumRepository getResultPublicationMediumRepository() {
		return resultPublicationMediumRepository;
	}

	/**
	 * @return the resultPublicationMetricsRepository
	 */
	public LinkResultPublicationMetricsRepository getResultPublicationMetricsRepository() {
		return resultPublicationMetricsRepository;
	}

	/**
	 * @return the resultPublicationResultPatentRepository
	 */
	public LinkResultPublicationResultPatentRepository getResultPublicationResultPatentRepository() {
		return resultPublicationResultPatentRepository;
	}

	/**
	 * @return the resultPublicationResultProductRepository
	 */
	public LinkResultPublicationResultProductRepository getResultPublicationResultProductRepository() {
		return resultPublicationResultProductRepository;
	}

	/**
	 * @return the resultPublicationResultPublicationRepository
	 */
	public LinkResultPublicationResultPublicationRepository getResultPublicationResultPublicationRepository() {
		return resultPublicationResultPublicationRepository;
	}

	/**
	 * @return the resultPublicationServiceRepository
	 */
	public LinkResultPublicationServiceRepository getResultPublicationServiceRepository() {
		return resultPublicationServiceRepository;
	}

	/**
	 * @return the serviceClassRepository
	 */
	public LinkServiceClassRepository getServiceClassRepository() {
		return serviceClassRepository;
	}

	/**
	 * @return the serviceEventRepository
	 */
	public LinkServiceEventRepository getServiceEventRepository() {
		return serviceEventRepository;
	}

	/**
	 * @return the serviceFederatedIdentifierRepository
	 */
	public LinkServiceFederatedIdentifierRepository getServiceFederatedIdentifierRepository() {
		return serviceFederatedIdentifierRepository;
	}

	/**
	 * @return the serviceFundingRepository
	 */
	public LinkServiceFundingRepository getServiceFundingRepository() {
		return serviceFundingRepository;
	}

	/**
	 * @return the serviceIndicatorRepository
	 */
	public LinkServiceIndicatorRepository getServiceIndicatorRepository() {
		return serviceIndicatorRepository;
	}

	/**
	 * @return the serviceMeasurementRepository
	 */
	public LinkServiceMeasurementRepository getServiceMeasurementRepository() {
		return serviceMeasurementRepository;
	}

	/**
	 * @return the serviceMediumRepository
	 */
	public LinkServiceMediumRepository getServiceMediumRepository() {
		return serviceMediumRepository;
	}

	/**
	 * @return the servicePostalAddressRepository
	 */
	public LinkServicePostalAddressRepository getServicePostalAddressRepository() {
		return servicePostalAddressRepository;
	}

	/**
	 * @return the serviceServiceRepository
	 */
	public LinkServiceServiceRepository getServiceServiceRepository() {
		return serviceServiceRepository;
	}

	
	
}
