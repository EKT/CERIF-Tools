package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Class;

@Component
public class LinkResultProductClassRepositoryImpl implements
		LinkResultProductClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductClassRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductClassCrudRepository linkResultProductClassCrudRepository;

	@Override
	public void delete(ResultProduct_Class entity) {
		linkResultProductClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Class> entities) {
		linkResultProductClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Class> save(
			Iterable<ResultProduct_Class> entities) {
		return linkResultProductClassCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Class save(ResultProduct_Class entity) {
		return linkResultProductClassCrudRepository.save(entity);
	}

}
