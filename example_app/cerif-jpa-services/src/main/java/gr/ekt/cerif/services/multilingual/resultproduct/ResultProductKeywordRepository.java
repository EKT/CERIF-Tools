package gr.ekt.cerif.services.multilingual.resultproduct;

import gr.ekt.cerif.features.multilingual.ResultProductKeyword;

public interface ResultProductKeywordRepository {
	
	public void delete(ResultProductKeyword entity); 
	
	public void delete(Iterable<ResultProductKeyword> entities); 

	public Iterable<ResultProductKeyword> save(Iterable<ResultProductKeyword> entities); 
	
	public ResultProductKeyword save(ResultProductKeyword entity);

}
