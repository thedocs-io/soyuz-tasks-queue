package io.thedocs.soyuz.tasksQueue.selector;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by fbelov on 10.02.16.
 */
public class TasksQueueSelectorQueuedOlderThan implements TasksQueueSelectorI {

    private int olderThanInMinutes;

    public TasksQueueSelectorQueuedOlderThan(int olderThanInMinutes) {
        this.olderThanInMinutes = olderThanInMinutes;
    }

    @Override
    public TaskQueue select(List<TaskQueue> tasks) {
        ZonedDateTime olderThan = ZonedDateTime.now().minusMinutes(olderThanInMinutes);

        return tasks
                .stream()
                .filter(t -> filter(t, olderThan))
                .findFirst()
                .orElse(null);
    }

    private boolean filter(TaskQueue task, ZonedDateTime olderThan) {
        return !task.hasBeenQueued() || task.getQueuedAt().isBefore(olderThan);
    }
}
