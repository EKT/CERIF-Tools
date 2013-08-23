package gr.ekt.cerif.services.link.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Equipment_Class;

@Component
public class LinkEquipmentClassRepositoryImpl implements
		LinkEquipmentClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentClassRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentClassCrudRepository linkEquipmentClassmCrudRepository;

	@Override
	public void delete(Equipment_Class entity) {
		linkEquipmentClassmCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Class> entities) {
		linkEquipmentClassmCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment_Class> save(Iterable<Equipment_Class> entities) {
		return linkEquipmentClassmCrudRepository.save(entities);
	}

	@Override
	public Equipment_Class save(Equipment_Class entity) {
		return linkEquipmentClassmCrudRepository.save(entity);
	}

}
