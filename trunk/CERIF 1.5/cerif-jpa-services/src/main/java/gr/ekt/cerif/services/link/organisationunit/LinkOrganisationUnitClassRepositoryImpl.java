package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkOrganisationUnitClassRepositoryImpl implements
		LinkOrganisationUnitClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitClassRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitClassCrudRepository linkOrganisationUnitClassCrudRepository;

	@Override
	public List<OrganisationUnit_Class> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitClassCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public void delete(OrganisationUnit_Class entity) {
		linkOrganisationUnitClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Class> entities) {
		linkOrganisationUnitClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Class> save(
			Iterable<OrganisationUnit_Class> entities) {
		return linkOrganisationUnitClassCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Class save(OrganisationUnit_Class entity) {
		return linkOrganisationUnitClassCrudRepository.save(entity);
	}

}
