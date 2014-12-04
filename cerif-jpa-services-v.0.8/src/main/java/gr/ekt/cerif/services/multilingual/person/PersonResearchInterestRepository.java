package gr.ekt.cerif.services.multilingual.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

public interface PersonResearchInterestRepository {

	public PersonResearchInterest save(PersonResearchInterest entity);

	public Iterable<PersonResearchInterest> save(Iterable<PersonResearchInterest> entities);
	
	public void delete(PersonResearchInterest entity);
	
	public void delete(Iterable<PersonResearchInterest> entities);
	
	List<PersonResearchInterest> findByPerson(Person person);
}
