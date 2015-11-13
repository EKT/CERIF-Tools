package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitEquipmentCrudRepository extends CrudRepository<OrganisationUnit_Equipment, Long> {
	
	List<OrganisationUnit_Equipment> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Equipment> findByEquipment(Equipment equipment);

}
