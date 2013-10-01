package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_ResultPatent;

@Component
public class LinkPersonResultPatentRepositoryImpl implements LinkPersonResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonResultPatentRepositoryImpl.class);
	
	@Autowired
	private LinkPersonResultPatentCrudRepository linkPersonResultPatentCrudRepository;

	@Override
	public void delete(Person_ResultPatent entity) {
		linkPersonResultPatentCrudRepository.save(entity);		
	}

	@Override
	public void delete(Iterable<Person_ResultPatent> entities) {
		linkPersonResultPatentCrudRepository.save(entities);		
	}

	@Override
	public Iterable<Person_ResultPatent> save(
			Iterable<Person_ResultPatent> entities) {
		return linkPersonResultPatentCrudRepository.save(entities);
	}

	@Override
	public Person_ResultPatent save(Person_ResultPatent entity) {
		return linkPersonResultPatentCrudRepository.save(entity);
	}

}
