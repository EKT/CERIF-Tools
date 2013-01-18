/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 
 */
@Component
public class ResultProductRepositoryImpl implements ResultProductRepository {

	@Autowired
	ResultProductCrudRepository resultProductCrudRepository;
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public ResultProduct save(ResultProduct resultProduct) {
		if (StringUtils.hasText(resultProduct.getUri())) {
			ResultProduct alreadyStored = resultProductCrudRepository.findByUri(resultProduct.getUri());
			if (alreadyStored != null) {
				resultProduct.setId(alreadyStored.getId());
			}
		}
		return resultProductCrudRepository.save(resultProduct);
	}

	@Transactional
	public Iterable<ResultProduct> save(Iterable<ResultProduct> productList) {
		for (ResultProduct product : productList) {
			save(product);
		}
		return productList;
	}

	public List<ResultProduct> getAllProducts() {
		return IteratorUtils.toList(resultProductCrudRepository.findAll().iterator());
	}
	
	public ResultProduct getProduct(Long id) {
		return resultProductCrudRepository.findOne(id);
	}

	public List<ResultProduct> findByKeyword(String keyword) {
		return entityManager.createNamedQuery("ResultProductTranslation.findByKeyword", ResultProduct.class).
				setParameter("input", String.format("%%%s%%", keyword)).getResultList();
	}
	
	public List<ResultProduct> findByClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByClass", ResultProduct.class)
				.setParameter("input", '%' + uri + '%')
				.getResultList();
	}
	
	public List<ResultProduct> findByOrganisationClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationClass", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}

	public List<ResultProduct> findByPersonClass(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByPersonClass", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}

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
	
	public List<ResultProduct> findByOrganisationURI(String uri) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationURI", ResultProduct.class)
				.setParameter(1, '%' + uri + '%')
				.getResultList();
	}
	
	public List<ResultProduct> findByOrganisationURIClass(String orgURI, String classURI) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationURIandClass", ResultProduct.class)
				.setParameter("orguri", '%' + orgURI + '%')
				.setParameter("classuri", '%' + classURI + '%')
				.getResultList();
	}
	
	public List<ResultProduct> findByOrganisationExpanded(String input, String classURI) {
		return entityManager.createNamedQuery("ResultProduct.findByOrganisationURIandClassExpanded", ResultProduct.class)
				.setParameter("orguri", '%' + input + '%')
				.setParameter("classuri", '%' + classURI + '%')
				.getResultList();
	}
	
	public List<ResultProduct> findByPersonComplete(String input) {
		return entityManager.createNamedQuery("ResultProduct.findByPersonURI", ResultProduct.class)
				.setParameter("input", '%' + input + '%')
				.getResultList();
	}

	@Transactional
	public void delete(ResultProduct entity) {
		resultProductCrudRepository.delete(entity);
	}

}
