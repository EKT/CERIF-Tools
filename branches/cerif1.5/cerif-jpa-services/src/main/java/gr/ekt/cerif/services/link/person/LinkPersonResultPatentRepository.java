package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_ResultPatent;

/**
 * A repository for links between persons and result patents.
 * 
 */
public interface LinkPersonResultPatentRepository {

	public void delete(Person_ResultPatent entity); 
	
	public void delete(Iterable<Person_ResultPatent> entities); 

	public Iterable<Person_ResultPatent> save(Iterable<Person_ResultPatent> entities); 
	
	public Person_ResultPatent save(Person_ResultPatent entity);
	
}
