package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and equipments.
 * 
 */
@Component
public class LinkOrganisationUnitEquipmentRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	EquipmentRepository equipmentRepository;
	
	@Transactional
	public void save(OrganisationUnit_Equipment entity) {
		if (entity.getOrganisationUnit() == null || entity.getEquipment() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a equipment.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_Equipment> entityList) {
		for (OrganisationUnit_Equipment entity : entityList) {
			save(entity);
		}
	}

}
