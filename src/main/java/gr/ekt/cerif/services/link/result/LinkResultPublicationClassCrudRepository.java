package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationClassCrudRepository extends CrudRepository<ResultPublication_Class, Long> {
	
	List<ResultPublication_Class> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Class> findByTheClass(Class theClass);

}
