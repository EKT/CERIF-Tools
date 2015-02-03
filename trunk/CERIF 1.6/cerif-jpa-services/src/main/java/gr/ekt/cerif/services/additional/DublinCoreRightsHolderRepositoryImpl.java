package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreRightsHolder;

@Deprecated
@Component
public class DublinCoreRightsHolderRepositoryImpl implements
		DublinCoreRightsHolderRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreRightsHolderRepositoryImpl.class);
	
	@Autowired
	private DublinCoreRightsHolderCrudRepository dublinCoreRightsHolderCrudRepository;

	@Override
	public void delete(DublinCoreRightsHolder entity) {
		dublinCoreRightsHolderCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreRightsHolder> entities) {
		dublinCoreRightsHolderCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreRightsHolder> save(
			Iterable<DublinCoreRightsHolder> entities) {
		return dublinCoreRightsHolderCrudRepository.save(entities);
	}

	@Override
	public DublinCoreRightsHolder save(DublinCoreRightsHolder entity) {
		return dublinCoreRightsHolderCrudRepository.save(entity);
	}

}
