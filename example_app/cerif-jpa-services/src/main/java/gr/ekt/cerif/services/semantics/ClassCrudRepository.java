package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.transferobjects.ClassView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassCrudRepository extends CrudRepository<Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Class findById(Long id);
    
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Class> findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Class> findByScheme(ClassScheme scheme);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.ClassView(" +
			   "       ct.term)        		" +
			   "  from Project p   			" +
			   "  left join p.projects_classes pc	" +
			   "  left join pc.theClass c	" +
			   "  join c.scheme s			" +
			   "  left join c.terms ct  	" +
			   "  join ct.language l  		" +
			   "  where p.id= ?1 and s.uri= ?2 AND l.code = 'en' ")
	List<ClassView> findClassByProjectIdAndClassScheme(Long id, String classSchemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.ClassView(" +
			   "       clt.term)        		" +
			   "  from OrganisationUnit ou  " +
			   "  left join ou.classes cls 	" +	
			   "  join cls.theClass cl	 	" +	
			   "  join cl.scheme sch 		" +
			   "  left join cl.terms clt  	" +
			   "  join clt.language l  		" +
			   "  where ou.id = ?1 and sch.uri = ?2 AND l.code = 'en' ")
	List<ClassView> findClassByOrganisationIdAndClassScheme(Long id, String classSchemeUri);	
	
}
