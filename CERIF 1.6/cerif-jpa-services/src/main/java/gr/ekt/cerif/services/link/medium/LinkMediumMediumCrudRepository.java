package gr.ekt.cerif.services.link.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMediumMediumCrudRepository extends CrudRepository<Medium_Medium, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Medium> findByMedium1(Medium medium);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Medium_Medium> findByMedium2(Medium medium);

}
