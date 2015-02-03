package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkOrganisationUnitOrganisationUnitRepositoryImpl implements
		LinkOrganisationUnitOrganisationUnitRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitOrganisationUnitRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitOrganisationUnitCrudRepository linkOrganisationUnitOrganisationUnitCrudRepository;

	@Override
	public void delete(OrganisationUnit_OrganisationUnit entity) {
		linkOrganisationUnitOrganisationUnitCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_OrganisationUnit> entities) {
		linkOrganisationUnitOrganisationUnitCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_OrganisationUnit> save(
			Iterable<OrganisationUnit_OrganisationUnit> entities) {
		return linkOrganisationUnitOrganisationUnitCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_OrganisationUnit save(
			OrganisationUnit_OrganisationUnit entity) {
		return linkOrganisationUnitOrganisationUnitCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitOrganisationUnitCrudRepository.findByOrganisationUnit1(organisationUnit);
	}

	@Override
	public List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit2(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitOrganisationUnitCrudRepository.findByOrganisationUnit2(organisationUnit);
	}

	@Override
	public List<OrganisationUnit_OrganisationUnit> findByOrganisationUnit1AndOrganisationUnit2AndTheClass(
			OrganisationUnit organisationUnit1,
			OrganisationUnit organisationUnit2, Class theClass) {
		return linkOrganisationUnitOrganisationUnitCrudRepository.findByOrganisationUnit1AndOrganisationUnit2AndTheClass(organisationUnit1, organisationUnit2, theClass);
	}

}
