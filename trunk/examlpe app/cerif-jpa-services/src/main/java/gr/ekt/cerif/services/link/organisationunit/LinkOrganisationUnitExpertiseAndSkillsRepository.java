package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;

/**
 * A repository for links between organisations and expertiseAndSkillss.
 * 
 */
public interface LinkOrganisationUnitExpertiseAndSkillsRepository {
	
	public void delete(OrganisationUnit_ExpertiseAndSkills entity); 
	
	public void delete(Iterable<OrganisationUnit_ExpertiseAndSkills> entities); 

	public Iterable<OrganisationUnit_ExpertiseAndSkills> save(Iterable<OrganisationUnit_ExpertiseAndSkills> entities); 
	
	public OrganisationUnit_ExpertiseAndSkills save(OrganisationUnit_ExpertiseAndSkills entity);

}
