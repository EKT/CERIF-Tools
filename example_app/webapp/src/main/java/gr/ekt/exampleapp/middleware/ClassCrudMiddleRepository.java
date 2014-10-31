package gr.ekt.exampleapp.middleware;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.exampleapp.transferobjects.ClassView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassCrudMiddleRepository extends CrudRepository<Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.ClassView(" +
			   "       clt.term)        		" +
			   "  from Project p   			" +
			   "  left join p.projects_classes pc	" +
			   "  left join pc.theClass c	" +
			   "  join c.scheme s			" +
			   "  left join c.classTerms clt  	" +
			   "  join clt.language l  		" +
			   "  where p.id = ?1 and s.uuid = ?2 AND l.code = 'en' ")
	List<ClassView> findClassByProjectIdAndClassScheme(Long id, String classSchemeUUID);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.ClassView(" +
			   "       clt.term)        		" +
			   "  from OrganisationUnit ou  " +
			   "  left join ou.organisationUnits_classes cls 	" +	
			   "  join cls.theClass cl	 	" +	
			   "  join cl.scheme sch 		" +
			   "  left join cl.classTerms clt  	" +
			   "  join clt.language l  		" +
			   "  where ou.id = ?1 and sch.uuid = ?2 AND l.code = 'en' ")
	List<ClassView> findClassByOrganisationIdAndClassScheme(Long id, String classSchemeUUID);
	
}
