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
	
	public List<Person_ResultPublication> queryPersResPubByResPubId(Long respubId, String persrespubclUri);
	
	public List<Person_ResultPublication> queryAllPersResPubByResPubId(Long respubId);
	
	public Person_ResultPublication queryPersResPubByResPubIdAndPersId(Long respubId, String persrespubclUri, Long persId);	
	
	public List<Long> queryPersIdsResPubId(Long respubId, String persrespubclUri);
	
	public Person_ResultPublication queryPersResPubById(Long persrespubId);
	
	List<Person_ResultPublication> findByPerson(Person person);
	
	List<Person_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
}
