package gr.ekt.cerif.services;


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
	SelectionResult select(SelectionOptions options) throws SelectionException;

}
