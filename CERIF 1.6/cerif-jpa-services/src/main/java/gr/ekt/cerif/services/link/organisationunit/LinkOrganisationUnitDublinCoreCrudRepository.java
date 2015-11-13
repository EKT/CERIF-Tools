package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_DublinCore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitDublinCoreCrudRepository extends CrudRepository<OrganisationUnit_DublinCore, Long> {
	
	List<OrganisationUnit_DublinCore> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
