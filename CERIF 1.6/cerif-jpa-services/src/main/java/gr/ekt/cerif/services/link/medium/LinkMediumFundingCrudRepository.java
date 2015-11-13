package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMediumFundingCrudRepository extends CrudRepository<Medium_Funding, Long> {
	
	List<Medium_Funding> findByFunding(Funding funding);
	
	List<Medium_Funding> findByMedium(Medium medium);

}
