package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

/**
 * A repository for links between persons and result publications.
 * 
 */
public interface LinkPersonResultPublicationRepository {
	
	public Person_ResultPublication save(Person_ResultPublication entity);
	
	public Iterable<Person_ResultPublication> save(Iterable<Person_ResultPublication> entityList);

	public void delete(Person_ResultPublication entity);
	
	public void delete(List<Person_ResultPublication> entityList);
	
	public List<Person_ResultPublication> findByResPublIdAndClassSchemeUri(Long respubId, String persrespubclUri);
	
	public List<Person_ResultPublication> findByResPublId(Long respubId);
	
	public Person_ResultPublication findByResPublIdAndClassSchemeAndPersonId(Long respubId, String persrespubclUri, Long persId);	
	
	public List<Long> findPersonIdsByResPublIdAndClassUri(Long respubId, String persrespubclUri);
	
	public Person_ResultPublication findByPersonResPublId(Long persrespubId);
	
	public List<Person_ResultPublication> findByPerson(Person person);
	
	public List<Person_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
	public List<Person_ResultPublication> findByPersonIdAndClassUri(Long personId, String persrespubclUri);

	public List<Person_ResultPublication> findByResPublIdAndClassUri(Long resPublId, String persrespubclUri);
	
	public Person_ResultPublication findByPersonIdAndResultPublicationId(Long PerId, Long ResId);
	
}
