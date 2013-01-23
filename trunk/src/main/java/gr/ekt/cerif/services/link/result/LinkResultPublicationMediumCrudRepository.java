package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationMediumCrudRepository extends CrudRepository<ResultPublication_Medium, Long> {

	List<ResultPublication_Medium> findByResultPublication(ResultPublication resultPublication);
	
}
