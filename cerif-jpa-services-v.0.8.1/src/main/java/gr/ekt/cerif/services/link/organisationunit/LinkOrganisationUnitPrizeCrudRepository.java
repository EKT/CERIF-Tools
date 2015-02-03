package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.second.Prize;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitPrizeCrudRepository extends CrudRepository<OrganisationUnit_Prize, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_Prize> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_Prize> findByPrize(Prize prize);

}
