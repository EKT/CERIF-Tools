package gr.ekt.exampleapp.middleware;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.exampleapp.transferobjects.ProjectView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ProjectCrudMiddleRepository extends CrudRepository<Project, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.ProjectView(" +
			   "       pr.id,    	 			" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       ab.abstractText,    			" +
			   "       pr.startDate,    	 	" +
			   "       pr.endDate)    	 		" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  left join pr.projectAbstracts ab 	" +
			   "  left join t.language lt  		" +
			   "  left join ab.language lab  		" +
			   "  where lt.code = 'en' and (lab.code is null or lab.code = 'en')  " +
			   "  order by pr.acronym ")
	List<ProjectView> findAllProjects();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.ProjectView(" +
			   "       pr.id,    	 			" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       ab.abstractText,    			" +
			   "       pr.startDate,    	 	" +
			   "       pr.endDate)    	 		" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  left join pr.projectAbstracts ab 		" +
			   "  left join t.language lt  		" +
			   "  left join ab.language lab  		" +
			   "  where pr.id = ?1 and lt.code = 'en' and (lab.code is null or lab.code = 'en')	" )
	ProjectView findProjectById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.ProjectView(" +
				   "       pr.id,				" +
				   "       t.title,				" +
				   "       clt.term)   			" +
				   "  from OrganisationUnit ou 	" +   
				   "  left join ou.projects_organisationUnits prs " +	
				   "  left join prs.project pr  " +
				   "  left join pr.projectTitles t 	" +
				   "  join prs.theClass cl 		" +
				   "  join cl.scheme sch 		" +
				   "  left join cl.classTerms clt  	" +
				   "  join clt.language l  		" +
				   "  where ou.id = ?1 and sch.uuid = ?2 AND l.code = 'en' ")
	List<ProjectView> findProjectByOrganisationIdAndClassScheme(Long id, String classSchemeUUID);


}
