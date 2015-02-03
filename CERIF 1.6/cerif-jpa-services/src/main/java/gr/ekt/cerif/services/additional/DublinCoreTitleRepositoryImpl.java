package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreTitle;

@Deprecated
@Component
public class DublinCoreTitleRepositoryImpl implements DublinCoreTitleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreTitleRepositoryImpl.class);
	
	@Autowired
	private DublinCoreTitleCrudRepository dublinCoreTitleCrudRepository;

	@Override
	public void delete(DublinCoreTitle entity) {
		dublinCoreTitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreTitle> entities) {
		dublinCoreTitleCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreTitle> save(Iterable<DublinCoreTitle> entities) {
		return dublinCoreTitleCrudRepository.save(entities);
	}

	@Override
	public DublinCoreTitle save(DublinCoreTitle entity) {
		return dublinCoreTitleCrudRepository.save(entity);
	}

}
