package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between persons and cvs.
 * 
 */
public interface LinkPersonCvRepository {

	Person_Cv save(Person_Cv entity);
	
	Person_Cv findPersonCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	Person_Cv findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri);
	
	Iterable<Person_Cv> save(Iterable<Person_Cv> entityList);
	
	void delete(Person_Cv entity);
	
	void delete(Iterable<Person_Cv> entityList);
	
	List<Person_Cv> findByPerson(Person person);
	
	List<Person_Cv> findByPersonAndTheClass(Person person, Class theClass);
	
}
