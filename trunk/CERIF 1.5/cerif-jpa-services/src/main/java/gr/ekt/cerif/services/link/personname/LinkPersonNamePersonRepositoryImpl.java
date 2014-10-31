package gr.ekt.cerif.services.link.personname;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.features.additional.PersonName;

@Component
public class LinkPersonNamePersonRepositoryImpl implements LinkPersonNamePersonRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonNamePersonRepositoryImpl.class);
	
	@Autowired
	private LinkPersonNamePersonCrudRepository linkPersonNamePersonCrudRepository;

	@Override
	public void delete(PersonName_Person entity) {
		linkPersonNamePersonCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PersonName_Person> entities) {
		linkPersonNamePersonCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PersonName_Person> save(Iterable<PersonName_Person> entities) {
		return linkPersonNamePersonCrudRepository.save(entities);
	}

	@Override
	public PersonName_Person save(PersonName_Person entity) {
		return linkPersonNamePersonCrudRepository.save(entity);
	}

	@Override
	public List<PersonName_Person> findByPersonName(PersonName personName) {
		return linkPersonNamePersonCrudRepository.findByPersonName(personName);
	}

	@Override
	public List<PersonName_Person> findByPerson(Person person) {
		return linkPersonNamePersonCrudRepository.findByPerson(person);
	}

}
