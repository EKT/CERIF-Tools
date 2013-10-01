package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_DublinCore;

/**
 * A repository for links between persons and dublinCorees.
 * 
 */
public interface LinkPersonDublinCoreRepository {

	public void delete(Person_DublinCore entity); 
	
	public void delete(Iterable<Person_DublinCore> entities); 

	public Iterable<Person_DublinCore> save(Iterable<Person_DublinCore> entities); 
	
	public Person_DublinCore save(Person_DublinCore entity);
	
}
