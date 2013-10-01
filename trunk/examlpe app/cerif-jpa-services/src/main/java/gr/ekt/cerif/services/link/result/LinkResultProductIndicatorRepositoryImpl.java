package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;

@Component
public class LinkResultProductIndicatorRepositoryImpl implements
		LinkResultProductIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductIndicatorCrudRepository linkResultProductIndicatorCrudRepository;

	@Override
	public void delete(ResultProduct_Indicator entity) {
		linkResultProductIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Indicator> entities) {
		linkResultProductIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Indicator> save(
			Iterable<ResultProduct_Indicator> entities) {
		return linkResultProductIndicatorCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Indicator save(ResultProduct_Indicator entity) {
		return linkResultProductIndicatorCrudRepository.save(entity);
	}

}
