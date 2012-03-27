package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and fundings.
 * 
 */
@Component
public class LinkPersonFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(Person_Funding entity) {
		if (entity.getPerson() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a person and a funding.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Funding> entityList) {
		for (Person_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
