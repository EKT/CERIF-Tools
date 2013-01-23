/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.OrganisationUnitList;
import gr.ekt.cerif.entities.base.OrganisationUnitView;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitCrudRepository extends CrudRepository<OrganisationUnit, Long> {

	public Iterable<OrganisationUnit> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select o from gr.ekt.cerif.entities.base.OrganisationUnit o where o.id = ?1")
	OrganisationUnit findById(Long id);
	
	OrganisationUnit findByUri(String uri);
	
	OrganisationUnit findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value="select o from gr.ekt.cerif.entities.base.OrganisationUnit o join o.organisationUnitNames oname where oname.name= ?1 ")
	OrganisationUnit findByOrganisationUnitName(String organisationUnitName);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value="select o " +
			"from gr.ekt.cerif.entities.base.OrganisationUnit o " +
			"join o.organisationUnitNames oname " +
			"where oname.name= ?1 and o.uri=?2")
	OrganisationUnit findByOrganisationUnitNameAndOrgUri(String organisationUnitName, String orgUri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value="select o from gr.ekt.cerif.entities.base.OrganisationUnit o join o.organisationUnitNames oname join o.postalAddresses posAddr join posAddr.postalAddress pAd join pAd.country country where oname.name= ?1 and country.code= ?2")
	OrganisationUnit findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String countryCode);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value="select oname from gr.ekt.cerif.features.multilingual.OrganisationUnitName oname where oname.name= ?1 ")
	OrganisationUnitName  findByOrganisationUnitName2(String organisationUnitName);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select orgn	" +
			   "  from OrganisationUnit org    		 	" +
			   "  join org.organisationUnitNames orgn		" +
			   " where org.id = ?1            ")
	OrganisationUnitName findOrganisationUnitNamesById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitView(" +
			   "       ou.id,				" +
			   "       ona.name,			" +
			   "       co.uri,				" +
			   "       ou.uri,				" +
			   "       pa.addressLine1,		" +
			   "       oucl.uri)   			" +
			   "  from Project pr 					" +   
			   "  join pr.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +
			   "  join ou.organisationUnitNames ona " +
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +			   
			   "  join prou.theClass oucl 			" +
			   "  join oucl.scheme sch 				" +
			   "  where pr.id =?1 and sch.uri='organisationstatus'")
	List<OrganisationUnitView> findOrganisationUnitsByProjectId(Long Id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitView(" +
			   "       ou.id,				" +
			   "       ona.name,			" +
			   "       co.uri,				" +
			   "       ou.uri,				" +
			   "       pa.addressLine1,		" +
			   "       oucl.uri)   			" +
			   "  from Project pr 					" +   
			   "  join pr.organisationUnits prou 	" +
			   "  join prou.organisationUnit ou 	" +
			   "  join ou.organisationUnitNames ona " +
			   "  left join ou.postalAddresses oupa " +
			   "  left join oupa.postalAddress pa 	" +
			   "  left join pa.country co 			" +			   
			   "  join prou.theClass oucl 			" +
			   "  join oucl.scheme sch 				" +
			   "  where pr.id =?1 and sch.uri='organisationstatus' and oucl.uri=?2")
	List<OrganisationUnitView> findOrganisationUnitsByProjectId(Long Id, String organisationStatus);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitView(" +
			   "       o.id,				" +
			   "	   ona.name,			" +
			   "       co.uri,				" +
			   "       o.uri,				" +
			   "       pa.addressLine1)   	" +
			   "  from OrganisationUnit o 				" +   
			   "  join o.organisationUnitNames ona 		" +
			   "  left join o.classes oc 				" +
			   "  left join oc.theClass c 				" +
			   "  left join o.postalAddresses oupa 		" +
			   "  left join oupa.postalAddress pa 		" +
			   "  left join pa.country co 				" +			   
			   "  where c.id is null or c.uri='Other type' " +
			   "  order by ona.name                     ")
	List<OrganisationUnitView> findAllOrgs();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitView(" +
			   "       o.id,				" +
			   "	   ona.name,			" +
			   "       co.uri,				" +
			   "       o.uri,				" +
			   "       pa.addressLine1)   	" +
			   "  from OrganisationUnit o 				" +   
			   "  join o.organisationUnitNames ona 		" +
			   "  left join o.classes oc 				" +
			   "  left join oc.theClass c 				" +
			   "  left join o.postalAddresses oupa 		" +
			   "  left join oupa.postalAddress pa 		" +
			   "  left join pa.country co 				" +		
			   "  left join o.persons_organisationUnits perso		" +	
			   "  left join perso.person pers		" +	
			   "  left join perso.theClass persocl		" +	
			   "  where c.id is null and pers.id =?1 and persocl.uri='Favourite' " +
			   "  order by ona.name                     ")
	List<OrganisationUnitView> findFavouriteOrgs(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitView(" +
			   "       o.id,				" +
			   "	   ona.name,			" +
			   "	   o.acronym,			" +
			   "	   o.headCount,			" +
			   "       co.uri,				" +
			   "       o.uri,				" +
			   "       pa.addressLine1)   	" +
			   "  from OrganisationUnit o 				" +   
			   "  join o.organisationUnitNames ona 		" +			   
			   "  left join o.postalAddresses oupa 		" +
			   "  left join oupa.postalAddress pa 		" +
			   "  left join pa.country co 				" +			   
			   "  where o.id=?1							" +
			   "  group by o.id")
	OrganisationUnitView findOrgById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ona.name,				" +
			   "	   ou.id,					" +
			   "       coun.uri,				" +
			   "       pa2.addressLine1)		" +
			   
			   "  from Person p 				" +   
			   "  left join p.persons_organisationUnits pou	  		" +
			   "  left join pou.organisationUnit ou       	   		" +
			   "  left join ou.classes oucl       	     		    " +
			   "  left join pou.theClass poucl       	     		    " +
			   
				"  left join ou.postalAddresses oupas       		" +
				"  left join oupas.postalAddress pa2       	   		" +
				"  left join pa2.country coun       	   		    " +

				"   left join ou.organisationUnitNames ona      	" +

			   "  where p.id=?1	and oucl is null and poucl.uri!='Favourite' " +
			   "  group by ou.id")
	List<OrganisationUnitList> findByPersonId(Long Id);
	
//select ou.cfURI, ona.cfName, ou.cfOrgUnitId from cfOrgUnit AS ou, cforgunitname AS ona, cforgunit_paddr AS op, cfPaddr AS p, cfcountry AS c where
//	ou.cfOrgUnitId=ona.cfOrgUnitId AND
//			ou.cfOrgUnitId=op.cfOrgUnitId AND
//			op.cfPAddrId=p.cfPAddrId AND
//			c.cfCountryCode='GR'

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
				"	   ou.id,		" +
				"       ona.name,	" +
				"       pac.uri,	" +
				"       ou.uri,	    " +
				"       pac.code,	" +
				"       count(ou))	" +
				"  from OrganisationUnit ou 	     " +   
				"  left join ou.postalAddresses pas	 " +
				"  left join pas.postalAddress pa    " +
				"  left join pa.country pac       	 " +
				"  left join ou.organisationUnitNames ona    " +
			   
			   "  where pac.code = ?1 " +
			   "  group by ou.id ")
	List<OrganisationUnitList> findOrganisationUnitsByCountryCode(String code);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ou.id,				" +
			   "	   ona.name,			" +
			   "       pac.uri,	" +
				"       ou.uri,	    " +
				"       pac.code)	" +
				"  from OrganisationUnit ou 	     " +   
				"  left join ou.postalAddresses pas	 " +
				"  left join pas.postalAddress pa    " +
				"  left join pa.country pac       	 " +
				"  left join ou.organisationUnitNames ona    " +	
				"  left join ou.classes oc 				" +
				"  left join oc.theClass c 				" +
			    "  where c.id is null or c.uri='Other type' ")
	List<OrganisationUnitList> findAllOrgs2();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			"	   ou.id,		" +
			"       ona.name,	" +
			"       pac.uri,	" +
			"       ou.uri,	    " +
			"       pac.code,   " +
			"       count(ou))	" +
			"  from OrganisationUnit ou 	     " +   
			"  left join ou.postalAddresses pas	 " +
			"  left join pas.postalAddress pa    " +
			"  left join pa.country pac       	 " +
			"  left join ou.organisationUnitNames ona    " +
		   "  group by pac.code order by pac.uri asc")
	List<OrganisationUnitList> findCountryCodesForOrganisationUnits();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ou.id,				" +
			   "	   ona.name)					" +
			   "  from Person p 				" +   
			   "  left join p.persons_organisationUnits pou	  		" +
			   "  left join pou.organisationUnit ou       	   		" +
			   "  left join ou.organisationUnitNames ona      	" +
			   "  left join pou.theClass poucl       		  " +
			   "  where poucl.uri = 'RI NCP'					" +
			   "  group by ou.id")
	List<OrganisationUnitList> findRINCP();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ou.id,				" +
			   "	   ona.name)					" +
			   "  from OrganisationUnit ou		" +
			   "  left join ou.classes oucl       	" +
			   "  left join oucl.theClass cl       	" +
			   "  left join ou.organisationUnitNames ona      	" +
			   "  where cl.uri = 'Members of the board / delegates of RI policy bodies'					" +
			   "  group by ou.id")
	List<OrganisationUnitList> findRIPolicyBody();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ou.id,				" +
			   "	   ona.name)					" +
			   "  from OrganisationUnit ou		" +
			   "  left join ou.classes oucles       	" +
			   "  left join oucles.theClass oucl       	" +
			   "  left join ou.resultPublications ourespubl "+
			   "  left join ourespubl.theClass cl"+
			   "  left join ou.organisationUnitNames ona      	" +
			   "  where cl.uri = 'Other Source'	or oucl.uri='Other type'				" +
			   "  group by ou.id")
	List<OrganisationUnitList> findOtherSource();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ou.id,				" +
			   "	   ona.name)					" +
			   "  from OrganisationUnit ou		" +
			   "  left join ou.classes oucl       	" +
			   "  left join oucl.theClass cl       	" +
			   "  left join ou.organisationUnitNames ona      	" +
			   "  where cl.uri = 'European Commission'					" +
			   "  group by ou.id")
	List<OrganisationUnitList> findEuropeanCommission();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.base.OrganisationUnitList(" +
			   "       ou.id,				" +
			   "	   ona.name)						" +
			   "  from OrganisationUnit ou				" +
			   "  left join ou.organisationUnitNames ona    " +
			   "  join ou.resultPublications ourp       	" +
			   "  join ourp.theClass cl       				" +
			   "  join cl.scheme sch      					" +
			   "  where sch.uri = 'documentsource'			" +
			   "  group by ou.id		")
	List<OrganisationUnitList> findAllSources();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select o.id,				" +
			   "	   ona.name					" +
			   "  from OrganisationUnit o 				" +   
			   "  join o.organisationUnitNames ona 		" +
			   "  left join o.classes oc 				" +
			   "  left join oc.theClass c 				" +
			   "  where c.id is null and ona.name like ?1		" +
			   "  order by ona.name                     		")
	List<Object[]> findAllOrgsForAjax(String term);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select o.id,				" +
			   "	   ona.name					" +
			   "  from OrganisationUnit o 				" +   
			   "  join o.organisationUnitNames ona 		" +
			   "  where o.id=?1							")
	Object[] findOrgByIdForAjax(Long id);
	
	
}
