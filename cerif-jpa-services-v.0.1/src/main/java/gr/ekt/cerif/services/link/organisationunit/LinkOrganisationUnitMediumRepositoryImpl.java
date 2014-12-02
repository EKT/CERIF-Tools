package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.second.Medium;

@Component
public class LinkOrganisationUnitMediumRepositoryImpl implements
		LinkOrganisationUnitMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitMediumRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitMediumCrudRepository linkOrganisationUnitMediumCrudRepository;

	@Override
	public void delete(OrganisationUnit_Medium entity) {
		linkOrganisationUnitMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Medium> entities) {
		linkOrganisationUnitMediumCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Medium> save(
			Iterable<OrganisationUnit_Medium> entities) {
		return linkOrganisationUnitMediumCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Medium save(OrganisationUnit_Medium entity) {
		return linkOrganisationUnitMediumCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_Medium> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitMediumCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public List<OrganisationUnit_Medium> findByMedium(Medium medium) {
		return linkOrganisationUnitMediumCrudRepository.findByMedium(medium);
	}

}
