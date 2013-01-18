package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkProjectClassRepositoryImpl implements LinkProjectClassRepository {

	@Autowired
	private LinkProjectClassCrudRepository linkProjectClassCrudRepository;
	
	public void delete(Project_Class entity) {
		linkProjectClassCrudRepository.delete(entity);		
	}

	public Project_Class save(Project_Class entity) {
		return linkProjectClassCrudRepository.save(entity);
	}

	public List<Project_Class> save(List<Project_Class> entities) {
		return (List<Project_Class>) linkProjectClassCrudRepository.save(entities);
	}

	public Project_Class findOne(Long id) {
		return linkProjectClassCrudRepository.findOne(id);
	}

	public List<Project_Class> findByTheClass(Class theClass) {
		return linkProjectClassCrudRepository.findByTheClass(theClass);
	}

	public Project_Class findByProjectAndTheClass(Project project, Class theClass) {
		return linkProjectClassCrudRepository.findByProjectAndTheClass(project, theClass).get(0);
	}

	public List<Project_Class> findByProjectAndTheClassList(Project project, Class theClass) {
		return linkProjectClassCrudRepository.findByProjectAndTheClassList(project, theClass);
	}

	public List<Project_Class> findByTheClassUri(String uri) {
		return linkProjectClassCrudRepository.findByTheClassUri(uri);
	}

	public Project_Class findByProjectAndClassschemeAndClass(Project project, ClassScheme classScheme, Class theClass) {
		return linkProjectClassCrudRepository.findByProjectAndClassschemeAndClass(project, classScheme, theClass);
	}

	public Project_Class findByProjectAndClassScheme(Project project, ClassScheme classScheme) {
		return linkProjectClassCrudRepository.findByProjectAndClassScheme(project, classScheme);
	}

}
