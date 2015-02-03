package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

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

	@Override
	public List<Equipment_Indicator> findByIndicator(Indicator indicator) {
		return linkEquipmentIndicatorCrudRepository.findByIndicator(indicator);
	}

	@Override
	public List<Equipment_Indicator> findByEquipment(Equipment equipment) {
		return linkEquipmentIndicatorCrudRepository.findByEquipment(equipment);
	}

}
