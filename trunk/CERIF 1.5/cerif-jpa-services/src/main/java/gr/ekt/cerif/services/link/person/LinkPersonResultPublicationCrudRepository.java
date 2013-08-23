package gr.ekt.cerif.services.link.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonResultPublicationCrudRepository extends CrudRepository<Person_ResultPublication, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_ResultPublication> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select persrespub from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = ?1 and persrespubcl.uri= ?2 ")
	List<Person_ResultPublication> findByResPublIdAndClassSchemeUri(Long respubId, String persrespubclUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select persrespub from Person_ResultPublication persrespub "+
			"  where persrespub.id = ?1 " )
	Person_ResultPublication findByPersonResPublId(Long persrespubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select persrespub from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.person pers " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = ?1 and persrespubcl.uri= ?2 "+
			"  and pers.id= ?3 ")
	Person_ResultPublication findByResPublIdAndClassSchemeAndPersonId(Long respubId, String persrespubclUri, Long persId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select pers.id from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.person pers " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = ?1 and persrespubcl.uri= ?2 ")
	List<Long> findPersonIdsByResPublIdAndClassUri(Long respubId, String persrespubclUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select persrespub from Person_ResultPublication persrespub "+
			"  left join persrespub.resultPublication respub " +
			"  where respub.id = ?1 ")
	List<Person_ResultPublication> findByResPublId(Long respubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select persrespub from Person_ResultPublication persrespub "+
			"  left join persrespub.person per " +
			"  left join persrespub.theClass persrespubcl " +
			"  where per.id = ?1 and persrespubcl.uri= ?2 ")
	List<Person_ResultPublication> findByPersonIdAndClassUri(Long personId, String persrespubclUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = " select persrespub from Person_ResultPublication persrespub "+
			"  left join persrespub.resultPublication respubl " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respubl.id = ?1 and persrespubcl.uri= ?2 ")
	List<Person_ResultPublication> findByResPublIdAndClassUri(Long resPublId, String persrespubclUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select prp from Person_ResultPublication prp "+
			"  left join prp.theClass prpcl "+
		    "  join prp.resultPublication rp "+
			"  join prp.person p "+
			"  where p.id = ?1 and rp.id=?2  and prpcl.uri!='Favourite'")
	Person_ResultPublication findByPersonIdAndResultPublicationId(Long PerId, Long ResId);
	
}
