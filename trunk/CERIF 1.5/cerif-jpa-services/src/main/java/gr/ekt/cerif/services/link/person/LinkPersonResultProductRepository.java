package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for links between persons and result products.
 * 
 */
public interface LinkPersonResultProductRepository {

	public void delete(Person_ResultProduct entity); 
	
	public void delete(Iterable<Person_ResultProduct> entities); 

	public Iterable<Person_ResultProduct> save(Iterable<Person_ResultProduct> entities); 
	
	public Person_ResultProduct save(Person_ResultProduct entity);
	
	List<Person_ResultProduct> findByPerson(Person person);
	
	List<Person_ResultProduct> findByResultProduct(ResultProduct resultProduct);
	
}
