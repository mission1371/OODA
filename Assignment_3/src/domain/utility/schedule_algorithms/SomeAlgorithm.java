package domain.utility.schedule_algorithms;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import domain.WorkItem;
import domain.store.ADataManagerFactory;
import domain.store.IDataManager;
import domain.utility.DataUtility;

/**
 * @author umut.taherzadeh
 *
 */
public class SomeAlgorithm implements IScheduleAlgorithm {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private IDataManager store;

    public SomeAlgorithm() {

        this.store = (IDataManager) ADataManagerFactory.getDataManager(WorkItem.class.getSimpleName());
    }

    @Override
    public void scheduleAlgorithm(WorkItem item) throws Exception {

        LocalDateTime today = LocalDateTime.now();

        if (DataUtility.isEmpty(item.getPredecessor(), false)) {

            item.setPlannedStartDate(arrangeDate(today));
            item.setCompletionDate(arrangeDate(today.plusDays(4L)));

        } else {

            Date startDate = new Date();

            String[] arr = item.getPredecessor().split("-");

            for (String itemId : arr) {

                WorkItem preItem = (WorkItem) store.select(itemId);
                Date compDate = new SimpleDateFormat("dd/MM/yyyy").parse(preItem.getCompletionDate());

                if (compDate.after(startDate)) {
                    startDate = compDate;
                }

            }

            LocalDateTime start = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());

            item.setPlannedStartDate(arrangeDate(start));
            item.setCompletionDate(arrangeDate(start.plusDays(4L)));

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

    // public static void main(String[] args) throws Exception {
    // SomeAlgorithm asd = new SomeAlgorithm();
    //
    // asd.scheduleAlgorithm(new Project(), new WorkItem());
    // }

    /*
     * 
     * Date in = new Date(); LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault()); Date out =
     * Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
     */
}
