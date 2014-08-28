package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentClassCrudRepository  extends CrudRepository<ResultPatent_Class, Long>{
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_Class> findByResultPatent(ResultPatent resultPatent);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_Class> findBytheClass(Class theClass);

}
