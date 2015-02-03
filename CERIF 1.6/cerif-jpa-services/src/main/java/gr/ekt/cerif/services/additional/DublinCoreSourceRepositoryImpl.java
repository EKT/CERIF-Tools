package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreSource;

@Deprecated
@Component
public class DublinCoreSourceRepositoryImpl implements
		DublinCoreSourceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreSourceRepositoryImpl.class);
	
	@Autowired
	private DublinCoreSourceCrudRepository dublinCoreSourceCrudRepository;

	@Override
	public void delete(DublinCoreSource entity) {
		dublinCoreSourceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreSource> entities) {
		dublinCoreSourceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreSource> save(Iterable<DublinCoreSource> entities) {
		return dublinCoreSourceCrudRepository.save(entities);
	}

	@Override
	public DublinCoreSource save(DublinCoreSource entity) {
		return dublinCoreSourceCrudRepository.save(entity);
	}

}
