package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreCreator;

@Deprecated
@Component
public class DublinCoreCreatorRepositoryImpl implements
		DublinCoreCreatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreCreatorRepositoryImpl.class);
	
	@Autowired
	private DublinCoreCreatorCrudRepository dublinCoreCreatorCrudRepository;

	@Override
	public void delete(DublinCoreCreator entity) {
		dublinCoreCreatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreCreator> entities) {
		dublinCoreCreatorCrudRepository.save(entities);
	}

	@Override
	public Iterable<DublinCoreCreator> save(Iterable<DublinCoreCreator> entities) {
		return dublinCoreCreatorCrudRepository.save(entities);
	}

	@Override
	public DublinCoreCreator save(DublinCoreCreator entity) {
		return dublinCoreCreatorCrudRepository.save(entity);
	}

}
