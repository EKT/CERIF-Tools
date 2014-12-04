package gr.ekt.cerif.services.link.person;

import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.second.Prize;
/**
 * A repository for links between persons and prizes.
 * 
 */
public interface LinkPersonPrizeRepository {

	public void delete(Person_Prize entity); 
	
	public void delete(Iterable<Person_Prize> entities); 

	public Iterable<Person_Prize> save(Iterable<Person_Prize> entities); 
	
	public Person_Prize save(Person_Prize entity);
	
	List<Person_Prize> findByPerson(Person person);
	
	List<Person_Prize> findByPrize(Prize prize);
	
}
