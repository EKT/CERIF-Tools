package gr.ekt.cerif.services.link.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Equipment_Measurement;

@Component
public class LinkEquipmentMeasurementRepositoryImpl implements
		LinkEquipmentMeasurementRepository {

	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentMeasurementCrudRepository linkEquipmentMeasurementCrudRepository;
	
	@Override
	public void delete(Equipment_Measurement entity) {
		linkEquipmentMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Measurement> entities) {
		linkEquipmentMeasurementCrudRepository.save(entities);
	}

	@Override
	public Iterable<Equipment_Measurement> save(
			Iterable<Equipment_Measurement> entities) {
		return linkEquipmentMeasurementCrudRepository.save(entities);
	}

	@Override
	public Equipment_Measurement save(Equipment_Measurement entity) {
		return linkEquipmentMeasurementCrudRepository.save(entity);
	}

}
