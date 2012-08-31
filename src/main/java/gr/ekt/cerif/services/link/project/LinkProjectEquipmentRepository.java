/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and equipments.
 * 
 */
@Component
public class LinkProjectEquipmentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Transactional
	public void save(Project_Equipment entity) {
		if (entity.getProject() == null || entity.getEquipment() == null) {
			throw new IllegalArgumentException("Please provide both a project and a Equipment.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Equipment> entityList) {
		for (Project_Equipment entity : entityList) {
			save(entity);
		}
	}
	
}
