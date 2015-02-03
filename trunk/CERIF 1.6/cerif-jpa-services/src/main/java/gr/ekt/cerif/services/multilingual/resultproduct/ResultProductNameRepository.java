package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductName;

public interface ResultProductNameRepository {

	public void delete(ResultProductName entity); 
	
	public void delete(Iterable<ResultProductName> entities); 

	public Iterable<ResultProductName> save(Iterable<ResultProductName> entities); 
	
	public ResultProductName save(ResultProductName entity);
	
	List<ResultProductName> findByResultProduct(ResultProduct resultProduct);
}
