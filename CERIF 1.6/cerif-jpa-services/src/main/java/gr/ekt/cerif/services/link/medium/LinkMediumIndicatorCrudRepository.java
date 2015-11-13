package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMediumIndicatorCrudRepository extends CrudRepository<Medium_Indicator, Long> {
	
	List<Medium_Indicator> findByIndicator(Indicator indicator);
	
	List<Medium_Indicator> findByMedium(Medium medium);

}
