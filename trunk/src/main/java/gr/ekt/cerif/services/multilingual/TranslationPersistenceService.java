/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;

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
	ClassSchemeNameRepository classSchemeNameRepository;
	
	@Autowired
	ClassSchemeDescriptionRepository classSchemeDescriptionRepository;
	
	@Autowired
	ClassTermRepository classTermRepository;
	
	@Autowired
	CountryNameRepository countryNameRepository;
	
	@Autowired
	FacilityNameRepository facilityNameRepository;
	
	@Autowired
	OrganisationUnitNameRepository organisationUnitNameRepository;
	
	@Autowired
	ProjectTitleRepository projectTitleRepository;
	
	@Autowired
	ProjectAbstractRepository projectAbstractRepository;
	
	@Autowired
	ResultPublicationTitleRepository resultPublicationTitleRepository;
	
	@Autowired
	ResultPublicationAbstractRepository resultPublicationAbstractRepository;
	
	@Autowired
	ResultPublicationKeywordRepository resultPublicationKeywordRepository;
	
	@Transactional
	public void delete(CerifMultipleLanguageFeature entity) {
		if (entity instanceof ClassSchemeName) {
			classSchemeNameRepository.save( (ClassSchemeName) entity);
		} else if (entity instanceof ClassSchemeDescription) {
			classSchemeDescriptionRepository.save( (ClassSchemeDescription) entity);
		} else if (entity instanceof FacilityName) {
			facilityNameRepository.delete( (FacilityName) entity);
		} else if (entity instanceof OrganisationUnitName) {
			organisationUnitNameRepository.delete( (OrganisationUnitName) entity);
			log.info("Deleting PersonTranslation");
		} else if (entity instanceof ResultPublicationTitle) {
			resultPublicationTitleRepository.delete((ResultPublicationTitle) entity);
		} else if (entity instanceof ResultPublicationAbstract) {
			resultPublicationAbstractRepository.delete((ResultPublicationAbstract) entity);
		} else if (entity instanceof ResultPublicationKeyword) {
			resultPublicationKeywordRepository.delete((ResultPublicationKeyword) entity);
		} else if (entity instanceof ProjectTitle) {
			projectTitleRepository.delete((ProjectTitle) entity);
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
		} else if (entity instanceof ProjectAbstract) {
			entity = projectAbstractRepository.save((ProjectAbstract) entity);
		} else if (entity instanceof ResultPublicationTitle) {
			entity = resultPublicationTitleRepository.save((ResultPublicationTitle) entity);
		} else if (entity instanceof ResultPublicationAbstract) {
			entity = resultPublicationAbstractRepository.save((ResultPublicationAbstract) entity);
		} else if (entity instanceof ResultPublicationKeyword) {
			entity = resultPublicationKeywordRepository.save((ResultPublicationKeyword) entity);
		} else if (entity instanceof ProjectTitle) {
			entity = projectTitleRepository.save((ProjectTitle) entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid multiple language feature entity provided. %s", entity));
		}
		return entity;
	}
	
	public CountryNameRepository getCountryNameRepository(){
		return countryNameRepository;
	}
	
	public OrganisationUnitNameRepository getOrganisationUnitNameRepository() {
		return organisationUnitNameRepository;
	}
	
	/**
	 * @return the classSchemeNameRepository
	 */
	public ClassSchemeNameRepository getClassSchemeNameRepository() {
		return classSchemeNameRepository;
	}

	/**
	 * @return the ProjectTitleRepository
	 */
	public ProjectTitleRepository getProjectTitleRepository() {
		return projectTitleRepository;
	}
	
	/**
	 * @return the classSchemeDescriptionRepository
	 */
	public ClassSchemeDescriptionRepository getClassSchemeDescriptionRepository() {
		return classSchemeDescriptionRepository;
	}

	/**
	 * @return the facilityNameRepository
	 */
	public FacilityNameRepository getFacilityNameRepository() {
		return facilityNameRepository;
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
