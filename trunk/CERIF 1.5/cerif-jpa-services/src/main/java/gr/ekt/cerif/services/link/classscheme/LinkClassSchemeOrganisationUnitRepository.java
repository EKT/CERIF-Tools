package gr.ekt.cerif.services.link.classscheme;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * A repository for links between classScheme and Organisation Unit.
 * 
 */
public interface LinkClassSchemeOrganisationUnitRepository {
	
	public void delete(ClassScheme_OrganisationUnit entity); 
	
	public void delete(Iterable<ClassScheme_OrganisationUnit> entities); 

	public Iterable<ClassScheme_OrganisationUnit> save(Iterable<ClassScheme_OrganisationUnit> entities); 
	
	public ClassScheme_OrganisationUnit save(ClassScheme_OrganisationUnit entity);
	
	List<ClassScheme_OrganisationUnit> findByScheme(ClassScheme classScheme);
	
	List<ClassScheme_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
