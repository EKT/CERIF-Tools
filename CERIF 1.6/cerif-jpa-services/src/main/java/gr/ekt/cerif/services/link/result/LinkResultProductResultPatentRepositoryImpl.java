package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkResultProductResultPatentRepositoryImpl implements LinkResultProductResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductResultPatentRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductResultPatentCrudRepository linkResultProductResultPatentCrudRepository;

	@Override
	public void delete(ResultProduct_ResultPatent entity) {
		linkResultProductResultPatentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_ResultPatent> entities) {
		linkResultProductResultPatentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_ResultPatent> save(
			Iterable<ResultProduct_ResultPatent> entities) {
		return linkResultProductResultPatentCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_ResultPatent save(ResultProduct_ResultPatent entity) {
		return linkResultProductResultPatentCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_ResultPatent> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultProductResultPatentCrudRepository.findByResultProduct(resultProduct);
	}

	@Override
	public List<ResultProduct_ResultPatent> findByResultPatent(
			ResultPatent resultPatent) {
		return linkResultProductResultPatentCrudRepository.findByResultPatent(resultPatent);
	}

}
