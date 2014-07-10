package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

@Component
public class LinkOrganisationUnitIndicatorRepositoryImpl implements
		LinkOrganisationUnitIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitIndicatorCrudRepository linkOrganisationUnitIndicatorCrudRepository;

	@Override
	public void delete(OrganisationUnit_Indicator entity) {
		linkOrganisationUnitIndicatorCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Indicator> entities) {
		linkOrganisationUnitIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Indicator> save(
			Iterable<OrganisationUnit_Indicator> entities) {
		return linkOrganisationUnitIndicatorCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Indicator save(OrganisationUnit_Indicator entity) {
		return linkOrganisationUnitIndicatorCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_Indicator> findByIndicator(Indicator indicator) {
		return linkOrganisationUnitIndicatorCrudRepository.findByIndicator(indicator);
	}

	@Override
	public List<OrganisationUnit_Indicator> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitIndicatorCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
