package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ResultPatentAbstractCrudRepository  extends CrudRepository<ResultPatentAbstract, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatentAbstract> findByResultPatent(ResultPatent resultPatent);

}
