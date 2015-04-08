package gr.ekt.cerif.services.link.postaladdress;

import gr.ekt.cerif.entities.link.PostalAddress_GeographicBoundingBox;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

/**
 * A repository for links between geographic bounding boxes and postalAddresses.
 * 
 */
public interface LinkPostalAddressGeographicBoundingBoxRepository {

	public void delete(PostalAddress_GeographicBoundingBox entity); 
	
	public void delete(Iterable<PostalAddress_GeographicBoundingBox> entities); 

	public Iterable<PostalAddress_GeographicBoundingBox> save(Iterable<PostalAddress_GeographicBoundingBox> entities); 
	
	public PostalAddress_GeographicBoundingBox save(PostalAddress_GeographicBoundingBox entity);
	
	List<PostalAddress_GeographicBoundingBox> findByPostalAddress(PostalAddress postalAddress);
	
	List<PostalAddress_GeographicBoundingBox> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
}
