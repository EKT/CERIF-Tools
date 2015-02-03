package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreRelation;

@Deprecated
@Component
public class DublinCoreRelationRepositoryImpl implements
		DublinCoreRelationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreRelationRepositoryImpl.class);
	
	@Autowired
	private DublinCoreRelationCrudRepository dublinCoreRelationCrudRepository;

	@Override
	public void delete(DublinCoreRelation entity) {
		dublinCoreRelationCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreRelation> entities) {
		dublinCoreRelationCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreRelation> save(
			Iterable<DublinCoreRelation> entities) {
		return dublinCoreRelationCrudRepository.save(entities);
	}

	@Override
	public DublinCoreRelation save(DublinCoreRelation entity) {
		return dublinCoreRelationCrudRepository.save(entity);
	}

}
