package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_Prize;

@Component
public class LinkPersonPrizeRepositoryImpl implements LinkPersonPrizeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonPrizeRepositoryImpl.class);
	
	@Autowired
	private LinkPersonPrizeCrudRepository linkPersonPrizeCrudRepository;

	@Override
	public void delete(Person_Prize entity) {
		linkPersonPrizeCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<Person_Prize> entities) {
		linkPersonPrizeCrudRepository.save(entities);
	}

	@Override
	public Iterable<Person_Prize> save(Iterable<Person_Prize> entities) {
		return linkPersonPrizeCrudRepository.save(entities);
	}

	@Override
	public Person_Prize save(Person_Prize entity) {
		return linkPersonPrizeCrudRepository.save(entity);
	}

}
