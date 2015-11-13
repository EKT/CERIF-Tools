package gr.ekt.cerif.services.link.citation;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkCitationClassCrudRepository extends CrudRepository<Citation_Class, Long> {
	
	List<Citation_Class> findByCitation(Citation citation);
	
	List<Citation_Class> findBytheClass(Class theClass);

}
