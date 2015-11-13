package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.person.Person_Equipment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonEquipmentCrudRepository extends CrudRepository<Person_Equipment, Long> {
	
	List<Person_Equipment> findByPerson(Person person);
	
	List<Person_Equipment> findByEquipment(Equipment equipment);

}
