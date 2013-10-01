package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_ResultProduct;

@Component
public class LinkPersonResultProductRepositoryImpl implements
		LinkPersonResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonResultProductRepositoryImpl.class);
	
	@Autowired
	private LinkPersonResultProductCrudRepository linkPersonResultProductCrudRepository;

	@Override
	public void delete(Person_ResultProduct entity) {
		linkPersonResultProductCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_ResultProduct> entities) {
		linkPersonResultProductCrudRepository.save(entities);
	}

	@Override
	public Iterable<Person_ResultProduct> save(
			Iterable<Person_ResultProduct> entities) {
		return linkPersonResultProductCrudRepository.save(entities);
	}

	@Override
	public Person_ResultProduct save(Person_ResultProduct entity) {
		return linkPersonResultProductCrudRepository.save(entity);
	}

}
