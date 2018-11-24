package domain.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import domain.Developer;
import domain.Iteration;
import domain.Phase;
import domain.Project;
import domain.ProjectManagementSystem;
import domain.WorkItem;

/**
 * @author umut - pc
 *
 */
public abstract class ADataManagerFactory implements IDataManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SYSTEM_FILE = "system.txt";
	private static final String PROPERTIES_FILE = "properties";

	public static void saveSystemState(ProjectManagementSystem system) throws FileNotFoundException, IOException {

		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SYSTEM_FILE));

		try {
			stream.writeObject(system);
		} finally {
			stream.close();
		}

	}

	public static ProjectManagementSystem getSystemState() throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SYSTEM_FILE));

		ProjectManagementSystem system;
		try {
			// stream.available();
			system = (ProjectManagementSystem) stream.readObject();
		} finally {
			stream.close();
		}

		return system;

	}

	public static void saveSystemProperties() {

		try {

			String strategy = "scheduling_algorithm : domain.utility.schedule_algorithms.SomeAlgorithm";

			File file = new File(PROPERTIES_FILE);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(strategy);
			bw.close();

			System.out.println("properties file created");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IDataManager getDataManager(String store) {

		IDataManager manager = null;
		if (Developer.class.getSimpleName().trim().toUpperCase().equals(store.trim().toUpperCase())) {
			manager = DeveloperDataManager.getInstance();

		} else if (Iteration.class.getSimpleName().trim().toUpperCase().equals(store.trim().toUpperCase())) {
			manager = IterationDataManager.getInstance();

		} else if (Phase.class.getSimpleName().trim().toUpperCase().equals(store.trim().toUpperCase())) {
			manager = PhaseDataManager.getInstance();

		} else if (Project.class.getSimpleName().trim().toUpperCase().equals(store.trim().toUpperCase())) {
			manager = ProjectDataManager.getInstance();

		} else if (WorkItem.class.getSimpleName().trim().toUpperCase().equals(store.trim().toUpperCase())) {
			manager = WorkItemDataManager.getInstance();

		}
		return manager;
	}

}
