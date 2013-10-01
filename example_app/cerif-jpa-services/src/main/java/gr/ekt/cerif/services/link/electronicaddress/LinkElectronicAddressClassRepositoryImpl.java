package gr.ekt.cerif.services.link.electronicaddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;

@Component
public class LinkElectronicAddressClassRepositoryImpl implements
		LinkElectronicAddressClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkElectronicAddressClassRepositoryImpl.class);
	
	@Autowired
	private LinkElectronicAddressClassCrudRepository linkElectronicAddressClassCrudRepository;

	@Override
	public void delete(ElectronicAddress_Class entity) {
		linkElectronicAddressClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ElectronicAddress_Class> entities) {
		linkElectronicAddressClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ElectronicAddress_Class> save(
			Iterable<ElectronicAddress_Class> entities) {
		return linkElectronicAddressClassCrudRepository.save(entities);
	}

	@Override
	public ElectronicAddress_Class save(ElectronicAddress_Class entity) {
		return linkElectronicAddressClassCrudRepository.save(entity);
	}

}
