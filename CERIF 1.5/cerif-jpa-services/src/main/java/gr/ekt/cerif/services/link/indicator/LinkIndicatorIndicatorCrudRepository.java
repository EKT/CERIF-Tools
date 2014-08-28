package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkIndicatorIndicatorCrudRepository extends CrudRepository<Indicator_Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator_Indicator> findByIndicator1(Indicator Indicator);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator_Indicator> findByIndicator2(Indicator indicator);

}
