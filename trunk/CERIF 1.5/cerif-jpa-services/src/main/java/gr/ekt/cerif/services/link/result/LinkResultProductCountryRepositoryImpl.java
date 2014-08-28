package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Country;

@Component
public class LinkResultProductCountryRepositoryImpl implements
		LinkResultProductCountryRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductCountryRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductCountryCrudRepository linkResultProductCountryCrudRepository;

	@Override
	public void delete(ResultProduct_Country entity) {
		linkResultProductCountryCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Country> entities) {
		linkResultProductCountryCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Country> save(
			Iterable<ResultProduct_Country> entities) {
		return linkResultProductCountryCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Country save(ResultProduct_Country entity) {
		return linkResultProductCountryCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_Country> findByCountry(Country country) {
		return linkResultProductCountryCrudRepository.findByCountry(country);
	}

	@Override
	public List<ResultProduct_Country> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultProductCountryCrudRepository.findByResultProduct(resultProduct);
	}

}
