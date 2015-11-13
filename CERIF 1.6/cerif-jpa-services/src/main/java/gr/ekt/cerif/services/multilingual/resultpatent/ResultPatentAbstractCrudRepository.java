package gr.ekt.cerif.services.multilingual.resultpatent;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultPatentAbstractCrudRepository  extends CrudRepository<ResultPatentAbstract, Long> {
	
	List<ResultPatentAbstract> findByResultPatent(ResultPatent resultPatent);

}
