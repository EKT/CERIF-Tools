/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bonisv
 *
 */
@Component
public class ResultPublicationTitleRepositoryImpl implements ResultPublicationTitleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationTitleRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationTitleCrudRepository resultPublicationTitleCrudRepository;

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationTitleRepository#findByResultPublication(gr.ekt.cerif.entities.result.ResultPublication)
	 */
	@Override
	public ResultPublicationTitle findByResultPublication(ResultPublication resultPublication) {
		return resultPublicationTitleCrudRepository.findByResultPublication(resultPublication);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationTitleRepository#delete(gr.ekt.cerif.features.multilingual.ResultPublicationTitle)
	 */
	@Override
	public void delete(ResultPublicationTitle entity) {
		resultPublicationTitleCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationTitleRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<ResultPublicationTitle> entityList) {
		resultPublicationTitleCrudRepository.delete(entityList);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationTitleRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<ResultPublicationTitle> save(Iterable<ResultPublicationTitle> entityList) {
		return resultPublicationTitleCrudRepository.save(entityList);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.multilingual.ResultPublicationTitleRepository#save(gr.ekt.cerif.features.multilingual.ResultPublicationTitle)
	 */
	@Override
	public ResultPublicationTitle save(ResultPublicationTitle entity) {
		return resultPublicationTitleCrudRepository.save(entity);
	}

}
