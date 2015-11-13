package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentClassCrudRepository  extends CrudRepository<ResultPatent_Class, Long>{
	
	List<ResultPatent_Class> findByResultPatent(ResultPatent resultPatent);
	
	List<ResultPatent_Class> findBytheClass(Class theClass);

}
