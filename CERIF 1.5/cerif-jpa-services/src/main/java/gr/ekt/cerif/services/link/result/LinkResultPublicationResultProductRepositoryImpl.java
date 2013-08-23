package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;

@Component
public class LinkResultPublicationResultProductRepositoryImpl implements
		LinkResultPublicationResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationResultProductRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationResultProductCrudRepository linkResultPublicationResultProductCrudRepository;

	@Override
	public void delete(ResultPublication_ResultProduct entity) {
		linkResultPublicationResultProductCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_ResultProduct> entities) {
		linkResultPublicationResultProductCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_ResultProduct> save(
			Iterable<ResultPublication_ResultProduct> entities) {
		return linkResultPublicationResultProductCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_ResultProduct save(
			ResultPublication_ResultProduct entity) {
		return linkResultPublicationResultProductCrudRepository.save(entity);
	}

}
