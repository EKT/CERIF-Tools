package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.second.Qualification;

@Component
public class LinkPersonQualificationRepositoryImpl implements LinkPersonQualificationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonQualificationRepositoryImpl.class);
	
	@Autowired
	private LinkPersonQualificationCrudRepository linkPersonQualificationCrudRepository;

	@Override
	public void delete(Person_Qualification entity) {
		linkPersonQualificationCrudRepository.save(entity);		
	}

	@Override
	public void delete(Iterable<Person_Qualification> entities) {
		linkPersonQualificationCrudRepository.save(entities);		
	}

	@Override
	public Iterable<Person_Qualification> save(
			Iterable<Person_Qualification> entities) {
		return linkPersonQualificationCrudRepository.save(entities);
	}

	@Override
	public Person_Qualification save(Person_Qualification entity) {
		return linkPersonQualificationCrudRepository.save(entity);
	}

	@Override
	public List<Person_Qualification> findByPerson(Person person) {
		return linkPersonQualificationCrudRepository.findByPerson(person);
	}

	@Override
	public List<Person_Qualification> findByQualification(
			Qualification qualification) {
		return linkPersonQualificationCrudRepository.findByQualification(qualification);
	}

}
