package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreResourceIdentifier;

@Component
public class DublinCoreResourceIdentifierRepositoryImpl implements
		DublinCoreResourceIdentifierRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreResourceIdentifierRepositoryImpl.class);
	
	@Autowired
	private DublinCoreResourceIdentifierCrudRepository dublinCoreResourceIdentifierCrudRepository;

	@Override
	public void delete(DublinCoreResourceIdentifier entity) {
		dublinCoreResourceIdentifierCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreResourceIdentifier> entities) {
		dublinCoreResourceIdentifierCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreResourceIdentifier> save(
			Iterable<DublinCoreResourceIdentifier> entities) {
		return dublinCoreResourceIdentifierCrudRepository.save(entities);
	}

	@Override
	public DublinCoreResourceIdentifier save(DublinCoreResourceIdentifier entity) {
		return dublinCoreResourceIdentifierCrudRepository.save(entity);
	}

}
