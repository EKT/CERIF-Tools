package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Funding;

/**
 * A repository for links between persons and fundings.
 * 
 */
public interface LinkPersonFundingRepository {

	public void delete(Person_Funding entity); 
	
	public void delete(Iterable<Person_Funding> entities); 

	public Iterable<Person_Funding> save(Iterable<Person_Funding> entities); 
	
	public Person_Funding save(Person_Funding entity);
	
}
