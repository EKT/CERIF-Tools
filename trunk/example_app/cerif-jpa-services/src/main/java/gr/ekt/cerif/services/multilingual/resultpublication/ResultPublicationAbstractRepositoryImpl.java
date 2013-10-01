/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bonisv
 *
 */
@Component
public class ResultPublicationAbstractRepositoryImpl implements ResultPublicationAbstractRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationAbstractRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationAbstractCrudRepository resultPublicationAbstractCrudRepository;

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationAbstractRepository#findByResultPublication(gr.ekt.cerif.entities.result.ResultPublication)
	 */
	@Override
	public ResultPublicationAbstract findByResultPublication(ResultPublication resultPublication) {
		return resultPublicationAbstractCrudRepository.findByResultPublication(resultPublication);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationAbstractRepository#delete(gr.ekt.cerif.features.multilingual.ClassTerm)
	 */
	@Override
	public void delete(ResultPublicationAbstract entity) {
		resultPublicationAbstractCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationAbstractRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<ResultPublicationAbstract> entityList) {
		resultPublicationAbstractCrudRepository.delete(entityList);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationAbstractRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<ResultPublicationAbstract> save(Iterable<ResultPublicationAbstract> entityList) {
		return resultPublicationAbstractCrudRepository.save(entityList);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationAbstractRepository#save(gr.ekt.cerif.features.multilingual.ClassTerm)
	 */
	@Override
	public ResultPublicationAbstract save(ResultPublicationAbstract entity) {
		return resultPublicationAbstractCrudRepository.save(entity);
	}

}
