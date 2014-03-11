/**
 * 
 */
package gr.ekt.cerif.services.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.services.GenericSuperRepository;


/**
 * A repository for persons.
 * 
 */
public interface PersonRepository {

	Person findPersonById(Long id);
	
	Person findPersonName(String familyNames);
	
	Person findPersonByOtherName(String otherNames);
	
	Object findPersonNameByPersonId(Long id);
	
	void delete(Person entity);
	
	void delete(Iterable<Person> entities);
	
	Iterable<Person> save(Iterable<Person> entities);
	
	Person save(Person entity);
	
	public GenericSuperRepository getPersonGenericRepository();
	
	public void setPersonGenericRepository(GenericSuperRepository personGenericRepository);
	
	Iterable<Person> findAll();
	
	Page<Person> findAll(Pageable page);

	
}
