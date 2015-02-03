package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.result.ResultPatent;

@Component
public class LinkResultPatentFacilityRepositoryImpl implements
		LinkResultPatentFacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPatentFacilityRepositoryImpl.class);
	
	@Autowired
	private LinkResultPatentFacilityCrudRepository linkResultPatentFacilityCrudRepository;

	@Override
	public void delete(ResultPatent_Facility entity) {
		linkResultPatentFacilityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent_Facility> entities) {
		linkResultPatentFacilityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatent_Facility> save(
			Iterable<ResultPatent_Facility> entities) {
		return linkResultPatentFacilityCrudRepository.save(entities);
	}

	@Override
	public ResultPatent_Facility save(ResultPatent_Facility entity) {
		return linkResultPatentFacilityCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatent_Facility> findByFacility(Facility facility) {
		return linkResultPatentFacilityCrudRepository.findByFacility(facility);
	}

	@Override
	public List<ResultPatent_Facility> findByResultPatent(
			ResultPatent resultPatent) {
		return linkResultPatentFacilityCrudRepository.findByResultPatent(resultPatent);
	}

}
