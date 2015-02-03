package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreResourceType;

@Deprecated
@Component
public class DublinCoreResourceTypeRepositoryImpl implements
		DublinCoreResourceTypeRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreResourceTypeRepositoryImpl.class);
	
	@Autowired
	private DublinCoreResourceTypeCrudRepository dublinCoreResourceTypeCrudRepository;

	@Override
	public void delete(DublinCoreResourceType entity) {
		dublinCoreResourceTypeCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreResourceType> entities) {
		dublinCoreResourceTypeCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreResourceType> save(
			Iterable<DublinCoreResourceType> entities) {
		return dublinCoreResourceTypeCrudRepository.save(entities);
	}

	@Override
	public DublinCoreResourceType save(DublinCoreResourceType entity) {
		return dublinCoreResourceTypeCrudRepository.save(entity);
	}

}
