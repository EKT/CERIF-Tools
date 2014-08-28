package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Citation;

@Component
public class LinkResultPublicationCitationRepositoryImpl implements
		LinkResultPublicationCitationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationCitationRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationCitationCrudRepository linkResultPublicationCitationCrudRepository;

	@Override
	public void delete(ResultPublication_Citation entity) {
		linkResultPublicationCitationCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Citation> entities) {
		linkResultPublicationCitationCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Citation> save(
			Iterable<ResultPublication_Citation> entities) {
		return linkResultPublicationCitationCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Citation save(ResultPublication_Citation entity) {
		return linkResultPublicationCitationCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublication_Citation> findByResultPublication(
			ResultPublication resultPublication) {
		return linkResultPublicationCitationCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<ResultPublication_Citation> findByCitation(Citation citation) {
		return linkResultPublicationCitationCrudRepository.findByCitation(citation);
	}

}
