package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitServiceCrudRepository extends CrudRepository<OrganisationUnit_Service, Long> {
	
	List<OrganisationUnit_Service> findByService(Service service);
	
	List<OrganisationUnit_Service> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
