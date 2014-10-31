/**
 * 
 */
package gr.ekt.cerif.services.additional;

import java.util.List;

import gr.ekt.cerif.features.additional.CerifAdditionalFeature;
import gr.ekt.cerif.features.additional.DublinCore;
import gr.ekt.cerif.features.additional.DublinCoreAudience;
import gr.ekt.cerif.features.additional.DublinCoreContributor;
import gr.ekt.cerif.features.additional.DublinCoreCoverage;
import gr.ekt.cerif.features.additional.DublinCoreCoverageSpatial;
import gr.ekt.cerif.features.additional.DublinCoreCoverageTemporal;
import gr.ekt.cerif.features.additional.DublinCoreCreator;
import gr.ekt.cerif.features.additional.DublinCoreDate;
import gr.ekt.cerif.features.additional.DublinCoreDescription;
import gr.ekt.cerif.features.additional.DublinCoreFormat;
import gr.ekt.cerif.features.additional.DublinCoreLanguage;
import gr.ekt.cerif.features.additional.DublinCoreProvenance;
import gr.ekt.cerif.features.additional.DublinCorePublisher;
import gr.ekt.cerif.features.additional.DublinCoreRelation;
import gr.ekt.cerif.features.additional.DublinCoreResourceIdentifier;
import gr.ekt.cerif.features.additional.DublinCoreResourceType;
import gr.ekt.cerif.features.additional.DublinCoreRightsHolder;
import gr.ekt.cerif.features.additional.DublinCoreRightsManagement;
import gr.ekt.cerif.features.additional.DublinCoreRightsManagementAccessRights;
import gr.ekt.cerif.features.additional.DublinCoreRightsManagementLicence;
import gr.ekt.cerif.features.additional.DublinCoreSource;
import gr.ekt.cerif.features.additional.DublinCoreSubject;
import gr.ekt.cerif.features.additional.DublinCoreTitle;
import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPricing;
import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPrivacy;
import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementRights;
import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementSecurity;
import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Persistence service for CERIF Multiple Language Feature Entities.
 * 
 */
@Component
public class AdditionalPersistenceService {

	@Autowired
	private PersonNameRepository personNameRepository;	
	
	@Autowired
	private DublinCoreAudienceRepository dublinCoreAudienceRepository;	
	
	@Autowired
	private DublinCoreContributorRepository dublinCoreContributorRepository;	
	
	@Autowired
	private DublinCoreCoverageRepository dublinCoreCoverageRepository;
	
	@Autowired
	private DublinCoreCoverageSpatialRepository dublinCoreCoverageSpatialRepository;
	
	@Autowired
	private DublinCoreCoverageTemporalRepository dublinCoreCoverageTemporalRepository;
	
	@Autowired
	private DublinCoreCreatorRepository dublinCoreCreatorRepository;
	
	@Autowired
	private DublinCoreDateRepository dublinCoreDateRepository;
	
	@Autowired
	private DublinCoreDescriptionRepository dublinCoreDescriptionRepository;
	
	@Autowired
	private DublinCoreFormatRepository dublinCoreFormatRepository;
	
	@Autowired
	private DublinCoreLanguageRepository dublinCoreLanguageRepository;
	
	@Autowired
	private DublinCoreProvenanceRepository dublinCoreProvenanceRepository;
	
	@Autowired
	private DublinCorePublisherRepository dublinCorePublisherRepository;
	
	@Autowired
	private DublinCoreRelationRepository dublinCoreRelationRepository;
	
	@Autowired
	private DublinCoreRightsHolderRepository dublinCoreRightsHolderRepository;
	
	@Autowired
	private DublinCoreRepository dublinCoreRepository;
	
	@Autowired
	private DublinCoreResourceIdentifierRepository dublinCoreResourceIdentifierRepository;
	
	@Autowired
	private DublinCoreResourceTypeRepository dublinCoreResourceTypeRepository;
	
	@Autowired
	private DublinCoreRightsManagementAccessRightsRepository dublinCoreRightsManagementAccessRightsRepository;
	
	@Autowired
	private DublinCoreRightsManagementLicenceRepository dublinCoreRightsManagementLicenceRepository;
	
	@Autowired
	private DublinCoreRightsManagementRepository dublinCoreRightsManagementRepository;
	
	@Autowired
	private DublinCoreSourceRepository dublinCoreSourceRepository;
	
	@Autowired
	private DublinCoreSubjectRepository dublinCoreSubjectRepository;
	
	@Autowired
	private DublinCoreTitleRepository dublinCoreTitleRepository;
	
	@Autowired
	private FormalisedDublinCoreRightsManagementPricingRepository formalisedDublinCoreRightsManagementPricingRepository;
	
	@Autowired
	private FormalisedDublinCoreRightsManagementPrivacyRepository formalisedDublinCoreRightsManagementPrivacyRepository;
	
	@Autowired
	private FormalisedDublinCoreRightsManagementRightsRepository formalisedDublinCoreRightsManagementRightsRepository;
	
	@Autowired
	private FormalisedDublinCoreRightsManagementSecurityRepository formalisedDublinCoreRightsManagementSecurityRepository;
	
	@Transactional
	public void delete(CerifAdditionalFeature entity) {
		if (entity instanceof PersonName) {
			personNameRepository.delete( (PersonName) entity);
		} else if (entity instanceof DublinCoreAudience) {
			dublinCoreAudienceRepository.delete( (DublinCoreAudience) entity);
		} else if (entity instanceof DublinCoreContributor) {
			dublinCoreContributorRepository.delete( (DublinCoreContributor) entity);
		} else if (entity instanceof DublinCoreCoverage) {
			dublinCoreCoverageRepository.delete( (DublinCoreCoverage) entity);
		} else if (entity instanceof DublinCoreCoverageSpatial) {
			dublinCoreCoverageSpatialRepository.delete( (DublinCoreCoverageSpatial) entity);
		} else if (entity instanceof DublinCoreCoverageTemporal) {
			dublinCoreCoverageTemporalRepository.delete( (DublinCoreCoverageTemporal) entity);
		} else if (entity instanceof DublinCoreCreator) {
			dublinCoreCreatorRepository.delete( (DublinCoreCreator) entity);
		} else if (entity instanceof DublinCoreDate) {
			dublinCoreDateRepository.delete( (DublinCoreDate) entity);
		} else if (entity instanceof DublinCoreDescription) {
			dublinCoreDescriptionRepository.delete( (DublinCoreDescription) entity);
		} else if (entity instanceof DublinCoreFormat) {
			dublinCoreFormatRepository.delete( (DublinCoreFormat) entity);
		} else if (entity instanceof DublinCoreLanguage) {
			dublinCoreLanguageRepository.delete( (DublinCoreLanguage) entity);
		} else if (entity instanceof DublinCoreProvenance) {
			dublinCoreProvenanceRepository.delete( (DublinCoreProvenance) entity);
		} else if (entity instanceof DublinCorePublisher) {
			dublinCorePublisherRepository.delete( (DublinCorePublisher) entity);
		} else if (entity instanceof DublinCoreRelation) {
			dublinCoreRelationRepository.delete( (DublinCoreRelation) entity);
		} else if (entity instanceof DublinCoreRightsHolder) {
			dublinCoreRightsHolderRepository.delete( (DublinCoreRightsHolder) entity);
		} else if (entity instanceof DublinCore) {
			dublinCoreRepository.delete( (DublinCore) entity);
		} else if (entity instanceof DublinCoreResourceIdentifier) {
			dublinCoreResourceIdentifierRepository.delete( (DublinCoreResourceIdentifier) entity);
		} else if (entity instanceof DublinCoreResourceType) {
			dublinCoreResourceTypeRepository.delete( (DublinCoreResourceType) entity);
		} else if (entity instanceof DublinCoreRightsManagementAccessRights) {
			dublinCoreRightsManagementAccessRightsRepository.delete( (DublinCoreRightsManagementAccessRights) entity);
		} else if (entity instanceof DublinCoreRightsManagementLicence) {
			dublinCoreRightsManagementLicenceRepository.delete( (DublinCoreRightsManagementLicence) entity);
		} else if (entity instanceof DublinCoreRightsManagement) {
			dublinCoreRightsManagementRepository.delete( (DublinCoreRightsManagement) entity);
		} else if (entity instanceof DublinCoreSource) {
			dublinCoreSourceRepository.delete( (DublinCoreSource) entity);
		} else if (entity instanceof DublinCoreSubject) {
			dublinCoreSubjectRepository.delete( (DublinCoreSubject) entity);
		} else if (entity instanceof DublinCoreTitle) {
			dublinCoreTitleRepository.delete( (DublinCoreTitle) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPricing) {
			formalisedDublinCoreRightsManagementPricingRepository.delete( (FormalisedDublinCoreRightsManagementPricing) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPrivacy) {
			formalisedDublinCoreRightsManagementPrivacyRepository.delete( (FormalisedDublinCoreRightsManagementPrivacy) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementRights) {
			formalisedDublinCoreRightsManagementRightsRepository.delete( (FormalisedDublinCoreRightsManagementRights) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementSecurity) {
			formalisedDublinCoreRightsManagementSecurityRepository.delete( (FormalisedDublinCoreRightsManagementSecurity) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid additional feature entity provided. %s", entity));
		}
	}
	
	@Transactional
	public CerifAdditionalFeature save(CerifAdditionalFeature entity) {
		if (entity instanceof PersonName) {
			entity = personNameRepository.save( (PersonName) entity);
		} else if (entity instanceof DublinCoreAudience) {
			entity = dublinCoreAudienceRepository.save( (DublinCoreAudience) entity);
		} else if (entity instanceof DublinCoreContributor) {
			entity = dublinCoreContributorRepository.save( (DublinCoreContributor) entity);
		} else if (entity instanceof DublinCoreCoverage) {
			entity = dublinCoreCoverageRepository.save( (DublinCoreCoverage) entity);
		} else if (entity instanceof DublinCoreCoverageSpatial) {
			entity = dublinCoreCoverageSpatialRepository.save( (DublinCoreCoverageSpatial) entity);
		} else if (entity instanceof DublinCoreCoverageTemporal) {
			entity = dublinCoreCoverageTemporalRepository.save( (DublinCoreCoverageTemporal) entity);
		} else if (entity instanceof DublinCoreCreator) {
			entity = dublinCoreCreatorRepository.save( (DublinCoreCreator) entity);
		} else if (entity instanceof DublinCoreDate) {
			entity = dublinCoreDateRepository.save( (DublinCoreDate) entity);
		} else if (entity instanceof DublinCoreDescription) {
			entity = dublinCoreDescriptionRepository.save( (DublinCoreDescription) entity);
		} else if (entity instanceof DublinCoreFormat) {
			entity = dublinCoreFormatRepository.save( (DublinCoreFormat) entity);
		} else if (entity instanceof DublinCoreLanguage) {
			entity = dublinCoreLanguageRepository.save( (DublinCoreLanguage) entity);
		} else if (entity instanceof DublinCoreProvenance) {
			entity = dublinCoreProvenanceRepository.save( (DublinCoreProvenance) entity);
		} else if (entity instanceof DublinCorePublisher) {
			entity = dublinCorePublisherRepository.save( (DublinCorePublisher) entity);
		} else if (entity instanceof DublinCoreRelation) {
			entity = dublinCoreRelationRepository.save( (DublinCoreRelation) entity);
		} else if (entity instanceof DublinCoreRightsHolder) {
			entity = dublinCoreRightsHolderRepository.save( (DublinCoreRightsHolder) entity);
		} else if (entity instanceof DublinCore) {
			entity = dublinCoreRepository.save( (DublinCore) entity);
		} else if (entity instanceof DublinCoreResourceIdentifier) {
			entity = dublinCoreResourceIdentifierRepository.save( (DublinCoreResourceIdentifier) entity);
		} else if (entity instanceof DublinCoreResourceType) {
			entity = dublinCoreResourceTypeRepository.save( (DublinCoreResourceType) entity);
		} else if (entity instanceof DublinCoreRightsManagementAccessRights) {
			entity = dublinCoreRightsManagementAccessRightsRepository.save( (DublinCoreRightsManagementAccessRights) entity);
		} else if (entity instanceof DublinCoreRightsManagementLicence) {
			entity = dublinCoreRightsManagementLicenceRepository.save( (DublinCoreRightsManagementLicence) entity);
		} else if (entity instanceof DublinCoreRightsManagement) {
			entity = dublinCoreRightsManagementRepository.save( (DublinCoreRightsManagement) entity);
		} else if (entity instanceof DublinCoreSource) {
			entity = dublinCoreSourceRepository.save( (DublinCoreSource) entity);
		} else if (entity instanceof DublinCoreSubject) {
			entity = dublinCoreSubjectRepository.save( (DublinCoreSubject) entity);
		} else if (entity instanceof DublinCoreTitle) {
			entity = dublinCoreTitleRepository.save( (DublinCoreTitle) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPricing) {
			entity = formalisedDublinCoreRightsManagementPricingRepository.save( (FormalisedDublinCoreRightsManagementPricing) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPrivacy) {
			entity = formalisedDublinCoreRightsManagementPrivacyRepository.save( (FormalisedDublinCoreRightsManagementPrivacy) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementRights) {
			entity = formalisedDublinCoreRightsManagementRightsRepository.save( (FormalisedDublinCoreRightsManagementRights) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementSecurity) {
			entity = formalisedDublinCoreRightsManagementSecurityRepository.save( (FormalisedDublinCoreRightsManagementSecurity) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid additional feature entity provided. %s", entity));
		}
		return entity;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Iterable<? extends CerifAdditionalFeature> save(Iterable<? extends CerifAdditionalFeature> entityList) {
		
		final CerifAdditionalFeature entity = (CerifAdditionalFeature)entityList.iterator().next();
		
		if (entity instanceof PersonName) {
			entityList = personNameRepository.save( (List<PersonName>) entityList);
		} else if (entity instanceof DublinCoreAudience) {
			entityList = dublinCoreAudienceRepository.save( (List<DublinCoreAudience>) entityList);
		} else if (entity instanceof DublinCoreContributor) {
			entityList = dublinCoreContributorRepository.save( (List<DublinCoreContributor>) entityList);
		} else if (entity instanceof DublinCoreCoverage) {
			entityList = dublinCoreCoverageRepository.save( (List<DublinCoreCoverage>) entityList);
		} else if (entity instanceof DublinCoreCoverageSpatial) {
			entityList = dublinCoreCoverageSpatialRepository.save( (List<DublinCoreCoverageSpatial>) entityList);
		} else if (entity instanceof DublinCoreCoverageTemporal) {
			entityList = dublinCoreCoverageTemporalRepository.save( (List<DublinCoreCoverageTemporal>) entityList);
		} else if (entity instanceof DublinCoreCreator) {
			entityList = dublinCoreCreatorRepository.save( (List<DublinCoreCreator>) entityList);
		} else if (entity instanceof DublinCoreDate) {
			entityList = dublinCoreDateRepository.save( (List<DublinCoreDate>) entityList);
		} else if (entity instanceof DublinCoreDescription) {
			entityList = dublinCoreDescriptionRepository.save( (List<DublinCoreDescription>) entityList);
		} else if (entity instanceof DublinCoreFormat) {
			entityList = dublinCoreFormatRepository.save( (List<DublinCoreFormat>) entityList);
		} else if (entity instanceof DublinCoreLanguage) {
			entityList = dublinCoreLanguageRepository.save( (List<DublinCoreLanguage>) entityList);
		} else if (entity instanceof DublinCoreProvenance) {
			entityList = dublinCoreProvenanceRepository.save( (List<DublinCoreProvenance>) entityList);
		} else if (entity instanceof DublinCorePublisher) {
			entityList = dublinCorePublisherRepository.save( (List<DublinCorePublisher>) entityList);
		} else if (entity instanceof DublinCoreRelation) {
			entityList = dublinCoreRelationRepository.save( (List<DublinCoreRelation>) entityList);
		} else if (entity instanceof DublinCoreRightsHolder) {
			entityList = dublinCoreRightsHolderRepository.save( (List<DublinCoreRightsHolder>) entityList);
		} else if (entity instanceof DublinCore) {
			entityList = dublinCoreRepository.save( (List<DublinCore>) entityList);
		} else if (entity instanceof DublinCoreResourceIdentifier) {
			entityList = dublinCoreResourceIdentifierRepository.save( (List<DublinCoreResourceIdentifier>) entityList);
		} else if (entity instanceof DublinCoreResourceType) {
			entityList = dublinCoreResourceTypeRepository.save( (List<DublinCoreResourceType>) entityList);
		} else if (entity instanceof DublinCoreRightsManagementAccessRights) {
			entityList = dublinCoreRightsManagementAccessRightsRepository.save( (List<DublinCoreRightsManagementAccessRights>) entityList);
		} else if (entity instanceof DublinCoreRightsManagementLicence) {
			entityList = dublinCoreRightsManagementLicenceRepository.save( (List<DublinCoreRightsManagementLicence>) entityList);
		} else if (entity instanceof DublinCoreRightsManagement) {
			entityList = dublinCoreRightsManagementRepository.save( (List<DublinCoreRightsManagement>) entityList);
		} else if (entity instanceof DublinCoreSource) {
			entityList = dublinCoreSourceRepository.save( (List<DublinCoreSource>) entityList);
		} else if (entity instanceof DublinCoreSubject) {
			entityList = dublinCoreSubjectRepository.save( (List<DublinCoreSubject>) entityList);
		} else if (entity instanceof DublinCoreTitle) {
			entityList = dublinCoreTitleRepository.save( (List<DublinCoreTitle>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPricing) {
			entityList = formalisedDublinCoreRightsManagementPricingRepository.save( (List<FormalisedDublinCoreRightsManagementPricing>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPrivacy) {
			entityList = formalisedDublinCoreRightsManagementPrivacyRepository.save( (List<FormalisedDublinCoreRightsManagementPrivacy>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementRights) {
			entityList = formalisedDublinCoreRightsManagementRightsRepository.save( (List<FormalisedDublinCoreRightsManagementRights>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementSecurity) {
			entityList = formalisedDublinCoreRightsManagementSecurityRepository.save( (List<FormalisedDublinCoreRightsManagementSecurity>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid additional feature entity provided. %s", entity));
		}
		return entityList;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public void delete(Iterable<? extends CerifAdditionalFeature> entityList) {
		
		final CerifAdditionalFeature entity = (CerifAdditionalFeature)entityList.iterator().next();
		
		if (entity instanceof PersonName) {
			personNameRepository.delete( (List<PersonName>) entityList);
		} else if (entity instanceof DublinCoreAudience) {
			dublinCoreAudienceRepository.delete( (List<DublinCoreAudience>) entityList);
		} else if (entity instanceof DublinCoreContributor) {
			dublinCoreContributorRepository.delete( (List<DublinCoreContributor>) entityList);
		} else if (entity instanceof DublinCoreCoverage) {
			dublinCoreCoverageRepository.delete( (List<DublinCoreCoverage>) entityList);
		} else if (entity instanceof DublinCoreCoverageSpatial) {
			dublinCoreCoverageSpatialRepository.delete( (List<DublinCoreCoverageSpatial>) entityList);
		} else if (entity instanceof DublinCoreCoverageTemporal) {
			dublinCoreCoverageTemporalRepository.delete( (List<DublinCoreCoverageTemporal>) entityList);
		} else if (entity instanceof DublinCoreCreator) {
			dublinCoreCreatorRepository.delete( (List<DublinCoreCreator>) entityList);
		} else if (entity instanceof DublinCoreDate) {
			dublinCoreDateRepository.delete( (List<DublinCoreDate>) entityList);
		} else if (entity instanceof DublinCoreDescription) {
			dublinCoreDescriptionRepository.delete( (List<DublinCoreDescription>) entityList);
		} else if (entity instanceof DublinCoreFormat) {
			dublinCoreFormatRepository.delete( (List<DublinCoreFormat>) entityList);
		} else if (entity instanceof DublinCoreLanguage) {
			dublinCoreLanguageRepository.delete( (List<DublinCoreLanguage>) entityList);
		} else if (entity instanceof DublinCoreProvenance) {
			dublinCoreProvenanceRepository.delete( (List<DublinCoreProvenance>) entityList);
		} else if (entity instanceof DublinCorePublisher) {
			dublinCorePublisherRepository.delete( (List<DublinCorePublisher>) entityList);
		} else if (entity instanceof DublinCoreRelation) {
			dublinCoreRelationRepository.delete( (List<DublinCoreRelation>) entityList);
		} else if (entity instanceof DublinCoreRightsHolder) {
			dublinCoreRightsHolderRepository.delete( (List<DublinCoreRightsHolder>) entityList);
		} else if (entity instanceof DublinCore) {
			dublinCoreRepository.delete( (List<DublinCore>) entityList);
		} else if (entity instanceof DublinCoreResourceIdentifier) {
			dublinCoreResourceIdentifierRepository.delete( (List<DublinCoreResourceIdentifier>) entityList);
		} else if (entity instanceof DublinCoreResourceType) {
			dublinCoreResourceTypeRepository.delete( (List<DublinCoreResourceType>) entityList);
		} else if (entity instanceof DublinCoreRightsManagementAccessRights) {
			dublinCoreRightsManagementAccessRightsRepository.delete( (List<DublinCoreRightsManagementAccessRights>) entityList);
		} else if (entity instanceof DublinCoreRightsManagementLicence) {
			dublinCoreRightsManagementLicenceRepository.delete( (List<DublinCoreRightsManagementLicence>) entityList);
		} else if (entity instanceof DublinCoreRightsManagement) {
			dublinCoreRightsManagementRepository.delete( (List<DublinCoreRightsManagement>) entityList);
		} else if (entity instanceof DublinCoreSource) {
			dublinCoreSourceRepository.delete( (List<DublinCoreSource>) entityList);
		} else if (entity instanceof DublinCoreSubject) {
			dublinCoreSubjectRepository.delete( (List<DublinCoreSubject>) entityList);
		} else if (entity instanceof DublinCoreTitle) {
			dublinCoreTitleRepository.delete( (List<DublinCoreTitle>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPricing) {
			formalisedDublinCoreRightsManagementPricingRepository.delete( (List<FormalisedDublinCoreRightsManagementPricing>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPrivacy) {
			formalisedDublinCoreRightsManagementPrivacyRepository.delete( (List<FormalisedDublinCoreRightsManagementPrivacy>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementRights) {
			formalisedDublinCoreRightsManagementRightsRepository.delete( (List<FormalisedDublinCoreRightsManagementRights>) entityList);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementSecurity) {
			formalisedDublinCoreRightsManagementSecurityRepository.delete( (List<FormalisedDublinCoreRightsManagementSecurity>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid additional feature entity provided. %s", entity));
		}

	}

	/**
	 * @return the personNameRepository
	 */
	public PersonNameRepository getPersonNameRepository() {
		return personNameRepository;
	}

	/**
	 * @return the dublinCoreAudienceRepository
	 */
	public DublinCoreAudienceRepository getDublinCoreAudienceRepository() {
		return dublinCoreAudienceRepository;
	}

	/**
	 * @return the dublinCoreContributorRepository
	 */
	public DublinCoreContributorRepository getDublinCoreContributorRepository() {
		return dublinCoreContributorRepository;
	}

	/**
	 * @return the dublinCoreCoverageRepository
	 */
	public DublinCoreCoverageRepository getDublinCoreCoverageRepository() {
		return dublinCoreCoverageRepository;
	}

	/**
	 * @return the dublinCoreCoverageSpatialRepository
	 */
	public DublinCoreCoverageSpatialRepository getDublinCoreCoverageSpatialRepository() {
		return dublinCoreCoverageSpatialRepository;
	}

	/**
	 * @return the dublinCoreCoverageTemporalRepository
	 */
	public DublinCoreCoverageTemporalRepository getDublinCoreCoverageTemporalRepository() {
		return dublinCoreCoverageTemporalRepository;
	}

	/**
	 * @return the dublinCoreCreatorRepository
	 */
	public DublinCoreCreatorRepository getDublinCoreCreatorRepository() {
		return dublinCoreCreatorRepository;
	}

	/**
	 * @return the dublinCoreDateRepository
	 */
	public DublinCoreDateRepository getDublinCoreDateRepository() {
		return dublinCoreDateRepository;
	}

	/**
	 * @return the dublinCoreDescriptionRepository
	 */
	public DublinCoreDescriptionRepository getDublinCoreDescriptionRepository() {
		return dublinCoreDescriptionRepository;
	}

	/**
	 * @return the dublinCoreFormatRepository
	 */
	public DublinCoreFormatRepository getDublinCoreFormatRepository() {
		return dublinCoreFormatRepository;
	}

	/**
	 * @return the dublinCoreLanguageRepository
	 */
	public DublinCoreLanguageRepository getDublinCoreLanguageRepository() {
		return dublinCoreLanguageRepository;
	}

	/**
	 * @return the dublinCoreProvenanceRepository
	 */
	public DublinCoreProvenanceRepository getDublinCoreProvenanceRepository() {
		return dublinCoreProvenanceRepository;
	}

	/**
	 * @return the dublinCorePublisherRepository
	 */
	public DublinCorePublisherRepository getDublinCorePublisherRepository() {
		return dublinCorePublisherRepository;
	}

	/**
	 * @return the dublinCoreRelationRepository
	 */
	public DublinCoreRelationRepository getDublinCoreRelationRepository() {
		return dublinCoreRelationRepository;
	}

	/**
	 * @return the dublinCoreRightsHolderRepository
	 */
	public DublinCoreRightsHolderRepository getDublinCoreRightsHolderRepository() {
		return dublinCoreRightsHolderRepository;
	}

	/**
	 * @return the dublinCoreRepository
	 */
	public DublinCoreRepository getDublinCoreRepository() {
		return dublinCoreRepository;
	}

	/**
	 * @return the dublinCoreResourceIdentifierRepository
	 */
	public DublinCoreResourceIdentifierRepository getDublinCoreResourceIdentifierRepository() {
		return dublinCoreResourceIdentifierRepository;
	}

	/**
	 * @return the dublinCoreResourceTypeRepository
	 */
	public DublinCoreResourceTypeRepository getDublinCoreResourceTypeRepository() {
		return dublinCoreResourceTypeRepository;
	}

	/**
	 * @return the dublinCoreRightsManagementAccessRightsRepository
	 */
	public DublinCoreRightsManagementAccessRightsRepository getDublinCoreRightsManagementAccessRightsRepository() {
		return dublinCoreRightsManagementAccessRightsRepository;
	}

	/**
	 * @return the dublinCoreRightsManagementLicenceRepository
	 */
	public DublinCoreRightsManagementLicenceRepository getDublinCoreRightsManagementLicenceRepository() {
		return dublinCoreRightsManagementLicenceRepository;
	}

	/**
	 * @return the dublinCoreRightsManagementRepository
	 */
	public DublinCoreRightsManagementRepository getDublinCoreRightsManagementRepository() {
		return dublinCoreRightsManagementRepository;
	}

	/**
	 * @return the dublinCoreSourceRepository
	 */
	public DublinCoreSourceRepository getDublinCoreSourceRepository() {
		return dublinCoreSourceRepository;
	}

	/**
	 * @return the dublinCoreSubjectRepository
	 */
	public DublinCoreSubjectRepository getDublinCoreSubjectRepository() {
		return dublinCoreSubjectRepository;
	}

	/**
	 * @return the dublinCoreTitleRepository
	 */
	public DublinCoreTitleRepository getDublinCoreTitleRepository() {
		return dublinCoreTitleRepository;
	}

	/**
	 * @return the formalisedDublinCoreRightsManagementPricingRepository
	 */
	public FormalisedDublinCoreRightsManagementPricingRepository getFormalisedDublinCoreRightsManagementPricingRepository() {
		return formalisedDublinCoreRightsManagementPricingRepository;
	}

	/**
	 * @return the formalisedDublinCoreRightsManagementPrivacyRepository
	 */
	public FormalisedDublinCoreRightsManagementPrivacyRepository getFormalisedDublinCoreRightsManagementPrivacyRepository() {
		return formalisedDublinCoreRightsManagementPrivacyRepository;
	}

	/**
	 * @return the formalisedDublinCoreRightsManagementRightsRepository
	 */
	public FormalisedDublinCoreRightsManagementRightsRepository getFormalisedDublinCoreRightsManagementRightsRepository() {
		return formalisedDublinCoreRightsManagementRightsRepository;
	}

	/**
	 * @return the formalisedDublinCoreRightsManagementSecurityRepository
	 */
	public FormalisedDublinCoreRightsManagementSecurityRepository getFormalisedDublinCoreRightsManagementSecurityRepository() {
		return formalisedDublinCoreRightsManagementSecurityRepository;
	}


	
}
