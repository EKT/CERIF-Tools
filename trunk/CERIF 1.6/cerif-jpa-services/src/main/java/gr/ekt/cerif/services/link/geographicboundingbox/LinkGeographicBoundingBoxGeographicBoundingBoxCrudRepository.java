package gr.ekt.cerif.services.link.geographicboundingbox;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkGeographicBoundingBoxGeographicBoundingBoxCrudRepository extends CrudRepository<GeographicBoundingBox_GeographicBoundingBox, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBox_GeographicBoundingBox> findByGeographicBoundingBox1(GeographicBoundingBox geographicBoundingBox);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBox_GeographicBoundingBox> findByGeographicBoundingBox2(GeographicBoundingBox geographicBoundingBox);

}
