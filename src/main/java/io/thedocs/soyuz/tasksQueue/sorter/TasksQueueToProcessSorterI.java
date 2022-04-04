package io.thedocs.soyuz.tasksQueue.sorter;

import io.thedocs.soyuz.tasksQueue.domain.Task;

import java.util.List;

/**
 * Created by fbelov on 18.03.16.
 */
public interface TasksQueueToProcessSorterI {

    List<Task> sort(List<Task> tasks);

}
