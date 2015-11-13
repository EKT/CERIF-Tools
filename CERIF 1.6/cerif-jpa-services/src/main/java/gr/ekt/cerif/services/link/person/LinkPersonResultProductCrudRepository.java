package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonResultProductCrudRepository extends CrudRepository<Person_ResultProduct, Long> {
	
	List<Person_ResultProduct> findByPerson(Person person);
	
	List<Person_ResultProduct> findByResultProduct(ResultProduct resultProduct);

}
