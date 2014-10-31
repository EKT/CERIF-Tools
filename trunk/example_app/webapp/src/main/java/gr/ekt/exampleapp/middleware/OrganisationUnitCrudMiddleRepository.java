/**
 * 
 */
package gr.ekt.exampleapp.middleware;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.exampleapp.transferobjects.OrganisationView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitCrudMiddleRepository extends CrudRepository<OrganisationUnit, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.OrganisationView(" +
				   "       ou.id,				" +
				   "       ona.name,			" +
				   "       ou.uri,				" +
				   "       con.name,			" +
				   "       pa.addressLine1)   	" +
				   "  from OrganisationUnit ou 	" +   
				   "  left join ou.organisationUnitNames ona " +
				   "  left join ou.organisationUnits_postalAddresses oupa " +
				   "  left join oupa.postalAddress pa 	" +
				   "  left join pa.country co 	" +
				   "  left join co.countryNames con 	" +	
				   "  where con.language = 'en'	" +
				   "  order by ona.name               ")
	List<OrganisationView> findAllOrganisations();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.OrganisationView(" +
				   "       ou.id,				" +
				   "       ona.name,			" +
				   "       ou.uri,				" +
				   "       con.name,			" +
				   "       pa.addressLine1)   	" +
				   "  from OrganisationUnit ou 	" +   
				   "  left join ou.organisationUnitNames ona " +
				   "  left join ou.organisationUnits_postalAddresses oupa " +
				   "  left join oupa.postalAddress pa 	" +
				   "  left join pa.country co 	" +
				   "  left join co.countryNames con 	" +	
				   "  where ou.id = ?1 and con.language = 'en' " )
	OrganisationView findOrganisationById(Long Id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.OrganisationView(" +
				   "       ou.id,				" +
				   "       ona.name,			" +
				   "       clt.term)   			" +
				   "  from Project pr 			" +   
				   "  left join pr.projects_organisationUnits ous " +
				   "  left join ous.organisationUnit ou " +
				   "  left join ou.organisationUnitNames ona " +
				   "  join ous.theClass cl 		" +
				   "  join cl.scheme sch 		" +
				   "  left join cl.classTerms clt  	" +
				   "  join clt.language l  		" +
				   "  where pr.id = ?1 and sch.uuid = ?2 AND l.code = 'en' " +
				   "  order by ona.name               ")
	List<OrganisationView> findOrganisationByProjectIdAndClassScheme(Long id, String classSchemeUUID);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.exampleapp.transferobjects.OrganisationView(" +
				   "       ona.name,				" +
				   "       clt.term,			" +
				   "       ou.id)   			" +
				   "  from Person per 			" +   
				   "  left join per.persons_organisationUnits ous " +
				   "  left join ous.organisationUnit ou " +
				   "  left join ou.organisationUnitNames ona " +
				   "  join ous.theClass cl 		" +
				   "  join cl.scheme sch 		" +
				   "  left join cl.classTerms clt  	" +
				   "  join clt.language l  		" +
				   "  where per.id = ?1 and sch.uuid = ?2 AND l.code = 'en' " +
				   "  order by ona.name               ")
	List<OrganisationView> findOrganisationByPersonIdAndClassScheme(Long id, String classSchemeUUID);

}
