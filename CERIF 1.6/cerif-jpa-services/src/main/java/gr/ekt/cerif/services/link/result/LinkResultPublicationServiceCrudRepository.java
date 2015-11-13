package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationServiceCrudRepository extends CrudRepository<ResultPublication_Service, Long> {
	
	List<ResultPublication_Service> findByService(Service service);
	
	List<ResultPublication_Service> findByResultPublication(ResultPublication resultPublication);

}
