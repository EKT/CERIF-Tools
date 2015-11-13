package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationIndicatorCrudRepository extends CrudRepository<ResultPublication_Indicator, Long> {
	
	List<ResultPublication_Indicator> findByIndicator(Indicator indicator);
	
	List<ResultPublication_Indicator> findByResultPublication(ResultPublication resultPublication);

}
