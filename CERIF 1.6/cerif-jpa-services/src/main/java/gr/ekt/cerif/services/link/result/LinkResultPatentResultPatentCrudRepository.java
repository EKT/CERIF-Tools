package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentResultPatentCrudRepository extends CrudRepository<ResultPatent_ResultPatent, Long> {
	
	List<ResultPatent_ResultPatent> findByResultPatent1(ResultPatent resultPatent);
	
	List<ResultPatent_ResultPatent> findByResultPatent2(ResultPatent resultPatent);

}
