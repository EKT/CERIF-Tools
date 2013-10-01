package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Country;

@Component
public class LinkProductCountryRepositoryImpl implements
		LinkProductCountryRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProductCountryRepositoryImpl.class);
	
	@Autowired
	private LinkProductCountryCrudRepository linkProductCountryCrudRepository;

	@Override
	public void delete(ResultProduct_Country entity) {
		linkProductCountryCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Country> entities) {
		linkProductCountryCrudRepository.save(entities);
	}

	@Override
	public Iterable<ResultProduct_Country> save(
			Iterable<ResultProduct_Country> entities) {
		return linkProductCountryCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Country save(ResultProduct_Country entity) {
		return linkProductCountryCrudRepository.save(entity);
	}

}
