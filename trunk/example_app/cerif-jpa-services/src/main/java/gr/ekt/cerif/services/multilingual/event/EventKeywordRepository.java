/**
 * 
 */
package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.features.multilingual.EventKeyword;

/**
 * @author bonisv
 *
 */
public interface EventKeywordRepository {

	public void delete(EventKeyword entity); 
	
	public void delete(Iterable<EventKeyword> entities); 

	public Iterable<EventKeyword> save(Iterable<EventKeyword> entities); 
	
	public EventKeyword save(EventKeyword entity);
}
