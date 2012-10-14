package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Country;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.CountryRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and countries.
 * 
 */
@Component
public class LinkPersonCountryRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public void save(Person_Country entity) {
		if (entity.getPerson() == null || entity.getCountry() == null) {
			throw new IllegalArgumentException("Please provide both a person and a country.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getCountry().getCode() == null) {
			countryRepository.save(entity.getCountry());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Country> entityList) {
		for (Person_Country entity : entityList) {
			save(entity);
		}
	}
	
}
