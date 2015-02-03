/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import java.util.List;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumTitle;

/**
 * @author bonisv
 *
 */
public interface MediumTitleRepository {
	
	public void delete(MediumTitle entity); 
	
	public void delete(Iterable<MediumTitle> entities); 

	public Iterable<MediumTitle> save(Iterable<MediumTitle> entities); 
	
	public MediumTitle save(MediumTitle entity);
	
	List<MediumTitle> findByMedium(Medium medium);

}
