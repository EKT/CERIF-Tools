package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Funding;

@Component
public class LinkResultProductFundingRepositoryImpl implements
		LinkResultProductFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductFundingRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductFundingCrudRepository linkResultProductFundingnCrudRepository;

	@Override
	public void delete(ResultProduct_Funding entity) {
		linkResultProductFundingnCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Funding> entities) {
		linkResultProductFundingnCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Funding> save(
			Iterable<ResultProduct_Funding> entities) {
		return linkResultProductFundingnCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Funding save(ResultProduct_Funding entity) {
		return linkResultProductFundingnCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_Funding> findByFunding(Funding funding) {
		return linkResultProductFundingnCrudRepository.findByFunding(funding);
	}

	@Override
	public List<ResultProduct_Funding> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultProductFundingnCrudRepository.findByResultProduct(resultProduct);
	}

}
