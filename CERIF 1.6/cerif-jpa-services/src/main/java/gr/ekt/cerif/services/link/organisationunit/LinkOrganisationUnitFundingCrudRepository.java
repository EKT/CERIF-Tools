package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitFundingCrudRepository extends CrudRepository<OrganisationUnit_Funding, Long> {
	
	List<OrganisationUnit_Funding> findByFunding(Funding funding);
	
	List<OrganisationUnit_Funding> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
