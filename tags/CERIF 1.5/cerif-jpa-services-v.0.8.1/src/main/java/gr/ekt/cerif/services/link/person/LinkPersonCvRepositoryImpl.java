package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.features.semantics.Class;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonCvRepositoryImpl implements LinkPersonCvRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonCvRepositoryImpl.class);
	
	@Autowired
	private LinkPersonCvCrudRepository linkPersonCvCrudRepository;
	
	@Transactional
	public Person_Cv save(Person_Cv entity) {
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

	@Override
	public List<Person_Cv> findByCv(CV cv) {
		return linkPersonCvCrudRepository.findByCv(cv);
	}
	
}
