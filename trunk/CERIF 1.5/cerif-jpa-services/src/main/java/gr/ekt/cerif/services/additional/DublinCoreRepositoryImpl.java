package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCore;

@Component
public class DublinCoreRepositoryImpl implements DublinCoreRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreRepositoryImpl.class);
	
	@Autowired
	private DublinCoreCrudRepository dublinCoreCrudRepository;

	@Override
	public void delete(DublinCore entity) {
		dublinCoreCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCore> entities) {
		dublinCoreCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCore> save(Iterable<DublinCore> entities) {
		return dublinCoreCrudRepository.save(entities);
	}

	@Override
	public DublinCore save(DublinCore entity) {
		return dublinCoreCrudRepository.save(entity);
	}

}
