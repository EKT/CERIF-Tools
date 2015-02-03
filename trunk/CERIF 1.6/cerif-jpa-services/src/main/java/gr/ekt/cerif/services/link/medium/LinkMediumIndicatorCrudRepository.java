package gr.ekt.cerif.services.link.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMediumIndicatorCrudRepository extends CrudRepository<Medium_Indicator, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Indicator> findByIndicator(Indicator indicator);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Indicator> findByMedium(Medium medium);

}
