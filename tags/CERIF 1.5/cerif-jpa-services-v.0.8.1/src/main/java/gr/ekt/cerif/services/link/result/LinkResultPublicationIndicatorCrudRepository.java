package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationIndicatorCrudRepository extends CrudRepository<ResultPublication_Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Indicator> findByIndicator(Indicator indicator);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPublication_Indicator> findByResultPublication(ResultPublication resultPublication);

}
