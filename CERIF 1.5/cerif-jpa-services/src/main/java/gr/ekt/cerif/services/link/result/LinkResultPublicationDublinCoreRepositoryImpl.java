package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;

@Component
public class LinkResultPublicationDublinCoreRepositoryImpl implements
		LinkResultPublicationDublinCoreRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationDublinCoreRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationDublinCoreCrudRepository linkResultPublicationDublinCoreCrudRepository;

	@Override
	public void delete(ResultPublication_DublinCore entity) {
		linkResultPublicationDublinCoreCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_DublinCore> entities) {
		linkResultPublicationDublinCoreCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_DublinCore> save(
			Iterable<ResultPublication_DublinCore> entities) {
		return linkResultPublicationDublinCoreCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_DublinCore save(ResultPublication_DublinCore entity) {
		return linkResultPublicationDublinCoreCrudRepository.save(entity);
	}

}
