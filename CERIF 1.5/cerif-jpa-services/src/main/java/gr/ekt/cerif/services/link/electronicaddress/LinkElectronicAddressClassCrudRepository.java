package gr.ekt.cerif.services.link.electronicaddress;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkElectronicAddressClassCrudRepository extends CrudRepository<ElectronicAddress_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ElectronicAddress_Class> findByElectronicAddress(ElectronicAddress electronicAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ElectronicAddress_Class> findBytheClass(Class theClass);

}
