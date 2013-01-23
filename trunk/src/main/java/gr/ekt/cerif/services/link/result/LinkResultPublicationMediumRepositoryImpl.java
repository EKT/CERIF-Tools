package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkResultPublicationMediumRepositoryImpl implements LinkResultPublicationMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private LinkResultPublicationMediumCrudRepository linkResultPublicationMediumCrudRepository;
	
	private static final String QUERY1 =
			"select mediumrespub from ResultPublication respub "+
			"  left join respub.resultPublications_medium mediumrespub " +
			"  where respub.id = :respubId ";
	
	private static final String QUERY2 =
			"select mediumrespub from ResultPublication_Medium mediumrespub "+ 
			"  where mediumrespub.id = :mediumrespubId";
	
	private static final String QUERY3 =
			"select	respubm							" +			
					"  from ResultPublication_Medium respubm		" +
					"  left join respubm.medium medium			" +
					"  where medium.id = :mediumId";
	
	@Transactional
	public ResultPublication_Medium save(ResultPublication_Medium entity) {
		if (entity.getResultPublication() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a medium.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<ResultPublication_Medium> save(Iterable<ResultPublication_Medium> entityList) {
		for (ResultPublication_Medium entity : entityList) {
			save(entity);
		}
		return entityList;
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
	public void delete(ResultPublication_Medium entity) {
		ResultPublication_Medium mediumrespub=queryMediumResPubById(entity.getId());
		if (mediumrespub != null) { 
			entityManager.remove(mediumrespub);
		}
	}
	
	@Transactional
	public void delete(Iterable<ResultPublication_Medium> entityList) {
		for (ResultPublication_Medium entity : entityList) {
			if (entity != null) {
				delete(entity);
			}
		}
	}
	
	public List<ResultPublication_Medium> queryMediumResPubByResPubId(Long respubId) {
		return entityManager.createQuery(QUERY1, ResultPublication_Medium.class)
		.setParameter("respubId", respubId).getResultList();
	}
	
	public ResultPublication_Medium queryMediumResPubById(Long mediumrespubId) {
		return entityManager.createQuery(QUERY2, ResultPublication_Medium.class)
		.setParameter("mediumrespubId", mediumrespubId)
		.getSingleResult();
	}
	
	public ResultPublication_Medium findByMediumId(Long mediumId) {
		ResultPublication_Medium resPubMedium=null;
		TypedQuery<ResultPublication_Medium> query;
		
		if (mediumId != null) {
			query = entityManager.createQuery(QUERY3, ResultPublication_Medium.class);
			query.setParameter("mediumId", mediumId);

			try {
				resPubMedium=query.getSingleResult();
			} catch (NoResultException nre) {
				resPubMedium = null;
			} catch (NonUniqueResultException nre) {
				resPubMedium = null;
			}
		} 
		return resPubMedium;
	}
	
	public List<ResultPublication_Medium> findByResultPublication(ResultPublication resultPublication) {
		return linkResultPublicationMediumCrudRepository.findByResultPublication(resultPublication);
	}
}
