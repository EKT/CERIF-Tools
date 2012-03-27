package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and countryes.
 * 
 */
@Component
public class LinkPersonPAddrRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PostalAddressRepository pAddrRepository;
	
	@Transactional
	public void save(Person_PostalAddress entity) {
		if (entity.getPerson() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both a person and a postal address.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getPostalAddress().getId() == null) {
			pAddrRepository.save(entity.getPostalAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_PostalAddress> entityList) {
		for (Person_PostalAddress entity : entityList) {
			save(entity);
		}
	}
	
}
