package domain.utility.schedule_algorithms;

import java.time.LocalDateTime;
import java.util.Date;

import domain.Project;
import domain.WorkItem;
import domain.store.ADataManagerFactory;
import domain.store.IDataManager;
import domain.utility.DataUtility;

/**
 * @author umut.taherzadeh
 *
 */
public class SomeAlgorithm {// implements IScheduleAlgorithm {

    private IDataManager store;

    public SomeAlgorithm() {

        this.store = (IDataManager) ADataManagerFactory.getDataManager(WorkItem.class.getSimpleName());
    }

    // TODO düzelt
    // @Override
    public void scheduleAlgorithm(Project project, WorkItem item) throws Exception {

        LocalDateTime today = LocalDateTime.now();

        if (DataUtility.isEmpty(item.getPredecessor(), false)) {

            item.setPlannedStartDate(arrangeDate(today));
            item.setCompletionDate(arrangeDate(today.plusDays(4L)));

        } else {

            
        }

    }

    private String arrangeDate(LocalDateTime date) {

        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        String s_day;
        String s_month;
        String s_year = "" + year;

        if (day < 10) {
            s_day = "0" + day;
        } else {
            s_day = "" + day;
        }
        if (month < 10) {
            s_month = "0" + month;
        } else {
            s_month = "" + month;

        }

        return s_day + "/" + s_month + "/" + s_year;
    }

    public static void main(String[] args) throws Exception {
        SomeAlgorithm asd = new SomeAlgorithm();

        asd.scheduleAlgorithm(new Project(), new WorkItem());
    }
}
