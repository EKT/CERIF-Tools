package gr.ekt.cerif.services.multilingual.person;

import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

public interface PersonResearchInterestRepository {

	public PersonResearchInterest save(PersonResearchInterest entity);

	public Iterable<PersonResearchInterest> save(Iterable<PersonResearchInterest> entities);
	
	public void delete(PersonResearchInterest entity);
	
	public void delete(Iterable<PersonResearchInterest> entities);
}
