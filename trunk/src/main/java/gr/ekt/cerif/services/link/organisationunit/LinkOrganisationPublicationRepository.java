/**
 * 
 */
package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and publications.
 * 
 */
@Component
public class LinkOrganisationPublicationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private OrganisationUnitRepository organisationRepository;
	
	@Autowired
	private ResultPublicationRepository publicationRepository;
	
	@Transactional
	public void save(OrganisationUnit_ResultPublication entity) {
		if (entity.getOrganisationUnit() == null || entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a publication.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getResultPublication().getId() == null) {
			publicationRepository.save(entity.getResultPublication());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_ResultPublication> entityList) {
		for (OrganisationUnit_ResultPublication entity : entityList) {
			save(entity);
		}
	}
	
}
