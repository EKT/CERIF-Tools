package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitMeasurementCrudRepository extends CrudRepository<OrganisationUnit_Measurement, Long> {
	
	List<OrganisationUnit_Measurement> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Measurement> findByMeasurement(Measurement measurement);

}
