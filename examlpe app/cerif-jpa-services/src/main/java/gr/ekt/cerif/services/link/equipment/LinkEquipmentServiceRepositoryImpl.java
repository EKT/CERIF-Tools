package gr.ekt.cerif.services.link.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Equipment_Service;

@Component
public class LinkEquipmentServiceRepositoryImpl implements
		LinkEquipmentServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentServiceRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentServiceCrudRepository linkEquipmentServiceCrudRepository;

	@Override
	public void delete(Equipment_Service entity) {
		linkEquipmentServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Service> entities) {
		linkEquipmentServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment_Service> save(Iterable<Equipment_Service> entities) {
		return linkEquipmentServiceCrudRepository.save(entities);
	}

	@Override
	public Equipment_Service save(Equipment_Service entity) {
		return linkEquipmentServiceCrudRepository.save(entity);
	}

}
