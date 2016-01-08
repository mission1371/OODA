package domain.controller;

import domain.Phase;

/**
 * @author umut - pc
 *
 */
public class ManagePhaseHandler {

    private Phase phase;
    private static ManagePhaseHandler instance = null;

    private ManagePhaseHandler() {
        this.phase = new Phase();

    }

    public static ManagePhaseHandler getInstance() {

        if (instance == null) {
            instance = new ManagePhaseHandler();
        }
        return instance;
    }

    public String[][] getPhasesFromFile(String projectId) throws Exception {
        return phase.getPhasesFromFile(projectId);

    }

    public String[] getPhaseTableFieldNames() throws Exception {
        return phase.getFieldNames();

    }

    public void deletePhase(String phaseId) throws Exception {
        phase.deletePhase(phaseId);

    }

    public void updatePhase(Phase phase) throws Exception {
        this.phase.updatePhase(phase);

    }

    public void savePhase(Phase phase) throws Exception {
        this.phase.savePhase(phase);

    }

    public Phase getPhase(String phaseId) throws Exception {
        return phase.getPhaseFromFile(phaseId);

    }

}
