/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.project.Project_Equipment;

/**
 * A repository for links between projects and equipments.
 * 
 */
public interface LinkProjectEquipmentRepository {

	public void delete(Project_Equipment entity); 
	
	public void delete(Iterable<Project_Equipment> entities); 

	public Iterable<Project_Equipment> save(Iterable<Project_Equipment> entities); 
	
	public Project_Equipment save(Project_Equipment entity);
	
	List<Project_Equipment> findByProject(Project project);
	
	List<Project_Equipment> findByEquipment(Equipment equipment);
	
}
