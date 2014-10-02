package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between resultProducts and mediums.
 * 
 */
public interface LinkResultProductMediumRepository {

	public void delete(ResultProduct_Medium entity); 
	
	public void delete(Iterable<ResultProduct_Medium> entities); 

	public Iterable<ResultProduct_Medium> save(Iterable<ResultProduct_Medium> entities); 
	
	public ResultProduct_Medium save(ResultProduct_Medium entity);
	
	List<ResultProduct_Medium> findByMedium(Medium medium);
	
	List<ResultProduct_Medium> findByResultProduct(ResultProduct resultProduct);
	
}
