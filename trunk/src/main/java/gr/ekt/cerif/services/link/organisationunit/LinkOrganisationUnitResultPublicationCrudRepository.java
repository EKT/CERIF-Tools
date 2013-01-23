package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitResultPublicationCrudRepository extends CrudRepository<OrganisationUnit_ResultPublication, Long> {
	
	List<OrganisationUnit_ResultPublication> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
}
