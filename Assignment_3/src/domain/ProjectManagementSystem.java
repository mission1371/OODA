package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author umut.taherzadeh
 *
 */
public class ProjectManagementSystem implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private ArrayList<Project> projects;

    private ArrayList<Developer> developers;

    private ArrayList<WorkItem> workItems;

    public ProjectManagementSystem() {

        this.projects = new ArrayList<Project>();
        System.out.println("projects initiated");

        this.developers = new ArrayList<Developer>();
        System.out.println("developers initiated");

        this.workItems = new ArrayList<WorkItem>();
        System.out.println("work items initiated");
    }

    public ArrayList<Project> getProjects() {
        if (projects == null) {
            System.out.println("projects are null in the system, new projects initiated");
            projects = new ArrayList<Project>();
        }

        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Developer> getDevelopers() {
        if (developers == null) {
            System.out.println("developers are null in the system, new developers initiated");
            developers = new ArrayList<Developer>();
        }

        return developers;
    }

    public void setDevelopers(ArrayList<Developer> developers) {
        this.developers = developers;
    }

    public ArrayList<WorkItem> getWorkItems() {
        if (workItems == null) {
            System.out.println("work items are null in the system, new work items initiated");
            workItems = new ArrayList<WorkItem>();
        }
        return workItems;
    }

    public void setWorkItems(ArrayList<WorkItem> workItems) {
        this.workItems = workItems;
    }

}
