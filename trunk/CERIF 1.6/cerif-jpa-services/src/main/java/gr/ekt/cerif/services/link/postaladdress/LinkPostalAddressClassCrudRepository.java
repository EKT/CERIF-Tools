package gr.ekt.cerif.services.link.postaladdress;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPostalAddressClassCrudRepository extends CrudRepository<PostalAddress_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PostalAddress_Class> findByPostalAddress(PostalAddress postalAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PostalAddress_Class> findByTheClass(Class theClass);

}
