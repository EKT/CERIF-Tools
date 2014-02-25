package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;

@Component
public class ResultProductDescriptionRepositoryImpl implements ResultProductDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultProductDescriptionRepositoryImpl.class);
	
	@Autowired
	private ResultProductDescriptionCrudRepository resultProductDescriptionCrudRepository;

	@Override
	public void delete(ResultProductDescription entity) {
		resultProductDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProductDescription> entities) {
		resultProductDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProductDescription> save(Iterable<ResultProductDescription> entities) {
		return resultProductDescriptionCrudRepository.save(entities);
	}

	@Override
	public ResultProductDescription save(ResultProductDescription entity) {
		return resultProductDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<ResultProductDescription> findByResultProduct(
			ResultProduct resultProduct) {
		return resultProductDescriptionCrudRepository.findByResultProduct(resultProduct);
	}

}
