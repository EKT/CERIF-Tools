package gr.ekt.cerif.services.link.classscheme;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkClassSchemeOrganisationUnitCrudRepository extends CrudRepository<ClassScheme_OrganisationUnit, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassScheme_OrganisationUnit> findByScheme(ClassScheme classScheme);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassScheme_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

}
