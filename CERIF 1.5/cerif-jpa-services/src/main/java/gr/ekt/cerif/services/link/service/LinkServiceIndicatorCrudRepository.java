package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceIndicatorCrudRepository extends CrudRepository<Service_Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_Indicator> findByIndicator(Indicator Iindicator);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Service_Indicator> findByService(Service service);

}
