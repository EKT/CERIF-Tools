package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitPostalAddressCrudRepository extends CrudRepository<OrganisationUnit_PostalAddress, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select op from OrganisationUnit_PostalAddress op join op.organisationUnit org join org.organisationUnitNames uname join op.postalAddress pa join pa.country cname join cname.countryNames countryName where uname.name=?1 and countryName.name=?2 ")
	OrganisationUnit_PostalAddress findByOrganisationUnitNameAndCountryName(String organisationUnitName, String cName);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select op from OrganisationUnit_PostalAddress op join op.organisationUnit org join org.organisationUnitNames uname  where uname.name=?1")
	OrganisationUnit_PostalAddress findByOrganisationUnitName(String organisationUnitName);

	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("select op from OrganisationUnit_PostalAddress op join op.organisationUnit org join org.organisationUnitNames uname join op.postalAddress pa join pa.country cname where uname.name=?1 and cname.code=?2 ")
	OrganisationUnit_PostalAddress findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String ccode);	

}
