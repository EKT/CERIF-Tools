package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreDescription;

@Deprecated
@Component
public class DublinCoreDescriptionRepositoryImpl implements
		DublinCoreDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreDescriptionRepositoryImpl.class);
	
	@Autowired
	private DublinCoreDescriptionCrudRepository dublinCoreDescriptionCrudRepository;

	@Override
	public void delete(DublinCoreDescription entity) {
		dublinCoreDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreDescription> entities) {
		dublinCoreDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreDescription> save(
			Iterable<DublinCoreDescription> entities) {
		return dublinCoreDescriptionCrudRepository.save(entities);
	}

	@Override
	public DublinCoreDescription save(DublinCoreDescription entity) {
		return dublinCoreDescriptionCrudRepository.save(entity);
	}

}
