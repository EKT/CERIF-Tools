package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_CurriculumVitae;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonCurriculumVitaeRepositoryImpl implements LinkPersonCurriculumVitaeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonCurriculumVitaeRepositoryImpl.class);
	
	@Autowired
	private LinkPersonCurriculumVitaeCrudRepository linkPersonCvCrudRepository;
	
	@Transactional
	public Person_CurriculumVitae save(Person_CurriculumVitae entity) {
		return linkPersonCvCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Person_CurriculumVitae> save(Iterable<Person_CurriculumVitae> entityList) {
		return linkPersonCvCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(Person_CurriculumVitae entity) {
		linkPersonCvCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Person_CurriculumVitae> entityList) {
		linkPersonCvCrudRepository.delete(entityList);
	}

	public List<Person_CurriculumVitae> findByPerson(Person person) {
		return linkPersonCvCrudRepository.findByPerson(person);
	}

	public List<Person_CurriculumVitae> findByPersonAndTheClass(Person person, Class theClass) {
		return linkPersonCvCrudRepository.findByPersonAndTheClass(person, theClass);
	}

	@Override
	public Person_CurriculumVitae findPersonCVByPersonIdAndClassId(Long personId,
			Long theClassId) {
		return linkPersonCvCrudRepository.findPersonCVByPersonIdAndClassId(personId, theClassId);
	}

	@Override
	public Person_CurriculumVitae findPersonCVByPersonIdAndClassUri(Long personId,
			String theClassUri) {
		return linkPersonCvCrudRepository.findPersonCVByPersonIdAndClassUri(personId, theClassUri);
	}

	@Override
	public List<Person_CurriculumVitae> findByCurriculumVitae(CurriculumVitae curriculumVitae) {
		return linkPersonCvCrudRepository.findByCurriculumVitae(curriculumVitae);
	}
	
}
