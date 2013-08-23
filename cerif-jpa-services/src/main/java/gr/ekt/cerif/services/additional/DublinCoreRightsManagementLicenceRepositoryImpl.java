package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreRightsManagementLicence;

@Component
public class DublinCoreRightsManagementLicenceRepositoryImpl implements
		DublinCoreRightsManagementLicenceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreRightsManagementLicenceRepositoryImpl.class);
	
	@Autowired
	private DublinCoreRightsManagementLicenceCrudRepository dublinCoreRightsManagementLicenceCrudRepository;

	@Override
	public void delete(DublinCoreRightsManagementLicence entity) {
		dublinCoreRightsManagementLicenceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreRightsManagementLicence> entities) {
		dublinCoreRightsManagementLicenceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreRightsManagementLicence> save(
			Iterable<DublinCoreRightsManagementLicence> entities) {
		return dublinCoreRightsManagementLicenceCrudRepository.save(entities);
	}

	@Override
	public DublinCoreRightsManagementLicence save(
			DublinCoreRightsManagementLicence entity) {
		return dublinCoreRightsManagementLicenceCrudRepository.save(entity);
	}

}
