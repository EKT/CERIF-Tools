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
	 * The federeated identifier repository.
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
			citationRepository.save((Citation)entity);
		} else if (entity instanceof Country) {
			System.out.println("COUNTRY");
			countryRepository.delete((Country)entity);
		} else if (entity instanceof Currency) {
			currencyRepository.save((Currency)entity);
		} else if (entity instanceof CV) {
			cvRepository.save((CV)entity);
		} else if (entity instanceof ElectronicAddress) {
			electronicRepository.delete((ElectronicAddress)entity);
		} else if (entity instanceof Event) {
			eventRepository.save((Event)entity);
		} else if (entity instanceof ExpertiseAndSkills) {
			expertiseAndSkillsRepository.save((ExpertiseAndSkills)entity);
		} else if (entity instanceof Funding) {
			fundingRepository.save((Funding)entity);
		} else if (entity instanceof GeographicBoundingBox) {
			geographicBoundingBoxRepository.save((GeographicBoundingBox)entity);
		} else if (entity instanceof Indicator) {
			indicatorRepository.save((Indicator)entity);
		} else if (entity instanceof Language) {
			languageRepository.save((Language)entity);
		} else if (entity instanceof Measurement) {
			measurementRepository.save((Measurement)entity);
		} else if (entity instanceof Medium) {
			mediumRepository.delete((Medium)entity);
		} else if (entity instanceof Metrics) {
			metricsRepository.save((Metrics)entity);
		} else if (entity instanceof PostalAddress) {
			postalRepository.delete((PostalAddress)entity);
		} else if (entity instanceof Prize) {
			prizeRepository.save((Prize)entity);
		} else if (entity instanceof Qualification) {
			qualificationRepository.save((Qualification)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid 2nd level entity provided. %s", entity));
		}
	}
	
	/**
	 * Saves the provided 2nd level entity.
	 * @param entity The 2nd level entity.
	 */
	public void save(CerifSecondLevelEntity entity) {
		if (entity instanceof Citation) {
			citationRepository.save((Citation)entity);
		} else if (entity instanceof Country) {
			System.out.println("COUNTRY");
			countryRepository.save((Country)entity);
		} else if (entity instanceof Currency) {
			currencyRepository.save((Currency)entity);
		} else if (entity instanceof CV) {
			cvRepository.save((CV)entity);
		} else if (entity instanceof ElectronicAddress) {
			electronicRepository.save((ElectronicAddress)entity);
		} else if (entity instanceof Event) {
			eventRepository.save((Event)entity);
		} else if (entity instanceof ExpertiseAndSkills) {
			expertiseAndSkillsRepository.save((ExpertiseAndSkills)entity);
		} else if (entity instanceof Funding) {
			fundingRepository.save((Funding)entity);
		} else if (entity instanceof GeographicBoundingBox) {
			geographicBoundingBoxRepository.save((GeographicBoundingBox)entity);
		} else if (entity instanceof Indicator) {
			indicatorRepository.save((Indicator)entity);
		} else if (entity instanceof Language) {
			languageRepository.save((Language)entity);
		} else if (entity instanceof Measurement) {
			measurementRepository.save((Measurement)entity);
		} else if (entity instanceof Medium) {
			mediumRepository.save((Medium)entity);
		} else if (entity instanceof Metrics) {
			metricsRepository.save((Metrics)entity);
		} else if (entity instanceof PostalAddress) {
			postalRepository.save((PostalAddress)entity);
		} else if (entity instanceof Prize) {
			prizeRepository.save((Prize)entity);
		} else if (entity instanceof Qualification) {
			qualificationRepository.save((Qualification)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid 2nd level entity provided. %s", entity));
		}
	}

	/**
	 * Saves the provided 2nd level entities.
	 * @param entity The 2nd level entities.
	 */
	@SuppressWarnings("unchecked")
	public void save(List<? extends CerifSecondLevelEntity> entityList) {
		
		final CerifSecondLevelEntity entity = (CerifSecondLevelEntity)entityList.get(0);
		
		if (entity instanceof Citation) {
			citationRepository.save((List<Citation>)entity);
		} else if (entity instanceof Country) {
			countryRepository.save((List<Country>)entity);
		} else if (entity instanceof Currency) {
			currencyRepository.save((List<Currency>)entity);
		} else if (entity instanceof CV) {
			cvRepository.save((List<CV>)entity);
		} else if (entity instanceof ElectronicAddress) {
			electronicRepository.save((List<ElectronicAddress>)entity);
		} else if (entity instanceof Event) {
			eventRepository.save((List<Event>)entity);
		} else if (entity instanceof ExpertiseAndSkills) {
			expertiseAndSkillsRepository.save((List<ExpertiseAndSkills>)entity);
		} else if (entity instanceof FederatedIdentifier) {
			federatedIdentifierRepository.save((List<FederatedIdentifier>)entity);			
		} else if (entity instanceof Funding) {
			fundingRepository.save((List<Funding>)entity);
		} else if (entity instanceof GeographicBoundingBox) {
			geographicBoundingBoxRepository.save((List<GeographicBoundingBox>)entity);
		} else if (entity instanceof Indicator) {
			indicatorRepository.save((List<Indicator>)entity);
		} else if (entity instanceof Language) {
			languageRepository.save((List<Language>)entity);
		} else if (entity instanceof Measurement) {
			measurementRepository.save((List<Measurement>)entity);
		} else if (entity instanceof Medium) {
			mediumRepository.save((List<Medium>)entity);
		} else if (entity instanceof Metrics) {
			metricsRepository.save((List<Metrics>)entity);
		} else if (entity instanceof PostalAddress) {
			postalRepository.save((List<PostalAddress>)entity);
		} else if (entity instanceof Prize) {
			prizeRepository.save((List<Prize>)entity);
		} else if (entity instanceof Qualification) {
			qualificationRepository.save((List<Qualification>)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of 2nd level entities provided. %s", entity));
		}
		
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
