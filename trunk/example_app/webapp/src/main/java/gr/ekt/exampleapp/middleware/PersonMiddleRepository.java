package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.PersonView;

import java.util.List;

/**
 * A repository for persons.
 * 
 */
public interface PersonMiddleRepository {
	
	List<PersonView> findAllPersons();
	
	List<PersonView> findPersonByOrganisationIdAndClassScheme(Long id, String classSchemeUUID);

}
