package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between equipments and fundings.
 * 
 */
@Component
public class LinkEquipmentFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public Equipment_Funding save(Equipment_Funding entity) {
		if (entity.getEquipment() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a equipment and a funding.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<Equipment_Funding> save(Iterable<Equipment_Funding> entityList) {
		for (Equipment_Funding entity : entityList) {
			save(entity);
		}
		return entityList;
	}
	
}
