/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationVersionInfoCrudRepository extends CrudRepository<ResultPublicationVersionInfo, Long>  {
	
	List<ResultPublicationVersionInfo> findByResultPublication(ResultPublication resultPublication);

}
