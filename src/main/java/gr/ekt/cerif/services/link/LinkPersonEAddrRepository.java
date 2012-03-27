/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and electronic addresses.
 * 
 */
@Component
public class LinkPersonEAddrRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ElectronicAddressRepository eAddrRepository;
	
	@Transactional
	public void save(Person_ElectronicAddress entity) {
		if (entity.getPerson() == null || entity.getElectronicAddress() == null) {
			throw new IllegalArgumentException("Please provide both a person and an electronic address.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getElectronicAddress().getId() == null) {
			eAddrRepository.save(entity.getElectronicAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_ElectronicAddress> entityList) {
		for (Person_ElectronicAddress entity : entityList) {
			save(entity);
		}
	}
	
}
