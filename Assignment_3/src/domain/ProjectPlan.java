package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author umut - pc
 *
 */
public class ProjectPlan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Phase> phases;
	private String projectId;

	
	public ProjectPlan() {
		this.phases = new ArrayList<Phase>();
	}

	public ArrayList<Phase> getPhases() {
		
		if (phases == null) {
            System.out.println("phases are null in the project, new phases initiated");
            phases = new ArrayList<Phase>();
        }
		return phases;
	}

	public void setPhases(ArrayList<Phase> phases) {
		this.phases = phases;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
