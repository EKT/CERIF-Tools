/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.services.multilingual.citation.CitationDescriptionRepository;
import gr.ekt.cerif.services.multilingual.citation.CitationTitleRepository;
import gr.ekt.cerif.services.multilingual.classscheme.ClassSchemeDescriptionRepository;
import gr.ekt.cerif.services.multilingual.classscheme.ClassSchemeNameRepository;
import gr.ekt.cerif.services.multilingual.country.CountryNameRepository;
import gr.ekt.cerif.services.multilingual.currency.CurrencyEntityNameRepository;
import gr.ekt.cerif.services.multilingual.currency.CurrencyNameRepository;
import gr.ekt.cerif.services.multilingual.equipment.EquipmentDescriptionRepository;
import gr.ekt.cerif.services.multilingual.equipment.EquipmentKeywordRepository;
import gr.ekt.cerif.services.multilingual.equipment.EquipmentNameRepository;
import gr.ekt.cerif.services.multilingual.event.EventDescriptionRepository;
import gr.ekt.cerif.services.multilingual.event.EventKeywordRepository;
import gr.ekt.cerif.services.multilingual.event.EventNameRepository;
import gr.ekt.cerif.services.multilingual.expertiseandskills.ExpertiseAndSkillsDescriptionRepository;
import gr.ekt.cerif.services.multilingual.expertiseandskills.ExpertiseAndSkillsKeywordRepository;
import gr.ekt.cerif.services.multilingual.expertiseandskills.ExpertiseAndSkillsNameRepository;
import gr.ekt.cerif.services.multilingual.facility.FacilityDescriptionRepository;
import gr.ekt.cerif.services.multilingual.facility.FacilityKeywordRepository;
import gr.ekt.cerif.services.multilingual.facility.FacilityNameRepository;
import gr.ekt.cerif.services.multilingual.funding.FundingDescriptionRepository;
import gr.ekt.cerif.services.multilingual.funding.FundingKeywordRepository;
import gr.ekt.cerif.services.multilingual.funding.FundingNameRepository;
import gr.ekt.cerif.services.multilingual.geographicboundingbox.GeographicBoundingBoxDescriptionRepository;
import gr.ekt.cerif.services.multilingual.geographicboundingbox.GeographicBoundingBoxKeywordRepository;
import gr.ekt.cerif.services.multilingual.geographicboundingbox.GeographicBoundingBoxNameRepository;
import gr.ekt.cerif.services.multilingual.indicator.IndicatorDescriptionRepository;
import gr.ekt.cerif.services.multilingual.indicator.IndicatorKeywordRepository;
import gr.ekt.cerif.services.multilingual.indicator.IndicatorNameRepository;
import gr.ekt.cerif.services.multilingual.language.LanguageNameRepository;
import gr.ekt.cerif.services.multilingual.measurement.MeasurementDescriptionRepository;
import gr.ekt.cerif.services.multilingual.measurement.MeasurementKeywordRepository;
import gr.ekt.cerif.services.multilingual.measurement.MeasurementNameRepository;
import gr.ekt.cerif.services.multilingual.medium.MediumDescriptionRepository;
import gr.ekt.cerif.services.multilingual.medium.MediumKeywordRepository;
import gr.ekt.cerif.services.multilingual.medium.MediumTitleRepository;
import gr.ekt.cerif.services.multilingual.metrics.MetricsDescriptionRepository;
import gr.ekt.cerif.services.multilingual.metrics.MetricsKeywordRepository;
import gr.ekt.cerif.services.multilingual.metrics.MetricsNameRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitKeywordRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitNameRepository;
import gr.ekt.cerif.services.multilingual.organisationunit.OrganisationUnitResearchActivityRepository;
import gr.ekt.cerif.services.multilingual.person.PersonKeywordRepository;
import gr.ekt.cerif.services.multilingual.person.PersonResearchInterestRepository;
import gr.ekt.cerif.services.multilingual.prize.PrizeDescriptionRepository;
import gr.ekt.cerif.services.multilingual.prize.PrizeKeywordRepository;
import gr.ekt.cerif.services.multilingual.prize.PrizeNameRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectAbstractRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectKeywordRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectTitleRepository;
import gr.ekt.cerif.services.multilingual.qualification.QualificationDescriptionRepository;
import gr.ekt.cerif.services.multilingual.qualification.QualificationKeywordRepository;
import gr.ekt.cerif.services.multilingual.qualification.QualificationTitleRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentAbstractRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentKeywordRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentTitleRepository;
import gr.ekt.cerif.services.multilingual.resultpatent.ResultPatentVersionInfoRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductAlternateNameRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductDescriptionRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductKeywordRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductNameRepository;
import gr.ekt.cerif.services.multilingual.resultproduct.ResultProductVersionInfoRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationAbstractRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationBibliographicNoteRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationKeywordRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationNameAbbreviationRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationSubtitleRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationTitleRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationVersionInfoRepository;
import gr.ekt.cerif.services.multilingual.service.ServiceDescriptionRepository;
import gr.ekt.cerif.services.multilingual.service.ServiceKeywordRepository;
import gr.ekt.cerif.services.multilingual.service.ServiceNameRepository;
import gr.ekt.cerif.services.multilingual.theclass.ClassDefinitionRepository;
import gr.ekt.cerif.services.multilingual.theclass.ClassDescriptionRepository;
import gr.ekt.cerif.services.multilingual.theclass.ClassExRepository;
import gr.ekt.cerif.services.multilingual.theclass.ClassTermRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF Multiple Language Feature Entities.
 * 
 */
@Component
public class TranslationPersistenceService {
	private static final Logger log = LoggerFactory.getLogger(TranslationPersistenceService.class);
	
	@Autowired
	CitationDescriptionRepository citationDescriptionRepository;

	@Autowired
	CitationTitleRepository citationTitleRepository;
	
	@Autowired
	ClassDefinitionRepository classDefinitionRepository;

	@Autowired
	ClassDescriptionRepository classDescriptionRepository;

	@Autowired
	ClassExRepository classExRepository;
	
	@Autowired
	ClassSchemeNameRepository classSchemeNameRepository;
	
	@Autowired
	ClassSchemeDescriptionRepository classSchemeDescriptionRepository;
	
	@Autowired
	ClassTermRepository classTermRepository;
	
	@Autowired
	CountryNameRepository countryNameRepository;
	
	@Autowired
	CurrencyNameRepository currencyNameRepository;

	@Autowired
	CurrencyEntityNameRepository currencyEntityNameRepository;
	
	@Autowired
	EquipmentDescriptionRepository equipmentDescriptionRepository;

	@Autowired
	EquipmentKeywordRepository equipmentKeywordRepository;

	@Autowired
	EquipmentNameRepository equipmentNameRepository;
	
	@Autowired
	ExpertiseAndSkillsDescriptionRepository expertiseAndSkillsDescriptionRepository;

	@Autowired
	ExpertiseAndSkillsKeywordRepository expertiseAndSkillsKeywordRepository;

	@Autowired
	ExpertiseAndSkillsNameRepository expertiseAndSkillsNameRepository;
	
	@Autowired
	FacilityNameRepository facilityNameRepository;
	
	@Autowired
	FacilityDescriptionRepository facilityDescriptionRepository;

	@Autowired
	FacilityKeywordRepository facilityKeywordRepository;
	
	@Autowired
	FundingDescriptionRepository fundingDescriptionRepository;

	@Autowired
	FundingKeywordRepository fundingKeywordRepository;

	@Autowired
	FundingNameRepository fundingNameRepository;
	
	@Autowired
	GeographicBoundingBoxNameRepository geographicBoundingBoxNameRepository;

	@Autowired
	GeographicBoundingBoxDescriptionRepository geographicBoundingBoxDescriptionRepository;

	@Autowired
	GeographicBoundingBoxKeywordRepository geographicBoundingBoxKeywordRepository;
	
	@Autowired
	IndicatorDescriptionRepository indicatorDescriptionRepository;

	@Autowired
	IndicatorKeywordRepository indicatorKeywordRepository;

	@Autowired
	IndicatorNameRepository indicatorNameRepository;
	
	@Autowired
	LanguageNameRepository languageNameRepository;

	@Autowired
	MeasurementDescriptionRepository measurementDescriptionRepository;

	@Autowired
	MeasurementKeywordRepository measurementKeywordRepository;

	@Autowired
	MeasurementNameRepository measurementNameRepository;

	@Autowired
	MediumDescriptionRepository mediumDescriptionRepository;

	@Autowired
	MediumKeywordRepository mediumKeywordRepository;

	@Autowired
	MediumTitleRepository mediumTitleRepository;

	@Autowired
	MetricsDescriptionRepository metricsDescriptionRepository;

	@Autowired
	MetricsKeywordRepository metricsKeywordRepository;

	@Autowired
	MetricsNameRepository metricsNameRepository;
	
	@Autowired
	OrganisationUnitNameRepository organisationUnitNameRepository;
	
	@Autowired
	OrganisationUnitResearchActivityRepository organisationUnitResearchActivityRepository;

	@Autowired
	OrganisationUnitKeywordRepository organisationUnitKeywordRepository;
	
	@Autowired
	PersonResearchInterestRepository personResearchInterestRepository;

	@Autowired
	PersonKeywordRepository personKeywordRepository;

	@Autowired
	PrizeDescriptionRepository prizeDescriptionRepository;

	@Autowired
	PrizeKeywordRepository prizeKeywordRepository;

	@Autowired
	PrizeNameRepository prizeNameRepository;
	
	@Autowired
	ProjectTitleRepository projectTitleRepository;
	
	@Autowired
	ProjectAbstractRepository projectAbstractRepository;

	@Autowired
	ProjectKeywordRepository projectKeywordRepository;
	
	@Autowired
	QualificationTitleRepository qualificationTitleRepository;

	@Autowired
	QualificationDescriptionRepository qualificationDescriptionRepository;

	@Autowired
	QualificationKeywordRepository qualificationKeywordRepository;

	@Autowired
	ResultPatentTitleRepository resultPatentTitleRepository;

	@Autowired
	ResultPatentAbstractRepository resultPatentAbstractRepository;

	@Autowired
	ResultPatentKeywordRepository resultPatentKeywordRepository;

	@Autowired
	ResultPatentVersionInfoRepository resultPatentVersionInfoRepository;

	@Autowired
	ResultProductNameRepository resultProductNameRepository;

	@Autowired
	ResultProductKeywordRepository resultProductKeywordRepository;

	@Autowired
	ResultProductDescriptionRepository resultProductDescriptionRepository;

	@Autowired
	ResultProductVersionInfoRepository resultProductVersionInfoRepository;
	
	@Autowired
	ResultProductAlternateNameRepository resultProductAlternateNameRepository;
	
	@Autowired
	ResultPublicationSubtitleRepository resultPublicationSubtitleRepository;

	@Autowired
	ResultPublicationNameAbbreviationRepository resultPublicationNameAbbreviationRepository;

	@Autowired
	ResultPublicationBibliographicNoteRepository resultPublicationBibliographicNoteRepository;

	@Autowired
	ResultPublicationVersionInfoRepository resultPublicationVersionInfoRepository;
	
	@Autowired
	ResultPublicationTitleRepository resultPublicationTitleRepository;
	
	@Autowired
	ResultPublicationAbstractRepository resultPublicationAbstractRepository;
	
	@Autowired
	ResultPublicationKeywordRepository resultPublicationKeywordRepository;
	
	@Autowired
	EventNameRepository eventNameRepository;
	
	@Autowired
	EventKeywordRepository eventKeywordRepository;
	
	@Autowired
	EventDescriptionRepository eventDescriptionRepository;
	
	@Autowired
	ServiceDescriptionRepository serviceDescriptionRepository;

	@Autowired
	ServiceKeywordRepository serviceKeywordRepository;

	@Autowired
	ServiceNameRepository serviceNameRepository;
	
	
	/**
	 * @return the citationDescriptionRepository
	 */
	public CitationDescriptionRepository getCitationDescriptionRepository() {
		return citationDescriptionRepository;
	}


	/**
	 * @return the citationTitleRepository
	 */
	public CitationTitleRepository getCitationTitleRepository() {
		return citationTitleRepository;
	}


	/**
	 * @return the classDefinitionRepository
	 */
	public ClassDefinitionRepository getClassDefinitionRepository() {
		return classDefinitionRepository;
	}


	/**
	 * @return the classDescriptionRepository
	 */
	public ClassDescriptionRepository getClassDescriptionRepository() {
		return classDescriptionRepository;
	}


	/**
	 * @return the classExRepository
	 */
	public ClassExRepository getClassExRepository() {
		return classExRepository;
	}


	/**
	 * @return the classSchemeNameRepository
	 */
	public ClassSchemeNameRepository getClassSchemeNameRepository() {
		return classSchemeNameRepository;
	}


	/**
	 * @return the classSchemeDescriptionRepository
	 */
	public ClassSchemeDescriptionRepository getClassSchemeDescriptionRepository() {
		return classSchemeDescriptionRepository;
	}


	/**
	 * @return the classTermRepository
	 */
	public ClassTermRepository getClassTermRepository() {
		return classTermRepository;
	}


	/**
	 * @return the countryNameRepository
	 */
	public CountryNameRepository getCountryNameRepository() {
		return countryNameRepository;
	}


	/**
	 * @return the currencyNameRepository
	 */
	public CurrencyNameRepository getCurrencyNameRepository() {
		return currencyNameRepository;
	}


	/**
	 * @return the currencyEntityNameRepository
	 */
	public CurrencyEntityNameRepository getCurrencyEntityNameRepository() {
		return currencyEntityNameRepository;
	}


	/**
	 * @return the equipmentDescriptionRepository
	 */
	public EquipmentDescriptionRepository getEquipmentDescriptionRepository() {
		return equipmentDescriptionRepository;
	}


	/**
	 * @return the equipmentKeywordRepository
	 */
	public EquipmentKeywordRepository getEquipmentKeywordRepository() {
		return equipmentKeywordRepository;
	}


	/**
	 * @return the equipmentNameRepository
	 */
	public EquipmentNameRepository getEquipmentNameRepository() {
		return equipmentNameRepository;
	}


	/**
	 * @return the expertiseAndSkillsDescriptionRepository
	 */
	public ExpertiseAndSkillsDescriptionRepository getExpertiseAndSkillsDescriptionRepository() {
		return expertiseAndSkillsDescriptionRepository;
	}


	/**
	 * @return the expertiseAndSkillsKeywordRepository
	 */
	public ExpertiseAndSkillsKeywordRepository getExpertiseAndSkillsKeywordRepository() {
		return expertiseAndSkillsKeywordRepository;
	}


	/**
	 * @return the expertiseAndSkillsNameRepository
	 */
	public ExpertiseAndSkillsNameRepository getExpertiseAndSkillsNameRepository() {
		return expertiseAndSkillsNameRepository;
	}


	/**
	 * @return the facilityNameRepository
	 */
	public FacilityNameRepository getFacilityNameRepository() {
		return facilityNameRepository;
	}


	/**
	 * @return the facilityDescriptionRepository
	 */
	public FacilityDescriptionRepository getFacilityDescriptionRepository() {
		return facilityDescriptionRepository;
	}


	/**
	 * @return the facilityKeywordRepository
	 */
	public FacilityKeywordRepository getFacilityKeywordRepository() {
		return facilityKeywordRepository;
	}


	/**
	 * @return the fundingDescriptionRepository
	 */
	public FundingDescriptionRepository getFundingDescriptionRepository() {
		return fundingDescriptionRepository;
	}


	/**
	 * @return the fundingKeywordRepository
	 */
	public FundingKeywordRepository getFundingKeywordRepository() {
		return fundingKeywordRepository;
	}


	/**
	 * @return the fundingNameRepository
	 */
	public FundingNameRepository getFundingNameRepository() {
		return fundingNameRepository;
	}


	/**
	 * @return the geographicBoundingBoxNameRepository
	 */
	public GeographicBoundingBoxNameRepository getGeographicBoundingBoxNameRepository() {
		return geographicBoundingBoxNameRepository;
	}


	/**
	 * @return the geographicBoundingBoxDescriptionRepository
	 */
	public GeographicBoundingBoxDescriptionRepository getGeographicBoundingBoxDescriptionRepository() {
		return geographicBoundingBoxDescriptionRepository;
	}


	/**
	 * @return the geographicBoundingBoxKeywordRepository
	 */
	public GeographicBoundingBoxKeywordRepository getGeographicBoundingBoxKeywordRepository() {
		return geographicBoundingBoxKeywordRepository;
	}


	/**
	 * @return the indicatorDescriptionRepository
	 */
	public IndicatorDescriptionRepository getIndicatorDescriptionRepository() {
		return indicatorDescriptionRepository;
	}


	/**
	 * @return the indicatorKeywordRepository
	 */
	public IndicatorKeywordRepository getIndicatorKeywordRepository() {
		return indicatorKeywordRepository;
	}


	/**
	 * @return the indicatorNameRepository
	 */
	public IndicatorNameRepository getIndicatorNameRepository() {
		return indicatorNameRepository;
	}


	/**
	 * @return the languageNameRepository
	 */
	public LanguageNameRepository getLanguageNameRepository() {
		return languageNameRepository;
	}


	/**
	 * @return the measurementDescriptionRepository
	 */
	public MeasurementDescriptionRepository getMeasurementDescriptionRepository() {
		return measurementDescriptionRepository;
	}


	/**
	 * @return the measurementKeywordRepository
	 */
	public MeasurementKeywordRepository getMeasurementKeywordRepository() {
		return measurementKeywordRepository;
	}


	/**
	 * @return the measurementNameRepository
	 */
	public MeasurementNameRepository getMeasurementNameRepository() {
		return measurementNameRepository;
	}


	/**
	 * @return the mediumDescriptionRepository
	 */
	public MediumDescriptionRepository getMediumDescriptionRepository() {
		return mediumDescriptionRepository;
	}


	/**
	 * @return the mediumKeywordRepository
	 */
	public MediumKeywordRepository getMediumKeywordRepository() {
		return mediumKeywordRepository;
	}


	/**
	 * @return the mediumTitleRepository
	 */
	public MediumTitleRepository getMediumTitleRepository() {
		return mediumTitleRepository;
	}


	/**
	 * @return the metricsDescriptionRepository
	 */
	public MetricsDescriptionRepository getMetricsDescriptionRepository() {
		return metricsDescriptionRepository;
	}


	/**
	 * @return the metricsKeywordRepository
	 */
	public MetricsKeywordRepository getMetricsKeywordRepository() {
		return metricsKeywordRepository;
	}


	/**
	 * @return the metricsNameRepository
	 */
	public MetricsNameRepository getMetricsNameRepository() {
		return metricsNameRepository;
	}


	/**
	 * @return the organisationUnitNameRepository
	 */
	public OrganisationUnitNameRepository getOrganisationUnitNameRepository() {
		return organisationUnitNameRepository;
	}


	/**
	 * @return the organisationUnitResearchActivityRepository
	 */
	public OrganisationUnitResearchActivityRepository getOrganisationUnitResearchActivityRepository() {
		return organisationUnitResearchActivityRepository;
	}


	/**
	 * @return the organisationUnitKeywordRepository
	 */
	public OrganisationUnitKeywordRepository getOrganisationUnitKeywordRepository() {
		return organisationUnitKeywordRepository;
	}


	/**
	 * @return the personResearchInterestRepository
	 */
	public PersonResearchInterestRepository getPersonResearchInterestRepository() {
		return personResearchInterestRepository;
	}


	/**
	 * @return the personKeywordRepository
	 */
	public PersonKeywordRepository getPersonKeywordRepository() {
		return personKeywordRepository;
	}


	/**
	 * @return the prizeDescriptionRepository
	 */
	public PrizeDescriptionRepository getPrizeDescriptionRepository() {
		return prizeDescriptionRepository;
	}


	/**
	 * @return the prizeKeywordRepository
	 */
	public PrizeKeywordRepository getPrizeKeywordRepository() {
		return prizeKeywordRepository;
	}


	/**
	 * @return the prizeNameRepository
	 */
	public PrizeNameRepository getPrizeNameRepository() {
		return prizeNameRepository;
	}


	/**
	 * @return the projectTitleRepository
	 */
	public ProjectTitleRepository getProjectTitleRepository() {
		return projectTitleRepository;
	}


	/**
	 * @return the projectAbstractRepository
	 */
	public ProjectAbstractRepository getProjectAbstractRepository() {
		return projectAbstractRepository;
	}


	/**
	 * @return the projectKeywordRepository
	 */
	public ProjectKeywordRepository getProjectKeywordRepository() {
		return projectKeywordRepository;
	}


	/**
	 * @return the qualificationTitleRepository
	 */
	public QualificationTitleRepository getQualificationTitleRepository() {
		return qualificationTitleRepository;
	}


	/**
	 * @return the qualificationDescriptionRepository
	 */
	public QualificationDescriptionRepository getQualificationDescriptionRepository() {
		return qualificationDescriptionRepository;
	}


	/**
	 * @return the qualificationKeywordRepository
	 */
	public QualificationKeywordRepository getQualificationKeywordRepository() {
		return qualificationKeywordRepository;
	}


	/**
	 * @return the resultPatentTitleRepository
	 */
	public ResultPatentTitleRepository getResultPatentTitleRepository() {
		return resultPatentTitleRepository;
	}


	/**
	 * @return the resultPatentAbstractRepository
	 */
	public ResultPatentAbstractRepository getResultPatentAbstractRepository() {
		return resultPatentAbstractRepository;
	}


	/**
	 * @return the resultPatentKeywordRepository
	 */
	public ResultPatentKeywordRepository getResultPatentKeywordRepository() {
		return resultPatentKeywordRepository;
	}


	/**
	 * @return the resultPatentVersionInfoRepository
	 */
	public ResultPatentVersionInfoRepository getResultPatentVersionInfoRepository() {
		return resultPatentVersionInfoRepository;
	}


	/**
	 * @return the resultProductNameRepository
	 */
	public ResultProductNameRepository getResultProductNameRepository() {
		return resultProductNameRepository;
	}


	/**
	 * @return the resultProductKeywordRepository
	 */
	public ResultProductKeywordRepository getResultProductKeywordRepository() {
		return resultProductKeywordRepository;
	}


	/**
	 * @return the resultProductDescriptionRepository
	 */
	public ResultProductDescriptionRepository getResultProductDescriptionRepository() {
		return resultProductDescriptionRepository;
	}


	/**
	 * @return the resultProductVersionInfoRepository
	 */
	public ResultProductVersionInfoRepository getResultProductVersionInfoRepository() {
		return resultProductVersionInfoRepository;
	}

	/**
	 * Returns the resultProductAlternateNameRepository.
	 * @return the resultProductAlternateNameRepository.
	 */
	public ResultProductAlternateNameRepository getResultProductAlternateNameRepository() {
		return resultProductAlternateNameRepository;
	}

	/**
	 * @return the resultPublicationSubtitleRepository
	 */
	public ResultPublicationSubtitleRepository getResultPublicationSubtitleRepository() {
		return resultPublicationSubtitleRepository;
	}


	/**
	 * @return the resultPublicationNameAbbreviationRepository
	 */
	public ResultPublicationNameAbbreviationRepository getResultPublicationNameAbbreviationRepository() {
		return resultPublicationNameAbbreviationRepository;
	}


	/**
	 * @return the resultPublicationBibliographicNoteRepository
	 */
	public ResultPublicationBibliographicNoteRepository getResultPublicationBibliographicNoteRepository() {
		return resultPublicationBibliographicNoteRepository;
	}


	/**
	 * @return the resultPublicationVersionInfoRepository
	 */
	public ResultPublicationVersionInfoRepository getResultPublicationVersionInfoRepository() {
		return resultPublicationVersionInfoRepository;
	}


	/**
	 * @return the resultPublicationTitleRepository
	 */
	public ResultPublicationTitleRepository getResultPublicationTitleRepository() {
		return resultPublicationTitleRepository;
	}


	/**
	 * @return the resultPublicationAbstractRepository
	 */
	public ResultPublicationAbstractRepository getResultPublicationAbstractRepository() {
		return resultPublicationAbstractRepository;
	}


	/**
	 * @return the resultPublicationKeywordRepository
	 */
	public ResultPublicationKeywordRepository getResultPublicationKeywordRepository() {
		return resultPublicationKeywordRepository;
	}


	/**
	 * @return the eventNameRepository
	 */
	public EventNameRepository getEventNameRepository() {
		return eventNameRepository;
	}


	/**
	 * @return the eventKeywordRepository
	 */
	public EventKeywordRepository getEventKeywordRepository() {
		return eventKeywordRepository;
	}


	/**
	 * @return the eventDescriptionRepository
	 */
	public EventDescriptionRepository getEventDescriptionRepository() {
		return eventDescriptionRepository;
	}


	/**
	 * @return the serviceDescriptionRepository
	 */
	public ServiceDescriptionRepository getServiceDescriptionRepository() {
		return serviceDescriptionRepository;
	}


	/**
	 * @return the serviceKeywordRepository
	 */
	public ServiceKeywordRepository getServiceKeywordRepository() {
		return serviceKeywordRepository;
	}


	/**
	 * @return the serviceNameRepository
	 */
	public ServiceNameRepository getServiceNameRepository() {
		return serviceNameRepository;
	}
	
	
	
}
