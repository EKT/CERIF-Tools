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

	void delete(ResultPatent entity);
	
	Iterable<ResultPatent> save(Iterable<ResultPatent> entities);
	
	ResultPatent save(ResultPatent entity);
}
