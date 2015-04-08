/**
 * 
 */
package gr.ekt.cerif.services.additional;

import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
