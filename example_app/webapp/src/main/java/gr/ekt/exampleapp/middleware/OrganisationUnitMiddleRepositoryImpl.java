/**
 * 
 */
package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.OrganisationView;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class OrganisationUnitMiddleRepositoryImpl implements OrganisationUnitMiddleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(OrganisationUnitMiddleRepositoryImpl.class);
	
	@Autowired
	private OrganisationUnitCrudMiddleRepository organisationUnitMiddleCrudRepository;

	public List<OrganisationView> findAllOrganisations() {
		return organisationUnitMiddleCrudRepository.findAllOrganisations();
	}

	public OrganisationView findOrganisationById(Long Id) {
		return organisationUnitMiddleCrudRepository.findOrganisationById(Id);
	}

	public List<OrganisationView> findOrganisationByProjectIdAndClassScheme(
			Long id, String classSchemeUUID) {
		return organisationUnitMiddleCrudRepository.findOrganisationByProjectIdAndClassScheme(id, classSchemeUUID);
	}

	public List<OrganisationView> findOrganisationByPersonIdAndClassScheme(
			Long id, String classSchemeUUID) {
		return organisationUnitMiddleCrudRepository.findOrganisationByPersonIdAndClassScheme(id, classSchemeUUID);
	}
	
}
