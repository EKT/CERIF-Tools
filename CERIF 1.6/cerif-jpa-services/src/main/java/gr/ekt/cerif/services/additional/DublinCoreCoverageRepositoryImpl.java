package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreCoverage;

@Component
public class DublinCoreCoverageRepositoryImpl implements
		DublinCoreCoverageRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreCoverageRepositoryImpl.class);
	
	@Autowired
	private DublinCoreCoverageCrudRepository dublinCoreCoverageCrudRepository;

	@Override
	public void delete(DublinCoreCoverage entity) {
		dublinCoreCoverageCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreCoverage> entities) {
		dublinCoreCoverageCrudRepository.save(entities);
	}

	@Override
	public Iterable<DublinCoreCoverage> save(
			Iterable<DublinCoreCoverage> entities) {
		return dublinCoreCoverageCrudRepository.save(entities);
	}

	@Override
	public DublinCoreCoverage save(DublinCoreCoverage entity) {
		return dublinCoreCoverageCrudRepository.save(entity);
	}

}
