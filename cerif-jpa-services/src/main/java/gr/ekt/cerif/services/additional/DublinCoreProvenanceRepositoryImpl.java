package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreProvenance;

@Component
public class DublinCoreProvenanceRepositoryImpl implements
		DublinCoreProvenanceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreProvenanceRepositoryImpl.class);
	
	@Autowired
	private DublinCoreProvenanceCrudRepository dublinCoreProvenanceCrudRepository;

	@Override
	public void delete(DublinCoreProvenance entity) {
		dublinCoreProvenanceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreProvenance> entities) {
		dublinCoreProvenanceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreProvenance> save(
			Iterable<DublinCoreProvenance> entities) {
		return dublinCoreProvenanceCrudRepository.save(entities);
	}

	@Override
	public DublinCoreProvenance save(DublinCoreProvenance entity) {
		return dublinCoreProvenanceCrudRepository.save(entity);
	}

}
