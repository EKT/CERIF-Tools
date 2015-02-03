package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.second.Funding;

@Component
public class LinkEquipmentFundingRepositoryImpl implements
		LinkEquipmentFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEquipmentFundingRepositoryImpl.class);
	
	@Autowired
	private LinkEquipmentFundingCrudRepository linkEquipmentFundingCrudRepository;

	@Override
	public void delete(Equipment_Funding entity) {
		linkEquipmentFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Equipment_Funding> entities) {
		linkEquipmentFundingCrudRepository.delete(entities);		

	}

	@Override
	public Iterable<Equipment_Funding> save(Iterable<Equipment_Funding> entities) {
		return linkEquipmentFundingCrudRepository.save(entities);
	}

	@Override
	public Equipment_Funding save(Equipment_Funding entity) {
		return linkEquipmentFundingCrudRepository.save(entity);
	}

	@Override
	public List<Equipment_Funding> findByFunding(Funding funding) {
		return linkEquipmentFundingCrudRepository.findByFunding(funding);
	}

	@Override
	public List<Equipment_Funding> findByEquipment(Equipment equipment) {
		return linkEquipmentFundingCrudRepository.findByEquipment(equipment);
	}

}
