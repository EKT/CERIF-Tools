package gr.ekt.cerif.services.link.geographicboundingbox;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkGeographicBoundingBoxClassCrudRepository extends CrudRepository<GeographicBoundingBox_Class, Long> {
	
	List<GeographicBoundingBox_Class> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	List<GeographicBoundingBox_Class> findByTheClass(Class theClass);

}
