package gr.ekt.cerif.services.link.organisationunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;

@Component
public class LinkOrganisationUnitResultPatentRepositoryImpl implements
		LinkOrganisationUnitResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitResultPatentRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitResultPatentCrudRepository linkOrganisationUnitResultPatentCrudRepository;

	@Override
	public void delete(OrganisationUnit_ResultPatent entity) {
		linkOrganisationUnitResultPatentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_ResultPatent> entities) {
		linkOrganisationUnitResultPatentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_ResultPatent> save(
			Iterable<OrganisationUnit_ResultPatent> entities) {
		return linkOrganisationUnitResultPatentCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_ResultPatent save(
			OrganisationUnit_ResultPatent entity) {
		return linkOrganisationUnitResultPatentCrudRepository.save(entity);
	}

}
