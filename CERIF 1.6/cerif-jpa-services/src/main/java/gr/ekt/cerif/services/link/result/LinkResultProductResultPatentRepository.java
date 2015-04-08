package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

/**
 * A repository for links between resultProduct and .resultPatent
 * 
 */
public interface LinkResultProductResultPatentRepository {
	
	public void delete(ResultProduct_ResultPatent entity); 
	
	public void delete(Iterable<ResultProduct_ResultPatent> entities); 

	public Iterable<ResultProduct_ResultPatent> save(Iterable<ResultProduct_ResultPatent> entities); 
	
	public ResultProduct_ResultPatent save(ResultProduct_ResultPatent entity);
	
	List<ResultProduct_ResultPatent> findByResultProduct(ResultProduct resultProduct);
	
	List<ResultProduct_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
