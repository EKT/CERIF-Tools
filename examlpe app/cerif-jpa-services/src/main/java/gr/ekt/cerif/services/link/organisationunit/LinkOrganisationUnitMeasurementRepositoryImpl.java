package gr.ekt.cerif.services.link.organisationunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;

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

}
