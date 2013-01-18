/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.CerifInfrastructureEntity;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;

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
	public CerifInfrastructureEntity save(CerifInfrastructureEntity entity) {
		if (entity instanceof Equipment) {
			entity = equipmentRepository.save((Equipment)entity);
		} else if (entity instanceof Facility) {
			entity = facilityRepository.save((Facility)entity);
		} else if (entity instanceof Service) {
			entity = serviceRepository.save((Service)entity);		
		} else {
			throw new IllegalArgumentException(String.format("Invalid infrastructure entity provided. %s", entity));
		}
		return entity;
	}

	/**
	 * Saves the provided infrastructure entities.
	 * @param entity The infrastructure entities.
	 */
	@SuppressWarnings("unchecked")
	public Iterable<? extends CerifInfrastructureEntity> save(Iterable<? extends CerifInfrastructureEntity> entityList) {
		
		final CerifInfrastructureEntity entity = (CerifInfrastructureEntity) entityList.iterator().next();
		
		if (entity instanceof Equipment) {
			entityList = equipmentRepository.save((Iterable<Equipment>)entityList);
		} else if (entity instanceof Facility) {
			entityList = facilityRepository.save((Iterable<Facility>)entityList);
		} else if (entity instanceof Service) {
			entityList = serviceRepository.save((Iterable<Service>)entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of infrastructure entities provided. %s", entity));
		}
		return entityList;
	}

	/**
	 * @return the equipmentRepository
	 */
	public EquipmentRepository getEquipmentRepository() {
		return equipmentRepository;
	}

	/**
	 * @return the facilityRepository
	 */
	public FacilityRepository getFacilityRepository() {
		return facilityRepository;
	}
	
}
