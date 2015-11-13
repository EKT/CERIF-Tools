/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Prize;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for prizes.
 * 
 */
public interface PrizeCrudRepository extends CrudRepository<Prize, Long> {
	
	public List<Prize> findAll();
	
	public Page<Prize> findAll(Pageable page);

	public Prize findById(Long id);

	public List<Prize> findByUri(String uri);

	public Prize findByUuid(String uuid);

}
