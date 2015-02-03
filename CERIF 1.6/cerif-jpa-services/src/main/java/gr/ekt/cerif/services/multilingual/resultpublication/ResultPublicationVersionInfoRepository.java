/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationVersionInfoRepository {
	
	public void delete(ResultPublicationVersionInfo entity); 
	
	public void delete(Iterable<ResultPublicationVersionInfo> entities); 

	public Iterable<ResultPublicationVersionInfo> save(Iterable<ResultPublicationVersionInfo> entities); 
	
	public ResultPublicationVersionInfo save(ResultPublicationVersionInfo entity);
	
	List<ResultPublicationVersionInfo> findByResultPublication(ResultPublication resultPublication);

}
