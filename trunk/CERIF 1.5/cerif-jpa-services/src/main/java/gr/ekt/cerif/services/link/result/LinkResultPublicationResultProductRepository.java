package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for links between resultPublications and resultProducts.
 * 
 */
public interface LinkResultPublicationResultProductRepository {

	public void delete(ResultPublication_ResultProduct entity); 
	
	public void delete(Iterable<ResultPublication_ResultProduct> entities); 

	public Iterable<ResultPublication_ResultProduct> save(Iterable<ResultPublication_ResultProduct> entities); 
	
	public ResultPublication_ResultProduct save(ResultPublication_ResultProduct entity);
	
	List<ResultPublication_ResultProduct> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_ResultProduct> findByResultProduct(ResultProduct resultProduct);
	
}
