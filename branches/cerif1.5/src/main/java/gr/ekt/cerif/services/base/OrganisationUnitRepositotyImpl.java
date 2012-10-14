/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public abstract class OrganisationUnitRepositotyImpl implements OrganisationUnitRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	public OrganisationUnit save(OrganisationUnit organisation) {
		if (StringUtils.hasText(organisation.getUri())) {
			OrganisationUnit alreadyStored = findByUri(organisation.getUri());
			if (alreadyStored != null) {
				organisation.setId(alreadyStored.getId());
			}
		}
		return entityManager.merge(organisation);
	}

	
	public void save(List<OrganisationUnit> organisationList) {
		for (OrganisationUnit organisation : organisationList) {
			save(organisation);
		}
	}

}
