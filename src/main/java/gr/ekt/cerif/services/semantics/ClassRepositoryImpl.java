package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.features.semantics.ClassView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClassRepositoryImpl implements ClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
		
	@Autowired
	private ClassSchemeRepository classSchemeRepository;
	
	@Autowired
	private ClassCrudRepository classCrudRepository;
	
	public Class findById(Long id) {
		return classCrudRepository.findById(id);
	}

	public Class findByUri(String uri) {
		return classCrudRepository.findByUri(uri).get(0);
	}
	
	public List<Class> findByScheme(ClassScheme scheme) {
		return classCrudRepository.findByScheme(scheme);
	}
	
	public List<ClassView> findByFacilityAndClassScheme(String classSchemeUri, Long FacilityId) {
		return classCrudRepository.findByClassScheme(classSchemeUri);
	}
	
	public List<ClassView> findByFacilityAndFundingClassScheme(String classSchemeUri, Long FacilityId) {
		return classCrudRepository.findByFacilityAndFundingClassScheme(classSchemeUri, FacilityId);
	}
	
	public List<ClassView> findByFacilityAndLinkFacilityFundingClassScheme(	String classSchemeUri, Long FacilityId) {		
		return classCrudRepository.findByFacilityAndLinkFacilityFundingClassScheme(classSchemeUri, FacilityId);
	}

	public List<ClassView> findByClassScheme(String classSchemeUri) {
		return classCrudRepository.findByClassScheme(classSchemeUri);
	}
	
	public List<ClassView> findTermByClassScheme(String classSchemeUri) {
		return classCrudRepository.findTermByClassScheme(classSchemeUri);
	}

	public Class findByClassAndClassScheme(String classUri, String classSchemeUri) {
		return classCrudRepository.findByClassAndClassScheme(classUri, classSchemeUri);
	}
	
	public List<ClassView> findByProjectIdAndClassScheme(Long id, String classSchemeUri) {
		return classCrudRepository.findByProjectIdAndClassScheme(id, classSchemeUri);
	}
	
	public List<String> findTermsByProjectIdAndClassScheme(Long id, String classSchemeUri) {
		return classCrudRepository.findTermsByProjectIdAndClassScheme(id, classSchemeUri);
	}
	
	public Class findByClassSchemeAndClass(String classSchemeUri, String classUri) {
		return classCrudRepository.findByClassSchemeAndClass(classSchemeUri, classUri);
	}
	
	public ClassView findClassViewBySchemeUriAndResPubId(String schemeUri, Long respubId) {
		return classCrudRepository.findClassViewBySchemeUriAndResPubId(schemeUri, respubId);
	}
	
	public Set<Class> findByFundingAndClassScheme(Funding funding, String schemeUri){
		
		ClassScheme classScheme = classSchemeRepository.findByUri(schemeUri);
	
		
		if (classScheme != null){
			List<Class> theClass = classCrudRepository.findByScheme(classScheme);
			
			Set<Class> classes = new HashSet<Class>();
			 for(Funding_Class cl:funding.getClasses()){
				if(theClass.contains(cl.getTheClass())){
					classes.add(cl.getTheClass());
				}
			 }			 
			
			return classes;
		}
		else
			return null;
		
	}
	
	public Set<Class> findByFacilityAndClassScheme(Facility facility, String schemeUri){
		ClassScheme classScheme = classSchemeRepository.findByUri(schemeUri);
		ClassSchemeName classSchemeName = classScheme.getNames().iterator().next();
		if (classSchemeName != null){
			List<Class> theClass = classCrudRepository.findByScheme(classSchemeName.getClassScheme());
			
			Set<Class> classes = new HashSet<Class>();
			 for(Facility_Class cl:facility.getClasses()){
				if(theClass.contains(cl.getTheClass()))
					classes.add(cl.getTheClass());
			 }			 
			
			return classes;
		}
		else
			return null;
		
	}

	@Transactional
	public void delete(Class entity) {
		classCrudRepository.delete(entity);		
	}

	@Transactional
	public Iterable<Class> save(Iterable<Class> entityList) {
		return classCrudRepository.save(entityList);
	}

	@Transactional
	public Class save(Class entity) {
		return classCrudRepository.save(entity);
	}

	public Class findOne(Long id) {
		return classCrudRepository.findOne(id);
	}

}
