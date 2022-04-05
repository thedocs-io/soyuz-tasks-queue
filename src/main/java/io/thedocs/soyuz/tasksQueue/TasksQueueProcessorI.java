package io.thedocs.soyuz.tasksQueue;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

/**
 * Created by fbelov on 09.02.16.
 */
public interface TasksQueueProcessorI<T> {

    Result process(TaskQueue task, T executionContext);

    enum Result {
        SUCCESS, FAILURE, SKIP, REPEAT, REPEAT_NOW, EXCEPTION;
    }

}
