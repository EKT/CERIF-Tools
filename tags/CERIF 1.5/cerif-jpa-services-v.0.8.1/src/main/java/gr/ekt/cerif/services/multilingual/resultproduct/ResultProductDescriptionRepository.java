package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;

public interface ResultProductDescriptionRepository {
	
	public void delete(ResultProductDescription entity); 
	
	public void delete(Iterable<ResultProductDescription> entities); 

	public Iterable<ResultProductDescription> save(Iterable<ResultProductDescription> entities); 
	
	public ResultProductDescription save(ResultProductDescription entity);
	
	List<ResultProductDescription> findByResultProduct(ResultProduct resultProduct);

}
