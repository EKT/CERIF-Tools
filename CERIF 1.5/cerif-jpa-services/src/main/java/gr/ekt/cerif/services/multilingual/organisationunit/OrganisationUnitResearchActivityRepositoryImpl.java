/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;


/**
 * @author bonisv
 *
 */
@Component
public class OrganisationUnitResearchActivityRepositoryImpl implements OrganisationUnitResearchActivityRepository{

	private static final Logger log = LoggerFactory.getLogger(OrganisationUnitResearchActivityRepositoryImpl.class);
	
	@Autowired
	private OrganisationUnitResearchActivityCrudRepository organisationUnitResearchActivityCrudRepository;
	
	@Override
	public void delete(OrganisationUnitResearchActivity entity) {
		organisationUnitResearchActivityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnitResearchActivity> entities) {
		organisationUnitResearchActivityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnitResearchActivity> save(Iterable<OrganisationUnitResearchActivity> entities) {
		return organisationUnitResearchActivityCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnitResearchActivity save(OrganisationUnitResearchActivity entity) {
		return organisationUnitResearchActivityCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnitResearchActivity> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return organisationUnitResearchActivityCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
