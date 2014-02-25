package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

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

	@Override
	public List<Person_ResultProduct> findByPerson(Person person) {
		return linkPersonResultProductCrudRepository.findByPerson(person);
	}

	@Override
	public List<Person_ResultProduct> findByResultProduct(
			ResultProduct resultProduct) {
		return linkPersonResultProductCrudRepository.findByResultProduct(resultProduct);
	}

}
