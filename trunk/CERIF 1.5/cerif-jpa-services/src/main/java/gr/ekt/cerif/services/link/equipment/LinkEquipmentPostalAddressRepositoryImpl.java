package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

@Component
public class LinkEquipmentPostalAddressRepositoryImpl implements
		LinkEquipmentPostalAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentPostalAddressRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentPostalAddressCrudRepository linkEquipmentPostalAddressCrudRepository;

	@Override
	public void delete(Equipment_PostalAddress entity) {
		linkEquipmentPostalAddressCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_PostalAddress> entities) {
		linkEquipmentPostalAddressCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment_PostalAddress> save(
			Iterable<Equipment_PostalAddress> entities) {
		return linkEquipmentPostalAddressCrudRepository.save(entities);
	}

	@Override
	public Equipment_PostalAddress save(Equipment_PostalAddress entity) {
		return linkEquipmentPostalAddressCrudRepository.save(entity);
	}

	@Override
	public List<Equipment_PostalAddress> findByPostalAddress(
			PostalAddress postalAddress) {
		return linkEquipmentPostalAddressCrudRepository.findByPostalAddress(postalAddress);
	}

	@Override
	public List<Equipment_PostalAddress> findByEquipment(Equipment equipment) {
		return linkEquipmentPostalAddressCrudRepository.findByEquipment(equipment);
	}

}
