package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationResultPatentCrudRepository extends CrudRepository<ResultPublication_ResultPatent, Long> {
	
	List<ResultPublication_ResultPatent> findByResultPatent(ResultPatent resultPatent);
	
	List<ResultPublication_ResultPatent> findByResultPublication(ResultPublication resultPublication);

}
