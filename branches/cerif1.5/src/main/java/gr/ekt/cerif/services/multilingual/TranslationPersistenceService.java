/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.multilingual.CitationTranslation;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTranslation;
import gr.ekt.cerif.features.multilingual.CountryName;
import gr.ekt.cerif.features.multilingual.CountryTranslation;
import gr.ekt.cerif.features.multilingual.CurrencyTranslation;
import gr.ekt.cerif.features.multilingual.EquipmentTranslation;
import gr.ekt.cerif.features.multilingual.EventTranslation;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsTranslation;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FacilityTranslation;
import gr.ekt.cerif.features.multilingual.FundingTranslation;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxTranslation;
import gr.ekt.cerif.features.multilingual.IndicatorTranslation;
import gr.ekt.cerif.features.multilingual.LanguageTranslation;
import gr.ekt.cerif.features.multilingual.MeasurementTranslation;
import gr.ekt.cerif.features.multilingual.MediumTranslation;
import gr.ekt.cerif.features.multilingual.MetricsTranslation;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitTranslation;
import gr.ekt.cerif.features.multilingual.PersonTranslation;
import gr.ekt.cerif.features.multilingual.PrizeTranslation;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.ProjectTranslation;
import gr.ekt.cerif.features.multilingual.QualificationTranslation;
import gr.ekt.cerif.features.multilingual.ResultPatentTranslation;
import gr.ekt.cerif.features.multilingual.ResultProductTranslation;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTranslation;
import gr.ekt.cerif.features.multilingual.ServiceTranslation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Persistence service for CERIF Multiple Language Feature Entities.
 * 
 */
@Component
public class TranslationPersistenceService {

	@Autowired
	CitationTranslationRepository citationTranslationRepository;
	
	@Autowired
	ClassSchemeNameRepository classSchemeNameRepository;
	
	@Autowired
	ClassSchemeNameService classSchemeNameService;
	
	@Autowired
	ClassSchemeDescriptionRepository classSchemeDescriptionRepository;
	
	@Autowired
	ClassTranslationRepository classTranslationRepository;
	
	@Autowired
	ClassTermRepository classTermRepository;
	
	@Autowired
	CountryTranslationRepository countryTranslationRepository;
	
	@Autowired
	CurrencyTranslationRepository currencyTranslationRepository;
	
	@Autowired
	EquipmentTranslationRepository equipmentTranslationRepository;
	
	@Autowired
	EventTranslationRepository eventTranslationRepository;
	
	@Autowired
	ExpertiseAndSkillsTranslationRepository expertiseAndSkillsTranslationRepository;
	
	@Autowired
	FacilityTranslationRepository facilityTranslationRepository;
	
	@Autowired
	FacilityNameService facilityNameService;
	
	@Autowired
	FundingTranslationRepository fundingTranslationRepository;
	
	@Autowired
	GeographicBoundingBoxTranslationRepository geographicBoundingBoxTranslationRepository;
	
	@Autowired
	IndicatorTranslationRepository indicatorTranslationRepository;
	
	@Autowired
	LanguageTranslationRepository languageTranslationRepository;
	
	@Autowired
	MeasurementTranslationRepository measurementTranslationRepository;
	
	@Autowired
	MediumTranslationRepository mediumTranslationRepository;
	
	@Autowired
	MetricsTranslationRepository metricsTranslationRepository;
	
	@Autowired
	OrganisationUnitTranslationRepository organisationUnitTranslationRepository;
	
	@Autowired
	PersonTranslationRepository personTranslationRepository;
	
	@Autowired
	PrizeTranslationRepository prizeTranslationRepository;
	
	@Autowired
	ProjectTranslationRepository projectTranslationRepository;
	
	@Autowired
	QualificationTranslationRepository qualificationTranslationRepository;	

	@Autowired
	ResultPatentTranslationRepository resultPatentTranslationRepository;

	@Autowired
	ResultProductTranslationRepository resultProductTranslationRepository;
	
	@Autowired
	ResultPublicationTitleRepository resultPublicationTitleRepository;
	
	@Autowired
	ResultPublicationAbstractRepository resultPublicationAbstractRepository;
	
	@Autowired
	ResultPublicationKeywordRepository resultPublicationKeywordRepository;

	@Autowired
	ResultPublicationTranslationRepository resultPublicationTranslationRepository;
	
	@Autowired
	ServiceTranslationRepository serviceTranslationRepository;	
	
	@Transactional
	public void delete(CerifMultipleLanguageFeature entity) {
		if (entity instanceof CitationTranslation) {
			citationTranslationRepository.save( (CitationTranslation) entity);
		} else if (entity instanceof ClassSchemeName) {
			classSchemeNameService.save( (ClassSchemeName) entity);
		} else if (entity instanceof ClassSchemeDescription) {
			classSchemeDescriptionRepository.save( (ClassSchemeDescription) entity);
		} else if (entity instanceof ClassTranslation) {
			classTranslationRepository.save( (ClassTranslation) entity);
		} else if (entity instanceof CountryTranslation) {
			countryTranslationRepository.delete( (CountryName) entity);
		} else if (entity instanceof CurrencyTranslation) {
			currencyTranslationRepository.save( (CurrencyTranslation) entity);
		} else if (entity instanceof EquipmentTranslation) {
			equipmentTranslationRepository.save( (EquipmentTranslation) entity);
		} else if (entity instanceof EventTranslation) {
			eventTranslationRepository.save( (EventTranslation) entity);
		} else if (entity instanceof ExpertiseAndSkillsTranslation) {
			expertiseAndSkillsTranslationRepository.save( (ExpertiseAndSkillsTranslation) entity);
		} else if (entity instanceof FacilityName) {
			facilityNameService.save( (FacilityName) entity);
		} else if (entity instanceof FacilityTranslation) {
			facilityTranslationRepository.save( (FacilityTranslation) entity);
		} else if (entity instanceof FundingTranslation) {
			fundingTranslationRepository.save( (FundingTranslation) entity);
		} else if (entity instanceof GeographicBoundingBoxTranslation) {
			geographicBoundingBoxTranslationRepository.save( (GeographicBoundingBoxTranslation) entity);
		} else if (entity instanceof IndicatorTranslation) {
			indicatorTranslationRepository.save( (IndicatorTranslation) entity);
		} else if (entity instanceof LanguageTranslation) {
			languageTranslationRepository.save( (LanguageTranslation) entity);
		} else if (entity instanceof MeasurementTranslation) {
			measurementTranslationRepository.save( (MeasurementTranslation) entity);
		} else if (entity instanceof MediumTranslation) {
			mediumTranslationRepository.save( (MediumTranslation) entity);
		} else if (entity instanceof MetricsTranslation) {
			metricsTranslationRepository.save( (MetricsTranslation) entity);
		} else if (entity instanceof OrganisationUnitTranslation) {
			organisationUnitTranslationRepository.delete( (OrganisationUnitName) entity);
		} else if (entity instanceof PersonTranslation) {
			personTranslationRepository.delete((PersonName) entity);
			 System.out.println("Deleting!!!!!!!");
		} else if (entity instanceof PrizeTranslation) {
			prizeTranslationRepository.save((PrizeTranslation) entity);
		} else if (entity instanceof ProjectTranslation) {
			projectTranslationRepository.save((ProjectTitle) entity);
		} else if (entity instanceof QualificationTranslation) {
			qualificationTranslationRepository.save((QualificationTranslation) entity);
		} else if (entity instanceof ResultPatentTranslation) {
			resultPatentTranslationRepository.save( (ResultPatentTranslation) entity);
		} else if (entity instanceof ResultProductTranslation) {
			resultProductTranslationRepository.save((ResultProductTranslation) entity);
		} else if (entity instanceof ResultPublicationTranslation) {
			resultPublicationTranslationRepository.save((ResultPublicationTranslation) entity);
		} else if (entity instanceof ServiceTranslation) {
			serviceTranslationRepository.save((ServiceTranslation) entity);
		} else if (entity instanceof ResultPublicationTitle) {
			resultPublicationTitleRepository.delete((ResultPublicationTitle) entity);
		} else if (entity instanceof ResultPublicationAbstract) {
			resultPublicationAbstractRepository.delete((ResultPublicationAbstract) entity);
		} else if (entity instanceof ResultPublicationKeyword) {
			resultPublicationKeywordRepository.delete((ResultPublicationKeyword) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
	}
	
	@Transactional
	public void save(CerifMultipleLanguageFeature entity) {
		if (entity instanceof CitationTranslation) {
			citationTranslationRepository.save( (CitationTranslation) entity);
		} else if (entity instanceof ClassSchemeName) {
			classSchemeNameService.save( (ClassSchemeName) entity);
		} else if (entity instanceof ClassSchemeDescription) {
			classSchemeDescriptionRepository.save( (ClassSchemeDescription) entity);
		} else if (entity instanceof ClassTranslation) {
			classTranslationRepository.save( (ClassTranslation) entity);
		} else if (entity instanceof CountryTranslation) {
			countryTranslationRepository.save( (CountryName) entity);
		} else if (entity instanceof CurrencyTranslation) {
			currencyTranslationRepository.save( (CurrencyTranslation) entity);
		} else if (entity instanceof EquipmentTranslation) {
			equipmentTranslationRepository.save( (EquipmentTranslation) entity);
		} else if (entity instanceof EventTranslation) {
			eventTranslationRepository.save( (EventTranslation) entity);
		} else if (entity instanceof ExpertiseAndSkillsTranslation) {
			expertiseAndSkillsTranslationRepository.save( (ExpertiseAndSkillsTranslation) entity);
		} else if (entity instanceof FacilityName) {
			facilityNameService.save( (FacilityName) entity);
		} else if (entity instanceof FacilityTranslation) {
			facilityTranslationRepository.save( (FacilityTranslation) entity);
		} else if (entity instanceof FundingTranslation) {
			fundingTranslationRepository.save( (FundingTranslation) entity);
		} else if (entity instanceof GeographicBoundingBoxTranslation) {
			geographicBoundingBoxTranslationRepository.save( (GeographicBoundingBoxTranslation) entity);
		} else if (entity instanceof IndicatorTranslation) {
			indicatorTranslationRepository.save( (IndicatorTranslation) entity);
		} else if (entity instanceof LanguageTranslation) {
			languageTranslationRepository.save( (LanguageTranslation) entity);
		} else if (entity instanceof MeasurementTranslation) {
			measurementTranslationRepository.save( (MeasurementTranslation) entity);
		} else if (entity instanceof MediumTranslation) {
			mediumTranslationRepository.save( (MediumTranslation) entity);
		} else if (entity instanceof MetricsTranslation) {
			metricsTranslationRepository.save( (MetricsTranslation) entity);
		} else if (entity instanceof OrganisationUnitTranslation) {
			organisationUnitTranslationRepository.save( (OrganisationUnitName) entity);
		} else if (entity instanceof PersonTranslation) {
			personTranslationRepository.save((PersonName) entity);
		} else if (entity instanceof PrizeTranslation) {
			prizeTranslationRepository.save((PrizeTranslation) entity);
		} else if (entity instanceof ProjectTranslation) {
			projectTranslationRepository.save((ProjectTitle) entity);
		} else if (entity instanceof QualificationTranslation) {
			qualificationTranslationRepository.save((QualificationTranslation) entity);
		} else if (entity instanceof ResultPatentTranslation) {
			resultPatentTranslationRepository.save( (ResultPatentTranslation) entity);
		} else if (entity instanceof ResultProductTranslation) {
			resultProductTranslationRepository.save((ResultProductTranslation) entity);
		} else if (entity instanceof ResultPublicationTranslation) {
			resultPublicationTranslationRepository.save((ResultPublicationTranslation) entity);
		} else if (entity instanceof ServiceTranslation) {
			serviceTranslationRepository.save((ServiceTranslation) entity);
		} else if (entity instanceof ResultPublicationTitle) {
			resultPublicationTitleRepository.save((ResultPublicationTitle) entity);
		} else if (entity instanceof ResultPublicationAbstract) {
			resultPublicationAbstractRepository.save((ResultPublicationAbstract) entity);
		} else if (entity instanceof ResultPublicationKeyword) {
			resultPublicationKeywordRepository.save((ResultPublicationKeyword) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
	}

	public OrganisationUnitTranslationRepository getOrganisationUnitTranslationRepository(){
		return organisationUnitTranslationRepository;
	}
	
	public CountryTranslationRepository getCountryTranslationRepository(){
		return countryTranslationRepository;
	}
	
	/**
	 * @return the classSchemeNameRepository
	 */
	public ClassSchemeNameRepository getClassSchemeNameRepository() {
		return classSchemeNameRepository;
	}

	/**
	 * @return the ProjectTranslationRepository
	 */
	public ProjectTranslationRepository getProjectTranslationRepository() {
		return projectTranslationRepository;
	}
	
	/**
	 * @return the classSchemeDescriptionRepository
	 */
	public ClassSchemeDescriptionRepository getClassSchemeDescriptionRepository() {
		return classSchemeDescriptionRepository;
	}

	/**
	 * @return the classSchemeNameService
	 */
	public ClassSchemeNameService getClassSchemeNameService() {
		return classSchemeNameService;
	}

	/**
	 * @return the facilityNameService
	 */
	public FacilityNameService getFacilityNameService() {
		return facilityNameService;
	}

	public ClassTermRepository getClassTermRepository() {
		return classTermRepository;
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
}
