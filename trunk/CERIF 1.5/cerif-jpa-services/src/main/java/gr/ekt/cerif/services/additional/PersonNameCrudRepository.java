/**
 * 
 */
package gr.ekt.cerif.services.additional;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for personNames.
 * 
 */
public interface PersonNameCrudRepository extends CrudRepository<PersonName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PersonName> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<PersonName> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public PersonName findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
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

}
