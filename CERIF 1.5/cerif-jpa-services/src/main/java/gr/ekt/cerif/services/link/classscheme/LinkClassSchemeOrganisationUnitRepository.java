package gr.ekt.cerif.services.link.classscheme;

import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;

/**
 * A repository for links between classScheme and Organisation Unit.
 * 
 */
public interface LinkClassSchemeOrganisationUnitRepository {
	
	public void delete(ClassScheme_OrganisationUnit entity); 
	
	public void delete(Iterable<ClassScheme_OrganisationUnit> entities); 

	public Iterable<ClassScheme_OrganisationUnit> save(Iterable<ClassScheme_OrganisationUnit> entities); 
	
	public ClassScheme_OrganisationUnit save(ClassScheme_OrganisationUnit entity);

}
