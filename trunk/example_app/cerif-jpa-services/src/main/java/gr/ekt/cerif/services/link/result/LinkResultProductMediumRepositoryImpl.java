package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;

@Component
public class LinkResultProductMediumRepositoryImpl implements
		LinkResultProductMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductMediumRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductMediumCrudRepository linkResultProductMediumCrudRepository;

	@Override
	public void delete(ResultProduct_Medium entity) {
		linkResultProductMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Medium> entities) {
		linkResultProductMediumCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Medium> save(
			Iterable<ResultProduct_Medium> entities) {
		return linkResultProductMediumCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Medium save(ResultProduct_Medium entity) {
		return linkResultProductMediumCrudRepository.save(entity);
	}

}
