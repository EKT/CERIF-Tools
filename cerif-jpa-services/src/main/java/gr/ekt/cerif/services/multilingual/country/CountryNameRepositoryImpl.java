/**
 * 
 */
package gr.ekt.cerif.services.multilingual.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.CountryName;

/**
 * @author bonisv
 *
 */
@Component
public class CountryNameRepositoryImpl implements CountryNameRepository {

	@Autowired
	CountryNameCrudRepository countryNameCrudRepository;
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.CountryNameRepository#findByName(java.lang.String)
	 */
	@Override
	public CountryName findByName(String name) {
		return countryNameCrudRepository.findByName(name);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.CountryNameRepository#delete(gr.ekt.cerif.features.multilingual.CountryName)
	 */
	@Override
	public void delete(CountryName entity) {
		countryNameCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.CountryNameRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<CountryName> entities) {
		countryNameCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.CountryNameRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<CountryName> save(Iterable<CountryName> entities) {
		return countryNameCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.CountryNameRepository#save(gr.ekt.cerif.features.multilingual.CountryName)
	 */
	@Override
	public CountryName save(CountryName entity) {
		return countryNameCrudRepository.save(entity);
	}

}
