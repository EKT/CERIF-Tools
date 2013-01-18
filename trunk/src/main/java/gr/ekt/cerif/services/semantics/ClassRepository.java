/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.features.semantics.ClassView;

import java.util.List;
import java.util.Set;


/**
 * A repository for links between facilities and classes.
 * 
 */

public interface ClassRepository {

	Class findById(Long id);
    
	Class findByUri(String uri);
	
	List<Class> findByScheme(ClassScheme scheme);
	
	List<ClassView> findByFacilityAndClassScheme(String classSchemeUri, Long FacilityId);
	
	List<ClassView> findByFacilityAndFundingClassScheme(String classSchemeUri, Long FacilityId);
	
	List<ClassView> findByFacilityAndLinkFacilityFundingClassScheme(String classSchemeUri, Long FacilityId);
	
	List<ClassView> findByClassScheme(String classSchemeUri);
	
	List<ClassView> findTermByClassScheme(String classSchemeUri);
	
	Class findByClassAndClassScheme(String classUri, String classSchemeUri);

	List<ClassView> findByProjectIdAndClassScheme(Long id, String classSchemeUri);

	List<String> findTermsByProjectIdAndClassScheme(Long id, String classSchemeUri);
	
	Class findByClassSchemeAndClass(String classSchemeUri, String classUri);
	
	ClassView findClassViewBySchemeUriAndResPubId(String schemeUri, Long respubId);
	
	public Set<Class> findByFundingAndClassScheme(Funding funding, String schemeUri);

	public Set<Class> findByFacilityAndClassScheme(Facility facility, String schemeUri);
	
	void delete(Class entity);
	
	Iterable<Class> save(Iterable<Class> entityList);
	
	Class save(Class entity);
	
	Class findOne(Long id);
	
}
