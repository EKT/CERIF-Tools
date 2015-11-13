package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentMediumCrudRepository extends CrudRepository<ResultPatent_Medium, Long> {
	
	List<ResultPatent_Medium> findByMedium(Medium medium);
	
	List<ResultPatent_Medium> findByResultPatent(ResultPatent resultPatent);

}
