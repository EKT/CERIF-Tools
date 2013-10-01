package gr.ekt.cerif.services.link.organisationunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;

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

}
