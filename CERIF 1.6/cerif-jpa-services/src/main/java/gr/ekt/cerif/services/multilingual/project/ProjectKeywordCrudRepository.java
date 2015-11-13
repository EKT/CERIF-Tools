package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectKeywordCrudRepository extends CrudRepository<ProjectKeyword, Long> {

	public List<ProjectKeyword> findByProject(Project project);
}
