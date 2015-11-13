package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ResultProductCrudRepository extends CrudRepository<ResultProduct, Long> {

	public List<ResultProduct> findAll();
	
	public Page<ResultProduct> findAll(Pageable page);

	public ResultProduct findByUuid(String uuid);
	
	public ResultProduct findById(Long id);
	
	public List<ResultProduct> findByUri(String uri);
	
}
