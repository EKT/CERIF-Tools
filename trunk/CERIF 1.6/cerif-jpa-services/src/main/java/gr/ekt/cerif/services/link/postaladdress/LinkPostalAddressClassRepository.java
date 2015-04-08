package gr.ekt.cerif.services.link.postaladdress;

import java.util.List;

import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between postalAddresses and classes.
 * 
 */
public interface LinkPostalAddressClassRepository {

	public void delete(PostalAddress_Class entity); 
	
	public void delete(Iterable<PostalAddress_Class> entities); 

	public Iterable<PostalAddress_Class> save(Iterable<PostalAddress_Class> entities); 
	
	public PostalAddress_Class save(PostalAddress_Class entity);
	
	List<PostalAddress_Class> findByPostalAddress(PostalAddress postalAddress);
	
	List<PostalAddress_Class> findByTheClass(Class theClass);
	
}
