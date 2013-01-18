/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

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
 * A repository for links between projects and ResultPublications.
 * 
 */
@Component
public class LinkProjectResultPublicationRepository {
	
	private static final String QUERY1 =
			"select projrespub from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  left join projrespub.project proj " +
			"  where respub.id = :respubId and proj.id=:projId ";
	
	private static final String QUERY2 =
			"select projrespub from Project_ResultPublication projrespub "+ 
			"  where projrespub.id = :projrespubId";
	
	private static final String QUERY3 =
			"select proj.id from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  left join projrespub.project proj " +
			"  where respub.id = :respubId";
	
	private static final String QUERY4 =
			"select projrespub from ResultPublication respub "+
			"  left join respub.projects_resultPublications projrespub " +
			"  where respub.id = :respubId ";

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Transactional
	public void save(Project_ResultPublication entity) {
		if (entity.getProject() == null || entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide both a project and a ResultPublication.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_ResultPublication> entityList) {
		for (Project_ResultPublication entity : entityList) {
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
	public void delete(Project_ResultPublication entity) {
		Project_ResultPublication projrespub=queryProjResPubById(entity.getId());
		if (projrespub!=null) { 
			entityManager.remove(projrespub);
		}
	}
	
	@Transactional
	public void delete(List<Project_ResultPublication> entityList) {
		for (Project_ResultPublication entity : entityList) {
			if (entity!=null) {
				delete(entity);
			}
		}
	}
	
	public Project_ResultPublication queryProjResPubByResPubId(Long respubId, Long projId) {
		Project_ResultPublication projResPub=null;
		TypedQuery<Project_ResultPublication> query;
		
		if (projId!=null) {
			query=entityManager.createQuery(QUERY1, Project_ResultPublication.class);
			query.setParameter("respubId", respubId);
			query.setParameter("projId", projId);

			try {
				projResPub=query.getSingleResult();
			} catch (NoResultException nre) {
				projResPub=null;
			} catch (NonUniqueResultException nre) {
				projResPub=null;
			}
			
		} 
		return projResPub;
	}
	
	
	public Project_ResultPublication queryProjResPubById(Long projrespubId) {
		return entityManager.createQuery(QUERY2, Project_ResultPublication.class)
		.setParameter("projrespubId", projrespubId)
		.getSingleResult();
	}
	
	
	public List<Project_ResultPublication> queryProjResPubByResPubId(Long respubId) {
		return entityManager.createQuery(QUERY4, Project_ResultPublication.class)
		.setParameter("respubId", respubId).getResultList();
		}
	
	
	public List<Long> queryProjIdsResPubId(Long respubId, String ClassUri) {
		
		List<Long> ids=null;
		TypedQuery<Long> query;
		
		query=entityManager.createQuery(QUERY3, Long.class);
		query.setParameter("respubId", respubId);
		
		try {
			ids=query.getResultList();
		} catch (NoResultException nre) {
			ids=null;
		} 
			
		return ids;
	}
}
