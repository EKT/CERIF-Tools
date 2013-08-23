/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface PostalAddressCrudRepository extends CrudRepository<PostalAddress, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PostalAddress> findByCountry(Country country);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa join pa.organisationUnits orgs join orgs.organisationUnit org join org.organisationUnitNames uname join pa.country cname where uname.name=?1 and cname.code=?2 ")
    PostalAddress findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String ccode);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa " +
			"join pa.organisationUnits orgs " +
			"join orgs.organisationUnit org " +
			"where org=?1 ")
    List<PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa join pa.organisationUnits orgs join orgs.organisationUnit org join pa.country cname where org=?1 and cname.code=?2 ")
	PostalAddress findByOrganisationUnitAndCountryCode(OrganisationUnit organisationUnit, String ccode);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select pa from PostalAddress pa join pa.persons_postalAddresses pp join pp.person per where per=?1")
	PostalAddress findByPerson(Person person);
	
	@Query("select pa from PostalAddress pa join pa.organisationUnits orgs join orgs.organisationUnit org join org.organisationUnitNames uname where uname.name=?1")
    PostalAddress findByOrganisationUnitName(String organisationUnitName);
	
}
