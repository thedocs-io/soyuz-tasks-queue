package io.thedocs.soyuz.tasksQueue;

import io.thedocs.soyuz.tasksQueue.domain.Task;

/**
 * Created by fbelov on 09.02.16.
 */
public interface TasksQueueProcessorI<T> {

    Result process(Task task, T executionContext);

    enum Result {
        SUCCESS, FAILURE, SKIP, REPEAT, REPEAT_NOW, EXCEPTION;
    }

}
