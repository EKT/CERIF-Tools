package gr.ekt.cerif.services.link.geographicboundingbox;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkGeographicBoundingBoxGeographicBoundingBoxCrudRepository extends CrudRepository<GeographicBoundingBox_GeographicBoundingBox, Long> {
	
	List<GeographicBoundingBox_GeographicBoundingBox> findByGeographicBoundingBox1(GeographicBoundingBox geographicBoundingBox);
	
	List<GeographicBoundingBox_GeographicBoundingBox> findByGeographicBoundingBox2(GeographicBoundingBox geographicBoundingBox);

}
