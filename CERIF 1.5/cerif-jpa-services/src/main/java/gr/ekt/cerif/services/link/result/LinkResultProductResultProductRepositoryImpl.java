package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

@Component
public class LinkResultProductResultProductRepositoryImpl implements
		LinkResultProductResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductResultProductRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductResultProductCrudRepository linkResultProductResultProductCrudRepository;

	@Override
	public void delete(ResultProduct_ResultProduct entity) {
		linkResultProductResultProductCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_ResultProduct> entities) {
		linkResultProductResultProductCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_ResultProduct> save(
			Iterable<ResultProduct_ResultProduct> entities) {
		return linkResultProductResultProductCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_ResultProduct save(ResultProduct_ResultProduct entity) {
		return linkResultProductResultProductCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_ResultProduct> findByResultProduct1(
			ResultProduct resultProduct) {
		return linkResultProductResultProductCrudRepository.findByResultProduct1(resultProduct);
	}

	@Override
	public List<ResultProduct_ResultProduct> findByResultProduct2(
			ResultProduct resultProduct) {
		return linkResultProductResultProductCrudRepository.findByResultProduct2(resultProduct);
	}

}
