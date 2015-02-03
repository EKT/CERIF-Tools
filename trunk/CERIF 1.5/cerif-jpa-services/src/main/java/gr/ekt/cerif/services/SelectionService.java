package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;

import java.util.List;

/**
 * Selection service.
 */
public interface SelectionService {
	
	/**
	 * Selects a list of CERIF entities based on some options.
	 * @param options The selection options.
	 * @return a list of entities.
	 * @throws SelectionException
	 */
	List<CerifEntity> select(SelectionOptions options) throws SelectionException;
	
	/**
	 * Selects a list of CERIF identifiers based on some options. 
	 * In addition, it returns some meta-data, such as page size, offset etc.  
	 * @param options The selection options.
	 * @return a selection result.
	 * @throws SelectionException
	 */
	SelectionResult selectIdentifiers(SelectionOptions options) throws SelectionException;

}
