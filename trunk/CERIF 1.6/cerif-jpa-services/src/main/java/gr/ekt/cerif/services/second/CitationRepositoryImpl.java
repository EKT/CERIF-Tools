/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Citation;

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
public class CitationRepositoryImpl implements CitationRepository {

	private static final Logger log = LoggerFactory.getLogger(CitationRepositoryImpl.class);
	
	@Autowired
	private CitationCrudRepository citationCrudRepository;
	
	
	@Override
	@Transactional
	public void delete(Citation entity) {		
		citationCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Citation> entities) {
		citationCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Citation> save(Iterable<Citation> entities) {
		return citationCrudRepository.save(entities);
	}

	@Override
	public Citation save(Citation entity) {
		return citationCrudRepository.save(entity);
	}

	@Override
	public List<Citation> findAll() {
		return citationCrudRepository.findAll();
	}

	@Override
	public Page<Citation> findAll(Pageable page) {
		return citationCrudRepository.findAll(page);
	}

	@Override
	public Citation findById(Long id) {
		return citationCrudRepository.findById(id);
	}

	@Override
	public List<Citation> findByUri(String uri) {
		return citationCrudRepository.findByUri(uri);
	}

	@Override
	public Citation findByUuid(String uuid) {
		return citationCrudRepository.findByUuid(uuid);
	}

}
