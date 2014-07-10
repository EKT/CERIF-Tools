package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonResultPublicationRepositoryImpl implements LinkPersonResultPublicationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonOrganisationUnitRepositoryImpl.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private LinkPersonResultPublicationCrudRepository linkPersonResultPublicationCrudRepository;
	
	@Transactional
	public Person_ResultPublication save(Person_ResultPublication entity) {
		if (entity.getPerson() == null || entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide both a person and a resultPublication.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		return linkPersonResultPublicationCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Person_ResultPublication> save(Iterable<Person_ResultPublication> entityList) {

		return linkPersonResultPublicationCrudRepository.save(entityList);
	}
	

	@Transactional
	public void delete(Person_ResultPublication entity) {
		linkPersonResultPublicationCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(List<Person_ResultPublication> entityList) {
		linkPersonResultPublicationCrudRepository.delete(entityList);
	}
	
	@Override
	public List<Person_ResultPublication> findByPerson(Person person) {
		return linkPersonResultPublicationCrudRepository.findByPerson(person);
	}
	
	@Override
	public List<Person_ResultPublication> findByResultPublication(ResultPublication resultPublication) {
		return linkPersonResultPublicationCrudRepository.findByResultPublication(resultPublication);
	}

	@Override
	public List<Person_ResultPublication> findByResPublIdAndClassSchemeUri(Long respubId, String persrespubclUri) {
		return linkPersonResultPublicationCrudRepository.findByResPublIdAndClassSchemeUri(respubId, persrespubclUri);
	}

	@Override
	public Person_ResultPublication findByPersonResPublId(Long persrespubId) {
		return linkPersonResultPublicationCrudRepository.findByPersonResPublId(persrespubId);
	}

	@Override
	public Person_ResultPublication findByResPublIdAndClassSchemeAndPersonId(Long respubId, String persrespubclUri, Long persId) {
		return linkPersonResultPublicationCrudRepository.findByResPublIdAndClassSchemeAndPersonId(respubId, persrespubclUri, persId);
	}

	@Override
	public List<Long> findPersonIdsByResPublIdAndClassUri(Long respubId, String persrespubclUri) {
		return linkPersonResultPublicationCrudRepository.findPersonIdsByResPublIdAndClassUri(respubId, persrespubclUri);
	}

	@Override
	public List<Person_ResultPublication> findByResPublId(Long respubId) {
		return linkPersonResultPublicationCrudRepository.findByResPublId(respubId);
	}


	@Override
	public List<Person_ResultPublication> findByPersonIdAndClassUri(Long personId, String persrespubclUri) {
		return linkPersonResultPublicationCrudRepository.findByPersonIdAndClassUri(personId, persrespubclUri);
	}


	@Override
	public List<Person_ResultPublication> findByResPublIdAndClassUri(Long resPublId, String persrespubclUri) {
		return linkPersonResultPublicationCrudRepository.findByResPublIdAndClassUri(resPublId, persrespubclUri);
	}

	@Override
	public Person_ResultPublication findByPersonIdAndResultPublicationId(Long PerId, Long ResId) {
		return linkPersonResultPublicationCrudRepository.findByPersonIdAndResultPublicationId(PerId, ResId);
	}
	
}
