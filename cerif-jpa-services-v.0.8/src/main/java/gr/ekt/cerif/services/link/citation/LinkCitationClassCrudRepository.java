package gr.ekt.cerif.services.link.citation;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkCitationClassCrudRepository extends CrudRepository<Citation_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Citation_Class> findByCitation(Citation citation);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Citation_Class> findBytheClass(Class theClass);

}
