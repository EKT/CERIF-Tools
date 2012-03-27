/**
 * 
 */
package gr.ekt.cerif.pk.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;

public class Project_PrizeAwardId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -164767023145003688L;

	/**
	 * The project.
	 */
	private Project project;
	
	/**
	 * The prize award connected to
	 */	
	private Prize prizeAward;
	
	private Class theClass;
	
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the prizeAward
	 */
	public Prize getPrizeAward() {
		return prizeAward;
	}

	/**
	 * @param prizeAward the prizeAward to set
	 */
	public void setPrizeAward(Prize prizeAward) {
		this.prizeAward = prizeAward;
	}


	public Class getTheClass() {
		return theClass;
	}
	
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}
	
}
