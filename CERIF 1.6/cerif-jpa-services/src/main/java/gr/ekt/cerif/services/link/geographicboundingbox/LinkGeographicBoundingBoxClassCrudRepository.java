package gr.ekt.cerif.services.link.geographicboundingbox;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkGeographicBoundingBoxClassCrudRepository extends CrudRepository<GeographicBoundingBox_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBox_Class> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBox_Class> findByTheClass(Class theClass);

}
