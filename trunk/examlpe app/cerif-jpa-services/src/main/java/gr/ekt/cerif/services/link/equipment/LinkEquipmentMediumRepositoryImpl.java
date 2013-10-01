package gr.ekt.cerif.services.link.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Equipment_Medium;

@Component
public class LinkEquipmentMediumRepositoryImpl implements LinkEquipmentMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentMediumRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentMediumCrudRepository linkEquipmentMediumCrudRepository;

	@Override
	public void delete(Equipment_Medium entity) {
		linkEquipmentMediumCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Equipment_Medium> entities) {
		linkEquipmentMediumCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Equipment_Medium> save(Iterable<Equipment_Medium> entities) {
		return linkEquipmentMediumCrudRepository.save(entities);
	}

	@Override
	public Equipment_Medium save(Equipment_Medium entity) {
		return linkEquipmentMediumCrudRepository.save(entity);
	}

}
