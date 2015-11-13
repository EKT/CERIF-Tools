package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationResultPublicationCrudRepository extends CrudRepository<ResultPublication_ResultPublication, Long> {
	
	List<ResultPublication_ResultPublication> findByResultPublication1(ResultPublication resultPublication);
	
	List<ResultPublication_ResultPublication> findByResultPublication2(ResultPublication resultPublication);

}
