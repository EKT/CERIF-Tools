package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMediumMediumCrudRepository extends CrudRepository<Medium_Medium, Long> {
	
	List<Medium_Medium> findByMedium1(Medium medium);
	
	List<Medium_Medium> findByMedium2(Medium medium);

}
