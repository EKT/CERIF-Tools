package gr.ekt.cerif.services.link.citation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Medium;

@Component
public class LinkCitationMediumRepositoryImpl implements
		LinkCitationMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkCitationMediumRepositoryImpl.class);
	
	@Autowired
	private LinkCitationMediumCrudRepository linkCitationMediumCrudRepository;

	@Override
	public void delete(Citation_Medium entity) {
		linkCitationMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Citation_Medium> entities) {
		linkCitationMediumCrudRepository.save(entities);
	}

	@Override
	public Iterable<Citation_Medium> save(Iterable<Citation_Medium> entities) {
		return linkCitationMediumCrudRepository.save(entities);
	}

	@Override
	public Citation_Medium save(Citation_Medium entity) {
		return linkCitationMediumCrudRepository.save(entity);
	}

	@Override
	public List<Citation_Medium> findByCitation(Citation citation) {
		return linkCitationMediumCrudRepository.findByCitation(citation);
	}

	@Override
	public List<Citation_Medium> findByMedium(Medium medium) {
		return linkCitationMediumCrudRepository.findByMedium(medium);
	}

}
