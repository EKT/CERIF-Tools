package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitResultPublicationRepositoryImpl implements LinkOrganisationUnitResultPublicationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitResultPublicationRepositoryImpl.class);
	
	@Autowired
	LinkOrganisationUnitResultPublicationCrudRepository linkOrganisationUnitResultPublicationCrudRepository;
	
	@Transactional
	public OrganisationUnit_ResultPublication save(OrganisationUnit_ResultPublication entity) {
		return linkOrganisationUnitResultPublicationCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<OrganisationUnit_ResultPublication> save(Iterable<OrganisationUnit_ResultPublication> entityList) {
		return linkOrganisationUnitResultPublicationCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(OrganisationUnit_ResultPublication entity) {
		linkOrganisationUnitResultPublicationCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<OrganisationUnit_ResultPublication> entityList) {
		linkOrganisationUnitResultPublicationCrudRepository.delete(entityList);
	}
	
	@Override
	public List<OrganisationUnit_ResultPublication> findByOrganisationUnit(OrganisationUnit orgUnit) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByOrganisationUnit(orgUnit);
	}

	@Override
	public List<OrganisationUnit_ResultPublication> findByResultPublication(ResultPublication resultPublication) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public OrganisationUnit_ResultPublication findById(Long orgunitrespubId) {
		return linkOrganisationUnitResultPublicationCrudRepository.findById(orgunitrespubId);
	}

	@Override
	public OrganisationUnit_ResultPublication findByOrganisationUnitIdAndResultPublicationId(Long ouId, Long resId) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByOrganisationUnitIdAndResultPublicationId(ouId, resId);
	}

	@Override
	public List<OrganisationUnit_ResultPublication> findByOrganisationUnitAndResultPublicationAndTheClass(
			OrganisationUnit orgUnit, ResultPublication resultPublication,
			Class theClass) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByOrganisationUnitAndResultPublicationAndTheClass(orgUnit, resultPublication, theClass);
	}

	@Override
	public List<OrganisationUnit_ResultPublication> findByResultPublicationAndTheClass(
			ResultPublication resultPublication, Class theClass) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByResultPublicationAndTheClass(resultPublication, theClass);
	}
}
