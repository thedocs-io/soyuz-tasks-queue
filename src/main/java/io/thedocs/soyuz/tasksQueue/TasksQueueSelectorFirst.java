package io.thedocs.soyuz.tasksQueue;

import io.thedocs.soyuz.tasksQueue.domain.Task;
import io.thedocs.soyuz.tasksQueue.selector.TasksQueueSelectorI;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by fbelov on 10.03.16.
 */
public class TasksQueueSelectorFirst implements TasksQueueSelectorI {

    @Nullable
    @Override
    public Task select(List<Task> tasks) {
        return tasks.stream().findFirst().orElse(null);
    }

}
