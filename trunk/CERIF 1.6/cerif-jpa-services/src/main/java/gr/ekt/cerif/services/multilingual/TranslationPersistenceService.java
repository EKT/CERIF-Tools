/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.CountryName;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;
import gr.ekt.cerif.features.multilingual.CurrencyName;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;
import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;
import gr.ekt.cerif.features.multilingual.LanguageName;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;
import gr.ekt.cerif.features.multilingual.MetricsDescription;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;
import gr.ekt.cerif.features.multilingual.MetricsName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;
import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;
import gr.ekt.cerif.features.multilingual.PrizeDescription;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;
import gr.ekt.cerif.features.multilingual.PrizeName;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.QualificationDescription;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;
import gr.ekt.cerif.features.multilingual.QualificationTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;
import gr.ekt.cerif.features.multilingual.ResultProductAlternateName;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;
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
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public void delete(CerifMultipleLanguageFeature entity) {
		if (entity instanceof ClassSchemeName) {
			classSchemeNameRepository.delete( (ClassSchemeName) entity);
		} else if (entity instanceof ClassSchemeDescription) {
			classSchemeDescriptionRepository.delete( (ClassSchemeDescription) entity);
		} else if (entity instanceof FacilityName) {
			facilityNameRepository.delete( (FacilityName) entity);
		} else if (entity instanceof OrganisationUnitName) {
			organisationUnitNameRepository.delete( (OrganisationUnitName) entity);
		} else if (entity instanceof ResultPublicationTitle) {
			resultPublicationTitleRepository.delete((ResultPublicationTitle) entity);
		} else if (entity instanceof ResultPublicationAbstract) {
			resultPublicationAbstractRepository.delete((ResultPublicationAbstract) entity);
		} else if (entity instanceof ResultPublicationKeyword) {
			resultPublicationKeywordRepository.delete((ResultPublicationKeyword) entity);
		} else if (entity instanceof ProjectTitle) {
			projectTitleRepository.delete((ProjectTitle) entity);
		} else if (entity instanceof ClassTerm) {
			classTermRepository.delete((ClassTerm) entity);
		} else if (entity instanceof EventName) {
			eventNameRepository.delete((EventName) entity);
		} else if (entity instanceof EventKeyword) {
			eventKeywordRepository.delete((EventKeyword) entity);
		} else if (entity instanceof EventDescription) {
			eventDescriptionRepository.delete((EventDescription) entity);
		} else if (entity instanceof CitationDescription) {
			citationDescriptionRepository.delete( (CitationDescription) entity);
		} else if (entity instanceof CitationTitle) {
			citationTitleRepository.delete( (CitationTitle) entity);
		} else if (entity instanceof ClassDefinition) {
			classDefinitionRepository.delete( (ClassDefinition) entity);
		} else if (entity instanceof ClassDescription) {
			classDescriptionRepository.delete( (ClassDescription) entity);
		} else if (entity instanceof ClassEx) {
			classExRepository.delete( (ClassEx) entity);
		} else if (entity instanceof CountryName) {
			countryNameRepository.delete( (CountryName) entity);
		} else if (entity instanceof CurrencyName) {
			currencyNameRepository.delete( (CurrencyName) entity);
		} else if (entity instanceof CurrencyEntityName) {
			currencyEntityNameRepository.delete( (CurrencyEntityName) entity);
		} else if (entity instanceof EquipmentDescription) {
			equipmentDescriptionRepository.delete( (EquipmentDescription) entity);
		} else if (entity instanceof EquipmentKeyword) {
			equipmentKeywordRepository.delete( (EquipmentKeyword) entity);
		} else if (entity instanceof EquipmentName) {
			equipmentNameRepository.delete( (EquipmentName) entity);
		} else if (entity instanceof ExpertiseAndSkillsDescription) {
			expertiseAndSkillsDescriptionRepository.delete( (ExpertiseAndSkillsDescription) entity);
		} else if (entity instanceof ExpertiseAndSkillsKeyword) {
			expertiseAndSkillsKeywordRepository.delete( (ExpertiseAndSkillsKeyword) entity);
		} else if (entity instanceof ExpertiseAndSkillsName) {
			expertiseAndSkillsNameRepository.delete( (ExpertiseAndSkillsName) entity);
		} else if (entity instanceof FacilityDescription) {
			facilityDescriptionRepository.delete( (FacilityDescription) entity);
		} else if (entity instanceof FacilityKeyword) {
			facilityKeywordRepository.delete( (FacilityKeyword) entity);
		} else if (entity instanceof FundingDescription) {
			fundingDescriptionRepository.delete( (FundingDescription) entity);
		} else if (entity instanceof FundingKeyword) {
			fundingKeywordRepository.delete( (FundingKeyword) entity);
		} else if (entity instanceof FundingName) {
			fundingNameRepository.delete( (FundingName) entity);
		} else if (entity instanceof GeographicBoundingBoxName) {
			geographicBoundingBoxNameRepository.delete( (GeographicBoundingBoxName) entity);
		} else if (entity instanceof GeographicBoundingBoxDescription) {
			geographicBoundingBoxDescriptionRepository.delete( (GeographicBoundingBoxDescription) entity);
		} else if (entity instanceof GeographicBoundingBoxKeyword) {
			geographicBoundingBoxKeywordRepository.delete( (GeographicBoundingBoxKeyword) entity);
		} else if (entity instanceof IndicatorDescription) {
			indicatorDescriptionRepository.delete( (IndicatorDescription) entity);
		} else if (entity instanceof IndicatorKeyword) {
			indicatorKeywordRepository.delete( (IndicatorKeyword) entity);
		} else if (entity instanceof IndicatorName) {
			indicatorNameRepository.delete( (IndicatorName) entity);
		} else if (entity instanceof LanguageName) {
			languageNameRepository.delete( (LanguageName) entity);
		} else if (entity instanceof MeasurementDescription) {
			measurementDescriptionRepository.delete( (MeasurementDescription) entity);
		} else if (entity instanceof MeasurementKeyword) {
			measurementKeywordRepository.delete( (MeasurementKeyword) entity);
		} else if (entity instanceof MeasurementName) {
			measurementNameRepository.delete( (MeasurementName) entity);
		} else if (entity instanceof MediumDescription) {
			mediumDescriptionRepository.delete( (MediumDescription) entity);
		} else if (entity instanceof MediumKeyword) {
			mediumKeywordRepository.delete( (MediumKeyword) entity);
		} else if (entity instanceof MediumTitle) {
			mediumTitleRepository.delete( (MediumTitle) entity);
		} else if (entity instanceof MetricsDescription) {
			metricsDescriptionRepository.delete( (MetricsDescription) entity);
		} else if (entity instanceof MetricsKeyword) {
			metricsKeywordRepository.delete( (MetricsKeyword) entity);
		} else if (entity instanceof MetricsName) {
			metricsNameRepository.delete( (MetricsName) entity);
		} else if (entity instanceof OrganisationUnitResearchActivity) {
			organisationUnitResearchActivityRepository.delete( (OrganisationUnitResearchActivity) entity);
		} else if (entity instanceof OrganisationUnitKeyword) {
			organisationUnitKeywordRepository.delete( (OrganisationUnitKeyword) entity);
		} else if (entity instanceof PersonResearchInterest) {
			personResearchInterestRepository.delete( (PersonResearchInterest) entity);
		} else if (entity instanceof PersonKeyword) {
			personKeywordRepository.delete( (PersonKeyword) entity);
		} else if (entity instanceof PrizeDescription) {
			prizeDescriptionRepository.delete( (PrizeDescription) entity);
		} else if (entity instanceof PrizeKeyword) {
			prizeKeywordRepository.delete( (PrizeKeyword) entity);
		} else if (entity instanceof PrizeName) {
			prizeNameRepository.delete( (PrizeName) entity);
		} else if (entity instanceof ProjectAbstract) {
			projectAbstractRepository.delete( (ProjectAbstract) entity);
		} else if (entity instanceof ProjectKeyword) {
			projectKeywordRepository.delete( (ProjectKeyword) entity);
		} else if (entity instanceof QualificationTitle) {
			qualificationTitleRepository.delete( (QualificationTitle) entity);
		} else if (entity instanceof QualificationDescription) {
			qualificationDescriptionRepository.delete( (QualificationDescription) entity);
		} else if (entity instanceof QualificationKeyword) {
			qualificationKeywordRepository.delete( (QualificationKeyword) entity);
		} else if (entity instanceof ResultPatentTitle) {
			resultPatentTitleRepository.delete( (ResultPatentTitle) entity);
		} else if (entity instanceof ResultPatentAbstract) {
			resultPatentAbstractRepository.delete( (ResultPatentAbstract) entity);
		} else if (entity instanceof ResultPatentKeyword) {
			resultPatentKeywordRepository.delete( (ResultPatentKeyword) entity);
		} else if (entity instanceof ResultPatentVersionInfo) {
			resultPatentVersionInfoRepository.delete( (ResultPatentVersionInfo) entity);
		} else if (entity instanceof ResultProductName) {
			resultProductNameRepository.delete( (ResultProductName) entity);
		} else if (entity instanceof ResultProductKeyword) {
			resultProductKeywordRepository.delete( (ResultProductKeyword) entity);
		} else if (entity instanceof ResultProductDescription) {
			resultProductDescriptionRepository.delete( (ResultProductDescription) entity);
		} else if (entity instanceof ResultProductVersionInfo) {
			resultProductVersionInfoRepository.delete( (ResultProductVersionInfo) entity);
		} else if (entity instanceof ResultProductAlternateName) {
			resultProductAlternateNameRepository.delete( (ResultProductAlternateName) entity);
		} else if (entity instanceof ResultPublicationSubtitle) {
			resultPublicationSubtitleRepository.delete( (ResultPublicationSubtitle) entity);
		} else if (entity instanceof ResultPublicationNameAbbreviation) {
			resultPublicationNameAbbreviationRepository.delete( (ResultPublicationNameAbbreviation) entity);
		} else if (entity instanceof ResultPublicationBibliographicNote) {
			resultPublicationBibliographicNoteRepository.delete( (ResultPublicationBibliographicNote) entity);
		} else if (entity instanceof ResultPublicationVersionInfo) {
			resultPublicationVersionInfoRepository.delete( (ResultPublicationVersionInfo) entity);
		} else if (entity instanceof ServiceDescription) {
			serviceDescriptionRepository.delete( (ServiceDescription) entity);
		} else if (entity instanceof ServiceKeyword) {
			serviceKeywordRepository.delete( (ServiceKeyword) entity);
		} else if (entity instanceof ServiceName) {
			serviceNameRepository.delete( (ServiceName) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
	}
	

	@SuppressWarnings("unchecked")
	public void delete(Iterable<? extends CerifMultipleLanguageFeature> entityList) {
		
		final CerifMultipleLanguageFeature entity = (CerifMultipleLanguageFeature) entityList.iterator().next();
		
		if (entity instanceof ClassSchemeName) {
			classSchemeNameRepository.delete( (List<ClassSchemeName>) entityList);
		} else if (entity instanceof ClassSchemeDescription) {
			classSchemeDescriptionRepository.delete( (List<ClassSchemeDescription>) entityList);
		} else if (entity instanceof FacilityName) {
			facilityNameRepository.delete( (List<FacilityName>) entityList);
		} else if (entity instanceof OrganisationUnitName) {
			organisationUnitNameRepository.delete( (List<OrganisationUnitName>) entityList);
		} else if (entity instanceof ResultPublicationTitle) {
			resultPublicationTitleRepository.delete( (List<ResultPublicationTitle>) entityList);
		} else if (entity instanceof ResultPublicationAbstract) {
			resultPublicationAbstractRepository.delete( (List<ResultPublicationAbstract>) entityList);
		} else if (entity instanceof ResultPublicationKeyword) {
			resultPublicationKeywordRepository.delete( (List<ResultPublicationKeyword>) entityList);
		} else if (entity instanceof ProjectTitle) {
			projectTitleRepository.delete( (List<ProjectTitle>) entityList);
		} else if (entity instanceof ClassTerm) {
			classTermRepository.delete( (List<ClassTerm>) entityList);
		} else if (entity instanceof EventName) {
			eventNameRepository.delete( (List<EventName>) entityList);
		} else if (entity instanceof EventKeyword) {
			eventKeywordRepository.delete( (List<EventKeyword>) entityList);
		} else if (entity instanceof EventDescription) {
			eventDescriptionRepository.delete( (List<EventDescription>) entityList);
		} else if (entity instanceof CitationDescription) {
			citationDescriptionRepository.delete( (List<CitationDescription>) entityList);
		} else if (entity instanceof CitationTitle) {
			citationTitleRepository.delete( (List<CitationTitle>) entityList);
		} else if (entity instanceof ClassDefinition) {
			classDefinitionRepository.delete( (List<ClassDefinition>) entityList);
		} else if (entity instanceof ClassDescription) {
			classDescriptionRepository.delete( (List<ClassDescription>) entityList);
		} else if (entity instanceof ClassEx) {
			classExRepository.delete( (List<ClassEx>) entityList);
		} else if (entity instanceof CountryName) {
			countryNameRepository.delete( (List<CountryName>) entityList);
		} else if (entity instanceof CurrencyName) {
			currencyNameRepository.delete( (List<CurrencyName>) entityList);
		} else if (entity instanceof CurrencyEntityName) {
			currencyEntityNameRepository.delete( (List<CurrencyEntityName>) entityList);
		} else if (entity instanceof EquipmentDescription) {
			equipmentDescriptionRepository.delete( (List<EquipmentDescription>) entityList);
		} else if (entity instanceof EquipmentKeyword) {
			equipmentKeywordRepository.delete( (List<EquipmentKeyword>) entityList);
		} else if (entity instanceof EquipmentName) {
			equipmentNameRepository.delete( (List<EquipmentName>) entityList);
		} else if (entity instanceof ExpertiseAndSkillsDescription) {
			expertiseAndSkillsDescriptionRepository.delete( (List<ExpertiseAndSkillsDescription>) entityList);
		} else if (entity instanceof ExpertiseAndSkillsKeyword) {
			expertiseAndSkillsKeywordRepository.delete( (List<ExpertiseAndSkillsKeyword>) entityList);
		} else if (entity instanceof ExpertiseAndSkillsName) {
			expertiseAndSkillsNameRepository.delete( (List<ExpertiseAndSkillsName>) entityList);
		} else if (entity instanceof FacilityDescription) {
			facilityDescriptionRepository.delete( (List<FacilityDescription>) entityList);
		} else if (entity instanceof FacilityKeyword) {
			facilityKeywordRepository.delete( (List<FacilityKeyword>) entityList);
		} else if (entity instanceof FundingDescription) {
			fundingDescriptionRepository.delete( (List<FundingDescription>) entityList);
		} else if (entity instanceof FundingKeyword) {
			fundingKeywordRepository.delete( (List<FundingKeyword>) entityList);
		} else if (entity instanceof FundingName) {
			fundingNameRepository.delete( (List<FundingName>) entityList);
		} else if (entity instanceof GeographicBoundingBoxName) {
			geographicBoundingBoxNameRepository.delete( (List<GeographicBoundingBoxName>) entityList);
		} else if (entity instanceof GeographicBoundingBoxDescription) {
			geographicBoundingBoxDescriptionRepository.delete( (List<GeographicBoundingBoxDescription>) entityList);
		} else if (entity instanceof GeographicBoundingBoxKeyword) {
			geographicBoundingBoxKeywordRepository.delete( (List<GeographicBoundingBoxKeyword>) entityList);
		} else if (entity instanceof IndicatorDescription) {
			indicatorDescriptionRepository.delete( (List<IndicatorDescription>) entityList);
		} else if (entity instanceof IndicatorKeyword) {
			indicatorKeywordRepository.delete( (List<IndicatorKeyword>) entityList);
		} else if (entity instanceof IndicatorName) {
			indicatorNameRepository.delete( (List<IndicatorName>) entityList);
		} else if (entity instanceof LanguageName) {
			languageNameRepository.delete( (List<LanguageName>) entityList);
		} else if (entity instanceof MeasurementDescription) {
			measurementDescriptionRepository.delete( (List<MeasurementDescription>) entityList);
		} else if (entity instanceof MeasurementKeyword) {
			measurementKeywordRepository.delete( (List<MeasurementKeyword>) entityList);
		} else if (entity instanceof MeasurementName) {
			measurementNameRepository.delete( (List<MeasurementName>) entityList);
		} else if (entity instanceof MediumDescription) {
			mediumDescriptionRepository.delete( (List<MediumDescription>) entityList);
		} else if (entity instanceof MediumKeyword) {
			mediumKeywordRepository.delete( (List<MediumKeyword>) entityList);
		} else if (entity instanceof MediumTitle) {
			mediumTitleRepository.delete( (List<MediumTitle>) entityList);
		} else if (entity instanceof MetricsDescription) {
			metricsDescriptionRepository.delete( (List<MetricsDescription>) entityList);
		} else if (entity instanceof MetricsKeyword) {
			metricsKeywordRepository.delete( (List<MetricsKeyword>) entityList);
		} else if (entity instanceof MetricsName) {
			metricsNameRepository.delete( (List<MetricsName>) entityList);
		} else if (entity instanceof OrganisationUnitResearchActivity) {
			organisationUnitResearchActivityRepository.delete( (List<OrganisationUnitResearchActivity>) entityList);
		} else if (entity instanceof OrganisationUnitKeyword) {
			organisationUnitKeywordRepository.delete( (List<OrganisationUnitKeyword>) entityList);
		} else if (entity instanceof PersonResearchInterest) {
			personResearchInterestRepository.delete( (List<PersonResearchInterest>) entityList);
		} else if (entity instanceof PersonKeyword) {
			personKeywordRepository.delete( (List<PersonKeyword>) entityList);
		} else if (entity instanceof PrizeDescription) {
			prizeDescriptionRepository.delete( (List<PrizeDescription>) entityList);
		} else if (entity instanceof PrizeKeyword) {
			prizeKeywordRepository.delete( (List<PrizeKeyword>) entityList);
		} else if (entity instanceof PrizeName) {
			prizeNameRepository.delete( (List<PrizeName>) entityList);
		} else if (entity instanceof ProjectAbstract) {
			projectAbstractRepository.delete( (List<ProjectAbstract>) entityList);
		} else if (entity instanceof ProjectKeyword) {
			projectKeywordRepository.delete( (List<ProjectKeyword>) entityList);
		} else if (entity instanceof QualificationTitle) {
			qualificationTitleRepository.delete( (List<QualificationTitle>) entityList);
		} else if (entity instanceof QualificationDescription) {
			qualificationDescriptionRepository.delete( (List<QualificationDescription>) entityList);
		} else if (entity instanceof QualificationKeyword) {
			qualificationKeywordRepository.delete( (List<QualificationKeyword>) entityList);
		} else if (entity instanceof ResultPatentTitle) {
			resultPatentTitleRepository.delete( (List<ResultPatentTitle>) entityList);
		} else if (entity instanceof ResultPatentAbstract) {
			resultPatentAbstractRepository.delete( (List<ResultPatentAbstract>) entityList);
		} else if (entity instanceof ResultPatentKeyword) {
			resultPatentKeywordRepository.delete( (List<ResultPatentKeyword>) entityList);
		} else if (entity instanceof ResultPatentVersionInfo) {
			resultPatentVersionInfoRepository.delete( (List<ResultPatentVersionInfo>) entityList);
		} else if (entity instanceof ResultProductName) {
			resultProductNameRepository.delete( (List<ResultProductName>) entityList);
		} else if (entity instanceof ResultProductKeyword) {
			resultProductKeywordRepository.delete( (List<ResultProductKeyword>) entityList);
		} else if (entity instanceof ResultProductDescription) {
			resultProductDescriptionRepository.delete( (List<ResultProductDescription>) entityList);
		} else if (entity instanceof ResultProductVersionInfo) {
			resultProductVersionInfoRepository.delete( (List<ResultProductVersionInfo>) entityList);
		} else if (entity instanceof ResultProductAlternateName) {
			resultProductAlternateNameRepository.delete( (List<ResultProductAlternateName>) entityList);
		} else if (entity instanceof ResultPublicationSubtitle) {
			resultPublicationSubtitleRepository.delete( (List<ResultPublicationSubtitle>) entityList);
		} else if (entity instanceof ResultPublicationNameAbbreviation) {
			resultPublicationNameAbbreviationRepository.delete( (List<ResultPublicationNameAbbreviation>) entityList);
		} else if (entity instanceof ResultPublicationBibliographicNote) {
			resultPublicationBibliographicNoteRepository.delete( (List<ResultPublicationBibliographicNote>) entityList);
		} else if (entity instanceof ResultPublicationVersionInfo) {
			resultPublicationVersionInfoRepository.delete( (List<ResultPublicationVersionInfo>) entityList);
		} else if (entity instanceof ServiceDescription) {
			serviceDescriptionRepository.delete( (List<ServiceDescription>) entityList);
		} else if (entity instanceof ServiceKeyword) {
			serviceKeywordRepository.delete( (List<ServiceKeyword>) entityList);
		} else if (entity instanceof ServiceName) {
			serviceNameRepository.delete( (List<ServiceName>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
	}
	
	@Transactional
	public CerifMultipleLanguageFeature save(CerifMultipleLanguageFeature entity) {
		if (entity instanceof ClassSchemeName) {
			entity = classSchemeNameRepository.save( (ClassSchemeName) entity);
		} else if (entity instanceof ClassSchemeDescription) {
			entity = classSchemeDescriptionRepository.save( (ClassSchemeDescription) entity);
		} else if (entity instanceof FacilityName) {
			entity = facilityNameRepository.save( (FacilityName) entity);
		} else if (entity instanceof OrganisationUnitName) {
			entity = organisationUnitNameRepository.save( (OrganisationUnitName) entity);
		} else if (entity instanceof ResultPublicationTitle) {
			entity = resultPublicationTitleRepository.save((ResultPublicationTitle) entity);
		} else if (entity instanceof ResultPublicationAbstract) {
			entity = resultPublicationAbstractRepository.save((ResultPublicationAbstract) entity);
		} else if (entity instanceof ResultPublicationKeyword) {
			entity = resultPublicationKeywordRepository.save((ResultPublicationKeyword) entity);
		} else if (entity instanceof ProjectTitle) {
			entity = projectTitleRepository.save((ProjectTitle) entity);
		} else if (entity instanceof ClassTerm) {
			entity = classTermRepository.save((ClassTerm) entity);
		} else if (entity instanceof EventName) {
			entity = eventNameRepository.save((EventName) entity);
		} else if (entity instanceof EventKeyword) {
			entity = eventKeywordRepository.save((EventKeyword) entity);
		} else if (entity instanceof EventDescription) {
			entity = eventDescriptionRepository.save((EventDescription) entity);
		} else if (entity instanceof CitationDescription) {
			entity = citationDescriptionRepository.save( (CitationDescription) entity);
		} else if (entity instanceof CitationTitle) {
			entity = citationTitleRepository.save( (CitationTitle) entity);
		} else if (entity instanceof ClassDefinition) {
			entity = classDefinitionRepository.save( (ClassDefinition) entity);
		} else if (entity instanceof ClassDescription) {
			entity = classDescriptionRepository.save( (ClassDescription) entity);
		} else if (entity instanceof ClassEx) {
			entity = classExRepository.save( (ClassEx) entity);
		} else if (entity instanceof CountryName) {
			entity = countryNameRepository.save( (CountryName) entity);
		} else if (entity instanceof CurrencyName) {
			entity = currencyNameRepository.save( (CurrencyName) entity);
		} else if (entity instanceof CurrencyEntityName) {
			entity = currencyEntityNameRepository.save( (CurrencyEntityName) entity);
		} else if (entity instanceof EquipmentDescription) {
			entity = equipmentDescriptionRepository.save( (EquipmentDescription) entity);
		} else if (entity instanceof EquipmentKeyword) {
			entity = equipmentKeywordRepository.save( (EquipmentKeyword) entity);
		} else if (entity instanceof EquipmentName) {
			entity = equipmentNameRepository.save( (EquipmentName) entity);
		} else if (entity instanceof ExpertiseAndSkillsDescription) {
			entity = expertiseAndSkillsDescriptionRepository.save( (ExpertiseAndSkillsDescription) entity);
		} else if (entity instanceof ExpertiseAndSkillsKeyword) {
			entity = expertiseAndSkillsKeywordRepository.save( (ExpertiseAndSkillsKeyword) entity);
		} else if (entity instanceof ExpertiseAndSkillsName) {
			entity = expertiseAndSkillsNameRepository.save( (ExpertiseAndSkillsName) entity);
		} else if (entity instanceof FacilityDescription) {
			entity = facilityDescriptionRepository.save( (FacilityDescription) entity);
		} else if (entity instanceof FacilityKeyword) {
			entity = facilityKeywordRepository.save( (FacilityKeyword) entity);
		} else if (entity instanceof FundingDescription) {
			entity = fundingDescriptionRepository.save( (FundingDescription) entity);
		} else if (entity instanceof FundingKeyword) {
			entity = fundingKeywordRepository.save( (FundingKeyword) entity);
		} else if (entity instanceof FundingName) {
			entity = fundingNameRepository.save( (FundingName) entity);
		} else if (entity instanceof GeographicBoundingBoxName) {
			entity = geographicBoundingBoxNameRepository.save( (GeographicBoundingBoxName) entity);
		} else if (entity instanceof GeographicBoundingBoxDescription) {
			entity = geographicBoundingBoxDescriptionRepository.save( (GeographicBoundingBoxDescription) entity);
		} else if (entity instanceof GeographicBoundingBoxKeyword) {
			entity = geographicBoundingBoxKeywordRepository.save( (GeographicBoundingBoxKeyword) entity);
		} else if (entity instanceof IndicatorDescription) {
			entity = indicatorDescriptionRepository.save( (IndicatorDescription) entity);
		} else if (entity instanceof IndicatorKeyword) {
			entity = indicatorKeywordRepository.save( (IndicatorKeyword) entity);
		} else if (entity instanceof IndicatorName) {
			entity = indicatorNameRepository.save( (IndicatorName) entity);
		} else if (entity instanceof LanguageName) {
			entity = languageNameRepository.save( (LanguageName) entity);
		} else if (entity instanceof MeasurementDescription) {
			entity = measurementDescriptionRepository.save( (MeasurementDescription) entity);
		} else if (entity instanceof MeasurementKeyword) {
			entity = measurementKeywordRepository.save( (MeasurementKeyword) entity);
		} else if (entity instanceof MeasurementName) {
			entity = measurementNameRepository.save( (MeasurementName) entity);
		} else if (entity instanceof MediumDescription) {
			entity = mediumDescriptionRepository.save( (MediumDescription) entity);
		} else if (entity instanceof MediumKeyword) {
			entity = mediumKeywordRepository.save( (MediumKeyword) entity);
		} else if (entity instanceof MediumTitle) {
			entity = mediumTitleRepository.save( (MediumTitle) entity);
		} else if (entity instanceof MetricsDescription) {
			entity = metricsDescriptionRepository.save( (MetricsDescription) entity);
		} else if (entity instanceof MetricsKeyword) {
			entity = metricsKeywordRepository.save( (MetricsKeyword) entity);
		} else if (entity instanceof MetricsName) {
			entity = metricsNameRepository.save( (MetricsName) entity);
		} else if (entity instanceof OrganisationUnitResearchActivity) {
			entity = organisationUnitResearchActivityRepository.save( (OrganisationUnitResearchActivity) entity);
		} else if (entity instanceof OrganisationUnitKeyword) {
			entity = organisationUnitKeywordRepository.save( (OrganisationUnitKeyword) entity);
		} else if (entity instanceof PersonResearchInterest) {
			entity = personResearchInterestRepository.save( (PersonResearchInterest) entity);
		} else if (entity instanceof PersonKeyword) {
			entity = personKeywordRepository.save( (PersonKeyword) entity);
		} else if (entity instanceof PrizeDescription) {
			entity = prizeDescriptionRepository.save( (PrizeDescription) entity);
		} else if (entity instanceof PrizeKeyword) {
			entity = prizeKeywordRepository.save( (PrizeKeyword) entity);
		} else if (entity instanceof PrizeName) {
			entity = prizeNameRepository.save( (PrizeName) entity);
		} else if (entity instanceof ProjectAbstract) {
			entity = projectAbstractRepository.save( (ProjectAbstract) entity);
		} else if (entity instanceof ProjectKeyword) {
			entity = projectKeywordRepository.save( (ProjectKeyword) entity);
		} else if (entity instanceof QualificationTitle) {
			entity = qualificationTitleRepository.save( (QualificationTitle) entity);
		} else if (entity instanceof QualificationDescription) {
			entity = qualificationDescriptionRepository.save( (QualificationDescription) entity);
		} else if (entity instanceof QualificationKeyword) {
			entity = qualificationKeywordRepository.save( (QualificationKeyword) entity);
		} else if (entity instanceof ResultPatentTitle) {
			entity = resultPatentTitleRepository.save( (ResultPatentTitle) entity);
		} else if (entity instanceof ResultPatentAbstract) {
			entity = resultPatentAbstractRepository.save( (ResultPatentAbstract) entity);
		} else if (entity instanceof ResultPatentKeyword) {
			entity = resultPatentKeywordRepository.save( (ResultPatentKeyword) entity);
		} else if (entity instanceof ResultPatentVersionInfo) {
			entity = resultPatentVersionInfoRepository.save( (ResultPatentVersionInfo) entity);
		} else if (entity instanceof ResultProductName) {
			entity = resultProductNameRepository.save( (ResultProductName) entity);
		} else if (entity instanceof ResultProductKeyword) {
			entity = resultProductKeywordRepository.save( (ResultProductKeyword) entity);
		} else if (entity instanceof ResultProductDescription) {
			entity = resultProductDescriptionRepository.save( (ResultProductDescription) entity);
		} else if (entity instanceof ResultProductVersionInfo) {
			entity = resultProductVersionInfoRepository.save( (ResultProductVersionInfo) entity);
		} else if (entity instanceof ResultProductAlternateName) {
			entity = resultProductAlternateNameRepository.save( (ResultProductAlternateName) entity);
		} else if (entity instanceof ResultPublicationSubtitle) {
			entity = resultPublicationSubtitleRepository.save( (ResultPublicationSubtitle) entity);
		} else if (entity instanceof ResultPublicationNameAbbreviation) {
			entity = resultPublicationNameAbbreviationRepository.save( (ResultPublicationNameAbbreviation) entity);
		} else if (entity instanceof ResultPublicationBibliographicNote) {
			entity = resultPublicationBibliographicNoteRepository.save( (ResultPublicationBibliographicNote) entity);
		} else if (entity instanceof ResultPublicationVersionInfo) {
			entity = resultPublicationVersionInfoRepository.save( (ResultPublicationVersionInfo) entity);
		} else if (entity instanceof ServiceDescription) {
			entity = serviceDescriptionRepository.save( (ServiceDescription) entity);
		} else if (entity instanceof ServiceKeyword) {
			entity = serviceKeywordRepository.save( (ServiceKeyword) entity);
		} else if (entity instanceof ServiceName) {
			entity = serviceNameRepository.save( (ServiceName) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<? extends CerifMultipleLanguageFeature> save(Iterable<? extends CerifMultipleLanguageFeature> entityList) {
		
		final CerifMultipleLanguageFeature entity = (CerifMultipleLanguageFeature) entityList.iterator().next();
		
		if (entity instanceof ClassSchemeName) {
			entityList = classSchemeNameRepository.save( (List<ClassSchemeName>) entityList);
		} else if (entity instanceof ClassSchemeDescription) {
			entityList = classSchemeDescriptionRepository.save( (List<ClassSchemeDescription>) entityList);
		} else if (entity instanceof FacilityName) {
			entityList = facilityNameRepository.save( (List<FacilityName>) entityList);
		} else if (entity instanceof OrganisationUnitName) {
			entityList = organisationUnitNameRepository.save( (List<OrganisationUnitName>) entityList);
		} else if (entity instanceof ResultPublicationTitle) {
			entityList = resultPublicationTitleRepository.save( (List<ResultPublicationTitle>) entityList);
		} else if (entity instanceof ResultPublicationAbstract) {
			entityList = resultPublicationAbstractRepository.save( (List<ResultPublicationAbstract>) entityList);
		} else if (entity instanceof ResultPublicationKeyword) {
			entityList = resultPublicationKeywordRepository.save( (List<ResultPublicationKeyword>) entityList);
		} else if (entity instanceof ProjectTitle) {
			entityList = projectTitleRepository.save( (List<ProjectTitle>) entityList);
		} else if (entity instanceof ClassTerm) {
			entityList = classTermRepository.save( (List<ClassTerm>) entityList);
		} else if (entity instanceof EventName) {
			entityList = eventNameRepository.save( (List<EventName>) entityList);
		} else if (entity instanceof EventKeyword) {
			entityList = eventKeywordRepository.save( (List<EventKeyword>) entityList);
		} else if (entity instanceof EventDescription) {
			entityList = eventDescriptionRepository.save( (List<EventDescription>) entityList);
		} else if (entity instanceof CitationDescription) {
			entityList = citationDescriptionRepository.save( (List<CitationDescription>) entityList);
		} else if (entity instanceof CitationTitle) {
			entityList = citationTitleRepository.save( (List<CitationTitle>) entityList);
		} else if (entity instanceof ClassDefinition) {
			entityList = classDefinitionRepository.save( (List<ClassDefinition>) entityList);
		} else if (entity instanceof ClassDescription) {
			entityList = classDescriptionRepository.save( (List<ClassDescription>) entityList);
		} else if (entity instanceof ClassEx) {
			entityList = classExRepository.save( (List<ClassEx>) entityList);
		} else if (entity instanceof CountryName) {
			entityList = countryNameRepository.save( (List<CountryName>) entityList);
		} else if (entity instanceof CurrencyName) {
			entityList = currencyNameRepository.save( (List<CurrencyName>) entityList);
		} else if (entity instanceof CurrencyEntityName) {
			entityList = currencyEntityNameRepository.save( (List<CurrencyEntityName>) entityList);
		} else if (entity instanceof EquipmentDescription) {
			entityList = equipmentDescriptionRepository.save( (List<EquipmentDescription>) entityList);
		} else if (entity instanceof EquipmentKeyword) {
			entityList = equipmentKeywordRepository.save( (List<EquipmentKeyword>) entityList);
		} else if (entity instanceof EquipmentName) {
			entityList = equipmentNameRepository.save( (List<EquipmentName>) entityList);
		} else if (entity instanceof ExpertiseAndSkillsDescription) {
			entityList = expertiseAndSkillsDescriptionRepository.save( (List<ExpertiseAndSkillsDescription>) entityList);
		} else if (entity instanceof ExpertiseAndSkillsKeyword) {
			entityList = expertiseAndSkillsKeywordRepository.save( (List<ExpertiseAndSkillsKeyword>) entityList);
		} else if (entity instanceof ExpertiseAndSkillsName) {
			entityList = expertiseAndSkillsNameRepository.save( (List<ExpertiseAndSkillsName>) entityList);
		} else if (entity instanceof FacilityDescription) {
			entityList = facilityDescriptionRepository.save( (List<FacilityDescription>) entityList);
		} else if (entity instanceof FacilityKeyword) {
			entityList = facilityKeywordRepository.save( (List<FacilityKeyword>) entityList);
		} else if (entity instanceof FundingDescription) {
			entityList = fundingDescriptionRepository.save( (List<FundingDescription>) entityList);
		} else if (entity instanceof FundingKeyword) {
			entityList = fundingKeywordRepository.save( (List<FundingKeyword>) entityList);
		} else if (entity instanceof FundingName) {
			entityList = fundingNameRepository.save( (List<FundingName>) entityList);
		} else if (entity instanceof GeographicBoundingBoxName) {
			entityList = geographicBoundingBoxNameRepository.save( (List<GeographicBoundingBoxName>) entityList);
		} else if (entity instanceof GeographicBoundingBoxDescription) {
			entityList = geographicBoundingBoxDescriptionRepository.save( (List<GeographicBoundingBoxDescription>) entityList);
		} else if (entity instanceof GeographicBoundingBoxKeyword) {
			entityList = geographicBoundingBoxKeywordRepository.save( (List<GeographicBoundingBoxKeyword>) entityList);
		} else if (entity instanceof IndicatorDescription) {
			entityList = indicatorDescriptionRepository.save( (List<IndicatorDescription>) entityList);
		} else if (entity instanceof IndicatorKeyword) {
			entityList = indicatorKeywordRepository.save( (List<IndicatorKeyword>) entityList);
		} else if (entity instanceof IndicatorName) {
			entityList = indicatorNameRepository.save( (List<IndicatorName>) entityList);
		} else if (entity instanceof LanguageName) {
			entityList = languageNameRepository.save( (List<LanguageName>) entityList);
		} else if (entity instanceof MeasurementDescription) {
			entityList = measurementDescriptionRepository.save( (List<MeasurementDescription>) entityList);
		} else if (entity instanceof MeasurementKeyword) {
			entityList = measurementKeywordRepository.save( (List<MeasurementKeyword>) entityList);
		} else if (entity instanceof MeasurementName) {
			entityList = measurementNameRepository.save( (List<MeasurementName>) entityList);
		} else if (entity instanceof MediumDescription) {
			entityList = mediumDescriptionRepository.save( (List<MediumDescription>) entityList);
		} else if (entity instanceof MediumKeyword) {
			entityList = mediumKeywordRepository.save( (List<MediumKeyword>) entityList);
		} else if (entity instanceof MediumTitle) {
			entityList = mediumTitleRepository.save( (List<MediumTitle>) entityList);
		} else if (entity instanceof MetricsDescription) {
			entityList = metricsDescriptionRepository.save( (List<MetricsDescription>) entityList);
		} else if (entity instanceof MetricsKeyword) {
			entityList = metricsKeywordRepository.save( (List<MetricsKeyword>) entityList);
		} else if (entity instanceof MetricsName) {
			entityList = metricsNameRepository.save( (List<MetricsName>) entityList);
		} else if (entity instanceof OrganisationUnitResearchActivity) {
			entityList = organisationUnitResearchActivityRepository.save( (List<OrganisationUnitResearchActivity>) entityList);
		} else if (entity instanceof OrganisationUnitKeyword) {
			entityList = organisationUnitKeywordRepository.save( (List<OrganisationUnitKeyword>) entityList);
		} else if (entity instanceof PersonResearchInterest) {
			entityList = personResearchInterestRepository.save( (List<PersonResearchInterest>) entityList);
		} else if (entity instanceof PersonKeyword) {
			entityList = personKeywordRepository.save( (List<PersonKeyword>) entityList);
		} else if (entity instanceof PrizeDescription) {
			entityList = prizeDescriptionRepository.save( (List<PrizeDescription>) entityList);
		} else if (entity instanceof PrizeKeyword) {
			entityList = prizeKeywordRepository.save( (List<PrizeKeyword>) entityList);
		} else if (entity instanceof PrizeName) {
			entityList = prizeNameRepository.save( (List<PrizeName>) entityList);
		} else if (entity instanceof ProjectAbstract) {
			entityList = projectAbstractRepository.save( (List<ProjectAbstract>) entityList);
		} else if (entity instanceof ProjectKeyword) {
			entityList = projectKeywordRepository.save( (List<ProjectKeyword>) entityList);
		} else if (entity instanceof QualificationTitle) {
			entityList = qualificationTitleRepository.save( (List<QualificationTitle>) entityList);
		} else if (entity instanceof QualificationDescription) {
			entityList = qualificationDescriptionRepository.save( (List<QualificationDescription>) entityList);
		} else if (entity instanceof QualificationKeyword) {
			entityList = qualificationKeywordRepository.save( (List<QualificationKeyword>) entityList);
		} else if (entity instanceof ResultPatentTitle) {
			entityList = resultPatentTitleRepository.save( (List<ResultPatentTitle>) entityList);
		} else if (entity instanceof ResultPatentAbstract) {
			entityList = resultPatentAbstractRepository.save( (List<ResultPatentAbstract>) entityList);
		} else if (entity instanceof ResultPatentKeyword) {
			entityList = resultPatentKeywordRepository.save( (List<ResultPatentKeyword>) entityList);
		} else if (entity instanceof ResultPatentVersionInfo) {
			entityList = resultPatentVersionInfoRepository.save( (List<ResultPatentVersionInfo>) entityList);
		} else if (entity instanceof ResultProductName) {
			entityList = resultProductNameRepository.save( (List<ResultProductName>) entityList);
		} else if (entity instanceof ResultProductKeyword) {
			entityList = resultProductKeywordRepository.save( (List<ResultProductKeyword>) entityList);
		} else if (entity instanceof ResultProductDescription) {
			entityList = resultProductDescriptionRepository.save( (List<ResultProductDescription>) entityList);
		} else if (entity instanceof ResultProductVersionInfo) {
			entityList = resultProductVersionInfoRepository.save( (List<ResultProductVersionInfo>) entityList);
		} else if (entity instanceof ResultProductAlternateName) {
			entityList = resultProductAlternateNameRepository.save( (List<ResultProductAlternateName>) entityList);
		} else if (entity instanceof ResultPublicationSubtitle) {
			entityList = resultPublicationSubtitleRepository.save( (List<ResultPublicationSubtitle>) entityList);
		} else if (entity instanceof ResultPublicationNameAbbreviation) {
			entityList = resultPublicationNameAbbreviationRepository.save( (List<ResultPublicationNameAbbreviation>) entityList);
		} else if (entity instanceof ResultPublicationBibliographicNote) {
			entityList = resultPublicationBibliographicNoteRepository.save( (List<ResultPublicationBibliographicNote>) entityList);
		} else if (entity instanceof ResultPublicationVersionInfo) {
			entityList = resultPublicationVersionInfoRepository.save( (List<ResultPublicationVersionInfo>) entityList);
		} else if (entity instanceof ServiceDescription) {
			entityList = serviceDescriptionRepository.save( (List<ServiceDescription>) entityList);
		} else if (entity instanceof ServiceKeyword) {
			entityList = serviceKeywordRepository.save( (List<ServiceKeyword>) entityList);
		} else if (entity instanceof ServiceName) {
			entityList = serviceNameRepository.save( (List<ServiceName>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entityList provided. %s", entityList));
		}
		return entityList;
		
	}


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
