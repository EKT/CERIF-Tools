/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for services.
 * 
 */
public interface ServiceRepository extends CrudRepository<Service, String> {

	Service findById(Long id);
	
	List<Service> findByAcronym(String acronym);
	
	Service findByUri(String uri);
}

