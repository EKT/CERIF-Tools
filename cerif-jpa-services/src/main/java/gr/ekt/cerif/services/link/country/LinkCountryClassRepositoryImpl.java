package gr.ekt.cerif.services.link.country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Country_Class;

@Component
public class LinkCountryClassRepositoryImpl implements
		LinkCountryClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkCountryClassRepositoryImpl.class);
	
	@Autowired
	private LinkCountryClassCrudRepository linkCountryClassCrudRepository;

	@Override
	public void delete(Country_Class entity) {
		linkCountryClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Country_Class> entities) {
		linkCountryClassCrudRepository.save(entities);
	}

	@Override
	public Iterable<Country_Class> save(Iterable<Country_Class> entities) {
		return linkCountryClassCrudRepository.save(entities);
	}

	@Override
	public Country_Class save(Country_Class entity) {
		return linkCountryClassCrudRepository.save(entity);
	}

}
