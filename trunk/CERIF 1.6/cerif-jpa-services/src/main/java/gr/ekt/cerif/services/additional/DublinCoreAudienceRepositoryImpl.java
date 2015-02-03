package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreAudience;

@Deprecated
@Component
public class DublinCoreAudienceRepositoryImpl implements
		DublinCoreAudienceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreAudienceRepositoryImpl.class);
	
	@Autowired
	private DublinCoreAudienceCrudRepository dublinCoreAudienceCrudRepository;

	@Override
	public void delete(DublinCoreAudience entity) {
		dublinCoreAudienceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreAudience> entities) {
		dublinCoreAudienceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreAudience> save(
			Iterable<DublinCoreAudience> entities) {
		return dublinCoreAudienceCrudRepository.save(entities);
	}

	@Override
	public DublinCoreAudience save(DublinCoreAudience entity) {
		return dublinCoreAudienceCrudRepository.save(entity);
	}

}
