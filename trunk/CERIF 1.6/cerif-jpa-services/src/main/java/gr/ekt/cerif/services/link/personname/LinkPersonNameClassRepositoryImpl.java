package gr.ekt.cerif.services.link.personname;

import gr.ekt.cerif.entities.link.PersonName_Class;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkPersonNameClassRepositoryImpl implements LinkPersonNameClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonNameClassRepositoryImpl.class);
	
	@Autowired
	private LinkPersonNameClassCrudRepository linkPersonNameClassCrudRepository;

	@Override
	public void delete(PersonName_Class entity) {
		linkPersonNameClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PersonName_Class> entities) { 
		linkPersonNameClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PersonName_Class> save(Iterable<PersonName_Class> entities) {
		return linkPersonNameClassCrudRepository.save(entities);
	}

	@Override
	public PersonName_Class save(PersonName_Class entity) {
		return linkPersonNameClassCrudRepository.save(entity);
	}

	@Override
	public List<PersonName_Class> findByPersonName(PersonName personName) {
		return linkPersonNameClassCrudRepository.findByPersonName(personName);
	}

	@Override
	public List<PersonName_Class> findBytheClass(Class theClass) {
		return linkPersonNameClassCrudRepository.findBytheClass(theClass);
	}

}
