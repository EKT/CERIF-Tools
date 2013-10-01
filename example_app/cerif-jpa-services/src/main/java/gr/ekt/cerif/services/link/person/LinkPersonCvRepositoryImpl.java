package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.CVRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonCvRepositoryImpl implements LinkPersonCvRepository {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CVRepository cvRepository;
	
	@Autowired
	private LinkPersonCvCrudRepository linkPersonCvCrudRepository;
	
	@Transactional
	public Person_Cv save(Person_Cv entity) {
		if (entity.getPerson() == null || entity.getCv() == null) {
			throw new IllegalArgumentException("Please provide both a person and a cv.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getCv().getId() == null) {
			cvRepository.save(entity.getCv());
		}
		return linkPersonCvCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Person_Cv> save(Iterable<Person_Cv> entityList) {
		return linkPersonCvCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(Person_Cv entity) {
		linkPersonCvCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Person_Cv> entityList) {
		linkPersonCvCrudRepository.delete(entityList);
	}

	public List<Person_Cv> findByPerson(Person person) {
		return linkPersonCvCrudRepository.findByPerson(person);
	}

	public List<Person_Cv> findByPersonAndTheClass(Person person, Class theClass) {
		return linkPersonCvCrudRepository.findByPersonAndTheClass(person, theClass);
	}

	@Override
	public Person_Cv findPersonCVByPersonIdAndClassId(Long personId,
			Long theClassId) {
		return linkPersonCvCrudRepository.findPersonCVByPersonIdAndClassId(personId, theClassId);
	}

	@Override
	public Person_Cv findPersonCVByPersonIdAndClassUri(Long personId,
			String theClassUri) {
		return linkPersonCvCrudRepository.findPersonCVByPersonIdAndClassUri(personId, theClassUri);
	}
	
}
