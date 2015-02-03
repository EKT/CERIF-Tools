package gr.ekt.cerif.services.link.citation;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkCitationMediumCrudRepository extends CrudRepository<Citation_Medium, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Citation_Medium> findByCitation(Citation citation);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Citation_Medium> findByMedium(Medium medium);

}
