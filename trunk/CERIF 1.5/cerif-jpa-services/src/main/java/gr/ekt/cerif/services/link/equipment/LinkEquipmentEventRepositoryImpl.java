package gr.ekt.cerif.services.link.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Equipment_Event;

@Component
public class LinkEquipmentEventRepositoryImpl implements
		LinkEquipmentEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentEventRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentEventCrudRepository linkEquipmentEventCrudRepository;

	@Override
	public void delete(Equipment_Event entity) {
		linkEquipmentEventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Event> entities) {
		linkEquipmentEventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment_Event> save(Iterable<Equipment_Event> entities) {
		return linkEquipmentEventCrudRepository.save(entities);
	}

	@Override
	public Equipment_Event save(Equipment_Event entity) {
		return linkEquipmentEventCrudRepository.save(entity);
	}

}
