package gr.ekt.cerif.services.link.classscheme;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkClassSchemeOrganisationUnitCrudRepository extends CrudRepository<ClassScheme_OrganisationUnit, Long> {
	
	List<ClassScheme_OrganisationUnit> findByScheme(ClassScheme classScheme);
	
	List<ClassScheme_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
