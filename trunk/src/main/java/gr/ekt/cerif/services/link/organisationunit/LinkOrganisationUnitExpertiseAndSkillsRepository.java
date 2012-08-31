package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.ExpertiseAndSkillsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and expertiseAndSkillss.
 * 
 */
@Component
public class LinkOrganisationUnitExpertiseAndSkillsRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ExpertiseAndSkillsRepository expertiseAndSkillsRepository;
	
	@Transactional
	public void save(OrganisationUnit_ExpertiseAndSkills entity) {
		if (entity.getOrganisationUnit() == null || entity.getExpertiseAndSkills() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an expertiseAndSkills.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getExpertiseAndSkills().getId() == null) {
			expertiseAndSkillsRepository.save(entity.getExpertiseAndSkills());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_ExpertiseAndSkills> entityList) {
		for (OrganisationUnit_ExpertiseAndSkills entity : entityList) {
			save(entity);
		}
	}

}
