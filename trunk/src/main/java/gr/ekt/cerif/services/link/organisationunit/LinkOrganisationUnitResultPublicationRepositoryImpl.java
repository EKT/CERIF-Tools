package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

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
public class LinkOrganisationUnitResultPublicationRepositoryImpl implements LinkOrganisationUnitResultPublicationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	LinkOrganisationUnitResultPublicationCrudRepository linkOrganisationUnitResultPublicationCrudRepository;
	
	private static final String QUERY1 =
			"select orgunitrespub from ResultPublication respub "+
			"  left join respub.organisationUnit_resultPublications orgunitrespub " +
			"  left join orgunitrespub.organisationUnit orgunit " +
			"  left join orgunitrespub.theClass orgunitrespubcl " +
			"  where respub.id = :respubId and orgunitrespubcl.uri=:orgunitrespubclUri "+
			"  and orgunit.id=:orgunitId ";
	
	private static final String QUERY2 =
			"select orgunitrespub from OrganisationUnit_ResultPublication orgunitrespub "+ 
			"  where orgunitrespub.id = :orgunitrespubId";
	
	private static final String QUERY3 =
			"select orgunitrespub from ResultPublication respub "+
			"  left join respub.organisationUnit_resultPublications orgunitrespub " +
			"  left join orgunitrespub.theClass orgunitrespubcl " +
			"  where respub.id = :respubId and orgunitrespubcl.uri=:orgunitrespubclUri ";
	
	private static final String QUERY4 =
			"select orgunit.id from ResultPublication respub "+
			"  left join respub.organisationUnit_resultPublications orgunitrespub " +
			"  left join orgunitrespub.organisationUnit orgunit " +
			"  left join orgunitrespub.theClass orgunitrespubcl " +
			"  where respub.id = :respubId and orgunitrespubcl.uri=:orgunitrespubclUri ";
	
	@Transactional
	public OrganisationUnit_ResultPublication save(OrganisationUnit_ResultPublication entity) {
		if (entity.getOrganisationUnit() == null) {
			throw new IllegalArgumentException("Please provide an organisation.");
		}
		if (entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide a result publication.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<OrganisationUnit_ResultPublication> save(Iterable<OrganisationUnit_ResultPublication> entityList) {
		for (OrganisationUnit_ResultPublication entity : entityList) {
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
	public void delete(OrganisationUnit_ResultPublication entity) {
		OrganisationUnit_ResultPublication orgunitrespub=queryOrgUnitResPubById(entity.getId());
		if (orgunitrespub!=null) { 
			entityManager.remove(orgunitrespub);
		}
	}
	
	@Transactional
	public void delete(Iterable<OrganisationUnit_ResultPublication> entityList) {
		for (OrganisationUnit_ResultPublication entity : entityList) {
			delete(entity);
		}
	}
	
	public OrganisationUnit_ResultPublication queryOrgUnitResPubByResPubId(Long respubId, 
			String orgunitrespubclUri, Long orgunitId) {
		OrganisationUnit_ResultPublication orgUnitResPub=null;
		TypedQuery<OrganisationUnit_ResultPublication> query;
		
		if (orgunitId!=null) {
			query=entityManager.createQuery(QUERY1, OrganisationUnit_ResultPublication.class);
			query.setParameter("respubId", respubId);
			query.setParameter("orgunitrespubclUri", orgunitrespubclUri);
			query.setParameter("orgunitId", orgunitId);

			try {
				orgUnitResPub=query.getSingleResult();
			} catch (NoResultException nre) {
				orgUnitResPub=null;
			} catch (NonUniqueResultException nre) {
				orgUnitResPub=null;
			}
			

		} else {
			query=entityManager.createQuery(QUERY3, OrganisationUnit_ResultPublication.class);
			query.setParameter("respubId", respubId);
			query.setParameter("orgunitrespubclUri", orgunitrespubclUri);
			
			try {
				orgUnitResPub=query.getSingleResult();
			} catch (NoResultException nre) {
				orgUnitResPub=null;
			}
		}
		return orgUnitResPub;
	}
	
	
	public List<Long> queryOrgUnitIdsResPubId(Long respubId, 
			String orgunitrespubclUri) {
		
		List<Long> ids=null;
		TypedQuery<Long> query;

		query=entityManager.createQuery(QUERY4, Long.class);
		query.setParameter("respubId", respubId);
		query.setParameter("orgunitrespubclUri", orgunitrespubclUri);
		
		//System.out.println("rep="+query.unwrap(org.hibernate.Query.class).getQueryString());
		try {
			ids=query.getResultList();
		} catch (NoResultException nre) {
			ids=null;
		}
			
		return ids;
	}
	
	
	public OrganisationUnit_ResultPublication queryOrgUnitResPubById(Long orgunitrespubId) {
		return entityManager.createQuery(QUERY2, OrganisationUnit_ResultPublication.class)
		.setParameter("orgunitrespubId", orgunitrespubId)
		.getSingleResult();
	}
	
	public List<OrganisationUnit_ResultPublication> findByOrganisationUnit(OrganisationUnit orgUnit) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByOrganisationUnit(orgUnit);
	}

	public List<OrganisationUnit_ResultPublication> findByResultPublication(ResultPublication resultPublication) {
		return linkOrganisationUnitResultPublicationCrudRepository.findByResultPublication(resultPublication);
	}
	
}
