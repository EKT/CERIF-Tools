package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Citation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationCitationCrudRepository extends CrudRepository<ResultPublication_Citation, Long> {
	
	List<ResultPublication_Citation> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Citation> findByCitation(Citation citation);

}
