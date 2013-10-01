package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Prize;
/**
 * A repository for links between persons and prizes.
 * 
 */
public interface LinkPersonPrizeRepository {

	public void delete(Person_Prize entity); 
	
	public void delete(Iterable<Person_Prize> entities); 

	public Iterable<Person_Prize> save(Iterable<Person_Prize> entities); 
	
	public Person_Prize save(Person_Prize entity);
	
}
