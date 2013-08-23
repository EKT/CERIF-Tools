package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitResultPublicationRepositoryImpl implements LinkOrganisationUnitResultPublicationRepository {
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	LinkOrganisationUnitResultPublicationCrudRepository linkOrganisationUnitResultPublicationCrudRepository;
	
	@Transactional
	public OrganisationUnit_ResultPublication save(OrganisationUnit_ResultPublication entity) {
		if (entity.getOrganisationUnit() == null) {
			throw new IllegalArgumentException("Please provide an organisation.");
		}
		if (entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide a result publication.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
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
}
