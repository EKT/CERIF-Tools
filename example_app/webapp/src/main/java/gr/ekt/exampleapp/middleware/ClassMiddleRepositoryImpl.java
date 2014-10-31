package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.ClassView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassMiddleRepositoryImpl implements ClassMiddleRepository {
	
	@Autowired
	private ClassCrudMiddleRepository classCrudMiddleRepository;

	public List<ClassView> findClassByProjectIdAndClassScheme(Long id,
			String classSchemeUUID) {
		return classCrudMiddleRepository.findClassByProjectIdAndClassScheme(id, classSchemeUUID);
	}

	public List<ClassView> findClassByOrganisationIdAndClassScheme(Long id,
			String classSchemeUUID) {
		return classCrudMiddleRepository.findClassByOrganisationIdAndClassScheme(id, classSchemeUUID);
	}

	

}
