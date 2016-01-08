package domain;

import java.io.Serializable;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;
import domain.utility.DataUtility;

/**
 * @author umut.taherzadeh
 *
 */
public class WorkItem implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;
    private EnumWorkItemStatus status;
    private EnumWorkItemPriority priority;
    private String iterationId;
    private String plannedStartDate;
    private String completionDate;
    private int estimatedEffort;
    private EnumWorkItemAssignStatus assignedStatus;
    private String predecessor;

    private IDataManager store;

    public WorkItem() {

        this.store = (IDataManager) ADataManagerFactory.getDataManager(this.getClass().getSimpleName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public EnumWorkItemStatus getStatus() {
        return status;
    }

    public void setStatus(EnumWorkItemStatus status) {
        this.status = status;
    }

    public EnumWorkItemPriority getPriority() {
        return priority;
    }

    public void setPriority(EnumWorkItemPriority priority) {
        this.priority = priority;
    }

    public String getIterationId() {
        return iterationId;
    }

    public void setIterationId(String iterationId) {
        this.iterationId = iterationId;
    }

    public String getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(String plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public EnumWorkItemAssignStatus getAssignedStatus() {
        return assignedStatus;
    }

    public void setAssignedStatus(EnumWorkItemAssignStatus assignedStatus) {
        this.assignedStatus = assignedStatus;
    }

    public int getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(int estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public String getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    /*
     * 
     * 
     * ------------------------------ Store Methods ----------------------
     */

    public String[] getFieldNames() {
        return new String[] { "Name", "Description", "Status", "Priority", "Is Assigned", "Estimated Effort", "Iteration ID", "Planned Start Date", "Complition Date", "Id" };
    }

    public String[][] getWorkItemsFromFile(String projectId) throws Exception {

        return store.getObjectsFromFile(projectId);

    }

    public void saveWorkItem(WorkItem workItem) throws Exception {

        checkNull(workItem);
        store.save(workItem);

    }

    public void updateWorkItem(WorkItem workItem) throws Exception {

        checkNull(workItem);
        store.update(workItem);

    }

    public void deleteWorkItem(String workItemId) throws Exception {

        store.delete(workItemId);

    }

    public WorkItem getWorkItemFromFile(String workItemId) throws Exception {

        return (WorkItem) store.select(workItemId);
    }

    /*
     * 
     * 
     * 
     * --------------------------------- PRIVATE ------------------------------
     */
    private void checkNull(WorkItem item) throws Exception {

        DataUtility.isNull(item);
        DataUtility.isNull(item.getId());
        DataUtility.isNull(item.getName());
        DataUtility.isNull(item.getDescription());
        DataUtility.isNull(item.getStatus());
        DataUtility.isNull(item.getPriority());
        DataUtility.isNull(item.getIterationId());
        DataUtility.isNull(item.getAssignedStatus());
        DataUtility.isNull(item.getEstimatedEffort());

        if (item.getEstimatedEffort() <= 0) {
            throw new Exception("Estimated effort must be greater than 0");
        }
        if (item.getAssignedStatus().getCode() == EnumWorkItemAssignStatus.ASSIGNED.getCode()) {
            DataUtility.isEmpty(item.getPlannedStartDate());
            DataUtility.isEmpty(item.getCompletionDate());
        }

        if (DataUtility.isNull(item.getPlannedStartDate(), false)) {
            item.setPlannedStartDate("");
        }

        if (DataUtility.isNull(item.getCompletionDate(), false)) {
            item.setCompletionDate("");
        }
    }

}
