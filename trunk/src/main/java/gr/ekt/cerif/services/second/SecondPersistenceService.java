/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.entities.second.CerifSecondLevelEntity;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Qualification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF 2nd Level Entities.
 * 
 */
@Component
public class SecondPersistenceService {
	
	/**
	 * The citation repository.
	 */
	@Autowired
	private CitationRepository citationRepository;
	
	/**
	 * The country repository.
	 */
	@Autowired
	private CountryRepository countryRepository;
	
	/**
	 * The currency repository.
	 */
	@Autowired
	private CurrencyRepository currencyRepository;
	
	/**
	 * The cv repository.
	 */
	@Autowired
	private CVRepository cvRepository;
	
	/**
	 * The electronic address repository.
	 */
	@Autowired
	private ElectronicAddressRepository electronicRepository;
	
	/**
	 * The event repository.
	 */
	@Autowired
	private EventRepository eventRepository;
	
	/**
	 * The expertise and skills repository.
	 */
	@Autowired
	private ExpertiseAndSkillsRepository expertiseAndSkillsRepository;
	
	
	/**
	 * The federated identifier repository.
	 */
	@Autowired
	private FederatedIdentifierRepository federatedIdentifierRepository;
	
	/**
	 * The funding repository.
	 */
	@Autowired
	private FundingRepository fundingRepository;
	
	/**
	 * The geographic bounding box repository.
	 */
	@Autowired
	private GeographicBoundingBoxRepository geographicBoundingBoxRepository;
	
	/**
	 * The indicator repository.
	 */
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	/**
	 * The language repository.
	 */
	@Autowired
	private LanguageRepository languageRepository;
	
	/**
	 * The measurement repository.
	 */
	@Autowired
	private MeasurementRepository measurementRepository;
	
	/**
	 * The medium repository.
	 */
	@Autowired
	private MediumRepository mediumRepository;
	
	/**
	 * The metrics repository.
	 */
	@Autowired
	private MetricsRepository metricsRepository;
	
	/**
	 * The postal address repository.
	 */
	@Autowired
	private PostalAddressRepository postalRepository;
	
	/**
	 * The prize repository.
	 */
	@Autowired
	private PrizeRepository prizeRepository;
	
	/**
	 * The qualification repository.
	 */
	@Autowired
	private QualificationRepository qualificationRepository;	
	
	/**
	 * Delete the provided 2nd level entity.
	 * @param entity The 2nd level entity.
	 */
	public void delete(CerifSecondLevelEntity entity) {
		if (entity instanceof Citation) {
			citationRepository.delete((Citation)entity);
		} else if (entity instanceof Country) {
			System.out.println("COUNTRY");
			countryRepository.delete((Country)entity);
		} else if (entity instanceof Currency) {
			currencyRepository.delete((Currency)entity);
		} else if (entity instanceof CV) {
			cvRepository.delete((CV)entity);
		} else if (entity instanceof ElectronicAddress) {
			electronicRepository.delete((ElectronicAddress)entity);
		} else if (entity instanceof Event) {
			eventRepository.delete((Event)entity);
		} else if (entity instanceof ExpertiseAndSkills) {
			expertiseAndSkillsRepository.delete((ExpertiseAndSkills)entity);
		} else if (entity instanceof FederatedIdentifier) {
			federatedIdentifierRepository.delete((FederatedIdentifier)entity);
		} else if (entity instanceof Funding) {
			fundingRepository.delete((Funding)entity);
		} else if (entity instanceof GeographicBoundingBox) {
			geographicBoundingBoxRepository.delete((GeographicBoundingBox)entity);
		} else if (entity instanceof Indicator) {
			indicatorRepository.delete((Indicator)entity);
		} else if (entity instanceof Language) {
			languageRepository.delete((Language)entity);
		} else if (entity instanceof Measurement) {
			measurementRepository.delete((Measurement)entity);
		} else if (entity instanceof Medium) {
			mediumRepository.delete((Medium)entity);
		} else if (entity instanceof Metrics) {
			metricsRepository.delete((Metrics)entity);
		} else if (entity instanceof PostalAddress) {
			postalRepository.delete((PostalAddress)entity);
		} else if (entity instanceof Prize) {
			prizeRepository.delete((Prize)entity);
		} else if (entity instanceof Qualification) {
			qualificationRepository.delete((Qualification)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid 2nd level entity provided. %s", entity));
		}
	}
	
	/**
	 * Saves the provided 2nd level entity.
	 * @param entity The 2nd level entity.
	 */
	public CerifSecondLevelEntity save(CerifSecondLevelEntity entity) {
		if (entity instanceof Citation) {
			entity = citationRepository.save((Citation)entity);
		} else if (entity instanceof Country) {
			entity = countryRepository.save((Country)entity);
		} else if (entity instanceof Currency) {
			entity = currencyRepository.save((Currency)entity);
		} else if (entity instanceof CV) {
			entity = cvRepository.save((CV)entity);
		} else if (entity instanceof ElectronicAddress) {
			entity = electronicRepository.save((ElectronicAddress)entity);
		} else if (entity instanceof Event) {
			entity = eventRepository.save((Event)entity);
		} else if (entity instanceof ExpertiseAndSkills) {
			entity = expertiseAndSkillsRepository.save((ExpertiseAndSkills)entity);
		} else if (entity instanceof FederatedIdentifier) {
			entity = federatedIdentifierRepository.save((FederatedIdentifier)entity);
		} else if (entity instanceof Funding) {
			entity = fundingRepository.save((Funding)entity);
		} else if (entity instanceof GeographicBoundingBox) {
			entity = geographicBoundingBoxRepository.save((GeographicBoundingBox)entity);
		} else if (entity instanceof Indicator) {
			entity = indicatorRepository.save((Indicator)entity);
		} else if (entity instanceof Language) {
			entity = languageRepository.save((Language)entity);
		} else if (entity instanceof Measurement) {
			entity = measurementRepository.save((Measurement)entity);
		} else if (entity instanceof Medium) {
			entity = mediumRepository.save((Medium)entity);
		} else if (entity instanceof Metrics) {
			entity = metricsRepository.save((Metrics)entity);
		} else if (entity instanceof PostalAddress) {
			entity = postalRepository.save((PostalAddress)entity);
		} else if (entity instanceof Prize) {
			entity = prizeRepository.save((Prize)entity);
		} else if (entity instanceof Qualification) {
			entity = qualificationRepository.save((Qualification)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid 2nd level entity provided. %s", entity));
		}
		return entity;
	}

	/**
	 * Saves the provided 2nd level entities.
	 * @param entity The 2nd level entities.
	 */
	@SuppressWarnings("unchecked")
	public Iterable<? extends CerifSecondLevelEntity> save(Iterable<? extends CerifSecondLevelEntity> entityList) {
		
		final CerifSecondLevelEntity entity = (CerifSecondLevelEntity) entityList.iterator().next();
		
		if (entity instanceof Citation) {
			entityList = citationRepository.save((Iterable<Citation>)entityList);
		} else if (entity instanceof Country) {
			entityList = countryRepository.save((List<Country>)entityList);
		} else if (entity instanceof Currency) {
			entityList = currencyRepository.save((List<Currency>)entityList);
		} else if (entity instanceof CV) {
			entityList = cvRepository.save((List<CV>)entityList);
		} else if (entity instanceof ElectronicAddress) {
			entityList = electronicRepository.save((List<ElectronicAddress>)entityList);
		} else if (entity instanceof Event) {
			entityList = eventRepository.save((List<Event>)entityList);
		} else if (entity instanceof ExpertiseAndSkills) {
			entityList = expertiseAndSkillsRepository.save((List<ExpertiseAndSkills>)entityList);
		} else if (entity instanceof FederatedIdentifier) {
			entityList = federatedIdentifierRepository.save((List<FederatedIdentifier>)entityList);
		} else if (entity instanceof Funding) {
			entityList = fundingRepository.save((List<Funding>)entityList);
		} else if (entity instanceof GeographicBoundingBox) {
			entityList = geographicBoundingBoxRepository.save((List<GeographicBoundingBox>)entityList);
		} else if (entity instanceof Indicator) {
			entityList = indicatorRepository.save((List<Indicator>)entityList);
		} else if (entity instanceof Language) {
			entityList = languageRepository.save((List<Language>)entityList);
		} else if (entity instanceof Measurement) {
			entityList = measurementRepository.save((List<Measurement>)entityList);
		} else if (entity instanceof Medium) {
			entityList = mediumRepository.save((List<Medium>)entityList);
		} else if (entity instanceof Metrics) {
			entityList = metricsRepository.save((List<Metrics>)entityList);
		} else if (entity instanceof PostalAddress) {
			entityList = postalRepository.save((List<PostalAddress>)entityList);
		} else if (entity instanceof Prize) {
			entityList = prizeRepository.save((List<Prize>)entityList);
		} else if (entity instanceof Qualification) {
			entityList = qualificationRepository.save((List<Qualification>)entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of 2nd level entities provided. %s", entity));
		}
		return entityList;
		
	}

	/**
	 * @return the citationRepository
	 */
	public CitationRepository getCitationRepository() {
		return citationRepository;
	}

	/**
	 * @return the countryRepository
	 */
	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	/**
	 * @return the currencyRepository
	 */
	public CurrencyRepository getCurrencyRepository() {
		return currencyRepository;
	}

	/**
	 * @return the cvRepository
	 */
	public CVRepository getCvRepository() {
		return cvRepository;
	}

	/**
	 * @return the electronicRepository
	 */
	public ElectronicAddressRepository getElectronicRepository() {
		return electronicRepository;
	}

	/**
	 * @return the eventRepository
	 */
	public EventRepository getEventRepository() {
		return eventRepository;
	}

	/**
	 * @return the expertiseAndSkillsRepository
	 */
	public ExpertiseAndSkillsRepository getExpertiseAndSkillsRepository() {
		return expertiseAndSkillsRepository;
	}
	
	public FederatedIdentifierRepository getFederatedIdentifierRepository() {
		return federatedIdentifierRepository;
	}

	/**
	 * @return the fundingRepository
	 */
	public FundingRepository getFundingRepository() {
		return fundingRepository;
	}

	/**
	 * @return the geographicBoundingBoxRepository
	 */
	public GeographicBoundingBoxRepository getGeographicBoundingBoxRepository() {
		return geographicBoundingBoxRepository;
	}

	/**
	 * @return the indicatorRepository
	 */
	public IndicatorRepository getIndicatorRepository() {
		return indicatorRepository;
	}

	/**
	 * @return the languageRepository
	 */
	public LanguageRepository getLanguageRepository() {
		return languageRepository;
	}

	/**
	 * @return the measurementRepository
	 */
	public MeasurementRepository getMeasurementRepository() {
		return measurementRepository;
	}

	/**
	 * @return the mediumRepository
	 */
	public MediumRepository getMediumRepository() {
		return mediumRepository;
	}

	/**
	 * @return the metricsRepository
	 */
	public MetricsRepository getMetricsRepository() {
		return metricsRepository;
	}

	/**
	 * @return the postalRepository
	 */
	public PostalAddressRepository getPostalRepository() {
		return postalRepository;
	}

	/**
	 * @return the prizeRepository
	 */
	public PrizeRepository getPrizeRepository() {
		return prizeRepository;
	}

	/**
	 * @return the qualificationRepository
	 */
	public QualificationRepository getQualificationRepository() {
		return qualificationRepository;
	}
	
	

}
