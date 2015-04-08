package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class FacilityRepositoryImpl implements FacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FacilityRepositoryImpl.class);

	@Autowired
	private FacilityCrudRepository facilityCrudRepository;
	
	
	@Override
	public Facility findById(Long id) {
		return facilityCrudRepository.findById(id);
	}

	@Override
	public Facility findByAcronym(String acronym) {
		return facilityCrudRepository.findByAcronym(acronym);
	}

	@Override
	@Transactional
	public void delete(Facility entity) {
		facilityCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<Facility> save(Iterable<Facility> entities) {
		return facilityCrudRepository.save(entities);
	}

	@Transactional
	public Facility save(Facility entity) {
		return facilityCrudRepository.save(entity);
	}

	@Override
	public List<Facility> findAll() {
		return facilityCrudRepository.findAll();
	}

	@Override
	public void delete(Iterable<Facility> entities) {
		facilityCrudRepository.delete(entities);		
	}

	@Override
	public Page<Facility> findAll(Pageable page) {
		return facilityCrudRepository.findAll(page);
	}

	@Override
	public Facility findByUuid(String uuid) {
		return facilityCrudRepository.findByUuid(uuid);
	}

}
