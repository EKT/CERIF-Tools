/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifComponent;

import java.util.List;

/**
 * Index service for CERIF entities.
 * 
 */
public interface IndexService {

	void createIndex();
	
	List<CerifComponent> queryIndex(String q);
	
}
