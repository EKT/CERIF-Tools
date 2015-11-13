package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.second.Prize;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitPrizeCrudRepository extends CrudRepository<OrganisationUnit_Prize, Long> {
	
	List<OrganisationUnit_Prize> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Prize> findByPrize(Prize prize);

}
