/**
 * 
 */
package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.additional.PersonName;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for personNames.
 * 
 */
public interface PersonNameCrudRepository extends CrudRepository<PersonName, Long> {
	
	public List<PersonName> findAll();
	
	public Page<PersonName> findAll(Pageable page);
	
	public PersonName findById(Long id);
	
	@Query(value = "select new gr.ekt.cerif.features.additional.PersonName(" +
				   "       name.firstNames,				" +
				   "       name.familyNames,			" +
				   "       name.otherNames)   	" +
				   "  from Person per 	" +   
				   "  left join per.personNames_persons pernames " +
				   "  left join pernames.personName name " +
				   "  where per.id = ?1	" +
				   "  order by name.familyNames               ")
	public List<PersonName> findAllNamesByPersonId(Long id);
	
	@Query("select pn from PersonName pn join pn.personNames_persons pnp join pnp.person per where per=?1")
	public List<PersonName> findByPerson(Person person);

}
