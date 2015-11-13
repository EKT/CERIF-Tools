package gr.ekt.cerif.services.link.service;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkServicePostalAddressCrudRepository extends CrudRepository<Service_PostalAddress, Long> {
	
	List<Service_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<Service_PostalAddress> findByService(Service service);

}
