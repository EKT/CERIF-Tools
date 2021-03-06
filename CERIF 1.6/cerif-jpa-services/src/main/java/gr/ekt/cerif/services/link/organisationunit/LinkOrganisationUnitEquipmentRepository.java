package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;

/**
 * A repository for links between organisations and equipments.
 * 
 */
public interface LinkOrganisationUnitEquipmentRepository {
	
	public void delete(OrganisationUnit_Equipment entity); 
	
	public void delete(Iterable<OrganisationUnit_Equipment> entities); 

	public Iterable<OrganisationUnit_Equipment> save(Iterable<OrganisationUnit_Equipment> entities); 
	
	public OrganisationUnit_Equipment save(OrganisationUnit_Equipment entity);
	
	List<OrganisationUnit_Equipment> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Equipment> findByEquipment(Equipment equipment);

}
