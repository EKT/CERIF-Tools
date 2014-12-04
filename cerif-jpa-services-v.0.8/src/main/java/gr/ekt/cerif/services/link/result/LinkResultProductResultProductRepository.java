package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for links between resultProducts.
 * 
 */
public interface LinkResultProductResultProductRepository {

	public void delete(ResultProduct_ResultProduct entity); 
	
	public void delete(Iterable<ResultProduct_ResultProduct> entities); 

	public Iterable<ResultProduct_ResultProduct> save(Iterable<ResultProduct_ResultProduct> entities); 
	
	public ResultProduct_ResultProduct save(ResultProduct_ResultProduct entity);
	
	List<ResultProduct_ResultProduct> findByResultProduct1(ResultProduct resultProduct);
	
	List<ResultProduct_ResultProduct> findByResultProduct2(ResultProduct resultProduct);
	
}
