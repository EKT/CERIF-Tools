/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;

/**
 * @author nkons
 *
 */
public interface InteroperabilityService {

	int consume(String xmlContents);
	
	int exportXml(CerifEntity component);
	
	int exportJson(CerifEntity component);
	
}
