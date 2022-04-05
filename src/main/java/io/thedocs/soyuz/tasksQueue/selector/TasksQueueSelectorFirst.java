package io.thedocs.soyuz.tasksQueue.selector;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import javax.annotation.Nullable;
import java.util.List;

public class TasksQueueSelectorFirst implements TasksQueueSelectorI {

    @Nullable
    @Override
    public TaskQueue select(List<TaskQueue> tasks) {
        return tasks.stream().findFirst().orElse(null);
    }
}
