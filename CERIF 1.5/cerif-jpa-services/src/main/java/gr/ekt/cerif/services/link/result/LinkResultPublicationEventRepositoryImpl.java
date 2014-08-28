package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkResultPublicationEventRepositoryImpl implements LinkResultPublicationEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationEventRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationEventCrudRepository linkResultPublicationEventCrudRepository;
	

	@Transactional
	public ResultPublication_Event save(ResultPublication_Event entity) {
		return linkResultPublicationEventCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<ResultPublication_Event> save(Iterable<ResultPublication_Event> entityList) {
		return linkResultPublicationEventCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(ResultPublication_Event entity) {
		linkResultPublicationEventCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<ResultPublication_Event> entityList) {
		linkResultPublicationEventCrudRepository.delete(entityList);
	}
	
	
	public List<ResultPublication_Event> findByResultPublication(ResultPublication resultPublication) {
		return linkResultPublicationEventCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<ResultPublication_Event> findResPublEventByResPublId(Long id) {
		return linkResultPublicationEventCrudRepository.findResPublEventByResPublId(id);
	}
	

	@Override
	public List<ResultPublication_Event> findByResPublIdAndClassUri(Long respubId, String classUri) {
		return linkResultPublicationEventCrudRepository.findByResPublIdAndClassUri(respubId, classUri);
	}

	@Override
	public ResultPublication_Event findByResPublIdAndClassUriAndEventId(Long respubId, String classUri, Long eventId) {
		return linkResultPublicationEventCrudRepository.findByResPublIdAndClassUriAndEventId(respubId, classUri, eventId);
	}

	@Override
	public List<ResultPublication_Event> findByEvent(Event event) {
		return linkResultPublicationEventCrudRepository.findByEvent(event);
	}
	
}
