package io.thedocs.soyuz.tasksQueue.listener;

import io.thedocs.soyuz.tasksQueue.TasksQueueProcessorI;
import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by fbelov on 09.02.16.
 */
public interface TasksQueueProcessListenerI<T> {

    void on(TaskQueue task, T executionContext, AtomicReference<TasksQueueProcessorI.Result> result);
    void onException(TaskQueue task, T executionContext, Throwable e);

    interface Start {
        void onStart(TaskQueue task);
    }

    interface Finally<T> {
        void onFinally(TaskQueue task, T executionContext);
    }

    interface AfterTransaction<T> {
        void onAfterTransaction(TaskQueue task, T executionContext, AtomicReference<TasksQueueProcessorI.Result> result);
    }
}
