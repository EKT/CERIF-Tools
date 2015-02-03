package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreRightsManagementAccessRights;

@Deprecated
@Component
public class DublinCoreRightsManagementAccessRightsRepositoryImpl implements
		DublinCoreRightsManagementAccessRightsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreRightsManagementAccessRightsRepositoryImpl.class);
	
	@Autowired
	private DublinCoreRightsManagementAccessRightsCrudRepository dublinCoreRightsManagementAccessRightsCrudRepository;

	@Override
	public void delete(DublinCoreRightsManagementAccessRights entity) {
		dublinCoreRightsManagementAccessRightsCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreRightsManagementAccessRights> entities) {
		dublinCoreRightsManagementAccessRightsCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreRightsManagementAccessRights> save(
			Iterable<DublinCoreRightsManagementAccessRights> entities) {
		return dublinCoreRightsManagementAccessRightsCrudRepository.save(entities);
	}

	@Override
	public DublinCoreRightsManagementAccessRights save(
			DublinCoreRightsManagementAccessRights entity) {
		return dublinCoreRightsManagementAccessRightsCrudRepository.save(entity);
	}

}
