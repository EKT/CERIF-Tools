/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

}
