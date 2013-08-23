package gr.ekt.cerif.services.link.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Equipment_Indicator;

@Component
public class LinkEquipmentIndicatorRepositoryImpl implements
		LinkEquipmentIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentIndicatorCrudRepository linkEquipmentIndicatorCrudRepository;

	@Override
	public void delete(Equipment_Indicator entity) {
		linkEquipmentIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Indicator> entities) {
		linkEquipmentIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Equipment_Indicator> save(
			Iterable<Equipment_Indicator> entities) {
		return linkEquipmentIndicatorCrudRepository.save(entities);
	}

	@Override
	public Equipment_Indicator save(Equipment_Indicator entity) {
		return linkEquipmentIndicatorCrudRepository.save(entity);
	}

}
