package domain.store;

import java.util.ArrayList;

import domain.Developer;
import domain.ProjectManagementSystem;

/**
 * @author umut - pc
 *
 */
public class DeveloperDataManager extends ADataManagerFactory {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static DeveloperDataManager instance = null;

    private DeveloperDataManager() {
        // to prevent new instance
    }

    public static DeveloperDataManager getInstance() {
        if (instance == null) {
            instance = new DeveloperDataManager();
        }
        return instance;
    }

    @Override
    public String[][] getObjectsFromFile(String managerId) throws Exception {
        String[][] returnArr = null;

        ArrayList<Developer> developers = getSystemState().getDevelopers();

        if (developers != null && !developers.isEmpty()) {
            returnArr = new String[developers.size()][(new Developer()).getFieldCount()];

            int i = 0;
            for (Developer developer : developers) {

                // TODO implement reflection

                returnArr[i][0] = developer.getName();
                returnArr[i][1] = developer.getLastName();
                returnArr[i][2] = developer.getTitle();
                returnArr[i][3] = developer.getProjectId();
                returnArr[i][4] = developer.getId();

                i++;
            }
        } else {
            returnArr = new String[0][0];
        }

        return returnArr;
    }

    @Override
    public void update(Object developer) throws Exception {

        ProjectManagementSystem system = getSystemState();

        for (Developer dbDeveloper : system.getDevelopers()) {
            if (((Developer) developer).getId().equals(dbDeveloper.getId())) {

                system.getDevelopers().remove(dbDeveloper);
                system.getDevelopers().add((Developer) developer);
                break;
            }
        }
        saveSystemState(system);

    }

    @Override
    public void delete(String developerId) throws Exception {

        ProjectManagementSystem system = getSystemState();

        for (Developer developer : system.getDevelopers()) {
            if (developerId.equals(developer.getId())) {

                system.getDevelopers().remove(developer);
                break;
            }
        }

        saveSystemState(system);

    }

    @Override
    public void save(Object developer) throws Exception {

        ProjectManagementSystem system = getSystemState();

        system.getDevelopers().add((Developer) developer);

        saveSystemState(system);

    }

    @Override
    public Object select(String developerId) throws Exception {

        Developer returnDeveloper = null;

        ArrayList<Developer> list = getSystemState().getDevelopers();

        for (Developer developer : list) {
            if (developerId.equals(developer.getId())) {
                returnDeveloper = developer;
            }
        }
        return returnDeveloper;
    }

}
