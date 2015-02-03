package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

@Component
public class LinkPersonIndicatorRepositoryImpl implements
		LinkPersonIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkPersonIndicatorCrudRepository linkPersonIndicatorCrudRepository;

	@Override
	public void delete(Person_Indicator entity) {
		linkPersonIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Indicator> entities) {
		linkPersonIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_Indicator> save(Iterable<Person_Indicator> entities) {
		return linkPersonIndicatorCrudRepository.save(entities);
	}

	@Override
	public Person_Indicator save(Person_Indicator entity) {
		return linkPersonIndicatorCrudRepository.save(entity);
	}

	@Override
	public List<Person_Indicator> findByIndicator(Indicator indicator) {
		return linkPersonIndicatorCrudRepository.findByIndicator(indicator);
	}

	@Override
	public List<Person_Indicator> findByPerson(Person person) {
		return linkPersonIndicatorCrudRepository.findByPerson(person);
	}

}
