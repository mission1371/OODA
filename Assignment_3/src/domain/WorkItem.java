package domain;

import java.io.Serializable;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;

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

    public String[] getFieldNames() {
        return new String[] { "Name", "Description", "Status", "Priority", "Iteration ID", "Planned Start Date", "Complition Date", "Id" };
    }

    public String[][] getWorkItemsFromFile(String projectId) throws Exception {

        return store.getObjectsFromFile(projectId);

    }

    public void saveWorkItem(WorkItem workItem) throws Exception {

        store.save(workItem);

    }

    public void updateWorkItem(WorkItem workItem) throws Exception {

        store.update(workItem);

    }

    public void deleteWorkItem(String workItemId) throws Exception {

        store.delete(workItemId);

    }

    public WorkItem getWorkItemFromFile(String workItemId) throws Exception {

        return (WorkItem) store.select(workItemId);
    }

}
