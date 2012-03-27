/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class ClassRepositoryImpl implements ClassRepository {
	
	@Autowired
	ClassService service;

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.semantics.ClassRepository#save(gr.ekt.cerif.features.semantics.Class)
	 */
	@Override
	public void save(Class feature) {
		if (StringUtils.hasText(feature.getUri())) {
			Class alreadyStored = service.findByUri(feature.getUri());
			if (alreadyStored != null) {
				feature.setId(alreadyStored.getId());
			}
		}
		service.save(feature);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.semantics.ClassRepository#save(java.util.List)
	 */
	@Override
	public void save(List<Class> featureList) {
		for (Class feature : featureList) {
			save(feature);
		}
	}

}
