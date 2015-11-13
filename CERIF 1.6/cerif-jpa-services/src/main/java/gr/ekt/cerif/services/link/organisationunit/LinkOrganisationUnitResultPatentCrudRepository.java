package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitResultPatentCrudRepository extends CrudRepository<OrganisationUnit_ResultPatent, Long> {
	
	List<OrganisationUnit_ResultPatent> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
