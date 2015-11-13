package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitIndicatorCrudRepository extends CrudRepository<OrganisationUnit_Indicator, Long> {
	
	List<OrganisationUnit_Indicator> findByIndicator(Indicator indicator);
	
	List<OrganisationUnit_Indicator> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
