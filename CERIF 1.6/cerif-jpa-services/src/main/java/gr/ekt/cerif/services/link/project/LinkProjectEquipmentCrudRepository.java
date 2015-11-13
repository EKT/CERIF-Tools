package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.project.Project_Equipment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectEquipmentCrudRepository extends CrudRepository<Project_Equipment, Long> {
	
	List<Project_Equipment> findByProject(Project project);
	
	List<Project_Equipment> findByEquipment(Equipment equipment);

}
