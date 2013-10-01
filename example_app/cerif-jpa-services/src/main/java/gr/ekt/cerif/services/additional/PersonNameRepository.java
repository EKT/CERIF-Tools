package gr.ekt.cerif.services.additional;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.additional.PersonName;

public interface PersonNameRepository {
	
	List<PersonName> findByPerson(Person person);
	
	List<PersonName> findPersonNamesByPersonId(Long id);
	
	public void delete(PersonName entity); 
	
	public void delete(Iterable<PersonName> entities); 

	public Iterable<PersonName> save(Iterable<PersonName> entities); 
	
	public PersonName save(PersonName entity);

}
