/**
 * 
 */
package gr.ekt.cerif.services.result;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.result.ResultPatent;


/**
 * A repository for patents.
 * 
 */
public interface ResultPatentRepository {

	void delete(ResultPatent entity); 
	
	void delete(Iterable<ResultPatent> entities); 

	Iterable<ResultPatent> save(Iterable<ResultPatent> entities); 
	
	ResultPatent save(ResultPatent entity);
	
	List<ResultPatent> findAll();
	
	Page<ResultPatent> findAll(Pageable page);
	
	ResultPatent findById(Long id);

	List<ResultPatent> findByUri(String uri);

	ResultPatent findByUuid(String uuid);
}
