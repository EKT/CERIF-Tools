package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.PersonList;
import gr.ekt.cerif.entities.base.PersonView;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, String> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from Person p where p.id = ?1")
	Person findPersonById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from Person p join p.personName pn where pn.familyNames = ?1")
	Person findPersonName(String familyNames);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select p	" +
			   "  from Person p    		 	" +
			   "  left join p.personName pn		" +
			   " where pn.otherNames = ?1            ")
	Person findPersonByOtherName(String otherNames);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       pn.familyNames   " +
			   "  from Person p    						 	" +
			   "  join p.personName pn		 				" +
			   " where p.id = ?1                            ")
	Object findPersonNameByPersonId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pn	" +
			   "  from Person p    		 	" +
			   "  join p.personName pn		" +
			   " where p.id = ?1            ")
	PersonName findPersonNamesByPersonId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.PersonView("+
			   "  persname.familyNames, persrespub.startDate)	" +
			   "  from Person_ResultPublication persrespub    		 	" +
			   "  left join persrespub.person pers " +
			   "  left join pers.personName persname " +
			   "  left join persrespub.resultPublication respub " +
			   "  left join persrespub.theClass persrespubcl " +
			   "  where respub.id = ?1 and persrespubcl.uri='Last Editor' "+
			   "  order by persrespub.startDate desc ")
	List<PersonView> findLastEditorNamesByResPubId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pers.id	" +
			"  from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.person pers " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = ?1 and persrespubcl.uri=?2")
	List<Long> findPersonIdsByResPubIdAndLinkClass(Long id, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pn	" +
			"  from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.person pers " +
			"  join pers.personName pn		" +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = ?1 and persrespubcl.uri=?2")
	List<PersonName> findPersonNamesByResPubIdAndLinkClass(Long id, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   			" +
			   "       pn.firstNames,	" +
			   "       ea.uri,			" +
			   "       pa.addressLine2)	" +
			   "  from Person p    	 							" +
			   "  join p.personName pn		 					" +
			   "  join p.projects prs		 					" +
			   "  join prs.project pr		 					" +
			   "  join prs.theClass tcl		 					" +
			   "  join tcl.scheme sch       					" +
			   "  left join p.persons_electronicAddresses pea	" +
			   "  left join pea.electronicAddress ea       		" +
			   "  left join p.persons_postalAddresses ppa       " +
			   "  left join ppa.postalAddress pa       			" +
			   " where pr.id = ?1                             	")
	List<PersonList> findByProjectId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   " +
			   "       pn.firstNames,		" +
			   "       pn.familyNames,		" +
			   "       ea.uri,   			" +
			   "       pa.addressLine2)   	" +
			   "  from Person p    	 " +
			   "  join p.personName pn		 " +
			   "  join p.projects prs		 " +
			   "  join prs.project pr		 " +
			   "  join prs.theClass tcl		 " +
			   "  join tcl.scheme sch       " +
			   "  left join p.persons_electronicAddresses pea		 	" +
			   "  left join pea.electronicAddress ea       				" +
			   "  left join p.persons_postalAddresses ppa       		" +
			   "  left join ppa.postalAddress pa       					" +
			   " where pr.id = ?3 and tcl.uri=?2 and sch.uri=?1 group by p.id        ")
	List<PersonList> findByProjPersClassSchemeAndProjPersClassAndProjectId(String schemeUri, String classUri, Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   " +
			   "       pn.familyNames,		" +
			   "       ea.uri,   			" +
			   "       pa.addressLine2)   	" +
			   "  from Person p    	 								" +
			   "  join p.personName pn		 						" +
			   "  join p.persons_organisationUnits po		 		" +
			   "  join po.theClass pocl		 		" +
			   "  join po.organisationUnit o		 				" +
			   "  join o.classes oc		 							" +
			   "  join oc.theClass c		 						" +
			   "  join c.scheme s       							" +
			   "  left join p.persons_electronicAddresses pea		" +
			   "  left join pea.electronicAddress ea       			" +
			   "  left join p.persons_postalAddresses ppa       	" +
			   "  left join ppa.postalAddress pa       				" +
			   " where s.uri = ?1 and c.uri=?2 and pocl.uri!='Favourite' 	")
	List<PersonList> findByOrgUnitClassSchemeAndOrgUnitClass(String schemeUri, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   				" +
			   "       pn.familyNames,		" +
			   "       ea.uri,   			" +
			   "       pa.addressLine2,   	" +
			   "       c.uri,				" +
			   "	   ona.name)			" +
			   "  from Person p    	 								" +
			   "  join p.personName pn		 						" +
			   "  join p.persons_organisationUnits po		 		" +
			   "  join po.organisationUnit o		 				" +
			   "  join po.theClass pocl		 		" +
			   "  join o.organisationUnitNames ona	 				" +
			   "  join o.classes oc		 							" +
			   "  join oc.theClass c		 						" +
			   "  join c.scheme s       							" +
			   "  left join p.persons_electronicAddresses pea		" +
			   "  left join pea.electronicAddress ea       			" +
			   "  left join p.persons_postalAddresses ppa       	" +
			   "  left join ppa.postalAddress pa       				" +
			   " where s.uri = ?1 and pocl.uri!='Favourite'	")
	List<PersonList> findByOrgUnitClassScheme(String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.PersonView(	" +
			   "       p.id,    	 					" +
			   "       n.familyNames,					" +
			   "	   ea.uri) 				   			" +
			   "  from Person p 							" +
			   "  join p.personName n 						" +
			   "  left join p.persons_organisationUnits po 	" +
			   "  left join po.organisationUnit o 			" +	
			   "  left join p.classes pc		 			" +
			   "  left join pc.theClass c					" +
			   "  left join p.persons_electronicAddresses pea		" +
		       "  left join pea.electronicAddress ea       			" +
		       "  left join po.theClass pocl       			" +
			   "  where c.uri != 'RI NCP Network Members' and o.id=?1 and pocl.uri!='Favourite' group by p.id" )
	List<PersonView> findByOrgUnitId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonView(	" +
			   "       pn.familyNames,    	 			" +
			   "       p.id,							" +
			   "	   ea.uri,    	 					" +
			   "       pa.addressLine2,					" +
			   "	   pa.addressLine1,					" +
			   "	   cou.uri)							" +		   
			   "  from Person p								" +
			   "  left join p.personName pn					" +			
			   "  left join p.persons_organisationUnits po  " +
			   "  left join po.theClass poc  				" +
			   "  left join po.organisationUnit o  			" +	
			   "  left join p.persons_electronicAddresses pea		" +
		       "  left join pea.electronicAddress ea       			" +
		       "  left join p.persons_postalAddresses ppa       	" +
			   "  left join ppa.postalAddress pa       				" +
			   "  left join pa.country cou       					" +
			   "  where o.id=?1 and poc.uri =?2 group by p.id	")
	List<PersonView> findByOrgUnitIdAndPersOrgRole(Long id, String role);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   				" +
			   "       pn.familyNames,		" +
			   "       c.uri,				" +
			   "	   ona.name)			" +			   
			   "  from Person p    	 								" +
			   "  join p.personName pn		 						" +			   
			   "  join p.persons_organisationUnits po		 		" +
			   "  left join po.theClass poc  				" +
			   "  join po.organisationUnit o		 				" +
			   "  join o.organisationUnitNames ona	 				" +			 
			   "  left join o.classes oc		 					" +
			   "  join oc.theClass c		 						" +
			   "  join c.scheme s       							" +
			   "  where c.uri = ?1 and poc.uri!='Favourite'			")
	List<PersonList> findByPolicyType(String PolicyType);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       pn.firstNames,   				" +
			   "       pn.familyNames,   				" +
			   "       p.id,   				" +
			   "       p.id)		" +			   
			   "  from Person p				" +
			   "  join p.personName pn		" +
			   "  order by pn.familyNames   ")
	List<PersonList> findAllPersons();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       pn.firstNames,   				" +
			   "       p.id,   				" +
			   "       pn.familyNames)		" +			   
			   "  from Person p						" +
			   "  join p.personName pn				" +
			   "  left join p.classes pc		 	" +
			   "  left join pc.theClass c			" +
			   "  where c.uri = ?1					")
	List<PersonList> findAllByStakeholderCat(String stakeholderCat);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       coun.uri,				" +
			   "       p.id,   					" +
			   "       pn.firstNames,   		" +
			   "       pn.familyNames,   		" +
			   "       ona.name,   				" +
			   "       ou.id)					" +		   
			   "  from Person p									" +
			   "  join p.personName pn							" +
			   "  join p.classes pc		 						" +
			   "  join pc.theClass c							" +
			   "  left join p.persons_organisationUnits pou	  	" +
			   "  left join pou.theClass poucl	  	" +
			   "  left join pou.organisationUnit ou       	   	" +
			   "  left join ou.organisationUnitNames ona      	" +

			   "  left join ou.postalAddresses oupas       		" +
			   "  left join oupas.postalAddress pa2       	   	" +
			   "  left join pa2.country coun       	   		    " +

			   "  where c.uri = 'Programme Committee members' and poucl.uri!='Favourite' group by p.id")
	List<PersonList> findAllProgrammeCommittee();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       cou.uri,   		" +
			   "       p.id,   					" +
			   "       pn.firstNames,   		" +
			   "       pn.familyNames,   		" +
			   "       ona.name,   				" +
			   "       o.id)					" +			   
			   "  from Person p								" +
			   "  join p.personName pn						" +
			   "  left join p.classes pc		 			" +
			   "  left join pc.theClass c					" +
			   "  left join p.projects pp  					" +
			   "  left join pp.theClass poc  				" +
			   "  left join pp.project pr  					" +
			   "  left join pr.organisationUnits po  		" +
			   "  left join po.organisationUnit o  			" +
			   "  left join o.organisationUnitNames ona  	" +
			   "  left join o.postalAddresses opa  			" +
			   "  left join opa.postalAddress pa  			" +
			   "  left join pa.country cou  				" +
			   "  where c.uri = ?1 and poc.uri = ?2 group by p.id					")
	List<PersonList> findAllByStakeholderCat(String stakeholderCat, String personCat);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       cou.uri,   		" +
			   "       p.id,   					" +
			   "       pn.firstNames,   		" +
			   "       pn.familyNames,   		" +
			   "       ona.name,   				" +
			   "       o.id)					" +			   
			   "  from Person p								" +
			   "  join p.personName pn						" +
			   "  left join p.projects pp  					" +
			   "  left join pp.theClass poc  				" +
			   "  left join pp.project pr  					" +
			   "  left join p.persons_organisationUnits po  " +
			   "  left join po.organisationUnit o  			" +
			   "  left join o.organisationUnitNames ona  	" +
			   "  left join o.postalAddresses opa  			" +
			   "  left join opa.postalAddress pa  			" +
			   "  left join pa.country cou  				" +
			   "  where poc.uri = ?1 group by p.id	")
	List<PersonList> findAllByPersonCat(String personCat);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       pn.familyNames,   		" +
			   "       pn.firstNames,   		" +
			   "       p.id,   					" +
			   "       c.uri)					" +			   
			   "  from Person p								" +
			   "  join p.personName pn						" +
			   "  left join p.classes pc		 			" +
			   "  left join pc.theClass c					" +
			   "  left join c.scheme s								" +
			   "  where s.uri = 'userstates' ")
	List<PersonList> findAllWithRegistration();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       pn.firstNames,   	" +
			   "       pn.familyNames,   	" +
			   "       c.uri,   			" +
			   "       p.id)				" +			   
			   "  from Person p										" +
			   "  join p.personName pn								" +
			   "  left join p.persons_organisationUnits po		 	" +
			   "  left join po.theClass c							" +
			   "  left join c.scheme s								" +
			   "  join po.organisationUnit o						" +
			   "  join o.organisationUnitNames ona	 				" +	
			   "  where s.uri = 'policybody' and ona.name = ?1 ")
	List<PersonList> findAllByRIPolicyBody(String policyBody);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	c.uri									" +			   
			   "  from Person p										" +
			   "  left join p.classes pc		 					" +
			   "  left join pc.theClass c							" +
			   "  where p.id = ?1")
	List<String> findStakeholderListByPersonId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	c.uri									" +			   
			   "  from Person p										" +
			   "  left join p.classes pc		 					" +
			   "  left join pc.theClass c							" +
			   "  left join c.scheme s								" +
			   "  where p.id = ?1 and s.id = ?2")
	List<String> findClassListByPersonIdAndSchemeId(Long id, Long schemeId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	c.uri									" +			   
			   "  from Person p										" +
			   "  left join p.classes pc		 					" +
			   "  left join pc.theClass c							" +
			   "  left join c.scheme s								" +
			   "  where p.id = ?1 and s.uri = ?2")
	List<String> findClassListByPersonIdAndSchemeUri(Long id, String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.features.semantics.ClassView(" +
			   "       c.uri, c.id)        " +		   
			   "  from Person p										" +
			   "  left join p.classes pc		 					" +
			   "  left join pc.theClass c							" +
			   "  left join c.scheme s								" +
			   "  where p.id = ?1 and s.id = ?2")
	List<ClassView> findClassViewListByPersonIdAndSchemeId(Long id, Long schemeId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ona.name									" +			   
			   "  from Person p										" +
			   "  left join p.persons_organisationUnits po		 	" +
			   "  left join po.theClass c							" +
			   "  left join c.scheme s								" +
			   "  join po.organisationUnit o						" +
			   "  join o.organisationUnitNames ona	 				" +	
			   "  where s.uri = 'policybody' and p.id = ?1 ")
	List<String> findPolicyBodiesByPersonId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri, count(c) 	" +
			   "  from Person p    			" +
			   "  join p.classes pc		 	" +
			   "  join pc.theClass c		" +
			   "  join c.scheme s			" +
			   "  where s.uri='stakeholdercategory' " +
				" group by c order by c.uri asc   ")
	List<Object[]> countByStakeholderCat();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri, count(p) 	" +
			   "  from Person p    							" +
			   "  join p.classes pc		 					" +
			   "  join pc.theClass c						" +
			   "  left join p.persons_organisationUnits po  " +
			   "  left join po.theClass poc  				" +
			   "  where c.uri = 'RI NCP Network Members' and poc.uri = 'RI NCP' order by c.uri asc ")
	List<Object[]> countRINCPNetwrokMembers();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select poc.uri, count(distinct p) 	" +
			   "  from Person p    							" +
			   "  join p.classes pc		 					" +
			   "  join pc.theClass c						" +
			   "  left join p.projects pp  					" +
			   "  left join pp.theClass poc  				" +
			   "  where c.uri = 'RI project contacts' and poc.uri!='Favourite' group by poc order by poc.uri asc                 ")
	List<Object[]> countRIContactPerson();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ona.name, count(ona) 	" +
			   "  from Person p    			" +
			   "  left join p.persons_organisationUnits po		 	" +
			   "  left join po.theClass c							" +
			   "  left join c.scheme s								" +
			   "  join po.organisationUnit o						" +
			   "  join o.organisationUnitNames ona	 				" +				   
			   " where s.uri = 'policybody' group by ona order by ona.name asc")
	List<Object[]> countByRIPolicyBody();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonView(	" +
			   "       p.id,   				" +
			   "       pn.familyNames,		" +
			   "       ea.uri,				" +
			   "	   pa.addressLine2,     " +
			   "       coun.uri)			" +
			   
			   "  from Person p    	 							" +
			   "  join p.personName pn		 					" +
		  
			   "  join p.classes oc		 			  			" +
			   "  join oc.theClass c		 					" +
			   "  join c.scheme s       						" +
			   
         "  left join p.persons_electronicAddresses pea			" +
         "  left join pea.electronicAddress ea       			" +
         
         "  left join p.persons_postalAddresses ppa				" +
         "  left join ppa.postalAddress pa       	    		" +
         
         "  left join p.persons_organisationUnits pou	  		" +
         "  left join pou.theClass poucl	  		" +
         "  left join pou.organisationUnit ou       	   		" +
         "  left join ou.classes oucl       	     		    " +
         
         "  left join ou.postalAddresses oupas       			" +
         "  left join oupas.postalAddress pa2       	   		" +
         "  left join pa2.country coun       	   		    	" +
         
		 " where s.uri = ?1 and p.id=?2 and oucl is null and poucl.uri!='Favourite' "+
         " group by p.id ")
	List<PersonView> findByPersonClassSchemeAndId(String PersonClass, Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonView(	" +
			   "       p.id,   				" +
			   "       pn.familyNames,		" +
			   "       ea.uri,				" +
			   "	   pa.addressLine2,      "+
			   "	   ona.name,      "+
			   "	   coun.uri,      "+
			   "       pn.otherNames)		" +
			   
			   "  from Person p    	 							" +
			   "  join p.personName pn		 					" +
		  
      "  left join p.persons_electronicAddresses pea			" +
      "  left join pea.electronicAddress ea       				" +
      
      "  left join p.persons_postalAddresses ppa				" +
      "  left join ppa.postalAddress pa       	    			" +
      
      "  left join p.persons_organisationUnits pou	  			" +
      "  left join pou.theClass poucl	  		" +
      "  left join pou.organisationUnit ou       	   			" +
      "  left join ou.classes oucl       	     		    	" +
      
      "  left join ou.postalAddresses oupas       				" +
      "  left join oupas.postalAddress pa2       	   			" +
      "  left join pa2.country coun       	   		    		" +
      
     "   left join ou.organisationUnitNames ona      			" +
      
	  "  where p.id=?1 and oucl is null and poucl.uri!='Favourite' "+
      "  group by p.id ")
	PersonView findByPersonId2(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonView(	" +
			   "       pn.familyNames,   	" +
			   "       pn.firstNames,   	" +
			   "       pn.otherNames,   	" +
			   "       p.id,				" +
			   "       ea.uri,				" +
			   "	   pa.addressLine2,		" +
			   "	   pa.addressLine1,		" +
			   "	   cou.uri,		" +
			   "	   m.uri)     		" +
			   
			   "  from Person p    	 						" +
			   "  join p.personName pn		 				" +
		  
   		"  left join p.persons_electronicAddresses pea		" +
   		"  left join pea.electronicAddress ea       		" +
   
   		"  left join p.persons_postalAddresses ppa			" +
   		"  left join ppa.postalAddress pa       	    	" +
   		"  left join pa.country cou    			   	    	" +
   		"  left join p.persons_medium pm  					" +
		"  left join pm.medium m  							" +   
   		"  where p.id=?1 group by p.id ")
	PersonView findByPersonId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select c.uri	 			    				" +			   
			   "  from Person p    	 								" +
			   "  left join p.persons_organisationUnits po		 	" +
			   "  left join po.theClass c							" +
			   "  left join c.scheme s								" +
			   "  where p.id=?1 and s.uri=?2 ")
	String findOrgTypeByPersonIdAndScheme(Long id,String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select cv.doc	 			    		" +			   
			   "  from Person p    	 						" +
			   "  left join p.persons_cvs pcv	 			" +		  
			   "  left join pcv.theClass c					" +
			   "  left join pcv.cv cv						" +
			   "  where p.id=?1 and c.uri=?2 ")
	byte[] findCVByPersonIdAndClassId(Long id, String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       pn.firstNames,   				" +
			   "       p.id,   				" +
			   "	   pn.familyNames)		" +			   
			   "  from Person p    	 					" +
			   "  join p.personName pn		 			" +	
			   
			   "  join p.classes oc		 			  	" +
			   "  join oc.theClass c		 			" +
			   "  join c.scheme s       				" +

			   "  join c.scheme s       				" +
			   "  where s.uri = ?1						" +
			   "  group by p.id ")
	List<PersonList> findByPolicySuperType(String PolicySuperType);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,			" +
			   "       coun.uri,			" +
			   "       pn.firstNames,			" +
			   "       pn.familyNames,   				" +
			   "       p.id)		" +		   
			   "  from Person p								" +
			   "  left join p.personName pn					" +
			   "  left join p.persons_postalAddresses ppa  	" +
			   "  left join ppa.postalAddress pa			" +
			   "  left join pa.country coun					" +
			   "  left join p.classes pc		 			" +
			   "  left join pc.theClass c					" +
			   "  where c.uri = 'Permanent Representation (EC)'	")
	List<PersonList> findAllWithCountry();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       coun.uri,			" +
			   "       p.id,   				" +
			   "       pn.firstNames,		" +
			   "       pn.familyNames,		" +
			   "       ona.name,			" +
			   "       o.id,			" +
			   "       poc.uri,				" +
			   "       e.uri,				" +
			   "       m.uri)				" +		   
			   "  from Person p								" +
			   "  left join p.personName pn					" +			
			   "  left join p.persons_organisationUnits po  " +
			   "  left join po.theClass poc  				" +
			   "  left join po.organisationUnit o  			" +
			   "  left join o.organisationUnitNames ona  	" +
			   "  left join o.postalAddresses opa  			" +
			   "  left join opa.postalAddress pa			" +
			   "  left join pa.country coun					" +
			   "  left join p.classes pc		 			" +
			   "  left join pc.theClass c					" +
			   "  left join p.persons_electronicAddresses pe		" +
			   "  left join pe.electronicAddress e					" +
			   "  left join p.persons_medium pm  					" +
			   "  left join pm.medium m  							" +
			   "  where c.uri = 'RI NCP Network Members' and poc.uri = 'RI NCP' group by p.id	")
	List<PersonList> findAllNCPWithCountry();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       coun.uri,			" +
			   "       p.id,   				" +
			   "       pn.familyNames,		" +
			   "       ona.name,			" +
			   "       poc.uri,				" +
			   "       e.uri)				" +		   
			   "  from Person p								" +
			   "  left join p.personName pn					" +			
			   "  left join p.persons_organisationUnits po  " +
			   "  left join po.theClass poc  				" +
			   "  left join po.organisationUnit o  			" +
			   "  left join o.organisationUnitNames ona  	" +
			   "  left join o.postalAddresses opa  			" +
			   "  left join opa.postalAddress pa			" +
			   "  left join pa.country coun					" +
			   "  left join p.classes pc		 			" +
			   "  left join pc.theClass c					" +
			   "  left join p.persons_electronicAddresses pe		" +
			   "  left join pe.electronicAddress e					" +
			   "  where c.uri = 'RI NCP Network Members' and poc.uri = ?1 and o.id = ?2	group by p.id")
	PersonList findAllNoNCPWithCountryByRoleAndOrg(String role, Long orgId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.PersonList(" +
            "       pn.firstNames,                   " +
            "       poscl.uri,                   " +
            "       oun.name,                   " + 
            "       p.id,                   " + 
            "       pn.familyNames)        " +
            "  from Person p                " +
            "  join p.personName pn        " +
            
            "  left join p.persons_organisationUnits pos " +
            "  join pos.theClass poscl        " +
            "  join poscl.scheme s        " +
            
            "  left join pos.organisationUnit ou " + 
            "  left join ou.organisationUnitNames oun " +
            
            "  where s.uri='policybody' " )
	List<PersonList> findAllWithRIPBRole();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	c.uri									" +			   
			   "  from Person p										" +
			   "  left join p.persons_organisationUnits po		 	" +
			   "  left join po.theClass c							" +
			   "  left join c.scheme s								" +
			   "  where s.uri = 'policybody' and p.id = ?1 ")
	String findRIPolicyBodyRoleByPersId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select    new gr.ekt.cerif.entities.base.PersonList(    " +
			"       pn.firstNames,                   " +
            "       pn.familyNames,                   " +
            "       poscl.uri,                   " +
            "       oun.name,                   " + 
            "       paco.uri,                   " +
            "       p.id)        " +
            "  from Person p                " +
            "  join p.personName pn        " +
            
            "  left join p.persons_organisationUnits pos " +
            "  join pos.theClass poscl        " +
            "  join poscl.scheme clsch        " +
            
            "  left join pos.organisationUnit ou " + 
            "  left join ou.organisationUnitNames oun " +
            
            "  left join ou.postalAddresses oupa " +
            "  left join oupa.postalAddress pa " +
            "  left join pa.country paco " +
            
            "  where clsch.uri!='policybody'" )
 List<PersonList> findAllPersonsWithOrgNoRIPBRoleAndWithCountry();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   				" +
			   "       pn.firstNames,		" +	
			   "       pn.familyNames,		" +	
			   "       ppr.id,				" +
			   "       ppr.acronym)			" +
			   "  from Person p						" +
			   "  join p.personName pn				" +
			   "  left join p.classes pc		 	" +
			   "  left join pc.theClass c			" +
			   
               "  left join p.projects pprs		 	" +
               "  left join pprs.project ppr		" +
            
			   "  where c.uri = 'RI project contacts'")
	List<PersonList> findAllPersonsWithProjects();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select p from gr.ekt.cerif.entities.base.Person p join p.projects projs where projs.project=?1 and projs.theClass=?2")
	Person findByProjectAndtheClass(Project project, Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pn			   	" +
			   "  from Person p				" +
			   "  left join p.personName pn		" +
			   " where p.id = ?1            ")
	PersonName findPersNameByPersonId(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ea			   							" +
			   "  from Person p										" +
			   "  left join p.persons_electronicAddresses pea		" +
			   "  left join pea.electronicAddress ea				" +
			   " where p.id = ?1            ")
	ElectronicAddress findElectronicAddressByPersonId(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pa			   							" +
			   "  from Person p										" +
			   "  left join p.persons_postalAddresses ppa			" +
			   "  left join ppa.postalAddress pa					" +
			   " where p.id = ?1            ")
	PostalAddress findPostalAddressByPersonId(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  left join p.classes ppc							" +
			   "  left join ppc.theClass c							" +
			   " where p.id = ?1 and c.uri=?2          ")
	Person_Class findByPersonIdAndClassUri(Long personId, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  left join p.classes ppc							" +
			   "  left join ppc.theClass c							" +
			   "  left join c.scheme cs							" +
			   " where p.id = ?1 and cs.uri='userstates' ")
	Person_Class findPersonUserState(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppo			   							" +
			   "  from Person p										" +
			   "  join p.persons_organisationUnits ppo			" +
			   "  join ppo.theClass c							" +
			   "  join c.scheme s								" +
			   " where p.id = ?1 and s.id=?2          ")
	Person_OrganisationUnit findByPersonIdAndSchemeId(Long personId, Long schemeId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppo			   							" +
			   "  from Person p										" +
			   "  join p.persons_organisationUnits ppo			" +
			   "  join ppo.theClass c							" +
			   "  join c.scheme s								" +
			   " where p.id = ?1 and s.uri=?2          ")
	Person_OrganisationUnit findByPersonIdAndSchemeUri(Long personId, String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  join p.classes ppc							" +
			   "  join ppc.theClass c							" +
			   "  join c.scheme s								" +
			   " where p.id = ?1 and s.id=?2          ")
	Person_Class findPersClassByPersonIdAndSchemeId(Long personId, Long schemeId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  join p.classes ppc							" +
			   "  join ppc.theClass c							" +
			   "  join c.scheme s								" +
			   " where p.id = ?1 and s.uri=?2          ")
	Person_Class findPersClassByPersonIdAndSchemeUri(Long personId, String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select perrespub from Person_ResultPublication perrespub "+
				"  left join perrespub.person per 	" +
				"  left join perrespub.resultPublication respub 	" +
				"  left join per.personName pername	" +
				"  left join perrespub.theClass cl  " +
			    "  where cl.uri = 'Favourite' and respub.id=?1 and pername.otherNames=?2 ")
	Person_ResultPublication isResultPublicationFavourite(Long id, String username);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select perorg from Person_OrganisationUnit perorg "+
			"  left join perorg.person per 	" +
			"  left join perorg.organisationUnit org 	" +
			"  left join per.personName pername	" +
			"  left join perorg.theClass cl  " +
		    "  where cl.uri = 'Favourite' and org.id=?1 and pername.otherNames=?2 ")
	Person_OrganisationUnit isOrganisationUnitFavourite(Long id, String username);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select perper from Person_Person perper "+
			"  left join perper.person1 per1 	" +
			"  left join perper.person2 per2 	" +
			"  left join per1.personName per1name	" +
			"  left join perper.theClass cl  " +
		    "  where cl.uri = 'Favourite' and per2.id=?1 and per1name.otherNames=?2 ")
	Person_Person isPersonFavourite(Long id, String username);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select	new gr.ekt.cerif.entities.base.PersonList(	" +
			   "       p.id,   				" +   
			   "       coun.uri,			" +
			   "       pn.firstNames,   				" +
			   "       pn.familyNames,   				" +
			   "       p.id)		" +	
			   "  from Person p								" +
			   "  left join p.personName pn					" +
			   "  left join p.persons_postalAddresses ppa  	" +
			   "  left join ppa.postalAddress pa			" +
			   "  left join pa.country coun					" +
			   "  left join p.person2_persons per2per		" +
			   "  left join per2per.person1 per1			" +
			   "  left join per2per.theClass per2percl		" +
			   "  where per1.id = ?1 and per2percl.uri='Favourite' ")
	List<PersonList> findFavouritePersons(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select cv			   							" +
			   "  from Person p										" +
			   "  join p.persons_cvs pcv							" +
			   "  join pcv.cv cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.id=?2          ")
	CV findCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select cv			   							" +
			   "  from Person p										" +
			   "  join p.persons_cvs pcv							" +
			   "  join pcv.cv cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.uri=?2          ")
	CV findCVByPersonIdAndClassUri(Long personId, String theClassUri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pcv			   							" +
			   "  from Person p										" +
			   "  join p.persons_cvs pcv							" +
			   "  join pcv.cv cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.id=?2          ")
	Person_Cv findPersonCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pcv			   							" +
			   "  from Person p										" +
			   "  join p.persons_cvs pcv							" +
			   "  join pcv.cv cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.uri=?2          ")
	Person_Cv findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select p" +			   
			   "  from Person p    	 						" +
			   "  join p.personName pn		 				" +
		  
   		"  left join p.persons_electronicAddresses pea		" +
   		"  left join pea.electronicAddress ea       		" +
   		"  where pn.firstNames=?1 and pn.familyNames=?2 and ea.uri=?3")
	Person findPersonByNameAndEmail(String firstName, String familyName, String email);
	
}
