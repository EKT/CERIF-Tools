/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class ResultProductRepositoryImpl implements ResultProductRepository {

	@Autowired
	ResultProductCrudRepository resultProductCrudRepository;

	@Override
	public void delete(ResultProduct entity) {
		resultProductCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<ResultProduct> entities) {
		resultProductCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<ResultProduct> save(Iterable<ResultProduct> entities) {
		return resultProductCrudRepository.save(entities);
	}

	@Override
	public ResultProduct save(ResultProduct entity) {
		return resultProductCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct> findAll() {
		return resultProductCrudRepository.findAll();
	}

	@Override
	public Page<ResultProduct> findAll(Pageable page) {
		return resultProductCrudRepository.findAll(page);
	}

}
