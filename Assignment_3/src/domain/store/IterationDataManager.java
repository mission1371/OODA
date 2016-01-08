package domain.store;

import java.util.ArrayList;

import domain.Iteration;
import domain.Phase;
import domain.Project;
import domain.ProjectManagementSystem;

/**
 * @author umut - pc
 *
 */
public class IterationDataManager extends ADataManagerFactory {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static IterationDataManager instance = null;

    private IterationDataManager() {
        // to prevent new instance
    }

    public static IterationDataManager getInstance() {
        if (instance == null) {
            instance = new IterationDataManager();
        }
        return instance;
    }

    @Override
    public String[][] getObjectsFromFile(String phaseId) throws Exception {

        String[][] returnArr = null;

        ArrayList<Project> projects = getSystemState().getProjects();

        if (projects != null && !projects.isEmpty()) {

            for (Project project : projects) {

                ArrayList<Phase> phases = project.getProjectPlan().getPhases();

                for (Phase phase : phases) {
                    if (phase.getId().equals(phaseId)) {

                        ArrayList<Iteration> iterations = phase.getIterations();
                        // TODO implement reflection
                        returnArr = new String[iterations.size()][Iteration.class.getDeclaredFields().length];

                        int i = 0;

                        for (Iteration iteration : iterations) {

                            returnArr[i][0] = iteration.getName();
                            returnArr[i][1] = iteration.getObjectives();
                            returnArr[i][2] = iteration.getEvaluationCriteria();
                            returnArr[i][3] = iteration.getStatus().getText();
                            returnArr[i][4] = iteration.getPhaseId();
                            returnArr[i][5] = iteration.getId();

                            i++;

                        }
                    }
                }

            }
        } else {
            returnArr = new String[0][0];
        }

        return returnArr;
    }

    @Override
    public void update(Object iteration) throws Exception {

        ProjectManagementSystem system = getSystemState();

        ArrayList<Project> projects = getSystemState().getProjects();

        for (Project project : projects) {

            ArrayList<Phase> phases = project.getProjectPlan().getPhases();

            for (Phase phase : phases) {

                ArrayList<Iteration> iterations = phase.getIterations();

                for (Iteration dbIteration : iterations)

                    if (dbIteration.getId().equals(((Iteration) iteration).getId())) {

                        iterations.remove(dbIteration);
                        iterations.add((Iteration) iteration);
                        break;
                    }
            }

        }
        saveSystemState(system);

    }

    @Override
    public void delete(String iterationId) throws Exception {

        ProjectManagementSystem system = getSystemState();

        ArrayList<Project> list = getSystemState().getProjects();

        for (Project project : list) {

            ArrayList<Phase> phases = project.getProjectPlan().getPhases();

            for (Phase phase : phases) {

                ArrayList<Iteration> iterations = phase.getIterations();

                for (Iteration iteration : iterations) {

                    if (iterationId.equals(iteration.getId())) {

                        iterations.remove(iteration);
                        break;
                    }
                }

            }

        }

        saveSystemState(system);

    }

    @Override
    public void save(Object iteration) throws Exception {

        ProjectManagementSystem system = getSystemState();
        String phaseId = ((Iteration) iteration).getPhaseId();
        ArrayList<Project> projects = system.getProjects();

        for (Project project : projects) {

            ArrayList<Phase> phases = project.getProjectPlan().getPhases();

            for (Phase phase : phases) {

                if (phaseId.equals(phase.getId())) {
                    phase.getIterations().add((Iteration) iteration);
                    break;
                }
            }

        }
        saveSystemState(system);

    }

    @Override
    public Object select(String iterationId) throws Exception {

        Iteration returnIteration = null;

        ArrayList<Project> list = getSystemState().getProjects();

        for (Project project : list) {
            for (Phase phase : project.getProjectPlan().getPhases()) {
                for (Iteration iteration : phase.getIterations()) {
                    if (iterationId.equals(iteration.getId())) {
                        returnIteration = iteration;
                    }
                }
            }
        }

        return returnIteration;

    }
}
