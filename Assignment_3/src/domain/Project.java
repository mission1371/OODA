package domain;

import java.io.Serializable;
import java.math.BigDecimal;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;

/**
 * @author umut - pc
 *
 */
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private BigDecimal budget;
	private BigDecimal cost;
	private String startDate;
	private String endDate;
	private EnumProjectStatus status;
	private String id;
	private ProjectPlan projectPlan;

	private IDataManager store;

	public Project() {
		this.store = (IDataManager) ADataManagerFactory.getDataManager(this.getClass().getSimpleName());
		this.projectPlan = new ProjectPlan();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public EnumProjectStatus getStatus() {
		return status;
	}

	public void setStatus(EnumProjectStatus status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public ProjectPlan getProjectPlan() {

		if (projectPlan == null) {
			System.out.println("project plan is null in the system -> project, new project plan initiated");
			projectPlan = new ProjectPlan();
		}
		return projectPlan;
	}

	public void setProjectPlan(ProjectPlan projectPlan) {
		this.projectPlan = projectPlan;
	}

	public String[] getFieldNames() {
		return new String[] { "Name", "Description", "Budget", "Cost", "Start Date", "End Date", "Status", "Id" };
	}

	public String[][] getProjectsFromFile(String managerId) throws Exception {

		return store.getObjectsFromFile(managerId);

	}

	public void saveProject(Project project) throws Exception {

		store.save(project);

	}

	public void updateProject(Project project) throws Exception {

		store.update(project);

	}

	public void deleteProject(String projectId) throws Exception {

		store.delete(projectId);

	}

	public Project getProjectFromFile(String projectId) throws Exception {

		return (Project) store.select(projectId);
	}
}
