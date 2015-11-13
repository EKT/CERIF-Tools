/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationNameAbbreviationCrudRepository extends CrudRepository<ResultPublicationNameAbbreviation, Long> {
	
	List<ResultPublicationNameAbbreviation> findByResultPublication(ResultPublication resultPublication);

}
