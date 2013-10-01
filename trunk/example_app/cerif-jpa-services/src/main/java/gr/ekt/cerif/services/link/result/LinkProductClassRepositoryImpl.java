package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Class;

@Component
public class LinkProductClassRepositoryImpl implements
		LinkProductClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProductClassRepositoryImpl.class);
	
	@Autowired
	private LinkProductClassCrudRepository linkProductClassCrudRepository;

	@Override
	public void delete(ResultProduct_Class entity) {
		linkProductClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Class> entities) {
		linkProductClassCrudRepository.save(entities);
	}

	@Override
	public Iterable<ResultProduct_Class> save(
			Iterable<ResultProduct_Class> entities) {
		return linkProductClassCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Class save(ResultProduct_Class entity) {
		return linkProductClassCrudRepository.save(entity);
	}

}
