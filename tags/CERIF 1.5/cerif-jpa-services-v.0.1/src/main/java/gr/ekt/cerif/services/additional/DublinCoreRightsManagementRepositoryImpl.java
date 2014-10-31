package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreRightsManagement;

@Component
public class DublinCoreRightsManagementRepositoryImpl implements
		DublinCoreRightsManagementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreRightsManagementRepositoryImpl.class);
	
	@Autowired
	private DublinCoreRightsManagementCrudRepository dublinCoreRightsManagementCrudRepository;

	@Override
	public void delete(DublinCoreRightsManagement entity) {
		dublinCoreRightsManagementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreRightsManagement> entities) {
		dublinCoreRightsManagementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreRightsManagement> save(
			Iterable<DublinCoreRightsManagement> entities) {
		return dublinCoreRightsManagementCrudRepository.save(entities);
	}

	@Override
	public DublinCoreRightsManagement save(DublinCoreRightsManagement entity) {
		return dublinCoreRightsManagementCrudRepository.save(entity);
	}

}
