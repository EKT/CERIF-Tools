/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.multilingual.CitationTranslation;
import gr.ekt.cerif.features.multilingual.ClassSchemeTranslation;
import gr.ekt.cerif.features.multilingual.ClassTranslation;
import gr.ekt.cerif.features.multilingual.CountryTranslation;
import gr.ekt.cerif.features.multilingual.CurrencyTranslation;
import gr.ekt.cerif.features.multilingual.EquipmentTranslation;
import gr.ekt.cerif.features.multilingual.EventTranslation;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsTranslation;
import gr.ekt.cerif.features.multilingual.FacilityTranslation;
import gr.ekt.cerif.features.multilingual.FundingTranslation;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxTranslation;
import gr.ekt.cerif.features.multilingual.IndicatorTranslation;
import gr.ekt.cerif.features.multilingual.LanguageTranslation;
import gr.ekt.cerif.features.multilingual.MeasurementTranslation;
import gr.ekt.cerif.features.multilingual.MediumTranslation;
import gr.ekt.cerif.features.multilingual.MetricsTranslation;
import gr.ekt.cerif.features.multilingual.OrganisationUnitTranslation;
import gr.ekt.cerif.features.multilingual.PersonTranslation;
import gr.ekt.cerif.features.multilingual.PrizeTranslation;
import gr.ekt.cerif.features.multilingual.ProjectTranslation;
import gr.ekt.cerif.features.multilingual.QualificationTranslation;
import gr.ekt.cerif.features.multilingual.ResultPatentTranslation;
import gr.ekt.cerif.features.multilingual.ResultProductTranslation;
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
	ClassSchemeTranslationRepository classSchemeTranslationRepository;
	
	@Autowired
	ClassTranslationRepository classTranslationRepository;
	
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
	ResultPublicationTranslationRepository resultPublicationTranslationRepository;
	
	@Autowired
	ServiceTranslationRepository serviceTranslationRepository;	
	
	@Transactional
	public void save(CerifMultipleLanguageFeature entity) {
		if (entity instanceof CitationTranslation) {
			citationTranslationRepository.save( (CitationTranslation) entity);
		} else if (entity instanceof ClassSchemeTranslation) {
			classSchemeTranslationRepository.save( (ClassSchemeTranslation) entity);
		} else if (entity instanceof ClassTranslation) {
			classTranslationRepository.save( (ClassTranslation) entity);
		} else if (entity instanceof CountryTranslation) {
			countryTranslationRepository.save( (CountryTranslation) entity);
		} else if (entity instanceof CurrencyTranslation) {
			currencyTranslationRepository.save( (CurrencyTranslation) entity);
		} else if (entity instanceof EquipmentTranslation) {
			equipmentTranslationRepository.save( (EquipmentTranslation) entity);
		} else if (entity instanceof EventTranslation) {
			eventTranslationRepository.save( (EventTranslation) entity);
		} else if (entity instanceof ExpertiseAndSkillsTranslation) {
			expertiseAndSkillsTranslationRepository.save( (ExpertiseAndSkillsTranslation) entity);
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
			organisationUnitTranslationRepository.save( (OrganisationUnitTranslation) entity);
		} else if (entity instanceof PersonTranslation) {
			personTranslationRepository.save((PersonTranslation) entity);
		} else if (entity instanceof PrizeTranslation) {
			prizeTranslationRepository.save((PrizeTranslation) entity);
		} else if (entity instanceof ProjectTranslation) {
			projectTranslationRepository.save((ProjectTranslation) entity);
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
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
	}
}
