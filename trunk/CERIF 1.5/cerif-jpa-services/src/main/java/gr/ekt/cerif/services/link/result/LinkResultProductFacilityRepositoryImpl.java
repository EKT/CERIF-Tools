package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;

@Component
public class LinkResultProductFacilityRepositoryImpl implements
		LinkResultProductFacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductFacilityRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductFacilityCrudRepository linkResultProductFacilityCrudRepository;

	@Override
	public void delete(ResultProduct_Facility entity) {
		linkResultProductFacilityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Facility> entities) {
		linkResultProductFacilityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Facility> save(
			Iterable<ResultProduct_Facility> entities) {
		return linkResultProductFacilityCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Facility save(ResultProduct_Facility entity) {
		return linkResultProductFacilityCrudRepository.save(entity);
	}

}
