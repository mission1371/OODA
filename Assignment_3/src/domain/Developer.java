package domain;

import java.math.BigDecimal;

import domain.store.ADataManagerFactory;
import domain.store.IDataManager;

/**
 * @author umut - pc
 *
 */
public class Developer extends AUser {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private static final String DEV_SALARY = "7000.0";

    private String projectId;
    private IDataManager store;

    public Developer() {
        this.setSalary(new BigDecimal(DEV_SALARY));
        this.store = (IDataManager) ADataManagerFactory.getDataManager(this.getClass().getSimpleName());
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public int getFieldCount() {
        return getFieldNames().length;
    }

    public String[] getFieldNames() {
        return new String[] { "Name", "Last Name", "Title", "Project Id", "Id" };
    }

    public String[][] getDevelopersFromFile(String managerId) throws Exception {

        return store.getObjectsFromFile(managerId);
    }

    public void saveDeveloper(Developer developer) throws Exception {

        store.save(developer);
    }

    public void updateDeveloper(Developer developer) throws Exception {

        store.update(developer);
    }

    public void deleteDeveloper(String developerId) throws Exception {

        store.delete(developerId);
    }

    public Developer getDeveloperFromFile(String developerId) throws Exception {

        return (Developer) store.select(developerId);
    }
}
