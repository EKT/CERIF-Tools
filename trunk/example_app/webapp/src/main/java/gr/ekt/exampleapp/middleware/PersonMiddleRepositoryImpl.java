package gr.ekt.exampleapp.middleware;

import gr.ekt.exampleapp.transferobjects.PersonView;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMiddleRepositoryImpl implements PersonMiddleRepository {

	private static final Logger log = LoggerFactory.getLogger(PersonMiddleRepositoryImpl.class);
	
	@Autowired
	private PersonCrudMiddleRepository personCrudMiddleRepository;

	public List<PersonView> findAllPersons() {
		return personCrudMiddleRepository.findAllPersons();
	}

	public List<PersonView> findPersonByOrganisationIdAndClassScheme(Long id,
			String classSchemeUUID) {
		return personCrudMiddleRepository.findPersonByOrganisationIdAndClassScheme(id, classSchemeUUID);
	}

	
}
