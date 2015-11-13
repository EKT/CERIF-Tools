package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitMediumCrudRepository extends CrudRepository<OrganisationUnit_Medium, Long> {
	
	List<OrganisationUnit_Medium> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Medium> findByMedium(Medium medium);

}
