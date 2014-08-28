package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;

public interface ResultPatentKeywordRepository {
	
	public void delete(ResultPatentKeyword entity); 
	
	public void delete(Iterable<ResultPatentKeyword> entities); 

	public Iterable<ResultPatentKeyword> save(Iterable<ResultPatentKeyword> entities); 
	
	public ResultPatentKeyword save(ResultPatentKeyword entity);
	
	List<ResultPatentKeyword> findByResultPatent(ResultPatent resultPatent);

}
