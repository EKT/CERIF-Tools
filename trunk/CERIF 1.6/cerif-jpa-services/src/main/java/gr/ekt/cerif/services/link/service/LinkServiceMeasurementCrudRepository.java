package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceMeasurementCrudRepository extends CrudRepository<Service_Measurement, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_Measurement> findByMeasurement(Measurement measurement);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_Measurement> findByService(Service service);

}
