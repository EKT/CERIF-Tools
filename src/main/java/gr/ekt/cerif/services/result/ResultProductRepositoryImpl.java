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
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class ResultProductRepositoryImpl implements ResultProductRepository {

	@Autowired
	ResultProductService service;
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#save(gr.ekt.cerif.entities.result.ResultProduct)
	 */
	@Override
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
	@Override
	public void save(List<ResultProduct> productList) {
		for (ResultProduct product : productList) {
			save(product);
		}
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#getAllProducts()
	 */
	@Override
	public List<ResultProduct> getAllProducts() {
		return service.findAll();
	}
	
	public ResultProduct getProduct(Long id) {
		return service.findOne(id);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#findByKeyword(java.lang.String)
	 */
	@Override
	public List<ResultProduct> findByKeyword(String keyword) {
		return entityManager.createNamedQuery("ResultProductTranslation.findByKeyword", ResultProduct.class).
				setParameter("input", String.format("%%%s%%", keyword)).getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#findByClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> findByClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByClass", ResultProduct.class)
				.setParameter("input", '%' + uri + '%')
				.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#findByOrganisationClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> findByOrganisationClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationClass", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#findByPersonClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> findByPersonClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByPersonClass", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.result.ResultProductRepository#findByProjectClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> findByProjectClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByProjectClass", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}
	
	public List<ResultProduct> findByCountry(String code) {
		return entityManager.createNamedQuery("ResultProduct_Country.getProductsByCountryCode", ResultProduct.class)
				.setParameter("code", '%' + code + '%')
				.getResultList();
	}
	
	@Override
	public List<ResultProduct> findByOrganisationURI(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationURI", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}
	
	@Override
	public List<ResultProduct> findByOrganisationURIClass(String orgURI, String classURI) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationURIandClass", ResultProduct.class)
				.setParameter("orguri", '%' + orgURI + '%')
				.setParameter("classuri", '%' + classURI + '%')
				.getResultList();
	}
	
	@Override
	public List<ResultProduct> findByOrganisationExpanded(String input, String classURI) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationURIandClassExpanded", ResultProduct.class)
				.setParameter("orguri", '%' + input + '%')
				.setParameter("classuri", '%' + classURI + '%')
				.getResultList();
	}
	
	
	
	@Override
	public List<ResultProduct> findByPersonComplete(String input) {
		return entityManager.createNamedQuery("ResultProduct.findByPersonURI", ResultProduct.class)
				.setParameter("input", '%' + input + '%')
				.getResultList();
	}
	

}
