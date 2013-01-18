package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between electronicAddresss and classes.
 * 
 */
@Component
public class LinkElectronicAddressClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ElectronicAddressRepository electronicAddressRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public ElectronicAddress_Class save(ElectronicAddress_Class entity) {
		if (entity.getElectronicAddress() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a electronicAddress and a class.");
		}
		if (entity.getElectronicAddress().getId() == null) {
			electronicAddressRepository.save(entity.getElectronicAddress());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<ElectronicAddress_Class> save(Iterable<ElectronicAddress_Class> entityList) {
		for (ElectronicAddress_Class entity : entityList) {
			save(entity);
		}
		return entityList;
	}
	
}
