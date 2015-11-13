package gr.ekt.cerif.services.link.electronicaddress;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkElectronicAddressClassCrudRepository extends CrudRepository<ElectronicAddress_Class, Long> {
	
	List<ElectronicAddress_Class> findByElectronicAddress(ElectronicAddress electronicAddress);
	
	List<ElectronicAddress_Class> findBytheClass(Class theClass);

}
