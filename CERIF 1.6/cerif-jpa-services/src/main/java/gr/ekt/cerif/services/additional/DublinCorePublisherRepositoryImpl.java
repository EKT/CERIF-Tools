package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCorePublisher;

@Deprecated
@Component
public class DublinCorePublisherRepositoryImpl implements
		DublinCorePublisherRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCorePublisherRepositoryImpl.class);
	
	@Autowired
	private DublinCorePublisherCrudRepository dublinCorePublisherCrudRepository;

	@Override
	public void delete(DublinCorePublisher entity) {
		dublinCorePublisherCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCorePublisher> entities) {
		dublinCorePublisherCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCorePublisher> save(
			Iterable<DublinCorePublisher> entities) {
		return dublinCorePublisherCrudRepository.save(entities);
	}

	@Override
	public DublinCorePublisher save(DublinCorePublisher entity) {
		return dublinCorePublisherCrudRepository.save(entity);
	}

}
