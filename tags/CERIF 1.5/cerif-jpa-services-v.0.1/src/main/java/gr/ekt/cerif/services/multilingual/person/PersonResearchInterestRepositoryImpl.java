package gr.ekt.cerif.services.multilingual.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;

@Component
public class PersonResearchInterestRepositoryImpl implements PersonResearchInterestRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PersonResearchInterestRepositoryImpl.class);
	
	@Autowired
	private PersonResearchInterestCrudRepository personResearchInterestCrudRepository;

	@Override
	public PersonResearchInterest save(PersonResearchInterest entity) {
		return personResearchInterestCrudRepository.save(entity);
	}

	@Override
	public Iterable<PersonResearchInterest> save(Iterable<PersonResearchInterest> entities) {
		return personResearchInterestCrudRepository.save(entities);
	}

	@Override
	public void delete(PersonResearchInterest entity) {
		personResearchInterestCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PersonResearchInterest> entities) {
		personResearchInterestCrudRepository.delete(entities);
	}

	@Override
	public List<PersonResearchInterest> findByPerson(Person person) {
		return personResearchInterestCrudRepository.findByPerson(person);
	}

}
