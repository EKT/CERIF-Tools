package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Measurement;

/**
 * A repository for links between persons and measurements.
 * 
 */
public interface LinkPersonMeasurementRepository {

	public void delete(Person_Measurement entity); 
	
	public void delete(Iterable<Person_Measurement> entities); 

	public Iterable<Person_Measurement> save(Iterable<Person_Measurement> entities); 
	
	public Person_Measurement save(Person_Measurement entity);
	
}
