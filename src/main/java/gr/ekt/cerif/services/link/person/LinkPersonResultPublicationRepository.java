package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and result publications.
 * 
 */
@Component
public class LinkPersonResultPublicationRepository {
	
	private static final String QUERY1 =
			"select persrespub from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = :respubId and persrespubcl.uri=:persrespubclUri";
	
	private static final String QUERY2 =
			"select persrespub from Person_ResultPublication persrespub "+
			"  where persrespub.id = :persrespubId";
	
	private static final String QUERY3 =
			"select persrespub from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.person pers " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = :respubId and persrespubcl.uri=:persrespubclUri "+
			"  and pers.id=:persId ";
	
	private static final String QUERY4 =
			"select pers.id from ResultPublication respub "+
			"  left join respub.persons_resultPublications persrespub " +
			"  left join persrespub.person pers " +
			"  left join persrespub.theClass persrespubcl " +
			"  where respub.id = :respubId and persrespubcl.uri=:persrespubclUri ";
	
	private static final String QUERY5 =
			"select persrespub from Person_ResultPublication persrespub "+
			"  left join persrespub.resultPublication respub " +
			"  where respub.id = :respubId ";


	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Transactional
	public void save(Person_ResultPublication entity) {
		if (entity.getPerson() == null || entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide both a person and a resultPublication.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_ResultPublication> entityList) {
		for (Person_ResultPublication entity : entityList) {
			save(entity);
		}
	}
	
	/*
	 * Because the retrieving of the entity to be removed and the actual
	 * removing should be in the same transaction, prior to removing,
	 * the entity has to be re-retrieved even though the argument originates
	 * by an already retrieved entity. The argument comes from outside the 
	 * transaction thus being outside the current persistence context.
	 * Without the re-retrieving an IllegalArgumentException: Removing a 
	 * detached instance exception, will occur.
	 */
	@Transactional
	public void delete(Person_ResultPublication entity) {
		Person_ResultPublication persrespub=queryPersResPubById(entity.getId());
		if (persrespub!=null) { 
			entityManager.remove(persrespub);
		}
	}
	
	@Transactional
	public void delete(List<Person_ResultPublication> entityList) {
		for (Person_ResultPublication entity : entityList) {
			delete(entity);
		}
	}
	
	public List<Person_ResultPublication> queryPersResPubByResPubId(Long respubId, String persrespubclUri) {
		List<Person_ResultPublication> perrespub=null;
		TypedQuery<Person_ResultPublication> query;
		
		query=entityManager.createQuery(QUERY1, Person_ResultPublication.class);
		query.setParameter("respubId", respubId);
		query.setParameter("persrespubclUri", persrespubclUri);
		
		try {
			perrespub=query.getResultList();
		} catch (NoResultException nre) {
			perrespub=null;
		}
			return perrespub;
	}
	
	public List<Person_ResultPublication> queryAllPersResPubByResPubId(Long respubId) {
		List<Person_ResultPublication> perrespub=null;
		TypedQuery<Person_ResultPublication> query;
		
		query=entityManager.createQuery(QUERY5, Person_ResultPublication.class);
		query.setParameter("respubId", respubId);
		
		try {
			perrespub=query.getResultList();
		} catch (NoResultException nre) {
			perrespub=null;
		}
			return perrespub;
	}
	
	public Person_ResultPublication queryPersResPubByResPubIdAndPersId(Long respubId, String persrespubclUri, Long persId) {
		Person_ResultPublication perrespub=null;
		TypedQuery<Person_ResultPublication> query;
		
		query=entityManager.createQuery(QUERY3, Person_ResultPublication.class);
		query.setParameter("respubId", respubId);
		query.setParameter("persrespubclUri", persrespubclUri);
		query.setParameter("persId", persId);

		try {
			perrespub=query.getSingleResult();
		} catch (NoResultException nre) {
			perrespub=null;
		} catch (NonUniqueResultException nre) {
			perrespub=null;
		} catch (EntityNotFoundException nre) {
			perrespub=null;
		}
			return perrespub;
	}
	
	public List<Long> queryPersIdsResPubId(Long respubId, 
			String persrespubclUri) {
		
		List<Long> ids=null;
		TypedQuery<Long> query;
		
		query=entityManager.createQuery(QUERY4, Long.class);
		query.setParameter("respubId", respubId);
		query.setParameter("persrespubclUri", persrespubclUri);
		
		try {
			ids=query.getResultList();
		} catch (NoResultException nre) {
			ids=null;
		} 
			
		return ids;
	}
	
	
	public Person_ResultPublication queryPersResPubById(Long persrespubId) {
		return entityManager.createQuery(QUERY2, Person_ResultPublication.class)
		.setParameter("persrespubId", persrespubId)
		.getSingleResult();
		}
	
}
