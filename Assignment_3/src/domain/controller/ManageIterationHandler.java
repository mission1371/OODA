package domain.controller;

import domain.EnumIterationStatus;
import domain.Iteration;

/**
 * @author umut - pc
 *
 */
public class ManageIterationHandler {

    private Iteration iteration;
    private static ManageIterationHandler instance = null;

    private ManageIterationHandler() {
        this.iteration = new Iteration();

    }

    public static ManageIterationHandler getInstance() {

        if (instance == null) {
            instance = new ManageIterationHandler();
        }
        return instance;
    }

    public String[][] getIterationsFromFile(String phaseId) throws Exception {
        return iteration.getIterationsFromFile(phaseId);

    }

    public String[] getIterationTableFieldNames() throws Exception {
        return iteration.getFieldNames();

    }

    public void deleteIteration(String iterationId) throws Exception {
        iteration.deleteIteration(iterationId);

    }

    public void updateIteration(Iteration iteration) throws Exception {
        this.iteration.updateIteration(iteration);

    }

    public void saveIteration(Iteration iteration) throws Exception {
        this.iteration.saveIteration(iteration);

    }

    public Iteration getIteration(String iterationId) throws Exception {
        return iteration.getIterationFromFile(iterationId);

    }

    public String[] getStatusLabels() {
        return EnumIterationStatus.getTextLabels();
    }

}
