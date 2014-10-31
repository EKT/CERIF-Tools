package gr.ekt.cerif.services.link.person;

import java.util.List;


import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between persons and fundings.
 * 
 */
public interface LinkPersonFundingRepository {

	public void delete(Person_Funding entity); 
	
	public void delete(Iterable<Person_Funding> entities); 

	public Iterable<Person_Funding> save(Iterable<Person_Funding> entities); 
	
	public Person_Funding save(Person_Funding entity);
	
	List<Person_Funding> findByFunding(Funding funding);
	
	List<Person_Funding> findByPerson(Person person);
	
}
