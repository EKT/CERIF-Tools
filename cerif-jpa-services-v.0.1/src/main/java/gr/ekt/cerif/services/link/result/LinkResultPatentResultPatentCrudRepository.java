package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentResultPatentCrudRepository extends CrudRepository<ResultPatent_ResultPatent, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_ResultPatent> findByResultPatent1(ResultPatent resultPatent);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_ResultPatent> findByResultPatent2(ResultPatent resultPatent);

}
