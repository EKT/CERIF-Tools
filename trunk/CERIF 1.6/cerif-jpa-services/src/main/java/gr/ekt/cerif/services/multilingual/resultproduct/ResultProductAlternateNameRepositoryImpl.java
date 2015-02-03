package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductAlternateName;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultProductAlternateNameRepositoryImpl implements ResultProductAlternateNameRepository {
		
	@Autowired
	private ResultProductAlternateNameCrudRepository repository;

	@Override
	public void delete(ResultProductAlternateName entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProductAlternateName> entities) {
		repository.delete(entities);
	}

	@Override
	public Iterable<ResultProductAlternateName> save(Iterable<ResultProductAlternateName> entities) {
		return repository.save(entities);
	}

	@Override
	public ResultProductAlternateName save(ResultProductAlternateName entity) {
		return repository.save(entity);
	}

	@Override
	public List<ResultProductAlternateName> findByResultProduct(ResultProduct resultProduct) {
		return repository.findByResultProduct(resultProduct);
	}

}
