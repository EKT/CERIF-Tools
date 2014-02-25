package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;

@Component
public class LinkOrganisationUnitServiceRepositoryImpl implements
		LinkOrganisationUnitServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitServiceRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitServiceCrudRepository linkOrganisationUnitServiceCrudRepository;

	@Override
	public void delete(OrganisationUnit_Service entity) {
		linkOrganisationUnitServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Service> entities) {
		linkOrganisationUnitServiceCrudRepository.save(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Service> save(
			Iterable<OrganisationUnit_Service> entities) {
		return linkOrganisationUnitServiceCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Service save(OrganisationUnit_Service entity) {
		return linkOrganisationUnitServiceCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_Service> findByService(Service service) {
		return linkOrganisationUnitServiceCrudRepository.findByService(service);
	}

	@Override
	public List<OrganisationUnit_Service> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitServiceCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
