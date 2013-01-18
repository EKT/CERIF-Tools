/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Service;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for services.
 * 
 */
public interface ServiceRepository extends CrudRepository<Service, String> {

}

