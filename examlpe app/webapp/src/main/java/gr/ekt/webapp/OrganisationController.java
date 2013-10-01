package gr.ekt.webapp;

import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.cerif.transferobjects.ClassView;
import gr.ekt.cerif.transferobjects.OrganisationView;
import gr.ekt.cerif.transferobjects.ProjectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/organisations")
public class OrganisationController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private PersistenceService service;
	
	@RequestMapping(value = "/browse")
	public String browse(Model model) {
		
		List<OrganisationView> organisations =  service.getBaseService().getOrganisationUnitRepository().findAllOrganisations();
		
		logger.info("Retrieving organisations");
		logger.info("Num of organisations: "+organisations.size());
		
		model.addAttribute("organisations", organisations);
		
		return "/organisation/browse";
	}
	
	
	@RequestMapping(value = "/view/{id}")
	public String view(Model model, @PathVariable("id") Long id) {
		
		OrganisationView organisation = service.getBaseService().getOrganisationUnitRepository().findOrganisationById(id);
		if (organisation!=null) {
			List<ClassView> type = service.getSemanticService().getClassRepository().findClassByOrganisationIdAndClassScheme(id, "orgtype");
			if (!type.isEmpty()) {
				organisation.setType(type.get(0));
			}
			
			Map<String,List<ProjectView>> projectsMap = new HashMap<String, List<ProjectView>>();
			
			List<ProjectView> partnerto = new ArrayList<ProjectView>();
			List<ProjectView> coordinatorto = new ArrayList<ProjectView>();
			
			List<ProjectView> projectsList = service.getBaseService().getProjectRepository().findProjectByOrganisationIdAndClassScheme(id, "org_proj_relationship");
			for (ProjectView prv:projectsList) {
				if (prv.getRoleofOrganisation().equals("Partner")) {
					partnerto.add(prv);
				} else if (prv.getRoleofOrganisation().equals("Coordinator")) {
					coordinatorto.add(prv);
				}
			}
			projectsMap.put("Partner", partnerto);
			projectsMap.put("Coordinator", coordinatorto);
			organisation.setProjects(projectsMap);

			model.addAttribute("organisation", organisation);
			
			return "/organisation/view";
		} else {
			return "/organisation/browse";
		}
		
	}
	
}
