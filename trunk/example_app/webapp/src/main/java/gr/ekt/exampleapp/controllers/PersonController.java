package gr.ekt.exampleapp.controllers;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.enumerations.semantics.ClassSchemeEnum;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.exampleapp.middleware.OrganisationUnitMiddleRepository;
import gr.ekt.exampleapp.middleware.PersonMiddleRepository;
import gr.ekt.exampleapp.transferobjects.OrganisationView;
import gr.ekt.exampleapp.transferobjects.PersonView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/persons")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersistenceService service;
	
	@Autowired
	private PersonMiddleRepository personMiddleRepository;
	
	@Autowired
	private OrganisationUnitMiddleRepository organisationUnitMiddleRepository;
	
	
	
	@RequestMapping(value = "/browse")
	public String browse(Model model) {
		
		List<PersonView> persons = personMiddleRepository.findAllPersons();
		
		logger.debug("Retrieving persons");
		logger.debug("Num of persons: "+persons.size());
		
		for (PersonView per:persons) {
			List<OrganisationView> orgs = organisationUnitMiddleRepository.findOrganisationByPersonIdAndClassScheme(per.getId(),
					ClassSchemeEnum.PERSON_ORGANISATION_ROLES.getUuid());
			if (!orgs.isEmpty()) {
				per.setOrganisations((ArrayList<OrganisationView>) orgs);
			}
		}
		
		model.addAttribute("persons", persons);
		
		return "/person/browse";
	}
	
	@RequestMapping(value = "/view/{id}")
	public String view(Model model, @PathVariable("id") Long id) {
		
		Person personEnt = service.getBaseService().getPersonRepository().findById(id);
		if (personEnt!=null) {
			PersonView person = new PersonView();
			List<PersonName> perns = service.getAdditionalService().getPersonNameRepository().findAllNamesByPersonId(personEnt.getId());
			if (!perns.isEmpty()) {
				person.setFirstName(perns.get(0).getFirstNames());
				person.setLastName(perns.get(0).getFamilyNames());
			}
			
			List<OrganisationView> orgs = organisationUnitMiddleRepository.findOrganisationByPersonIdAndClassScheme(personEnt.getId(),
					ClassSchemeEnum.PERSON_ORGANISATION_ROLES.getUuid());
			if (!orgs.isEmpty()) {
				person.setOrganisations((ArrayList<OrganisationView>) orgs);
			}
			
			model.addAttribute("person", person);
			
			return "/person/view";
		} else {
			return "/person/browse";
		}
		
	}

}
