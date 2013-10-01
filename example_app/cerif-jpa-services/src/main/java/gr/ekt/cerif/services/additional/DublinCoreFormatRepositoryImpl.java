package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreFormat;

@Component
public class DublinCoreFormatRepositoryImpl implements
		DublinCoreFormatRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreFormatRepositoryImpl.class);
	
	@Autowired
	private DublinCoreFormatCrudRepository dublinCoreFormatCrudRepository;

	@Override
	public void delete(DublinCoreFormat entity) {
		dublinCoreFormatCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreFormat> entities) {
		dublinCoreFormatCrudRepository.save(entities);
	}

	@Override
	public Iterable<DublinCoreFormat> save(Iterable<DublinCoreFormat> entities) {
		return dublinCoreFormatCrudRepository.save(entities);
	}

	@Override
	public DublinCoreFormat save(DublinCoreFormat entity) {
		return dublinCoreFormatCrudRepository.save(entity);
	}

}
