package gr.ekt.cerif.services.link.postaladdress;

import gr.ekt.cerif.entities.link.PostalAddress_Class;

/**
 * A repository for links between postalAddresses and classes.
 * 
 */
public interface LinkPostalAddressClassRepository {

	public void delete(PostalAddress_Class entity); 
	
	public void delete(Iterable<PostalAddress_Class> entities); 

	public Iterable<PostalAddress_Class> save(Iterable<PostalAddress_Class> entities); 
	
	public PostalAddress_Class save(PostalAddress_Class entity);
	
}
