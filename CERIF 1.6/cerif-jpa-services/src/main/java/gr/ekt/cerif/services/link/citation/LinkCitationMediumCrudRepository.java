package gr.ekt.cerif.services.link.citation;

import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkCitationMediumCrudRepository extends CrudRepository<Citation_Medium, Long> {
	
	List<Citation_Medium> findByCitation(Citation citation);
	
	List<Citation_Medium> findByMedium(Medium medium);

}
