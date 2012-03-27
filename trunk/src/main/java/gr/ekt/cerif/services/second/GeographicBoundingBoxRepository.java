/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface GeographicBoundingBoxRepository extends CrudRepository<GeographicBoundingBox, String> {

}
