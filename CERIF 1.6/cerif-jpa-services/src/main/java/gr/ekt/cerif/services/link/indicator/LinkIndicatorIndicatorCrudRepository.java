package gr.ekt.cerif.services.link.indicator;

import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkIndicatorIndicatorCrudRepository extends CrudRepository<Indicator_Indicator, Long> {
	
	List<Indicator_Indicator> findByIndicator1(Indicator Indicator);
	
	List<Indicator_Indicator> findByIndicator2(Indicator indicator);

}
