package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.EventCrudRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkResultPublicationEventRepositoryImpl implements LinkResultPublicationEventRepository {
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private EventCrudRepository eventRepository;
	
	@Autowired
	private LinkResultPublicationEventCrudRepository linkResultPublicationEventCrudRepository;
	
	@Autowired
	private ClassRepository classRepository;

	@Transactional
	public ResultPublication_Event save(ResultPublication_Event entity) {
		if (entity.getResultPublication() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a event.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
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
	
}
