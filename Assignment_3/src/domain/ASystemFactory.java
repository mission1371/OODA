package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import domain.utility.schedule_algorithms.IScheduleAlgorithm;

/**
 * @author umut.taherzadeh
 *
 */
public class ASystemFactory {

    private static ASystemFactory instance = null;
    private static final String PROPERTIES_FILE = "properties";
    private static final String SCHEDULING_ALGORITHM_KEY = "scheduling_algorithm";

    private ASystemFactory() {
        // prevent public creation
    }

    public static ASystemFactory getInstance() {

        if (instance == null) {
            instance = new ASystemFactory();
        }

        return instance;
    }

    public static IScheduleAlgorithm getScheduleAlgorithm() {

        IScheduleAlgorithm algo = null;

        try {
            String clazz = "";

            try (BufferedReader br = new BufferedReader(new FileReader(PROPERTIES_FILE))) {

                String sCurrentLine;

                while ((sCurrentLine = br.readLine()) != null) {

                    if (sCurrentLine.contains(SCHEDULING_ALGORITHM_KEY)) {

                        String[] arr = sCurrentLine.split("\\:");
                        clazz = arr[arr.length - 1].trim();
                        break;
                    }
                }

            } catch (IOException e) {
                throw new Exception("Properties file is missing");
            }

            algo = (IScheduleAlgorithm) Class.forName(clazz).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return algo;
    }

}
