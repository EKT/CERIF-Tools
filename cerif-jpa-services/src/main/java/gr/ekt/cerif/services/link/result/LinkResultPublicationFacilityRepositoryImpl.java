package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;

@Component
public class LinkResultPublicationFacilityRepositoryImpl implements
		LinkResultPublicationFacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationFacilityRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationFacilityCrudRepository linkResultPublicationFacilityCrudRepository;

	@Override
	public void delete(ResultPublication_Facility entity) {
		linkResultPublicationFacilityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Facility> entities) {
		linkResultPublicationFacilityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Facility> save(
			Iterable<ResultPublication_Facility> entities) {
		return linkResultPublicationFacilityCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Facility save(ResultPublication_Facility entity) {
		return linkResultPublicationFacilityCrudRepository.save(entity);
	}

}
