/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class ResultProductRepository {

	@Autowired
	ResultProductService service;
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#save(gr.ekt.cerif.entities.result.ResultProduct)
	 */
	@Transactional
	public void save(ResultProduct resultProduct) {
		if (StringUtils.hasText(resultProduct.getUri())) {
			ResultProduct alreadyStored = service.findByUri(resultProduct.getUri());
			if (alreadyStored != null) {
				resultProduct.setId(alreadyStored.getId());
			}
		}
		service.save(resultProduct);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#save(java.util.List)
	 */
	@Transactional
	public void save(List<ResultProduct> productList) {
		for (ResultProduct product : productList) {
			save(product);
		}
	}

}
