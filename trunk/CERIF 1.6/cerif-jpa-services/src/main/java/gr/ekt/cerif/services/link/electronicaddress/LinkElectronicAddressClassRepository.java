package gr.ekt.cerif.services.link.electronicaddress;

import java.util.List;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between electronicAddresss and classes.
 * 
 */
public interface LinkElectronicAddressClassRepository {

	public void delete(ElectronicAddress_Class entity); 
	
	public void delete(Iterable<ElectronicAddress_Class> entities); 

	public Iterable<ElectronicAddress_Class> save(Iterable<ElectronicAddress_Class> entities); 
	
	public ElectronicAddress_Class save(ElectronicAddress_Class entity);
	
	List<ElectronicAddress_Class> findByElectronicAddress(ElectronicAddress electronicAddress);
	
	List<ElectronicAddress_Class> findBytheClass(Class theClass);
	
}
