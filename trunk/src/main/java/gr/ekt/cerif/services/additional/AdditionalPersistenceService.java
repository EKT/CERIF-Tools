/**
 * 
 */
package gr.ekt.cerif.services.additional;

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
	public void save(CerifAdditionalFeature entity) {
		if (entity instanceof PersonName) {
			personNameRepository.save( (PersonName) entity);
		} else if (entity instanceof DublinCoreAudience) {
			dublinCoreAudienceRepository.save( (DublinCoreAudience) entity);
		} else if (entity instanceof DublinCoreContributor) {
			dublinCoreContributorRepository.save( (DublinCoreContributor) entity);
		} else if (entity instanceof DublinCoreCoverage) {
			dublinCoreCoverageRepository.save( (DublinCoreCoverage) entity);
		} else if (entity instanceof DublinCoreCoverageSpatial) {
			dublinCoreCoverageSpatialRepository.save( (DublinCoreCoverageSpatial) entity);
		} else if (entity instanceof DublinCoreCoverageTemporal) {
			dublinCoreCoverageTemporalRepository.save( (DublinCoreCoverageTemporal) entity);
		} else if (entity instanceof DublinCoreCreator) {
			dublinCoreCreatorRepository.save( (DublinCoreCreator) entity);
		} else if (entity instanceof DublinCoreDate) {
			dublinCoreDateRepository.save( (DublinCoreDate) entity);
		} else if (entity instanceof DublinCoreDescription) {
			dublinCoreDescriptionRepository.save( (DublinCoreDescription) entity);
		} else if (entity instanceof DublinCoreFormat) {
			dublinCoreFormatRepository.save( (DublinCoreFormat) entity);
		} else if (entity instanceof DublinCoreLanguage) {
			dublinCoreLanguageRepository.save( (DublinCoreLanguage) entity);
		} else if (entity instanceof DublinCoreProvenance) {
			dublinCoreProvenanceRepository.save( (DublinCoreProvenance) entity);
		} else if (entity instanceof DublinCorePublisher) {
			dublinCorePublisherRepository.save( (DublinCorePublisher) entity);
		} else if (entity instanceof DublinCoreRelation) {
			dublinCoreRelationRepository.save( (DublinCoreRelation) entity);
		} else if (entity instanceof DublinCore) {
			dublinCoreRepository.save( (DublinCore) entity);
		} else if (entity instanceof DublinCoreResourceIdentifier) {
			dublinCoreResourceIdentifierRepository.save( (DublinCoreResourceIdentifier) entity);
		} else if (entity instanceof DublinCoreResourceType) {
			dublinCoreResourceTypeRepository.save( (DublinCoreResourceType) entity);
		} else if (entity instanceof DublinCoreRightsManagementAccessRights) {
			dublinCoreRightsManagementAccessRightsRepository.save( (DublinCoreRightsManagementAccessRights) entity);
		} else if (entity instanceof DublinCoreRightsManagementLicence) {
			dublinCoreRightsManagementLicenceRepository.save( (DublinCoreRightsManagementLicence) entity);
		} else if (entity instanceof DublinCoreRightsManagement) {
			dublinCoreRightsManagementRepository.save( (DublinCoreRightsManagement) entity);
		} else if (entity instanceof DublinCoreSource) {
			dublinCoreSourceRepository.save( (DublinCoreSource) entity);
		} else if (entity instanceof DublinCoreSubject) {
			dublinCoreSubjectRepository.save( (DublinCoreSubject) entity);
		} else if (entity instanceof DublinCoreTitle) {
			dublinCoreTitleRepository.save( (DublinCoreTitle) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPricing) {
			formalisedDublinCoreRightsManagementPricingRepository.save( (FormalisedDublinCoreRightsManagementPricing) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementPrivacy) {
			formalisedDublinCoreRightsManagementPrivacyRepository.save( (FormalisedDublinCoreRightsManagementPrivacy) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementRights) {
			formalisedDublinCoreRightsManagementRightsRepository.save( (FormalisedDublinCoreRightsManagementRights) entity);
		} else if (entity instanceof FormalisedDublinCoreRightsManagementSecurity) {
			formalisedDublinCoreRightsManagementSecurityRepository.save( (FormalisedDublinCoreRightsManagementSecurity) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid additional feature entity provided. %s", entity));
		}
	}
}
