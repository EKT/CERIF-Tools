package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_Equipment;

@Component
public class LinkPersonEquipmentRepositoryImpl implements
		LinkPersonEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkPersonEquipmentCrudRepository linkPersonEquipmentCrudRepository;

	@Override
	public void delete(Person_Equipment entity) {
		linkPersonEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Equipment> entities) {
		linkPersonEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_Equipment> save(Iterable<Person_Equipment> entities) {
		return linkPersonEquipmentCrudRepository.save(entities);
	}

	@Override
	public Person_Equipment save(Person_Equipment entity) {
		return linkPersonEquipmentCrudRepository.save(entity);
	}

}
