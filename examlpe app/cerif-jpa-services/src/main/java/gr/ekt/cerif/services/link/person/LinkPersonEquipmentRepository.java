package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Equipment;

/**
 * A repository for links between persons and equipments.
 * 
 */
public interface LinkPersonEquipmentRepository {

	public void delete(Person_Equipment entity); 
	
	public void delete(Iterable<Person_Equipment> entities); 

	public Iterable<Person_Equipment> save(Iterable<Person_Equipment> entities); 
	
	public Person_Equipment save(Person_Equipment entity);
	
}
