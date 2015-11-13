package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultProductFacilityCrudRepository extends CrudRepository<ResultProduct_Facility, Long> {
	
	List<ResultProduct_Facility> findByFacility(Facility facility);
	
	List<ResultProduct_Facility> findByResultProduct(ResultProduct resultProduct);

}
