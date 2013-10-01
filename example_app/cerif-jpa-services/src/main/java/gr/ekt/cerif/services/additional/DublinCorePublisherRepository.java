package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCorePublisher;

/**
 * A repository for dublin core publisher.
 * 
 */
public interface DublinCorePublisherRepository {

	public void delete(DublinCorePublisher entity); 
	
	public void delete(Iterable<DublinCorePublisher> entities); 

	public Iterable<DublinCorePublisher> save(Iterable<DublinCorePublisher> entities); 
	
	public DublinCorePublisher save(DublinCorePublisher entity);
}

