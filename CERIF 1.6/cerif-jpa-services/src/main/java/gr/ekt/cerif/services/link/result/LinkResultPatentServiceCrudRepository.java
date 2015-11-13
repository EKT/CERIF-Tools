package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentServiceCrudRepository extends CrudRepository<ResultPatent_Service, Long> {
	
	List<ResultPatent_Service> findByService(Service service);
	
	List<ResultPatent_Service> findByResultPatent(ResultPatent resultPatent);

}
