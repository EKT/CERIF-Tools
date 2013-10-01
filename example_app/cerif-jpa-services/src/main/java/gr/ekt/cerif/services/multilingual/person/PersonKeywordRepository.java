package gr.ekt.cerif.services.multilingual.person;

import gr.ekt.cerif.features.multilingual.PersonKeyword;

public interface PersonKeywordRepository {
	
	public void delete(PersonKeyword entity); 
	
	public void delete(Iterable<PersonKeyword> entities); 

	public Iterable<PersonKeyword> save(Iterable<PersonKeyword> entities); 
	
	public PersonKeyword save(PersonKeyword entity);

}
