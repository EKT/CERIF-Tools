/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Prize;

/**
 * @author bonisv
 *
 */
public interface PrizeRepository {

	public void delete(Prize entity); 
	
	public void delete(Iterable<Prize> entities); 

	public Iterable<Prize> save(Iterable<Prize> entities); 
	
	public Prize save(Prize entity);
}
