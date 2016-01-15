package domain.utility.schedule_algorithms;

import java.io.Serializable;

import domain.WorkItem;

/**
 * @author umut.taherzadeh
 *
 */
public interface IScheduleAlgorithm extends Serializable {

    void scheduleAlgorithm(WorkItem items) throws Exception;
}
