package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductServiceCrudRepository extends CrudRepository<ResultProduct_Service, Long> {
	
	List<ResultProduct_Service> findByService(Service service);
	
	List<ResultProduct_Service> findByResultProduct(ResultProduct resultProduct);

}
