/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class FederatedIdentifierRepositoryImpl implements FederatedIdentifierRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FederatedIdentifierRepositoryImpl.class);
	
	@Autowired
	private FederatedIdentifierCrudRepository federatedIdentifierCrudRepository;
	

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#delete(gr.ekt.cerif.entities.second.FederatedIdentifier)
	 */
	@Override
	@Transactional
	public void delete(FederatedIdentifier entity) {
		federatedIdentifierCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<FederatedIdentifier> entities) {
		federatedIdentifierCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<FederatedIdentifier> save(Iterable<FederatedIdentifier> entities) {
		return federatedIdentifierCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FederatedIdentifierRepository#save(gr.ekt.cerif.entities.second.FederatedIdentifier)
	 */
	@Override
	public FederatedIdentifier save(FederatedIdentifier entity) {
		return federatedIdentifierCrudRepository.save(entity);
	}

	@Override
	public List<FederatedIdentifier> findAll() {
		return federatedIdentifierCrudRepository.findAll();
	}

	@Override
	public Page<FederatedIdentifier> findAll(Pageable page) {
		return federatedIdentifierCrudRepository.findAll(page);
	}

	@Override
	public List<FederatedIdentifier> findFedIdByClassUriAndInstId(
			String classUri, Long instanceId) {
		return federatedIdentifierCrudRepository.findFedIdByClassUriAndInstId(classUri, instanceId);
	}

	@Override
	public List<FederatedIdentifier> findFedIdByClassUuidAndInstId(
			String classUuid, Long instanceId) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(classUuid, instanceId);
	}

	@Override
	public FederatedIdentifier findById(Long id) {
		return federatedIdentifierCrudRepository.findOne(id);
	}

	@Override
	public List<FederatedIdentifier> findFedIdByClassClassSchemeInstIdAndFedId(
			Class theClass, ClassScheme classScheme, Long instanceId,
			String fedId) {
		return federatedIdentifierCrudRepository.findFedIdByClassClassSchemeInstIdAndFedId(theClass, classScheme, instanceId, fedId);
	}

	@Override
	public List<FederatedIdentifier> findFedIdByClassClassSchemeAndFedId(
			Class theClass, String fedId, Class fedType) {
		return federatedIdentifierCrudRepository.findFedIdByClassClassSchemeAndFedId(theClass, fedId, fedType);
	}

	@Override
	public FederatedIdentifier findByUuid(String uuid) {
		return federatedIdentifierCrudRepository.findByUuid(uuid);
	}

	@Override
	public List<FederatedIdentifier> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.ORGANISATION.getUuid(), organisationUnit.getId());
	}

	@Override
	public List<FederatedIdentifier> findByResultPublication(
			ResultPublication resultPublication) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.PUBLICATION.getUuid(), resultPublication.getId());
	}

	@Override
	public List<FederatedIdentifier> findByPerson(Person person) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.PERSON.getUuid(), person.getId());
	}

	@Override
	public List<FederatedIdentifier> findByProject(Project project) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.PROJECT.getUuid(), project.getId());
	}

	@Override
	public List<FederatedIdentifier> findByEquipment(Equipment equipment) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.EQUIPMENT.getUuid(), equipment.getId());
	}

	@Override
	public List<FederatedIdentifier> findByFacility(Facility facility) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.FACILITY.getUuid(), facility.getId());
	}

	@Override
	public List<FederatedIdentifier> findByService(Service service) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.SERVICE.getUuid(), service.getId());
	}

	@Override
	public List<FederatedIdentifier> findByResultPatent(
			ResultPatent resultPatent) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.PATENT.getUuid(), resultPatent.getId());
	}

	@Override
	public List<FederatedIdentifier> findByResultProduct(
			ResultProduct resultProduct) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.PRODUCT.getUuid(), resultProduct.getId());
	}

	@Override
	public List<FederatedIdentifier> findByCitation(Citation citation) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.CITATION.getUuid(), citation.getId());
	}

	@Override
	public List<FederatedIdentifier> findByCurriculumVitae(CurriculumVitae curriculumVitae) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.CURRICULUM_VITAE.getUuid(), curriculumVitae.getId());
	}

	@Override
	public List<FederatedIdentifier> findByElectronicAddress(
			ElectronicAddress electronicAddress) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.ELECTRONIC_ADDRESS.getUuid(), electronicAddress.getId());
	}

	@Override
	public List<FederatedIdentifier> findByEvent(Event event) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.EVENT.getUuid(), event.getId());
	}

	@Override
	public List<FederatedIdentifier> findByExpertiseAndSkills(
			ExpertiseAndSkills expertiseAndSkills) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.EXPERTISE_AND_SKILLS.getUuid(), expertiseAndSkills.getId());
	}

	@Override
	public List<FederatedIdentifier> findByFunding(Funding funding) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.FUNDING.getUuid(), funding.getId());
	}

	@Override
	public List<FederatedIdentifier> findByGeographicBoundingBox(
			GeographicBoundingBox geographicBoundingBox) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.GEOGRAPHIC_BOUNDING_BOX.getUuid(), geographicBoundingBox.getId());
	}

	@Override
	public List<FederatedIdentifier> findByMeasurement(Measurement measurement) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.MEASUREMENT.getUuid(), measurement.getId());
	}

	@Override
	public List<FederatedIdentifier> findByMedium(Medium medium) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.MEDIUM.getUuid(), medium.getId());
	}

	@Override
	public List<FederatedIdentifier> findByPostalAddress(
			PostalAddress postalAddress) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.POSTAL_ADDRESS.getUuid(), postalAddress.getId());
	}

	@Override
	public List<FederatedIdentifier> findByMetrics(Metrics metrics) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.METRICS.getUuid(), metrics.getId());
	}

	@Override
	public List<FederatedIdentifier> findByPrize(Prize prize) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.PRIZE.getUuid(), prize.getId());
	}

	@Override
	public List<FederatedIdentifier> findByIndicator(Indicator indicator) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.INDICATOR.getUuid(), indicator.getId());
	}

	@Override
	public List<FederatedIdentifier> findByQualification(
			Qualification qualification) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.QUALIFICATION.getUuid(), qualification.getId());
	}

	@Override
	public List<FederatedIdentifier> findByClass(Class theClass) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.CLASSIFICATION.getUuid(), theClass.getId());
	}

	@Override
	public List<FederatedIdentifier> findByClassScheme(ClassScheme classScheme) {
		return federatedIdentifierCrudRepository.findFedIdByClassUuidAndInstId(ClassEnum.CLASSIFICATION_SCHEME.getUuid(), classScheme.getId());
	}

}
