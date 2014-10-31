/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Country;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * @author bonisv
 *
 */
@Component
public class CountryRepositoryImpl implements CountryRepository {

	private static final Logger log = LoggerFactory.getLogger(CountryRepositoryImpl.class);
	
	@Autowired
	private CountryCrudRepository countryCrudRepository;
	
	@Override
	public Country findByCode(String code) {
		return countryCrudRepository.findByCode(code);
	}

	@Override
	public Country findByUri(String uri) {
		return countryCrudRepository.findByUri(uri);
	}

	@Override
	public List<Country> findAll() {
		return countryCrudRepository.findAll();
	}

	@Override
	public void delete(Country entity) {
		countryCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Country> entities) {
		countryCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Country> save(Iterable<Country> entities) {
		return countryCrudRepository.save(entities);
	}

	@Override
	public Country save(Country entity) {
		return countryCrudRepository.save(entity);
	}

	@Override
	public Page<Country> findAll(Pageable page) {
		return countryCrudRepository.findAll(page);
	}

	@Override
	public Country findByUuid(String uuid) {
		return countryCrudRepository.findByUuid(uuid);
	}

}
