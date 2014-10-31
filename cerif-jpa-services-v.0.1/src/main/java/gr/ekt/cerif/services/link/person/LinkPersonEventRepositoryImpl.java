package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.second.Event;

@Component
public class LinkPersonEventRepositoryImpl implements LinkPersonEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonEventRepositoryImpl.class);
	
	@Autowired
	private LinkPersonEventCrudRepository linkPersonEventCrudRepository;

	@Override
	public void delete(Person_Event entity) {
		linkPersonEventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Event> entities) {
		linkPersonEventCrudRepository.save(entities);
	}

	@Override
	public Iterable<Person_Event> save(Iterable<Person_Event> entities) {
		return linkPersonEventCrudRepository.save(entities);
	}

	@Override
	public Person_Event save(Person_Event entity) {
		return linkPersonEventCrudRepository.save(entity);
	}

	@Override
	public List<Person_Event> findByPerson(Person person) {
		return linkPersonEventCrudRepository.findByPerson(person);
	}

	@Override
	public List<Person_Event> findByEvent(Event event) {
		return linkPersonEventCrudRepository.findByEvent(event);
	}

}
