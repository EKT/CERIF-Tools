/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;

/**
 * @author bonisv
 *
 */
public interface ResultPublicationNameAbbreviationRepository {

	public void delete(ResultPublicationNameAbbreviation entity); 
	
	public void delete(Iterable<ResultPublicationNameAbbreviation> entities); 

	public Iterable<ResultPublicationNameAbbreviation> save(Iterable<ResultPublicationNameAbbreviation> entities); 
	
	public ResultPublicationNameAbbreviation save(ResultPublicationNameAbbreviation entity);
}
