/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.services.link.citation.LinkCitationClassRepository;
import gr.ekt.cerif.services.link.citation.LinkCitationMediumRepository;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeClassRepository;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeClassSchemeRepository;
import gr.ekt.cerif.services.link.classscheme.LinkClassSchemeOrganisationUnitRepository;
import gr.ekt.cerif.services.link.country.LinkCountryClassRepository;
import gr.ekt.cerif.services.link.currency.LinkCurrencyClassRepository;
import gr.ekt.cerif.services.link.curriculumvitae.LinkCurriculumVitaeClassRepository;
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
import gr.ekt.cerif.services.link.person.LinkPersonCurriculumVitaeRepository;
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
import gr.ekt.cerif.services.link.personname.LinkPersonNameClassRepository;
import gr.ekt.cerif.services.link.personname.LinkPersonNamePersonRepository;
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
import gr.ekt.cerif.services.link.result.LinkGeographicBoundingBoxMeasurementRepository;
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
	private LinkCurriculumVitaeClassRepository curriculumVitaeClassRepository;

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
	private LinkGeographicBoundingBoxMeasurementRepository geographicBoundingBoxMeasurementRepository;
	
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
	private LinkPersonCurriculumVitaeRepository personCurriculumVitaeRepository;

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

	@Autowired
	private LinkPersonNamePersonRepository personNamePersonRepository;
	
	@Autowired
	private LinkPersonNameClassRepository personNameClassRepository;
	
	
	
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
	 * Returns the geographicBoundingBoxMeasurementRepository.
	 * @return the geographicBoundingBoxMeasurementRepository.
	 */
	public LinkGeographicBoundingBoxMeasurementRepository getGeographicBoundingBoxMeasurementRepository() {
		return geographicBoundingBoxMeasurementRepository;
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
	 * @return the curriculumVitaeClassRepository
	 */
	public LinkCurriculumVitaeClassRepository getCurriculumVitaeClassRepository() {
		return curriculumVitaeClassRepository;
	}

	/**
	 * @return the personCurriculumVitaeRepository
	 */
	public LinkPersonCurriculumVitaeRepository getPersonCurriculumVitaeRepository() {
		return personCurriculumVitaeRepository;
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

	/**
	 * @return the personNamePersonRepository
	 */
	public LinkPersonNamePersonRepository getPersonNamePersonRepository() {
		return personNamePersonRepository;
	}

	/**
	 * @return the personNameClassRepository
	 */
	public LinkPersonNameClassRepository getPersonNameClassRepository() {
		return personNameClassRepository;
	}

	
}
