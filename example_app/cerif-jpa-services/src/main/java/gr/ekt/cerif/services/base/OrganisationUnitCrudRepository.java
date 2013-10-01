/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.transferobjects.OrganisationView;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


/**
 * A repository for organisations.
 * 
 */
public interface OrganisationUnitCrudRepository extends CrudRepository<OrganisationUnit, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Iterable<OrganisationUnit> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select o from gr.ekt.cerif.entities.base.OrganisationUnit o where o.id = ?1")
	OrganisationUnit findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select o from gr.ekt.cerif.entities.base.OrganisationUnit o where o.id in ?1")
	List<OrganisationUnit> findById(List<Long> ids);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	OrganisationUnit findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	OrganisationUnit findByAcronym(String acronym);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value="select o from gr.ekt.cerif.entities.base.OrganisationUnit o join o.organisationUnitNames oname where oname.name= ?1 ")
	OrganisationUnit findByOrganisationUnitName(String organisationUnitName);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.OrganisationView(" +
				   "       ou.id,				" +
				   "       ona.name,			" +
				   "       ou.uri,				" +
				   "       con.name,			" +
				   "       pa.addressLine1,		" +
				   "       pa.addressLine2)   	" +
				   "  from OrganisationUnit ou 	" +   
				   "  left join ou.organisationUnitNames ona " +
				   "  left join ou.postalAddresses oupa " +
				   "  left join oupa.postalAddress pa 	" +
				   "  left join pa.country co 	" +
				   "  left join co.names con 	" +	
				   "  order by ona.name               ")
	List<OrganisationView> findAllOrganisations();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.OrganisationView(" +
				   "       ou.id,				" +
				   "       ona.name,			" +
				   "       clt.term)   			" +
				   "  from Project pr 			" +   
				   "  left join pr.organisationUnits ous " +
				   "  left join ous.organisationUnit ou " +
				   "  left join ou.organisationUnitNames ona " +
				   "  join ous.theClass cl 		" +
				   "  join cl.scheme sch 		" +
				   "  left join cl.terms clt  	" +
				   "  join clt.language l  		" +
				   "  where pr.id = ?1 and sch.uri = ?2 AND l.code = 'en' " +
				   "  order by ona.name               ")
	List<OrganisationView> findOrganisationByProjectIdAndClassScheme(Long id, String classSchemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.transferobjects.OrganisationView(" +
				   "       ou.id,				" +
				   "       ona.name,			" +
				   "       ou.uri,				" +
				   "       con.name,			" +
				   "       pa.addressLine1,		" +
				   "       pa.addressLine2)   	" +
				   "  from OrganisationUnit ou 	" +   
				   "  left join ou.organisationUnitNames ona " +
				   "  left join ou.postalAddresses oupa " +
				   "  left join oupa.postalAddress pa 	" +
				   "  left join pa.country co 	" +
				   "  left join co.names con 	" +	
				   "  where ou.id = ?1 	" )
	OrganisationView findOrganisationById(Long Id);
	

}
