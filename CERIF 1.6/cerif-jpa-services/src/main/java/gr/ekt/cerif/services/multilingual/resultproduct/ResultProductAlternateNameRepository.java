package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductAlternateName;

import java.util.List;

public interface ResultProductAlternateNameRepository {

	public void delete(ResultProductAlternateName entity); 
	
	public void delete(Iterable<ResultProductAlternateName> entities); 

	public Iterable<ResultProductAlternateName> save(Iterable<ResultProductAlternateName> entities); 
	
	public ResultProductAlternateName save(ResultProductAlternateName entity);
	
	List<ResultProductAlternateName> findByResultProduct(ResultProduct resultProduct);
	
}
