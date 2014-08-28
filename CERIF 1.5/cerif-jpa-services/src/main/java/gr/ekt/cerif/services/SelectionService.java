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

}
