package gr.ekt.cerif.services.link.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMediumClassCrudRepository extends CrudRepository<Medium_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Class> findByMedium(Medium medium);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Class> findBytheClass(Class theClass);

}
