package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and classes.
 * 
 */
@Component
public class LinkResultPublicationClassRepository {
	
	private static final String QUERY1 =
			"select respubc from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  join respubc.theClass cl " +
			"  join cl.scheme sch " +
			"  where respub.id = :respubId and sch.uri= :schUri ";
	
	private static final String QUERY2 =
			"select respubc from ResultPublication_Class respubc "+
			"  where respubc.id = :respubclId";
	
	private static final String QUERY3 =
			"select cl.id from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  join respubc.theClass cl " +
			"  join cl.scheme sch " +
			"  where respub.id = :respubId and sch.uri= :schUri ";
	
	private static final String QUERY4 =
			"select respubc from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  join respubc.theClass cl " +
			"  where respub.id = :respubId and cl.id= :clId ";
	
	private static final String QUERY5 =
			"select respubc from ResultPublication respub "+
			"  left join respub.resultPublications_classes respubc " +
			"  where respub.id = :respubId";

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(ResultPublication_Class entity) {
		if (entity.getResultPublication() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a class.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Class> entityList) {
		for (ResultPublication_Class entity : entityList) {
			save(entity);
		}
	}
	
	/*
	 * Because the retrieving of the entity to be removed and the actual
	 * removing should be in the same transaction, prior to removing,
	 * the entity has to be re-retrieve even though the argument originates
	 * by a already retrieved entity. The argument comes from outside the 
	 * transaction thus being outside the current persistence context.
	 * Without the re-retrieving an IllegalArgumentException: Removing a 
	 * detached instance exception, will occur.
	 */
	@Transactional
	public void delete(ResultPublication_Class entity) {
		ResultPublication_Class respubc=queryResPubClassById(entity.getId());
		if (respubc!=null) { 
			entityManager.remove(respubc);
		}
	}
	
	@Transactional
	public void delete(List<ResultPublication_Class> entityList) {
		for (ResultPublication_Class entity : entityList) {
			delete(entity);
		}
	}
	
	public ResultPublication_Class queryResPubClassByResPubId(Long respubId, String schUri) {
		ResultPublication_Class resPubClass=null;
		TypedQuery<ResultPublication_Class> query;
		
		if (respubId!=null) {
			if (schUri!=null) {
				query=entityManager.createQuery(QUERY1, ResultPublication_Class.class);
				query.setParameter("respubId", respubId);
				query.setParameter("schUri", schUri);
	
				try {
					resPubClass=query.getSingleResult();
				} catch (NoResultException nre) {
					resPubClass=null;
				} catch (NonUniqueResultException nre) {
					resPubClass=null;
				}
			}
		} 
		return resPubClass;
	}
	
	public List<ResultPublication_Class> queryAllResPubClassByResPubId(Long respubId) {
		List<ResultPublication_Class> resPubClass=null;
		TypedQuery<ResultPublication_Class> query;
		
		if (respubId!=null) {
				query=entityManager.createQuery(QUERY5, ResultPublication_Class.class);
				query.setParameter("respubId", respubId);

				try {
					resPubClass=query.getResultList();
				} catch (NoResultException nre) {
					resPubClass=null;
				}

		} 
		return resPubClass;
	}
	
	public ResultPublication_Class queryResPubClassByResPubIdAndClassId(Long respubId, Long clId) {
		ResultPublication_Class resPubClass=null;
		TypedQuery<ResultPublication_Class> query;
		
		if (respubId!=null) {
			query=entityManager.createQuery(QUERY4, ResultPublication_Class.class);
			query.setParameter("respubId", respubId);
			query.setParameter("clId", clId);

			try {
				resPubClass=query.getSingleResult();
			} catch (NoResultException nre) {
				resPubClass=null;
			} catch (NonUniqueResultException nre) {
				resPubClass=null;
			}
		} 
		return resPubClass;
	}
	
	public List<Long> queryClassesIdsResPubId(Long respubId, String schUri) {
		
		List<Long> ids=null;
		TypedQuery<Long> query;
		
		query=entityManager.createQuery(QUERY3, Long.class);
		query.setParameter("respubId", respubId);
		query.setParameter("schUri", schUri);
		
		ids=query.getResultList();
			
		return ids;
	}
	
	public ResultPublication_Class queryResPubClassById(Long respubclId) {
		return entityManager.createQuery(QUERY2, ResultPublication_Class.class)
		.setParameter("respubclId", respubclId)
		.getSingleResult();
		}
}
