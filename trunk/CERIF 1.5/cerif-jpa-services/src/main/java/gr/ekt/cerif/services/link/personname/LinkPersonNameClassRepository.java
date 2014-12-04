package gr.ekt.cerif.services.link.personname;

import java.util.List;

import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;

public interface LinkPersonNameClassRepository {
	
	void delete(PersonName_Class entity); 
	
	void delete(Iterable<PersonName_Class> entities); 

	Iterable<PersonName_Class> save(Iterable<PersonName_Class> entities); 
	
	PersonName_Class save(PersonName_Class entity);
	
	List<PersonName_Class> findByPersonName(PersonName personName);
	
	List<PersonName_Class> findBytheClass(Class theClass);

}
