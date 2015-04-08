package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

@Component
public class LinkOrganisationUnitExpertiseAndSkillsRepositoryImpl implements
		LinkOrganisationUnitExpertiseAndSkillsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitExpertiseAndSkillsRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitExpertiseAndSkillsCrudRepository linkOrganisationUnitExpertiseAndSkillsCrudRepository;

	@Override
	public void delete(OrganisationUnit_ExpertiseAndSkills entity) {
		linkOrganisationUnitExpertiseAndSkillsCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_ExpertiseAndSkills> entities) {
		linkOrganisationUnitExpertiseAndSkillsCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_ExpertiseAndSkills> save(
			Iterable<OrganisationUnit_ExpertiseAndSkills> entities) {
		return linkOrganisationUnitExpertiseAndSkillsCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_ExpertiseAndSkills save(
			OrganisationUnit_ExpertiseAndSkills entity) {
		return linkOrganisationUnitExpertiseAndSkillsCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_ExpertiseAndSkills> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitExpertiseAndSkillsCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public List<OrganisationUnit_ExpertiseAndSkills> findByExpertiseAndSkills(
			ExpertiseAndSkills expertiseAndSkills) {
		return linkOrganisationUnitExpertiseAndSkillsCrudRepository.findByExpertiseAndSkills(expertiseAndSkills);
	}


}
