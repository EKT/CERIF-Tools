package gr.ekt.cerif.services.link.organisationunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;

@Component
public class LinkOrganisationUnitPrizeRepositoryImpl implements
		LinkOrganisationUnitPrizeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitPrizeRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitPrizeCrudRepository linkOrganisationUnitPrizeCrudRepository;

	@Override
	public void delete(OrganisationUnit_Prize entity) {
		linkOrganisationUnitPrizeCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Prize> entities) {
		linkOrganisationUnitPrizeCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Prize> save(
			Iterable<OrganisationUnit_Prize> entities) {
		return linkOrganisationUnitPrizeCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Prize save(OrganisationUnit_Prize entity) {
		return linkOrganisationUnitPrizeCrudRepository.save(entity);
	}

}
