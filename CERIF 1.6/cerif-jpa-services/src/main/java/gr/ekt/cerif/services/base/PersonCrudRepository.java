package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

	public Person findById(Long id);
	
	public Iterable<Person> findAll();
	
	public Page<Person> findAll(Pageable page);

	public Person findByUuid(String uuid);
	
	public Person findByUri(String uri);

	@Query(
		"select p " +
		"  from Person p " +
		"  left join fetch p.personResearchInterests    " +
		"  left join fetch p.personKeywords " + 
		" where p.uuid = ?1 ")
	Person findByUuidFetchMultilingual(String uuid);
}
