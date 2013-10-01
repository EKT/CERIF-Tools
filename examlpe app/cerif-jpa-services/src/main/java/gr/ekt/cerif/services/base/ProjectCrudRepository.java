package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.transferobjects.ProjectView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ProjectCrudRepository extends CrudRepository<Project, Long> {

public Project findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from gr.ekt.cerif.entities.base.Project p where p.id = ?1")
	public Project findById(Long id);
	

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Project> findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.ProjectView(" +
			   "       pr.id,    	 			" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       ab.abstractText,    			" +
			   "       pr.startDate,    	 	" +
			   "       pr.endDate)    	 		" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  left join pr.projectAbstracts ab 		" +
			   "  order by pr.acronym               ")
	List<ProjectView> findAllProjects();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.ProjectView(" +
			   "       pr.id,    	 			" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       ab.abstractText,    			" +
			   "       pr.startDate,    	 	" +
			   "       pr.endDate)    	 		" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  left join pr.projectAbstracts ab 		" +
			   "  where pr.id = ?1 		" )
	ProjectView findProjectById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.ProjectView(" +
				   "       pr.id,				" +
				   "       t.title,				" +
				   "       clt.term)   			" +
				   "  from OrganisationUnit ou 	" +   
				   "  left join ou.projects prs " +	
				   "  left join prs.project pr  " +
				   "  left join pr.projectTitles t 	" +
				   "  join prs.theClass cl 		" +
				   "  join cl.scheme sch 		" +
				   "  left join cl.terms clt  	" +
				   "  join clt.language l  		" +
				   "  where ou.id = ?1 and sch.uri = ?2 AND l.code = 'en' ")
	List<ProjectView> findProjectByOrganisationIdAndClassScheme(Long id, String classSchemeUri);
		
}
