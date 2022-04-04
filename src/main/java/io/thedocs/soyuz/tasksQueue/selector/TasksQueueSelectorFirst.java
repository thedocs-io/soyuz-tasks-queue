package io.thedocs.soyuz.tasksQueue.selector;

import io.thedocs.soyuz.tasksQueue.domain.Task;

import javax.annotation.Nullable;
import java.util.List;

public class TasksQueueSelectorFirst implements TasksQueueSelectorI {

    @Nullable
    @Override
    public Task select(List<Task> tasks) {
        return tasks.stream().findFirst().orElse(null);
    }
}
