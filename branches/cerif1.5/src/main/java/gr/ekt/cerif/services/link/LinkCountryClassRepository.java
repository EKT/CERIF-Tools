package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Country_Class;
import gr.ekt.cerif.services.second.CountryRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between countries and classes.
* 
*/
@Component
public class LinkCountryClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Country_Class entity) {
		if (entity.getCountry() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a country and a class.");
		}
		if (entity.getCountry().getCode() == null) {
			countryRepository.save(entity.getCountry());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Country_Class> entityList) {
		for (Country_Class entity : entityList) {
			save(entity);
		}
	}
	
}
