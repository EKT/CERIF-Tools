package gr.ekt.exampleapp.middleware;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.exampleapp.transferobjects.PersonView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudMiddleRepository extends CrudRepository<Person, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.PersonView(" +
				   "       per.id,				" +
				   "       name.firstNames,			" +
				   "       name.familyNames)   	" +
				   "  from Person per 	" +   
				   "  left join per.personNames_persons pernames " +
				   "  left join pernames.personName name " +
				   "  order by name.familyNames               ")
	List<PersonView> findAllPersons();

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.PersonView(" +
					"       per.id,				" +
					"       name.firstNames,			" +
					"       name.familyNames,   	" +
					"       clt.term)   	" +
				   "  from OrganisationUnit org 			" +   
				   "  left join org.persons_organisationUnits pers " +
				   "  left join pers.person per " +
				   "  left join per.personNames_persons pernames " +
				   "  left join pernames.personName name " +
				   "  join pers.theClass cl 		" +
				   "  join cl.scheme sch 		" +
				   "  left join cl.classTerms clt  	" +
				   "  join clt.language l  		" +
				   "  where org.id = ?1 and sch.uuid = ?2 AND l.code = 'en' ")
	List<PersonView> findPersonByOrganisationIdAndClassScheme(Long id, String classSchemeUUID);
}
