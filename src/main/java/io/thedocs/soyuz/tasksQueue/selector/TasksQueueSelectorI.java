package io.thedocs.soyuz.tasksQueue.selector;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by fbelov on 09.02.16.
 */
public interface TasksQueueSelectorI {

    @Nullable
    TaskQueue select(List<TaskQueue> tasks);

}
