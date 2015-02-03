package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitServiceCrudRepository extends CrudRepository<OrganisationUnit_Service, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_Service> findByService(Service service);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_Service> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
