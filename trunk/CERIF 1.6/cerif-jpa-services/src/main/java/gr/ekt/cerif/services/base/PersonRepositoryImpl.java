package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.services.second.SecondPersistenceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonRepositoryImpl implements PersonRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PersonRepositoryImpl.class);

	@Autowired
	private PersonCrudRepository personCrudRepository;
	
	/**
	 * Service for second level entities.
	 */
	@Autowired
	private SecondPersistenceService secondService;
	

	@Override
	@Transactional
	public void delete(Person entity) {
		personCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<Person> save(Iterable<Person> entities) {
		return personCrudRepository.save(entities);
	}

	@Transactional
	public Person save(Person entity) {
		return personCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<Person> entities) {
		personCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person> findAll() {
		return personCrudRepository.findAll();
	}

	@Override
	public Page<Person> findAll(Pageable page) {
		return personCrudRepository.findAll(page);
	}

	@Override
	public Person findById(Long id) {
		return personCrudRepository.findById(id);
	}

	@Override
	public Person findByUuid(String uuid) {
		return personCrudRepository.findByUuid(uuid);
	}

	@Override
	public Person findByUri(String uri) {
		return personCrudRepository.findByUri(uri);
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.PersonRepository#findByUuidFetchMultilingual(java.lang.String)
	 */
	@Override
	public Person findByUuidFetchMultilingual(String uuid) {
		return personCrudRepository.findByUuidFetchMultilingual(uuid);
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.PersonRepository#findByUuidFetchMultilingualAndFederatedIds(java.lang.String)
	 */
	@Override
	public Person findByUuidFetchMultilingualAndFederatedIds(String uuid) {
		Person person = findByUuidFetchMultilingual(uuid);
		if (person != null) {
			person.setFederatedIdentifiers(secondService.getFederatedIdentifiersForEntity(ClassEnum.PERSON.getUuid(), person.getId()));
		}
		return person;
	}
	
}
