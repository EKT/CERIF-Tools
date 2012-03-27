/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class OrganisationUnitRepositotyImpl implements OrganisationUnitRepository {

	@Autowired
	OrganisationUnitService service;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.OrganisationUnitRepository#save(gr.ekt.cerif.entities.base.OrganisationUnit)
	 */
	@Override
	public void save(OrganisationUnit organisation) {
		if (StringUtils.hasText(organisation.getUri())) {
			OrganisationUnit alreadyStored = service.findByUri(organisation.getUri());
			if (alreadyStored != null) {
				organisation.setId(alreadyStored.getId());
			}
		}
		service.save(organisation);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.OrganisationUnitRepository#save(java.util.List)
	 */
	@Override
	public void save(List<OrganisationUnit> organisationList) {
		for (OrganisationUnit organisation : organisationList) {
			save(organisation);
		}
	}

}
