package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreCoverageTemporal;

@Component
public class DublinCoreCoverageTemporalRepositoryImpl implements
		DublinCoreCoverageTemporalRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreCoverageTemporalRepositoryImpl.class);
	
	@Autowired
	private DublinCoreCoverageTemporalCrudRepository dublinCoreCoverageTemporalCrudRepository;

	@Override
	public void delete(DublinCoreCoverageTemporal entity) {
		dublinCoreCoverageTemporalCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreCoverageTemporal> entities) {
		dublinCoreCoverageTemporalCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreCoverageTemporal> save(
			Iterable<DublinCoreCoverageTemporal> entities) {
		return dublinCoreCoverageTemporalCrudRepository.save(entities);
	}

	@Override
	public DublinCoreCoverageTemporal save(DublinCoreCoverageTemporal entity) {
		return dublinCoreCoverageTemporalCrudRepository.save(entity);
	}

}
