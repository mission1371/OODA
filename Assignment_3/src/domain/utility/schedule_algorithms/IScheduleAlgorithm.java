package domain.utility.schedule_algorithms;

import java.util.List;

import domain.Project;
import domain.WorkItem;

/**
 * @author umut.taherzadeh
 *
 */
public interface IScheduleAlgorithm {

    void scheduleAlgorithm(Project project, List<WorkItem> items);
}
