package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

public interface OrganisationUnitNameRepository {

	OrganisationUnitName findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	OrganisationUnitName save(OrganisationUnitName entity);
	
	Iterable<? extends OrganisationUnitName> save(Iterable<? extends OrganisationUnitName> entities);
	
	void delete(OrganisationUnitName entity);
	
}
