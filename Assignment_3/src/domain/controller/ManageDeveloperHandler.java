package domain.controller;

import domain.Developer;

/**
 * @author umut - pc
 *
 */
public class ManageDeveloperHandler {

    private Developer developer;
    private static ManageDeveloperHandler instance = null;

    private ManageDeveloperHandler() {
        this.developer = new Developer();

    }

    public static ManageDeveloperHandler getInstance() {

        if (instance == null) {
            instance = new ManageDeveloperHandler();
        }
        return instance;
    }

    public String[][] getDevelopersFromFile(String managerId) throws Exception {
        return developer.getDevelopersFromFile(managerId);
    }

    public String[] getDeveloperTableFieldNames() throws Exception {

        return developer.getFieldNames();

    }

    public void deleteDeveloper(String developerId) throws Exception {
        developer.deleteDeveloper(developerId);

    }

    public void updateDeveloper(Developer developer) throws Exception {
        developer.updateDeveloper(developer);

    }

    public void saveDeveloper(Developer developer) throws Exception {
        developer.saveDeveloper(developer);

    }

    public Developer getDeveloper(String developerId) throws Exception {
        return developer.getDeveloperFromFile(developerId);

    }

}
