package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.second.Funding;

@Component
public class LinkPersonFundingRepositoryImpl implements LinkPersonFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonFundingRepositoryImpl.class);
	
	@Autowired
	private LinkPersonFundingCrudRepository linkPersonFundingCrudRepository;

	@Override
	public void delete(Person_Funding entity) {
		linkPersonFundingCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Person_Funding> entities) {
		linkPersonFundingCrudRepository.save(entities);		
	}

	@Override
	public Iterable<Person_Funding> save(Iterable<Person_Funding> entities) {
		return linkPersonFundingCrudRepository.save(entities);
	}

	@Override
	public Person_Funding save(Person_Funding entity) {
		return linkPersonFundingCrudRepository.save(entity);
	}

	@Override
	public List<Person_Funding> findByFunding(Funding funding) {
		return linkPersonFundingCrudRepository.findByFunding(funding);
	}

	@Override
	public List<Person_Funding> findByPerson(Person person) {
		return linkPersonFundingCrudRepository.findByPerson(person);
	}

}
