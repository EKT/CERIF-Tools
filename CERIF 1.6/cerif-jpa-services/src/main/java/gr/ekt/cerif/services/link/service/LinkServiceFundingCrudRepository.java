package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServiceFundingCrudRepository extends CrudRepository<Service_Funding, Long> {
	
	List<Service_Funding> findByFunding(Funding funding);
	
	List<Service_Funding> findByService(Service service);

}
