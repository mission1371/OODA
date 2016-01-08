package domain.controller;

import domain.EnumWorkItemAssignStatus;
import domain.EnumWorkItemPriority;
import domain.EnumWorkItemStatus;
import domain.WorkItem;

/**
 * @author umut.taherzadeh
 *
 */
public class ManageWorkItemHandler {

    private WorkItem workItem;
    private static ManageWorkItemHandler instance = null;

    private ManageWorkItemHandler() {
        this.workItem = new WorkItem();

    }

    public static ManageWorkItemHandler getInstance() {

        if (instance == null) {
            instance = new ManageWorkItemHandler();
        }
        return instance;
    }

    public String[][] getWorkItemsFromFile(String projectId) throws Exception {
        return workItem.getWorkItemsFromFile(projectId);
    }

    public String[] getWorkItemTableFieldNames() throws Exception {

        return workItem.getFieldNames();

    }

    public void deleteWorkItem(String workItemId) throws Exception {
        workItem.deleteWorkItem(workItemId);

    }

    public void updateWorkItem(WorkItem item) throws Exception {
        workItem.updateWorkItem(item);

    }

    public void saveWorkItem(WorkItem item) throws Exception {
        workItem.saveWorkItem(item);

    }

    public WorkItem getWorkItem(String workItemId) throws Exception {
        return workItem.getWorkItemFromFile(workItemId);

    }

    public String[] getStatusLabels() {
        return EnumWorkItemStatus.getTextLabels();
    }

    public String[] getPriorityLabels() {
        return EnumWorkItemPriority.getTextLabels();
    }

    public String[] getAssignedStatusLabels() {
        return EnumWorkItemAssignStatus.getTextLabels();
    }

}