package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitResultProductCrudRepository extends CrudRepository<OrganisationUnit_ResultProduct, Long> {
	
	List<OrganisationUnit_ResultProduct> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ResultProduct> findByResultProduct(ResultProduct resultProduct);

}
