package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Qualification;

/**
 * A repository for links between persons and qualifications.
 * 
 */
public interface LinkPersonQualificationRepository {

	public void delete(Person_Qualification entity); 
	
	public void delete(Iterable<Person_Qualification> entities); 

	public Iterable<Person_Qualification> save(Iterable<Person_Qualification> entities); 
	
	public Person_Qualification save(Person_Qualification entity);
	
}
