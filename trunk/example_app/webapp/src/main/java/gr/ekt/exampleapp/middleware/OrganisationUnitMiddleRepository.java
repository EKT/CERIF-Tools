package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.OrganisationView;

import java.util.List;

public interface OrganisationUnitMiddleRepository {

	List<OrganisationView> findAllOrganisations();
	
	OrganisationView findOrganisationById(Long Id);
	
	List<OrganisationView> findOrganisationByProjectIdAndClassScheme(Long id, String classSchemeUUID);
	
	List<OrganisationView> findOrganisationByPersonIdAndClassScheme(Long id, String classSchemeUUID);
	
}
