package domain.controller;

import domain.EnumProjectStatus;
import domain.Project;

/**
 * @author umut - pc
 *
 */
public class ManageProjectHandler {

    private Project project;
    private static ManageProjectHandler instance = null;

    private ManageProjectHandler() {
        this.project = new Project();

    }

    public static ManageProjectHandler getInstance() {

        if (instance == null) {
            instance = new ManageProjectHandler();
        }
        return instance;
    }

    public String[][] getProjectsFromFile(String managerId) throws Exception {
        return project.getProjectsFromFile(managerId);
    }

    public String[] getProjectTableFieldNames() throws Exception {

        return project.getFieldNames();

    }

    public void deleteProject(String projectId) throws Exception {
        project.deleteProject(projectId);

    }

    public void updateProject(Project project) throws Exception {
        this.project.updateProject(project);

    }

    public void saveProject(Project project) throws Exception {
        this.project.saveProject(project);

    }

    public Project getProject(String projectId) throws Exception {
        return project.getProjectFromFile(projectId);

    }

    public String[] getStatusLabels() {
        return EnumProjectStatus.getTextLabels();
    }

}
