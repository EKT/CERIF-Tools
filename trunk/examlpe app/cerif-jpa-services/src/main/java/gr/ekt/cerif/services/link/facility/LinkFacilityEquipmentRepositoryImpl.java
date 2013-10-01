package gr.ekt.cerif.services.link.facility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Facility_Equipment;

@Component
public class LinkFacilityEquipmentRepositoryImpl implements
		LinkFacilityEquipmentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityEquipmentRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityEquipmentCrudRepository linkFacilityEquipmentCrudRepository;

	@Override
	public void delete(Facility_Equipment entity) {
		linkFacilityEquipmentCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Equipment> entities) {
		linkFacilityEquipmentCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Facility_Equipment> save(
			Iterable<Facility_Equipment> entities) {
		return linkFacilityEquipmentCrudRepository.save(entities);
	}

	@Override
	public Facility_Equipment save(Facility_Equipment entity) {
		return linkFacilityEquipmentCrudRepository.save(entity);
	}

}
