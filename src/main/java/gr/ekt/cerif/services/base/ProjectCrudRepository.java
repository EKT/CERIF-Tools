package gr.ekt.cerif.services.base;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.base.ProjectList;
import gr.ekt.cerif.entities.base.ProjectView;
import gr.ekt.cerif.entities.link.project.Project_Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ProjectCrudRepository extends CrudRepository<Project, Long> {

public Project findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from gr.ekt.cerif.entities.base.Project p where p.id = ?1")
	public Project findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       c.uri,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  left join pr.projects_classes pc 	" +
			   "  join pc.theClass c 				" +
			   "  join c.scheme s	 				" +
			   "  where s.uri = 'domain'            " +
			   "  order by pr.acronym               ")
	List<ProjectList> findAllProjects();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  order by pr.acronym               ")
	List<ProjectList> findAllProjectsWithNoDomainClass();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +   
			   "  left join pr.projectTitles t 		" +
			   "  left join pr.persons persproj 		" +
			   "  left join persproj.person pers 		" +
			   "  left join persproj.theClass persprojcl 	" +
			   "  where persprojcl.uri = 'Favourite' and pers.id=?1   " +
			   "  order by pr.acronym               ")
	List<ProjectList> findAllProjectsWithNoDomainClassFavourite(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       c.uri,    	 			" +   			   
			   "       pr.id)   				" +
			   "  from Project pr 				" +   
			   "  left join pr.projects_classes pc 		" +
			   "  left join pc.theClass c 				" +
			   "  left join c.scheme s	 				" +
			   "  where s.uri = 'domain'            	" +
			   "  order by pr.acronym               	")
	List<ProjectList> findAllProjectsWithDomainClass();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       c.uri,    	 			" +   			   
			   "       pr.id)   				" +
			   "  from Project pr 				" +   
			   "  left join pr.projects_classes pc 		" +
			   "  left join pc.theClass c 				" +
			   "  left join c.scheme s	 				" +
			   "  left join pr.persons persproj 		" +
			   "  left join persproj.person pers 		" +
			   "  left join persproj.theClass persprojcl 	" +
			   "  where s.uri = 'domain' and persprojcl.uri = 'Favourite' and pers.id=?1 	" +
			   "  order by pr.acronym               	")
	List<ProjectList> findAllProjectsWithDomainClassFavourite(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectView(" +
			   "       pr.id,    	 			" +
			   "       pr.acronym,    			" +
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       t.title,   				" +
			   "       pr.uri,   				" +
			   "       fu.acronym,				" +
			   "       pa.abstractText) 	    " +
			   "  from Project pr 								" +   
			   "  left join pr.projectTitles t 					" +
			   "  left join pr.projects_fundings prfu			" +
			   "  left join prfu.funding fu 					" +
			   "  left join pr.projectAbstracts pa				" +
			   "  where pr.id=?1" )
	ProjectView findProjectById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectView(" +
			   "       pr.id,    	 					" +
			   "       pr.acronym,    					" +
			   "       t.title,							" +
			   "	   oucl.uri) 				    	" +
			   "  from Project pr 						" +
			   "  join pr.projectTitles t 				" +
			   "  left join pr.organisationUnits po 	" +
			   "  left join po.organisationUnit o 		" +
			   "  left join po.theClass oucl 			" +
			   "  where o.id=?1" )
	List<ProjectView> findByOrgUnitId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectView(" +
			   "       pr.id,    	 					" +
			   "       pr.acronym,    					" +
			   "       t.title,							" +
			   "	   oucl.uri) 				    	" +
			   "  from Project pr 						" +
			   "  join pr.projectTitles t 				" +
			   "  left join pr.organisationUnits po 	" +
			   "  left join po.organisationUnit o 		" +
			   "  left join po.theClass oucl 			" +
			   "  where o.id=?1 and oucl.uri=?2" )
	List<ProjectView> findByOrgUnitId(Long id, String organisationStatus);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 					" +
			   "       pr.acronym) 				    	" +
			   "  from Person p    				" +
			   "  join p.projects prs 				" +
			   "  join prs.project pr 				" +
			   "  where p.id=?1" )
	List<ProjectList> findByPersonId(Long id);

	public List<Project> findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pr.id, pr.acronym 	" +
			   "  from Project pr    			" +			   
			   "  where pr.acronym like ?1" )
	List<Object[]> findByStartingAcronym(String term);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pr.id, pr.acronym			" +
				"  from Project pr    					" +
			   	"  where pr.id=?1							")
	Object[] findProjByIdForAjax(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select projpers from Project_Person projpers "+
			"  left join projpers.person per 	" +
			"  left join projpers.project proj 	" +
			"  left join per.personName pername	" +
			"  left join projpers.theClass cl  " +
		    "  where cl.uri = 'Favourite' and proj.id=?1 and pername.otherNames=?2 ")
	Project_Person isProjectFavourite(Long id, String username);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct c.uri, c.uri, count(p) 	" +
			   "  from Project p   			" +
			   "  join p.projects_classes pc		 	" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri='domain' " +
				" group by c order by c.uri asc      ")
	List<Object[]> countByScientificDomain();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       c.uri,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +
			   "  join pr.projectTitles t 				" +
			   "  join pr.projects_classes pc 		" +
			   "  join pc.theClass c 				" +
			   "  join c.scheme s	 				" +
			   "  where c.uri = ?1  		          	" +
			   "  and s.uri='domain' " +
			   "  order by pr.acronym               	")
	List<ProjectList> findProjectsWithDomainClass(String domainClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct c.uri, c.uri, count(p) 	" +
			   "  from Project p   			" +
			   "  join p.projects_classes pc		 	" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri='activity' " +
				" group by c order by c.uri asc   ")
	List<Object[]> countByActivity();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       c.uri,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +
			   "  join pr.projectTitles t 				" +
			   "  join pr.projects_classes pc 		" +
			   "  join pc.theClass c 				" +
			   "  join c.scheme s	 				" +
			   "  where c.uri = ?1  		          	" +
			   "  and s.uri='activity' " +
			   "  order by pr.acronym               	")
	List<ProjectList> findProjectsWithActivity(String activity);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct c.uri, c.uri, count(p) 	" +
			   "  from Project p   			" +
			   "  join p.projects_classes pc		 	" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri='maincategory' " +
				" group by c order by c.uri asc  ")
	List<Object[]> countByMainCategory();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       c.uri,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +
			   "  join pr.projectTitles t 				" +
			   "  join pr.projects_classes pc 		" +
			   "  join pc.theClass c 				" +
			   "  join c.scheme s	 				" +
			   "  where c.uri = ?1  		          	" +
			   "  and s.uri='maincategory' " +
			   "  order by pr.acronym               	")
	List<ProjectList> findProjectsWithMainCategory(String mainCategory);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct c.uri, c.uri, count(p) 	" +
			   "  from Project p   			" +
			   "  join p.projects_classes pc		 	" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri='actionline' " +
				" group by c order by c.uri asc          ")
	List<Object[]> countByActionLine();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       c.uri,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 				" +
			   "  join pr.projectTitles t 				" +
			   "  join pr.projects_classes pc 		" +
			   "  join pc.theClass c 				" +
			   "  join c.scheme s	 				" +
			   "  where c.uri = ?1  		          	" +
			   "  and s.uri='actionline' " +
			   "  order by pr.acronym               	")
	List<ProjectList> findProjectsWithActionLine(String actionLine);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct co.uri, co.code, count(pr)" +
			   "  from Project pr 					" +   
			   "  join pr.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +			   
			   "  where prou.theClass.uri='Coordinator' " +
			   " group by co order by co.uri asc ")
	List<Object[]> countByCoordinatorCountry();
	
	/*For Visualisations*/
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select pr.acronym,pr.startDate,pr.endDate,c.uri, names.name, co.uri,co.code, prou.theClass.uri"+
			 "  from Project pr 					" +  
			  "  join pr.projects_classes pc	"+
			   "  join pr.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +			   
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +
			   " join ou.organisationUnitNames names" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri='domain' "
			)
	List<Object[]> countAnalyticProjectsByCountryVisualisation();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct co.uri, co.code, count(pr)" +
			   "  from Project pr 					" +   
			   "  join pr.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +			   
			   "  where prou.theClass.uri=?1 " +
			   " group by co ")
	List<Object[]> countProjectsByCountryVisualisation(String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct co.uri, c.uri, c.uri, count(p) 	" +
			   "  from Project p   			" +
			   "  join p.projects_classes pc		 	" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  join p.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +	
			   "  where s.uri='domain' " +
				" group by co,c                ")
	List<Object[]> countProjectsByScientificDomainVisualisation();
	/*End Visualisations*/
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select distinct new gr.ekt.cerif.entities.base.ProjectList(" +
			   "       pr.id,    	 			" +   			   
			   "       pr.startDate,    	 	" +
			   "       pr.endDate,    	 		" +
			   "       pr.acronym,    			" +
			   "       t.title,   				" +
			   "       c.uri,   				" +
			   "       pr.uri)   				" +
			   "  from Project pr 					" +
			   "  join pr.projectTitles t 			" +
			   "  join pr.projects_classes pc 		" +
			   "  join pc.theClass c 				" +
			   "  join pr.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +			   
			   "  where prou.theClass.uri='Coordinator' " +
			   "  and co.code= ?1  		          	" +
			   " group by pr " +
			   "  order by pr.acronym  ")
	List<ProjectList> findProjectsWithCoordinatorCountry(String countryCode);
	
}
