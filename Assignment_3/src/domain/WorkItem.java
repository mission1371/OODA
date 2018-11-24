package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;
import domain.utility.DataUtility;
import domain.utility.schedule_algorithms.IScheduleAlgorithm;

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
    private String developerId;

    private IDataManager store;
    private IScheduleAlgorithm schedule;

    public WorkItem() {

        this.store = (IDataManager) ADataManagerFactory.getDataManager(this.getClass().getSimpleName());
        this.schedule = (IScheduleAlgorithm) ASystemFactory.getScheduleAlgorithm();
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

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    /*
     * 
     * 
     * ------------------------------ Store Methods ----------------------
     */

    public String[] getFieldNames() {
        return new String[] { "Name", "Description", "Status", "Priority", "Is Assigned", "Estimated Effort", "Iteration ID", "Planned Start Date", "Complition Date", "Id" };
    }

    public String[][] getWorkItemsFromFile(String iterationId) throws Exception {

        return store.getObjectsFromFile(iterationId);

    }

    public void saveWorkItem(WorkItem workItem) throws Exception {

        checkPredecessor(workItem);
        validateDates(workItem);
        schedule.scheduleAlgorithm(workItem);
        checkNull(workItem);
        store.save(workItem);

    }

    public void updateWorkItem(WorkItem workItem) throws Exception {

        checkPredecessor(workItem);
        validateDates(workItem);
        schedule.scheduleAlgorithm(workItem);
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

        DataUtility.isNull(item, "Work item can not be empty");
        DataUtility.isNull(item.getId(), "Id of Work item can not be empty");
        DataUtility.isNull(item.getName(), "Name of Work item can not be empty");
        DataUtility.isNull(item.getDescription(), "Description of Work item can not be empty");
        DataUtility.isNull(item.getStatus(), "Status of Work item can not be empty");
        DataUtility.isNull(item.getPriority(), "Priority of Work item can not be empty");
        DataUtility.isNull(item.getIterationId(), "Iteration Id of Work item can not be empty");
        DataUtility.isNull(item.getAssignedStatus(), "Assignment status of Work item can not be empty");
        DataUtility.isNull(item.getEstimatedEffort(), "Estimated effort of Work item can not be empty");

        if (item.getEstimatedEffort() <= 0) {
            throw new Exception("Estimated effort must be greater than 0");
        }
        
        if (item.getAssignedStatus().getCode() == EnumWorkItemAssignStatus.ASSIGNED.getCode()) {
            DataUtility.isEmpty(item.getPlannedStartDate(), "Planned start date of Work item can not be empty due to assignment status of work item.");
            DataUtility.isEmpty(item.getCompletionDate(), "Completion date of Work item can not be empty due to assignment status of work item.");
            DataUtility.isEmpty(item.getDeveloperId(), "Developer ID can not be empty due to assignment status of work item.");
        }

        if (item.getAssignedStatus().getCode() == EnumWorkItemAssignStatus.NOT_ASSIGNED.getCode()) {
            item.setDeveloperId("");
        }

        if (DataUtility.isNull(item.getPlannedStartDate(), false)) {
            item.setPlannedStartDate("");
        }

        if (DataUtility.isNull(item.getCompletionDate(), false)) {
            item.setCompletionDate("");
        }
    }

    private void validateDates(WorkItem workItem) throws Exception {

        if (workItem.assignedStatus.getCode() == EnumWorkItemAssignStatus.ASSIGNED.getCode()) {
            Date itemStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(workItem.getPlannedStartDate());

            if (!DataUtility.isEmpty(workItem.getPredecessor(), false)) {

                String[] arr = workItem.getPredecessor().split("-");

                for (String itemId : arr) {

                    WorkItem item = (WorkItem) store.select(itemId);
                    Date compDate = new SimpleDateFormat("dd/MM/yyyy").parse(item.getCompletionDate());

                    if (compDate.after(itemStartDate)) {
                        throw new Exception("Work item's planned start date cannot be earlier than one of its predecessors.");
                    }
                }
            }
        }
    }

    private void checkPredecessor(WorkItem workItem) throws Exception {

        if (!DataUtility.isEmpty(workItem.getPredecessor(), false)) {

            String[] arr = workItem.getPredecessor().split("-");
            List<WorkItem> workItems = ADataManagerFactory.getSystemState().getWorkItems();
            List<String> checkList = new ArrayList<String>();
            Collections.addAll(checkList, arr);

            for (String pre : arr) {
                for (WorkItem item : workItems) {

                    if (item.getId().equals(pre)) {
                        // onceki work item için en date in boş olup olmaması

                        if (DataUtility.isEmpty(item.getPlannedStartDate(), false) || DataUtility.isEmpty(item.getCompletionDate(), false)) {
                            throw new Exception("Predecessors must have planned start date and completion date.");
                        }

                        checkList.remove(pre);
                        continue;
                    }
                }

            }
            if (!checkList.isEmpty()) {
                throw new Exception("One of the work items' id is not registered in the system.");
            }
        }
    }

}
