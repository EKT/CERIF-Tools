/**
 * 
 */
package gr.ekt.cerif.xml.records.base;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.transformationengine.core.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bonisv
 *
 */
public class CerifProjectRecord extends Record {

	private Project project;
	
	public CerifProjectRecord(Project project) {
		this.project = project;
	}
	
	@Override
	public List<Object> getByName(String elementName) {
		return null;
	}

	@Override
	public void printByName(String elementName) {
	}

	@Override
	public void removeField(String fieldName) {
	}
	
	@Override
	public void addField(String arg0, ArrayList<Object> arg1) {
	}

	@Override
	public void addValueToField(String arg0, Object arg1) {
	}

	@Override
	public void removeValueFromField(String arg0, Object arg1) {
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
