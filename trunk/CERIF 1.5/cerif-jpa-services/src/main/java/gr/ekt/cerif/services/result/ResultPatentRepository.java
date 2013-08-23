/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPatent;


/**
 * A repository for patents.
 * 
 */
public interface ResultPatentRepository {

	public void delete(ResultPatent entity); 
	
	public void delete(Iterable<ResultPatent> entities); 

	public Iterable<ResultPatent> save(Iterable<ResultPatent> entities); 
	
	public ResultPatent save(ResultPatent entity);
}
