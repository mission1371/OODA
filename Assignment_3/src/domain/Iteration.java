package domain;

import java.io.Serializable;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;

/**
 * @author umut - pc
 *
 */
public class Iteration implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private String objectives;
    private String evaluationCriteria;
    private String phaseId;
    private EnumIterationStatus status;

    private IDataManager store;

    public Iteration() {
        this.store = (IDataManager) ADataManagerFactory.getDataManager(this.getClass().getSimpleName());
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

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    public EnumIterationStatus getStatus() {
        return status;
    }

    public void setStatus(EnumIterationStatus status) {
        this.status = status;
    }

    public String[] getFieldNames() {
        return new String[] { "Name", "Objectives", "Evaluation Criteria", "Status", "Phase Id", "Id" };
    }

    public String[][] getIterationsFromFile(String phaseId) throws Exception {

        return store.getObjectsFromFile(phaseId);

    }

    public void saveIteration(Iteration iteration) throws Exception {

        store.save(iteration);

    }

    public void updateIteration(Iteration iteration) throws Exception {

        store.update(iteration);

    }

    public void deleteIteration(String iterationId) throws Exception {

        store.delete(iterationId);

    }

    public Iteration getIterationFromFile(String iterationId) throws Exception {

        return (Iteration) store.select(iterationId);
    }

}
