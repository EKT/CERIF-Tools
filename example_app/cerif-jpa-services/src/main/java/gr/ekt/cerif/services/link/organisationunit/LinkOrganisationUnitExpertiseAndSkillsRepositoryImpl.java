package gr.ekt.cerif.services.link.organisationunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;

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

}
