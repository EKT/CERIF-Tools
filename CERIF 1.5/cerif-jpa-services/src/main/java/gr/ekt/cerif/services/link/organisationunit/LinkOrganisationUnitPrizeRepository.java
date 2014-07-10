package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.second.Prize;
/**
 * A repository for links between organisations and prizes.
 * 
 */
public interface LinkOrganisationUnitPrizeRepository {
	
	public void delete(OrganisationUnit_Prize entity); 
	
	public void delete(Iterable<OrganisationUnit_Prize> entities); 

	public Iterable<OrganisationUnit_Prize> save(Iterable<OrganisationUnit_Prize> entities); 
	
	public OrganisationUnit_Prize save(OrganisationUnit_Prize entity);
	
	List<OrganisationUnit_Prize> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Prize> findByPrize(Prize prize);

}
