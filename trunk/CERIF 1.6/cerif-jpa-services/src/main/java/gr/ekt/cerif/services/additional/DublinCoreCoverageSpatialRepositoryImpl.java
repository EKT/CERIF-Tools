package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreCoverageSpatial;

@Deprecated
@Component
public class DublinCoreCoverageSpatialRepositoryImpl implements
		DublinCoreCoverageSpatialRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreCoverageSpatialRepositoryImpl.class);
	
	@Autowired
	private DublinCoreCoverageSpatialCrudRepository dublinCoreCoverageSpatialCrudRepository;

	@Override
	public void delete(DublinCoreCoverageSpatial entity) {
		dublinCoreCoverageSpatialCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreCoverageSpatial> entities) {
		dublinCoreCoverageSpatialCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreCoverageSpatial> save(
			Iterable<DublinCoreCoverageSpatial> entities) {
		return dublinCoreCoverageSpatialCrudRepository.save(entities);
	}

	@Override
	public DublinCoreCoverageSpatial save(DublinCoreCoverageSpatial entity) {
		return dublinCoreCoverageSpatialCrudRepository.save(entity);
	}

}
