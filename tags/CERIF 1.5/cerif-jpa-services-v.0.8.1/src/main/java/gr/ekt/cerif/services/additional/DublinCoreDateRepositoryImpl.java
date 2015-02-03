package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreDate;

@Component
public class DublinCoreDateRepositoryImpl implements DublinCoreDateRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreDateRepositoryImpl.class);
	
	@Autowired
	private DublinCoreDateCrudRepository dublinCoreDateCrudRepository;

	@Override
	public void delete(DublinCoreDate entity) {
		dublinCoreDateCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreDate> entities) {
		dublinCoreDateCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreDate> save(Iterable<DublinCoreDate> entities) {
		return dublinCoreDateCrudRepository.save(entities);
	}

	@Override
	public DublinCoreDate save(DublinCoreDate entity) {
		return dublinCoreDateCrudRepository.save(entity);
	}

}
