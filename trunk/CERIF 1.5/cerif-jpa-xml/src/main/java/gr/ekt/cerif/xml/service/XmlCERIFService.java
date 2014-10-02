package gr.ekt.cerif.xml.service;

import gr.ekt.cerif.CerifEntity;

import java.util.List;

/**
 * CERIF XML service.
 *
 * @author Bill Bonis <bonisv@ekt.gr>
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public interface XmlCERIFService {
	
	/**
	 * Produces a CERIF XML of the given entities.
	 * @param entities The CERIF entities.
	 * @return a CERIF XML string.
	 */
	String makeXMLString(List<CerifEntity> entities);
	
	/**
	 * Produces a CERIF XML of the given entities, based on some additional options.
	 * @param entities The CERIF entities.
	 * @param options The options.
	 * @return a CERIF XML string.
	 */
	String makeXMLString(List<CerifEntity> entities, XmlCERIFOptions options);
	
	/**
	 * Produces a CERIF XML of the given entities.
	 * @param entities The CERIF entities.
	 * @return a CERIF XML byte array.
	 */
	byte[] makeXML(List<CerifEntity> entities);
		
	/**
	 * Produces a CERIF XML of the given entities, based on some additional options.
	 * @param entities The CERIF entities.
	 * @param options The options.
	 * @return a CERIF XML byte array.
	 */
	byte[] makeXML(List<CerifEntity> entities, XmlCERIFOptions options);

}
