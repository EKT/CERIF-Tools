package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentEventRepository;
import gr.ekt.cerif.services.link.event.LinkEventClassRepository;
import gr.ekt.cerif.services.link.event.LinkEventEventRepository;
import gr.ekt.cerif.services.link.event.LinkEventIndicatorRepository;
import gr.ekt.cerif.services.link.event.LinkEventMeasurementRepository;
import gr.ekt.cerif.services.link.event.LinkEventMediumRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitEventRepository;
import gr.ekt.cerif.services.link.person.LinkPersonEventRepository;
import gr.ekt.cerif.services.link.project.LinkProjectEventRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEventRepository;
import gr.ekt.cerif.services.link.service.LinkServiceEventRepository;
import gr.ekt.cerif.services.multilingual.event.EventDescriptionRepository;
import gr.ekt.cerif.services.multilingual.event.EventKeywordRepository;
import gr.ekt.cerif.services.multilingual.event.EventNameRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventRepositoryImpl implements EventRepository {

	private static final Logger log = LoggerFactory.getLogger(EventRepositoryImpl.class);

	@Autowired
	private EventCrudRepository eventCrudRepository;
	
	@Autowired
	private EventNameRepository eventNameRepository;
	
	@Autowired
	private EventKeywordRepository eventKeywordRepository;
	
	@Autowired
	private EventDescriptionRepository eventDescriptionRepository;
	
	@Autowired
	private LinkProjectEventRepository linkProjectEventRepository;
	
	@Autowired
	private LinkPersonEventRepository linkPersonEventRepository;
	
	@Autowired
	private LinkResultPublicationEventRepository linkResultPublicationEventRepository;
	
	@Autowired
	private LinkEventClassRepository linkEventClassRepository;
	
	@Autowired
	private LinkOrganisationUnitEventRepository linkOrganisationUnitEventRepository;
	
	@Autowired
	private LinkServiceEventRepository linkServiceEventRepository;
	
	@Autowired
	private LinkEquipmentEventRepository linkEquipmentEventRepository;
	
	@Autowired
	private LinkEventMediumRepository linkEventMediumRepository;
	
	@Autowired
	private LinkEventIndicatorRepository linkEventIndicatorRepository;
	
	@Autowired
	private LinkEventMeasurementRepository linkEventMeasurementRepository;
	
	@Autowired
	private LinkEventEventRepository linkEventEventRepository;
	
	
	
	@Override
	public Event findById(Long id) {
		return eventCrudRepository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Event entity) {
		List<EventName> evname = eventNameRepository.findByEvent(entity);
		if (evname != null) eventNameRepository.delete(evname);
		entity.setEventNames(null);
		
		List<EventKeyword> evkey = eventKeywordRepository.findByEvent(entity);
		if (evkey != null) eventKeywordRepository.delete(evkey);
		entity.setEventKeywords(null);
		
		List<EventDescription> evdescr = eventDescriptionRepository.findByEvent(entity);
		if (evdescr != null) eventDescriptionRepository.delete(evdescr);
		entity.setEventDescriptions(null);
		
		List<Project_Event> prev = linkProjectEventRepository.findByEvent(entity);
		if (prev != null) linkProjectEventRepository.delete(prev);
		entity.setProjects_events(null);
		
		List<Person_Event> pev = linkPersonEventRepository.findByEvent(entity);
		if (pev != null) linkPersonEventRepository.delete(pev);
		entity.setPersons_events(null);
		
		List<ResultPublication_Event> re = linkResultPublicationEventRepository.findByEvent(entity);
		if (re != null) linkResultPublicationEventRepository.delete(re);
		entity.setResultPublications_events(null);
		
		List<Event_Class> evcl = linkEventClassRepository.findByEvent(entity);
		if (evcl != null) linkEventClassRepository.delete(evcl);
		entity.setEvents_classes(null);
		
		List<OrganisationUnit_Event> events = linkOrganisationUnitEventRepository.findByEvent(entity);
		if (events != null) linkOrganisationUnitEventRepository.delete(events);
		entity.setOrganisationUnits_events(null);
		
		List<Service_Event> srvev = linkServiceEventRepository.findByEvent(entity);
		if (srvev != null) linkServiceEventRepository.delete(srvev);
		entity.setServices_events(null);
		
		List<Equipment_Event> equipev = linkEquipmentEventRepository.findByEvent(entity);
		if (equipev != null) linkEquipmentEventRepository.delete(equipev);
		entity.setServices_events(null);
		
		List<Event_Medium> evmed = linkEventMediumRepository.findByEvent(entity);
		if (evmed != null) linkEventMediumRepository.delete(evmed);
		entity.setEvents_mediums(null);
		
		List<Event_Indicator> evind = linkEventIndicatorRepository.findByEvent(entity);
		if (evind != null) linkEventIndicatorRepository.delete(evind);
		entity.setEvents_indicators(null);
		
		List<Event_Measurement> evmeas = linkEventMeasurementRepository.findByEvent(entity);
		if (evmeas != null) linkEventMeasurementRepository.delete(evmeas);
		entity.setEvents_measurements(null);
		
		List<Event_Event> evev1 = linkEventEventRepository.findByEvent1(entity);
		if (evev1 != null) linkEventEventRepository.delete(evev1);
		entity.setEvents_events1(null);
		
		List<Event_Event> evev2 = linkEventEventRepository.findByEvent2(entity);
		if (evev2 != null) linkEventEventRepository.delete(evev2);
		entity.setEvents_events2(null);
		
		entity = eventCrudRepository.save(entity);
		eventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event> entities) {
		eventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Event> save(Iterable<Event> entities) {
		return eventCrudRepository.save(entities);
	}

	@Override
	public Event save(Event entity) {
		return eventCrudRepository.save(entity);
	}

}
