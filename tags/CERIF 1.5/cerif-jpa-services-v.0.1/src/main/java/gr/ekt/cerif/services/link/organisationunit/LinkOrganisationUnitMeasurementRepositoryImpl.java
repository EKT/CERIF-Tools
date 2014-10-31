package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkOrganisationUnitMeasurementRepositoryImpl implements
		LinkOrganisationUnitMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitMeasurementCrudRepository linkOrganisationUnitMeasurementCrudRepository;

	@Override
	public void delete(OrganisationUnit_Measurement entity) {
		linkOrganisationUnitMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_Measurement> entities) {
		linkOrganisationUnitMeasurementCrudRepository.save(entities);
	}

	@Override
	public Iterable<OrganisationUnit_Measurement> save(
			Iterable<OrganisationUnit_Measurement> entities) {
		return linkOrganisationUnitMeasurementCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_Measurement save(OrganisationUnit_Measurement entity) {
		return linkOrganisationUnitMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_Measurement> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitMeasurementCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public List<OrganisationUnit_Measurement> findByMeasurement(
			Measurement measurement) {
		return linkOrganisationUnitMeasurementCrudRepository.findByMeasurement(measurement);
	}

}
