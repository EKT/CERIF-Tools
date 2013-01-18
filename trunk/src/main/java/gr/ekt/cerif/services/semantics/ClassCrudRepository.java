package gr.ekt.cerif.services.semantics;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.features.semantics.ClassView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassCrudRepository extends CrudRepository<Class, Long> {

	Class findById(Long id);
    
	List<Class> findByUri(String uri);
	
	List<Class> findByScheme(ClassScheme scheme);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       c.uri)        " +
			   "  from Facility f    " +
			   "  join f.classes fc  " +
	   	       "  join fc.theClass c  " +
	   	       "  join c.scheme s  " +
			   " where s.uri = ?1 AND f.id = ?2 ")
	List<ClassView> findByFacilityAndClassScheme(String classSchemeUri, Long FacilityId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       c.uri)        " +
			   "  from Facility f    " +
			   "  join f.facilities_fundings funds  " +
			   "  join funds.funding fund  " +
			   "  join fund.classes fc  " +
			   "  join fc.theClass c  " +
	   	       "  join c.scheme s  " +
			   " where s.uri = ?1 AND f.id = ?2 ")
	List<ClassView> findByFacilityAndFundingClassScheme(String classSchemeUri, Long FacilityId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       c.uri)        " +
			   "  from Facility f    				" +
			   "  join f.facilities_fundings funds  " +
			   "  join funds.theClass c  			" +
	   	       "  join c.scheme s  		 			" +
			   " where s.uri = ?1 AND f.id = ?2 ")
	List<ClassView> findByFacilityAndLinkFacilityFundingClassScheme(String classSchemeUri, Long FacilityId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       c.uri, c.id)        	" +
			   "  from Class c    		" +
			   "  join c.scheme s  		" +
			   "  where s.uri = ?1		"+
			   "  order by c.uri ASC ")
	List<ClassView> findByClassScheme(String classSchemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       ct.term, c.id)        				" +
			   "  from Class c    							" +
			   "  join c.scheme s  							" +
			   "  join c.terms ct  							" +
			   "  join ct.language l  						" +
			   "  where s.uri = ?1 AND l.code = 'en'		" +
			   "  order by c.uri ASC ")
	List<ClassView> findTermByClassScheme(String classSchemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c        	" +
			   "  from Class c    		" +
			   "  join c.scheme s  		" +
			   "  where c.uri = ?1 AND s.uri = ?2		")
	Class findByClassAndClassScheme(String classUri, String classSchemeUri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       c.uri)        	" +
			   "  from Class c    		" +
			   "  join c.projects_classes pcl  			" +
			   "  join pcl.project pr  					" +
			   "  join c.scheme s  						" +
			   "  where pr.id = ?1 AND s.uri = ?2		")
	List<ClassView> findByProjectIdAndClassScheme(Long id, String classSchemeUri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri						" +
			   "  from Class c							" +
			   "  join c.projects_classes pcl  			" +
			   "  join pcl.project pr  					" +
			   "  join c.scheme s  						" +
			   "  where pr.id = ?1 AND s.uri = ?2		")
	List<String> findTermsByProjectIdAndClassScheme(Long id, String classSchemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "Select c from gr.ekt.cerif.features.semantics.Class c" +
            "  join c.scheme s          " +
            "  where s.uri = ?1 AND c.uri = ?2        ")
	Class findByClassSchemeAndClass(String classSchemeUri, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       cl.uri)										" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublications_classes respubcls	" +
			   "  left join respubcls.theClass cl						" +
			   "  left join cl.scheme scheme							" +
			   "  where scheme.uri=?1 and respub.id=?2")
	ClassView findClassViewBySchemeUriAndResPubId(String schemeUri, Long respubId);
	
	Class findOne(Long id);
	
//	@Query(value="Select c from gr.ekt.cerif.features.semantics.Class c join c.organisationUnits_classes org_cl join org_cl.organisationUnit org where org=?1")
//	Class findByOrganisationUnit(OrganisationUnit organisation);
	
}
