/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.CerifInfrastructureEntity;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF 2nd Level Entities.
 * 
 */
@Component
public class InfrastructurePersistenceService {
	
	/**
	 * The equipment repository.
	 */
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	/**
	 * The facility repository.
	 */
	@Autowired
	private FacilityRepository facilityRepository;
	
	/**
	 * The service repository.
	 */
	@Autowired
	private ServiceRepository serviceRepository;
		
	
	/**
	 * Saves the provided infrastructure entity.
	 * @param entity The infrastructure entity.
	 */
	public void save(CerifInfrastructureEntity entity) {
		if (entity instanceof Equipment) {
			equipmentRepository.save((Equipment)entity);
		} else if (entity instanceof Facility) {
			facilityRepository.save((Facility)entity);
		} else if (entity instanceof Service) {
			serviceRepository.save((Service)entity);		
		} else {
			throw new IllegalArgumentException(String.format("Invalid infrastructure entity provided. %s", entity));
		}
	}

	/**
	 * Saves the provided infrastructure entities.
	 * @param entity The infrastructure entities.
	 */
	@SuppressWarnings("unchecked")
	public void save(List<? extends CerifInfrastructureEntity> entityList) {
		
		final CerifInfrastructureEntity entity = (CerifInfrastructureEntity)entityList.get(0);
		
		if (entity instanceof Equipment) {
			equipmentRepository.save((List<Equipment>)entityList);
		} else if (entity instanceof Facility) {
			facilityRepository.save((List<Facility>)entityList);
		} else if (entity instanceof Service) {
			serviceRepository.save((List<Service>)entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of infrastructure entities provided. %s", entity));
		}
		
	}

}
