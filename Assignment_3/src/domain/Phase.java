package domain;

import java.io.Serializable;
import java.util.ArrayList;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;

/**
 * @author umut - pc
 *
 */
// TODO abstract entity yarat
public class Phase implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private ArrayList<Iteration> iterations;

    private String name;
    private String id;
    private String description;
    private String plannedStartDate;
    private String completionDate;
    private String projectId;

    private IDataManager store;

    public Phase() {
        this.store = (IDataManager) ADataManagerFactory.getDataManager(this.getClass().getSimpleName());
        this.iterations = new ArrayList<Iteration>();
    }

    public ArrayList<Iteration> getIterations() {

        if (iterations == null) {
            System.out.println("iterations are null in the phase, new iterations initiated");
            iterations = new ArrayList<Iteration>();
        }
        return iterations;
    }

    public void setIterations(ArrayList<Iteration> iterations) {
        this.iterations = iterations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String[] getFieldNames() {
        return new String[] { "Name", "Description", "Start Date", "End Date", "Project Id", "Id" };
    }

    public String[][] getPhasesFromFile(String projectId) throws Exception {

        return store.getObjectsFromFile(projectId);

    }

    public void savePhase(Phase phase) throws Exception {

        store.save(phase);

    }

    public void updatePhase(Phase phase) throws Exception {

        store.update(phase);

    }

    public void deletePhase(String phaseId) throws Exception {

        store.delete(phaseId);

    }

    public Phase getPhaseFromFile(String phaseId) throws Exception {

        return (Phase) store.select(phaseId);
    }

}
