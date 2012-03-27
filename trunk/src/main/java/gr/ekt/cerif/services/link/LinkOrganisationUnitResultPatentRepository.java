package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.result.ResultPatentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and result patents.
 * 
 */
@Component
public class LinkOrganisationUnitResultPatentRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ResultPatentRepository resultPatentRepository;
	
	@Transactional
	public void save(OrganisationUnit_ResultPatent entity) {
		if (entity.getOrganisationUnit() == null || entity.getResultPatent() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a result patent.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_ResultPatent> entityList) {
		for (OrganisationUnit_ResultPatent entity : entityList) {
			save(entity);
		}
	}

}
