package gr.ekt.cerif.services.result;

import java.util.Date;
import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.base.ProjectView;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.PersonResultPublicationView;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.ProjectResultPublicationView;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublicationMediumView;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublicationView;
import gr.ekt.cerif.entities.second.EventView;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.ClassView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPublicationCrudRepository extends CrudRepository<ResultPublication, Long> {

	ResultPublication findByUri(String uri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,				" +
			   "       respubt.title,			" +
			   "       respuba.abstractText,	" +
			   "       respubk.keyword,			" +
			   "       cl.uri,					" +
			   "       respub.uri,				" +
			   "       respub.date)				" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublicationTitles respubt		" +
			   "  left join respub.resultPublicationAbstracts respuba	" +
			   "  left join respub.resultPublicationKeywords respubk	" +
			   "  left join respub.resultPublications_classes respubc	" +
			   "  left join respubc.theClass cl							" +
			   "  where respub.id = ?1 group by respub.id")
	ResultPublicationView findViewById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	respubm.medium " +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublications_medium respubm	" +
			   "  left join respubm.theClass respubmcl	" +
			   "  where respub.id = ?1 and respubmcl.uri='Document Cover' ")
	Medium findCoverById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.ProjectView(	" +
			   "       proj.id,					" +
			   "       proj.acronym)			" +
			   "  from ResultPublication respub 									" +			   
			   "  join respub.projects_resultPublications prrespub				" +
			   "  join prrespub.project proj									" +		   
			   "  where respub.id = ?1	   											")
	List<ProjectView> findProjectsById(Long id);
		
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView(	" +
			   "       org.id,			" +
			   "       orgname.name,	" +
			   "       respub.id,		" +
			   "       orgrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +			   
			   "  where respub.id = ?1 and orgrespubclsch.uri='documentsource'    	")
	OrganisationUnitResultPublicationView findDocumentSourceById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView(	" +
			   "       org.id,			" +
			   "       orgname.name,	" +
			   "       respub.id,		" +
			   "       orgrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +			   
			   "  where orgrespubclsch.uri='documentsource'    	")
	List<OrganisationUnitResultPublicationView> findAllDocumentSourcesForResultPubl();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView(	" +
			   "       org.id,			" +
			   "       orgname.name,	" +
			   "       respub.id,		" +
			   "       orgrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +			   
			   "  where respub.id = ?1 and orgrespubclsch.uri<>'documentsource'    	")
	List<OrganisationUnitResultPublicationView> findOrganisationsById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView(	" +
			   "       org.id,			" +
			   "       orgname.name,	" +
			   "       respub.id,		" +
			   "       orgrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  where respub.id = ?1											")
	List<OrganisationUnitResultPublicationView> findAllOrganisationsById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView(	" +
			   "       org.id,			" +
			   "       orgname.name,	" +
			   "       respub.id,		" +
			   "       orgrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +			   
			   "  where orgrespubclsch.uri<>'documentsource'    	")
	List<OrganisationUnitResultPublicationView> findAllOrganisationsForResultPubl();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView(	" +
			   "       org.id,			" +
			   "       orgname.name,	" +
			   "       respub.id,		" +
			   "       orgrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch")
	List<OrganisationUnitResultPublicationView> findOrganisationsForResultPubl();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.person.PersonResultPublicationView(	" +
			   "       per.id,			" +
			   "       pername.firstNames,	" +
			   "       pername.familyNames,	" +
			   "       respub.id,		" +
			   "       perrespubcl.uri)	" +
			   "  from ResultPublication respub 									" +			   
			   "  left join respub.persons_resultPublications perrespub	" +
			   "  left join perrespub.person per							" +
			   "  left join per.personName pername  						" +
			   "  left join perrespub.theClass perrespubcl							" +
			   "  left join perrespubcl.scheme perrespubclsch						" +			   
			   "  where respub.id = ?1 and perrespubclsch.uri='pers_respubl' order by perrespub.startDate desc  	")
	List<PersonResultPublicationView> findPersonsById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.result.ResultPublicationView( " +
			   "	   respub.id,			" +
			   "       respubt.title,		" +
			   "       respubk.keyword,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublicationTitles respubt		" +
			   "  left join respub.resultPublicationKeywords respubk	" +
			   "  group by respub.id ")
	List<ResultPublicationView> findAllViews();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.result.ResultPublicationView( " +
			   "	   respub.id,			" +
			   "       respubt.title,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublicationTitles respubt		" +
			   "  left join respub.persons_resultPublications persrespubl	" +
			   "  left join persrespubl.person pers	" +
			   "  left join persrespubl.theClass persrespublcl	" +
			   "  where pers.id = ?1 and persrespublcl.uri='Favourite'	" +
			   "  group by respub.id ")
	List<ResultPublicationView> findFavouriteResPubl(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.result.ResultPublicationView( " +
			   "	   respub.id,			" +
			   "       respubt.title,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublicationTitles respubt		" +
			   "  left join respub.persons_resultPublications persrespubl	" +
			   "  left join persrespubl.person pers	" +
			   "  left join persrespubl.theClass persrespublcl	" +
			   "  left join persrespublcl.scheme persrespublsch	" +
			   "  where pers.id = ?1 and persrespublcl.uri='Creator' and persrespublsch.uri='ldap' " +
			   "  group by respub.id ")
	List<ResultPublicationView> findMyUploads(Long id);
	   
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select respub from ResultPublication respub "+
			"  where respub.id = ?1")
	ResultPublication findById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from ResultPublication respub "+
		    "  join respub.persons_resultPublications rpp "+
		    "  left join rpp.theClass rppcl "+
			"  join rpp.person p "+
			"  where respub.id = ?1 and rppcl.uri!='Favourite'")
	Person findPersonById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select prp from Person_ResultPublication prp "+
			"  left join prp.theClass prpcl "+
		    "  join prp.resultPublication rp "+
			"  join prp.person p "+
			"  where p.id = ?1 and rp.id=?2  and prpcl.uri!='Favourite'")
	Person_ResultPublication findByPersonIdAndResultPublicationId(Long PerId, Long ResId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select ou from ResultPublication respub "+
		    "  join respub.organisationUnit_resultPublications ourp "+
			"  join ourp.organisationUnit ou "+
			"  where respub.id = ?1")
	OrganisationUnit findOrganisationUnitById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select ourp from OrganisationUnit_ResultPublication ourp "+
		    "  join ourp.resultPublication rp "+
			"  join ourp.organisationUnit ou "+
			"  where ou.id = ?1 and rp.id=?2 ")
	OrganisationUnit_ResultPublication findByOrganisationUnitIdAndResultPublicationId(Long ouId, Long resId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select pr from ResultPublication respub "+
		    "  join respub.projects_resultPublications prrp "+
			"  join prrp.project pr "+
			"  where respub.id = ?1")
	Project findProjectById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select prrp from Project_ResultPublication prrp "+
		    "  join prrp.resultPublication rp "+
			"  join prrp.project pr "+
			"  where pr.id = ?1 and rp.id=?2 ")
	Project_ResultPublication findByProjectIdAndResultPublicationId(Long prId, Long resId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       cl.uri,									" +
			   "       respub.id,									" +
			   "	   rpt.title)									" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublicationTitles rpt 		" +
			   "  left join respub.persons_resultPublications rpp 	" +
			   "  left join rpp.person p 							" +
			   "  left join rpp.theClass cl							" +
			   "  where p.id = ?1")
	List<ResultPublicationView> findResPublByPersonId(Long id);	
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.link.result.ResultPublicationMediumView(	" +
			   "       rpm.medium)									" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublications_medium rpm 	" +
			   "  where respub.id = ?1")
	List<ResultPublicationMediumView> findResPublMediumByResPubId(Long id);	
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       rppcl.uri,									" +
			   "       respub.id,									" +
			   "	   rpt.title)									" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublicationTitles rpt 		" +
			   "  left join respub.projects_resultPublications rpp 	" +
			   "  left join rpp.project p 							" +
			   "  left join rpp.theClass rppcl						" +
			   "  where p.id = ?1 and rppcl.uri='N/A' ")
	List<ResultPublicationView> findByProjectId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,			" +
			   "       respubt.title,		" +
			   "       respubk.keyword,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 									" +
			   "  left join respub.resultPublicationTitles respubt					" +
			   "  left join respub.resultPublicationKeywords respubk				" +
			   "  left join respub.projects_resultPublications prrespub				" +
			   "  left join prrespub.project proj 									" +
			   "  where proj.id = ?1")
	List<ResultPublicationView> findAllViewsByProjectId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,			" +
			   "       respubt.title,		" +
			   "       respubk.keyword,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 									" +
			   "  left join respub.resultPublicationTitles respubt					" +
			   "  left join respub.resultPublicationKeywords respubk				" +
			   "  left join respub.resultPublications_events rpeve				" +
			   "  left join rpeve.event eve 									" +
			   "  where eve.id = ?1")
	List<ResultPublicationView> findAllViewsByEventId(Long Id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p.id, count(respub)						" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.projects_resultPublications rpp 	" +
			   "  left join rpp.project p 							" +
			   "  join respub.resultPublicationTitles rpt 			" +
			   "  group by p")
	List<Object[]> countByProjectId();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       cl.uri,									" +
			   "	   respub.id,									" +
			   "	   rpt.title)									" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublicationTitles rpt 		" +
			   "  left join respub.organisationUnit_resultPublications rpo 	" +
			   "  left join rpo.theClass cl   	 	" +
			   "  left join rpo.organisationUnit o 							" +
			   "  where o.id = ?1")
	List<ResultPublicationView> findByOrganisationUnitId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       cl.uri,									" +
			   "	   respub.id,									" +
			   "	   rpt.title)									" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublicationTitles rpt 		" +
			   "  left join respub.resultPublications_events rpe 	" +
			   "  left join rpe.theClass cl   	 	" +
			   "  left join rpe.event ev 							" +
			   "  where ev.id = ?1")
	List<ResultPublicationView> findByEventId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,										" +
			   "	   spm.medium,										" +
			   "	   cl.uri)										" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublications_medium spm 	" +
			   "  left join spm.theClass cl 						" +
			   "  where respub.id = ?1")
	List<ResultPublicationView> findByResultPublicationId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select new gr.ekt.cerif.entities.link.result.ResultPublicationMediumView(	" +
			   "       spm.medium,										" +
			   "	   respub.id,										" +
			   "	   cl.uri)										" +
			   "  from ResultPublication respub 					" +
			   "  left join respub.resultPublications_medium spm 	" +
			   "  left join spm.theClass cl 						")
	List<ResultPublicationMediumView> findAllFiles();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.link.project.ProjectResultPublicationView(	" +
			   "       proj.id,				" +
			   "       proj.acronym,		" +
			   "       respub.id)			" +
			   "  from ResultPublication respub 								" +			   
			   "  join respub.projects_resultPublications prrespub				" +
			   "  join prrespub.project proj									")
	List<ProjectResultPublicationView> findAllProjects();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.link.person.PersonResultPublicationView(	" +
			   "       per.id,			" +
			   "       pername.firstNames,	" +
			   "       pername.familyNames,	" +
			   "       respub.id,		" +
			   "       perrespubcl.uri)	" +
			   "  from ResultPublication respub 							" +			   
			   "  join respub.persons_resultPublications perrespub			" +
			   "  join perrespub.person per									" +
			   "  join per.personName pername  								" +
			   "  left join perrespub.theClass perrespubcl					" +
			   "  left join perrespubcl.scheme perrespubclsch				" +			   
			   "  where perrespubclsch.uri='pers_respubl'    	")
	List<PersonResultPublicationView> findAllPersons();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       cl.uri, cl.id)        	" +
			   "  from ResultPublication respub  "+
			   "  left join respub.resultPublications_classes respubcl "+
			   "  join respubcl.theClass  cl "+
			   "  join cl.scheme sch  		" +
			   "  where respub.id=?1 and sch.uri = ?2")
	List<ClassView> findClassByResPublIdAndScheme(Long id, String classSchemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       cl.uri, cl.id)        	" +
			   "  from ResultPublication respub  "+
			   "  left join respub.resultPublications_classes respubcl "+
			   "  join respubcl.theClass  cl "+
			   "  where respub.id=?1 and cl.uri = 'Non Visible' ")
	ClassView findVisibilityByResPublId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.second.EventView(" +
			   "       ev.id,  "+
			   "       evnames.name)   "+
			   "  from ResultPublication respub  "+
			   "  left join respub.resultPublications_events respubev "+
			   "  left join respubev.event ev "+
			   "  left join ev.names evnames  	" +
			   "  where respub.id=?1")
	List<EventView> findEventByResPubId(Long id);
		
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select respubev" +
			   "  from ResultPublication respub  "+
			   "  left join respub.resultPublications_events respubev "+
			   "  where respub.id=?1")
	ResultPublication_Event findResPublEventByResPublId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select prti.title, p.id, count(respub)						" +
			   "  from ResultPublication respub 					" +
			   "  join respub.projects_resultPublications rpp 	" +
			   "  left join rpp.project p 							" +
			   "  left join p.projectTitles prti        			" +
			   "  group by p order by prti.title asc")
	List<Object[]> countByProject();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select prti.title, p.id, count(respub)						" +
			   "  from ResultPublication respub 					" +
			   "  join respub.projects_resultPublications rpp 	" +
			   "  left join rpp.project p 							" +
			   "  left join p.projectTitles prti        			" +
			   "  where respub.id not in ("+
			   "  select res.id from ResultPublication res "+
			   "  left join res.resultPublications_classes resc	" +
			   "  left join resc.theClass c			" +
			   "  where c.uri='Unpublished') "+
			   "  group by p order by prti.title asc")
	List<Object[]> countByProjectPublished();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select evena.name, eve.id, count(respub)						" +
			   "  from ResultPublication respub 					" +
			   "  join respub.resultPublications_events rpeve 	" +
			   "  left join rpeve.event eve 							" +
			   "  left join eve.names evena        			" +
			   "  group by eve order by evena.name asc")
	List<Object[]> countByEvent();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select evena.name, eve.id, count(respub)						" +
			   "  from ResultPublication respub 					" +
			   "  join respub.resultPublications_events rpeve 	" +
			   "  left join rpeve.event eve 							" +
			   "  left join eve.names evena        			" +
			   "  where respub.id not in ("+
			   "  select res.id from ResultPublication res "+
			   "  left join res.resultPublications_classes resc	" +
			   "  left join resc.theClass c			" +
			   "  where c.uri='Unpublished') "+
			   "  group by eve order by evena.name asc")
	List<Object[]> countByEventPublished();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select respub.date, count(respub) 	" +
			   "  from ResultPublication respub     	" +
			   "  where respub.date is not null group by respub.date order by respub.date asc")
	List<Object[]> countByYear();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select respub.date, count(respub) 	" +
			   "  from ResultPublication respub     	" +
			   "  where respub.date is not null and respub.id not in ("+
			   "  select res.id from ResultPublication res "+
			   "  left join res.resultPublications_classes resc	" +
			   "  left join resc.theClass c			" +
			   "  where c.uri='Unpublished') "+
			   "  group by respub.date order by respub.date asc")
	List<Object[]> countByYearPublished();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,			" +
			   "       respubt.title,		" +
			   "       respubk.keyword,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 									" +
			   "  left join respub.resultPublicationTitles respubt					" +
			   "  left join respub.resultPublicationKeywords respubk				" +
			   "  where respub.date = ?1")
	List<ResultPublicationView> findAllViewsByYear(Date date);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select cl.uri, cl.id, count(respub) 						" +
			   "  from ResultPublication respub     					" +		
			   "  left join respub.resultPublications_classes respubc	" +
			   "  left join respubc.theClass cl							" +
			   "  left join cl.scheme sch							" +
			   "  where sch.uri='respubltype' group by cl.uri order by cl.uri asc ")
	List<Object[]> countByType();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select cl.uri, cl.id, count(respub) 						" +
			   "  from ResultPublication respub     					" +		
			   "  left join respub.resultPublications_classes respubc	" +
			   "  left join respubc.theClass cl							" +
			   "  left join cl.scheme sch							" +
			   "  where sch.uri='respubltype' and respub.id not in ("+
			   "  select res.id from ResultPublication res "+
			   "  left join res.resultPublications_classes resc	" +
			   "  left join resc.theClass c			" +
			   "  where c.uri='Unpublished') "+
			   "  group by cl.uri order by cl.uri asc ")
	List<Object[]> countByTypePublished();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,			" +
			   "       respubt.title,		" +
			   "       respubk.keyword,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublicationTitles respubt		" +
			   "  left join respub.resultPublicationKeywords respubk	" +
			   "  left join respub.resultPublications_classes respubc	" +
			   "  left join respubc.theClass cl							" +
			   "  where cl.id = ?1")
	List<ResultPublicationView> findAllViewsByType(Long typeId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select orgname.name, org.id, count(respub), orgcl.uri 						" +
			   "  from ResultPublication respub     					" +		
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +
			   "  left join org.classes orgcles							" +
			   "  left join orgcles.theClass orgcl       	" +
			   "  where orgrespubclsch.uri='documentsource' group by orgname order by orgname.name asc ")
	List<Object[]> countBySource();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select orgname.name, org.id, count(respub), orgcl.uri 						" +
			   "  from ResultPublication respub     					" +		
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +
			   "  left join org.classes orgcles							" +
			   "  left join orgcles.theClass orgcl       	" +
			   "  where orgrespubclsch.uri='documentsource' and respub.id not in ("+
			   "  select res.id from ResultPublication res "+
			   "  left join res.resultPublications_classes resc	" +
			   "  left join resc.theClass c			" +
			   "  where c.uri='Unpublished') group by orgname order by orgname.name asc ")
	List<Object[]> countBySourcePublished();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
			   "       respub.id,			" +
			   "       respubt.title,		" +
			   "       respubk.keyword,		" +
			   "       respub.date) 	" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublicationTitles respubt		" +
			   "  left join respub.resultPublicationKeywords respubk	" +
			   "  left join respub.resultPublications_classes respubc	" +
			   "  left join respub.organisationUnit_resultPublications orgrespub	" +
			   "  left join orgrespub.organisationUnit org							" +
			   "  left join org.organisationUnitNames orgname  						" +
			   "  left join orgrespub.theClass orgrespubcl							" +
			   "  left join orgrespubcl.scheme orgrespubclsch						" +
			   "  where orgrespubclsch.uri='documentsource' AND org.id = ?1 group by respub")
	List<ResultPublicationView> findAllViewsBySource(Long sourceId);		
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select respubcls									" +
			   "  from ResultPublication respub 						" +
			   "  left join respub.resultPublications_classes respubcls	" +
			   "  left join respubcls.theClass cl						" +
			   "  left join cl.scheme scheme							" +
			   "  where scheme.uri=?1 and respub.id=?2")
	ResultPublication_Class findResPubClassBySchemeUriAndResPubId(String schemeUri, Long respubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select per										" +
			   "  from ResultPublication respub 							" +
			   "  left join respub.persons_resultPublications persrespubl	" +
			   "  left join persrespubl.person per						" +
			   "  left join persrespubl.theClass cl						" +
			   "  left join cl.scheme scheme							" +
			   "  where scheme.uri='ldap' and cl.uri='Creator' and respub.id=?1")
	Person findCreatorByResPubId(Long respubId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.result.ResultPublicationView( " +
			   "	   respub.id,		" +
			   "       per.id)			" +
			   "  from ResultPublication respub 							" +
			   "  left join respub.persons_resultPublications persrespubl	" +
			   "  left join persrespubl.person per						" +
			   "  left join persrespubl.theClass cl						" +
			   "  left join cl.scheme scheme							" +
			   "  where scheme.uri='ldap' and cl.uri='Creator'			" +
			   "  group by respub.id ")
	List<ResultPublicationView> findAllCreatorResPub();

}
