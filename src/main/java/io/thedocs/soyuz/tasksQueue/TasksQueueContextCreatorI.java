package io.thedocs.soyuz.tasksQueue;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

/**
 * Created by fbelov on 18.02.16.
 */
public interface TasksQueueContextCreatorI<T> {

    T createContext(TaskQueue task);

}
