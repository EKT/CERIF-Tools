package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.second.Funding;

@Component
public class LinkOrganisationUnitFundingRepositoryImpl implements
		LinkOrganisationUnitFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitFundingRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitFundingCrudRepository linkOrganisationUnitFundingCrudRepository;

	@Override
	public void delete(OrganisationUnit_Funding entity) {
		linkOrganisationUnitFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Funding> entities) {
		linkOrganisationUnitFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Funding> save(
			Iterable<OrganisationUnit_Funding> entities) {
		return linkOrganisationUnitFundingCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Funding save(OrganisationUnit_Funding entity) {
		return linkOrganisationUnitFundingCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_Funding> findByFunding(Funding funding) {
		return linkOrganisationUnitFundingCrudRepository.findByFunding(funding);
	}

	@Override
	public List<OrganisationUnit_Funding> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitFundingCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
