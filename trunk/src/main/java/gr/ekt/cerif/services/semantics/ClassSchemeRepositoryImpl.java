/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class ClassSchemeRepositoryImpl implements ClassSchemeRepository {

	@Autowired
	ClassSchemeService service;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.semantics.ClassSchemeRepository#save(gr.ekt.cerif.features.semantics.ClassScheme)
	 */
	@Override
	public void save(ClassScheme scheme) {
		if (StringUtils.hasText(scheme.getUri())) {
			ClassScheme alreadyStored = service.findByUri(scheme.getUri());
			if (alreadyStored != null) {
				scheme.setId(alreadyStored.getId());
			}
		}
		service.save(scheme);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.semantics.ClassSchemeRepository#save(java.util.List)
	 */
	@Override
	public void save(List<ClassScheme> schemeList) {
		for (ClassScheme scheme : schemeList) {
			save(scheme);
		}
	}

}
