package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentIndicatorCrudRepository  extends CrudRepository<ResultPatent_Indicator, Long>{
	
	List<ResultPatent_Indicator> findByIndicator(Indicator indicator);
	
	List<ResultPatent_Indicator> findByResultPatent(ResultPatent resultPatent);

}
