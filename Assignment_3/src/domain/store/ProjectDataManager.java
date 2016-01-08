package domain.store;

import java.util.ArrayList;

import domain.Project;
import domain.ProjectManagementSystem;

/**
 * @author umut.taherzadeh
 *
 */
public class ProjectDataManager extends ADataManagerFactory {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static ProjectDataManager instance = null;

    private ProjectDataManager() {
        // to prevent new instance
    }

    public static ProjectDataManager getInstance() {
        if (instance == null) {
            instance = new ProjectDataManager();
        }
        return instance;
    }

    @Override
    public String[][] getObjectsFromFile(String managerId) throws Exception {

        String[][] returnArr = null;

        ArrayList<Project> projects = getSystemState().getProjects();

        if (projects != null && !projects.isEmpty()) {
            returnArr = new String[projects.size()][Project.class.getDeclaredFields().length];

            int i = 0;
            for (Project project : projects) {

                // TODO implement reflection

                returnArr[i][0] = project.getName();
                returnArr[i][1] = project.getDescription();
                returnArr[i][2] = project.getBudget().toPlainString();
                returnArr[i][3] = project.getCost().toPlainString();
                returnArr[i][4] = project.getStartDate();
                returnArr[i][5] = project.getEndDate();
                returnArr[i][6] = project.getStatus().getText();
                returnArr[i][7] = project.getId();

                i++;
            }
        } else {
            returnArr = new String[0][0];
        }

        return returnArr;
    }

    @Override
    public void update(Object project) throws Exception {

        ProjectManagementSystem system = getSystemState();

        for (Project dbProject : system.getProjects()) {
            if (((Project) project).getId().equals(dbProject.getId())) {

                system.getProjects().remove(dbProject);
                system.getProjects().add((Project) project);
                break;
            }
        }
        saveSystemState(system);

    }

    @Override
    public void delete(String projectId) throws Exception {

        ProjectManagementSystem system = getSystemState();

        for (Project project : system.getProjects()) {
            if (projectId.equals(project.getId())) {

                system.getProjects().remove(project);
                break;
            }
        }

        saveSystemState(system);

    }

    @Override
    public void save(Object project) throws Exception {

        ProjectManagementSystem system = getSystemState();

        system.getProjects().add((Project) project);

        saveSystemState(system);

    }

    @Override
    public Object select(String projectId) throws Exception {

        Project returnProject = null;

        ArrayList<Project> list = getSystemState().getProjects();

        for (Project project : list) {
            if (projectId.equals(project.getId())) {
                returnProject = project;
            }
        }

        return returnProject;

    }

}
