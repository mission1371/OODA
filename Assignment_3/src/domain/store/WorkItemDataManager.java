package domain.store;

import java.util.ArrayList;

import domain.ProjectManagementSystem;
import domain.WorkItem;

/**
 * @author umut.taherzadeh
 *
 */
public class WorkItemDataManager extends ADataManagerFactory {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static WorkItemDataManager instance = null;

    private WorkItemDataManager() {
        // to prevent new instance
    }

    public static WorkItemDataManager getInstance() {
        if (instance == null) {
            instance = new WorkItemDataManager();
        }
        return instance;
    }

    @Override
    public String[][] getObjectsFromFile(String managerId) throws Exception {

        String[][] returnArr = null;

        ArrayList<WorkItem> workItems = getSystemState().getWorkItems();

        if (workItems != null && !workItems.isEmpty()) {
            returnArr = new String[workItems.size()][WorkItem.class.getDeclaredFields().length];

            int i = 0;
            for (WorkItem item : workItems) {

                // TODO implement reflection
                
                returnArr[i][0] = item.getName();
                returnArr[i][1] = item.getDescription();
                returnArr[i][2] = item.getStatus().getText();
                returnArr[i][3] = item.getPriority().getText();
                returnArr[i][4] = item.getAssignedStatus().getText();
                returnArr[i][5] = String.valueOf(item.getEstimatedEffort());
                returnArr[i][6] = item.getIterationId();
                returnArr[i][7] = item.getPlannedStartDate();
                returnArr[i][8] = item.getCompletionDate();
                returnArr[i][9] = item.getId();

                i++;
            }
        } else {
            returnArr = new String[0][0];
        }

        return returnArr;
    }

    @Override
    public void update(Object workItem) throws Exception {

        ProjectManagementSystem system = getSystemState();

        for (WorkItem dbItem : system.getWorkItems()) {
            if (((WorkItem) workItem).getId().equals(dbItem.getId())) {

                system.getWorkItems().remove(dbItem);
                system.getWorkItems().add((WorkItem) workItem);
                break;
            }
        }
        saveSystemState(system);

    }

    @Override
    public void delete(String workItemId) throws Exception {

        ProjectManagementSystem system = getSystemState();

        for (WorkItem item : system.getWorkItems()) {
            if (workItemId.equals(item.getId())) {

                system.getProjects().remove(item);
                break;
            }
        }

        saveSystemState(system);

    }

    @Override
    public void save(Object workItem) throws Exception {

        ProjectManagementSystem system = getSystemState();

        system.getWorkItems().add((WorkItem) workItem);

        saveSystemState(system);

    }

    @Override
    public Object select(String workItemId) throws Exception {

        WorkItem returnProject = null;

        ArrayList<WorkItem> list = getSystemState().getWorkItems();

        for (WorkItem item : list) {
            if (workItemId.equals(item.getId())) {
                returnProject = item;
            }
        }

        return returnProject;

    }

}
