package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreContributor;

@Component
public class DublinCoreContributorRepositoryImpl implements
		DublinCoreContributorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreContributorRepositoryImpl.class);
	
	@Autowired
	private DublinCoreContributorCrudRepository dublinCoreContributorCrudRepository;

	@Override
	public void delete(DublinCoreContributor entity) {
		dublinCoreContributorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreContributor> entities) {
		dublinCoreContributorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreContributor> save(
			Iterable<DublinCoreContributor> entities) {
		return dublinCoreContributorCrudRepository.save(entities);
	}

	@Override
	public DublinCoreContributor save(DublinCoreContributor entity) {
		return dublinCoreContributorCrudRepository.save(entity);
	}

}
