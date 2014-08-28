package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Indicator;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentIndicatorCrudRepository  extends CrudRepository<ResultPatent_Indicator, Long>{
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_Indicator> findByIndicator(Indicator indicator);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_Indicator> findByResultPatent(ResultPatent resultPatent);

}
