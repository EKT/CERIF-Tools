/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;

import java.util.ArrayList;

/**
 * Index service for CERIF entities.
 * 
 */
public interface IndexService {

	void createIndex();
	
	ArrayList<CerifEntity> queryIndex(String q);
	
}
