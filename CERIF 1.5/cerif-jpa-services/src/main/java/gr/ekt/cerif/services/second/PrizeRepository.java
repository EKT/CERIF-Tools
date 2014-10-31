/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Prize;

/**
 * @author bonisv
 *
 */
public interface PrizeRepository {

	void delete(Prize entity); 
	
	void delete(Iterable<Prize> entities); 

	Iterable<Prize> save(Iterable<Prize> entities); 
	
	Prize save(Prize entity);
	
	List<Prize> findAll();
	
	Page<Prize> findAll(Pageable page);

	Prize findById(Long id);

	List<Prize> findByUri(String uri);

	Prize findByUuid(String uuid);
}
