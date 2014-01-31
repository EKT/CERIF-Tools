/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author nhoussos
 * @author karaiskos
 * @author bonisv
 * 
 */
@Entity
@Table(name="cfFedId")
public class FederatedIdentifier implements CerifSecondLevelEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3294630150204664144L;

	/**
	 * The federated identifier database-internal unique id.
	 */
	@Id
	@Column(name="cfFedIdId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The instance id of the CERIF entity identified by the federated identifier (e.g. cfPersonId, cfProjId, cfOrgUnitId).
	 */
	@Column(name="cfInstId")
	private Long instanceId;
	
	/**
	 * The federated identifier value.
	 */
	@Column(name="cfFedId")
	private String fedId;
	
	/**
	 * The start date.
	 */
	@Column(name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@Column(name="cfEndDate")
	private Date endDate;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
	private Class theClass;
	
	/**
	 * The classification scheme.
	 */
	@ManyToOne(optional=false)
	@JoinColumn (name = "cfClassSchemeId")
	private ClassScheme scheme;

	/**
	 * The classifications.
	 */
	@OneToMany(mappedBy="fedId")
	private Set<FederatedIdentifier_Class> fedIds_classes;	
	
	/**
	 * The services.
	 */
	@OneToMany(mappedBy="fedId")
	private Set<Service_FederatedIdentifier> services_fedids;
	
	
	
	/**
	 * 
	 */
	public FederatedIdentifier() {
		super();
	}

	/**
	 * @param id
	 * @param instanceId
	 * @param fedId
	 * @param startDate
	 * @param endDate
	 * @param fedIds_classes
	 * @param services_fedids
	 */
	public FederatedIdentifier(Long instanceId, String fedId,
			Date startDate, Date endDate) {
		super();
		this.instanceId = instanceId;
		this.fedId = fedId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * @param instanceId
	 * @param fedId
	 * @param theClass
	 * @param scheme
	 * @param startDate
	 * @param endDate
	 */
	public FederatedIdentifier(Long instanceId, String fedId, Class theClass,
			ClassScheme scheme, Date startDate, Date endDate) {
		this.instanceId = instanceId;
		this.fedId = fedId;
		this.theClass = theClass;
		this.scheme = scheme;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the instanceId
	 */
	public Long getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the fedId
	 */
	public String getFedId() {
		return fedId;
	}

	/**
	 * @param fedId the fedId to set
	 */
	public void setFedId(String fedId) {
		this.fedId = fedId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Set<FederatedIdentifier_Class> getFedIds_classes() {
		return fedIds_classes;
	}
	
	public void setFedIds_classes(Set<FederatedIdentifier_Class> fedIds_classes) {
		this.fedIds_classes = fedIds_classes;
	}
	
	/**
	 * @return the services_fedids
	 */
	public Set<Service_FederatedIdentifier> getServices_fedids() {
		return services_fedids;
	}

	/**
	 * @param services_fedids the services_fedids to set
	 */
	public void setServices_fedids(Set<Service_FederatedIdentifier> services_fedids) {
		this.services_fedids = services_fedids;
	}

	public Class getTheClass() {
		return theClass;
	}

	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	public ClassScheme getScheme() {
		return scheme;
	}

	public void setScheme(ClassScheme scheme) {
		this.scheme = scheme;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FederatedIdentifier [id=" + id + ", instanceId=" + instanceId
				+ ", fedId=" + fedId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}


}
