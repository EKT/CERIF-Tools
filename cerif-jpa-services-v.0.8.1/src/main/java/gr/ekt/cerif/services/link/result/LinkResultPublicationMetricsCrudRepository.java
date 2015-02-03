package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Metrics;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationMetricsCrudRepository extends CrudRepository<ResultPublication_Metrics, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Metrics> findByMetrics(Metrics metrics);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Metrics> findByResultPublication(ResultPublication resultPublication);

}
