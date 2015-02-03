package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_DublinCore;

@Component
public class LinkPersonDublinCoreRepositoryImpl implements
		LinkPersonDublinCoreRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonDublinCoreRepositoryImpl.class);
	
	@Autowired
	private LinkPersonDublinCoreCrudRepository linkPersonDublinCoreCrudRepository;

	@Override
	public void delete(Person_DublinCore entity) {
		linkPersonDublinCoreCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_DublinCore> entities) {
		linkPersonDublinCoreCrudRepository.save(entities);
	}

	@Override
	public Iterable<Person_DublinCore> save(Iterable<Person_DublinCore> entities) {
		return linkPersonDublinCoreCrudRepository.save(entities);
	}

	@Override
	public Person_DublinCore save(Person_DublinCore entity) {
		return linkPersonDublinCoreCrudRepository.save(entity);
	}

}
