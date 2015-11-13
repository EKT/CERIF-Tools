package gr.ekt.cerif.services.link.postaladdress;

import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPostalAddressClassCrudRepository extends CrudRepository<PostalAddress_Class, Long> {
	
	List<PostalAddress_Class> findByPostalAddress(PostalAddress postalAddress);
	
	List<PostalAddress_Class> findByTheClass(Class theClass);

}
