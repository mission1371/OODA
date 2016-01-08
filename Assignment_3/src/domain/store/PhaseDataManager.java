package domain.store;

import java.util.ArrayList;

import domain.Phase;
import domain.Project;
import domain.ProjectManagementSystem;

/**
 * @author umut - pc
 *
 */
public class PhaseDataManager extends ADataManagerFactory {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static PhaseDataManager instance = null;

    private PhaseDataManager() {
        // to prevent new instance
    }

    public static PhaseDataManager getInstance() {
        if (instance == null) {
            instance = new PhaseDataManager();
        }
        return instance;
    }

    @Override
    public String[][] getObjectsFromFile(String projectId) throws Exception {

        String[][] returnArr = null;

        ArrayList<Project> projects = getSystemState().getProjects();

        if (projects != null && !projects.isEmpty()) {

            for (Project project : projects) {

                if (project.getId().equals(projectId)) {

                    ArrayList<Phase> phases = project.getProjectPlan().getPhases();
                    // TODO implement reflection

                    returnArr = new String[phases.size()][Phase.class.getDeclaredFields().length];

                    int i = 0;

                    for (Phase phase : phases) {

                        returnArr[i][0] = phase.getName();
                        returnArr[i][1] = phase.getDescription();
                        returnArr[i][2] = phase.getPlannedStartDate();
                        returnArr[i][3] = phase.getCompletionDate();
                        returnArr[i][4] = phase.getProjectId();
                        returnArr[i][5] = phase.getId();

                        i++;

                    }

                }
            }
        } else {
            returnArr = new String[0][0];
        }

        return returnArr;
    }

    @Override
    public void update(Object phase) throws Exception {

        ProjectManagementSystem system = getSystemState();

        ArrayList<Project> projects = getSystemState().getProjects();

        for (Project project : projects) {

            ArrayList<Phase> phases = project.getProjectPlan().getPhases();

            for (Phase dbPhase : phases) {

                if (dbPhase.getId().equals(((Phase) phase).getId())) {

                    phases.remove(dbPhase);
                    phases.add((Phase) phase);
                    break;
                }
            }

        }
        saveSystemState(system);

    }

    @Override
    public void delete(String phaseId) throws Exception {

        ProjectManagementSystem system = getSystemState();

        ArrayList<Project> list = getSystemState().getProjects();

        for (Project project : list) {

            ArrayList<Phase> phases = project.getProjectPlan().getPhases();

            for (Phase phase : phases) {

                if (phaseId.equals(phase.getId())) {

                    phases.remove(phase);
                    break;
                }
            }

        }

        saveSystemState(system);

    }

    @Override
    public void save(Object phase) throws Exception {

        ProjectManagementSystem system = getSystemState();
        String projectId = ((Phase) phase).getProjectId();

        for (Project project : system.getProjects()) {

            if (projectId.equals(project.getId())) {
                project.getProjectPlan().getPhases().add((Phase) phase);
                break;
            }

        }
        saveSystemState(system);

    }

    @Override
    public Object select(String phaseId) throws Exception {

        Phase returnPhase = null;

        ArrayList<Project> list = getSystemState().getProjects();

        for (Project project : list) {
            for (Phase phase : project.getProjectPlan().getPhases()) {

                if (phaseId.equals(phase.getId())) {
                    returnPhase = phase;
                }
            }

        }

        return returnPhase;

    }

}
