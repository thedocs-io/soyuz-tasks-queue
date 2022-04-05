package io.thedocs.soyuz.tasksQueue.listener;

import io.thedocs.soyuz.log.LoggerEvents;
import io.thedocs.soyuz.tasksQueue.TasksQueueProcessorI;
import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;
import io.thedocs.soyuz.to;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Retries task on failure N times
 */
public class TasksQueueProcessListenerStopOnTooManyIterations implements TasksQueueProcessListenerI<Object> {

    private static final LoggerEvents loge = LoggerEvents.getInstance(TasksQueueProcessListenerStopOnTooManyIterations.class);

    private int maxIterationsCount;
    private IterationsCountProvider iterationsCountProvider;

    public TasksQueueProcessListenerStopOnTooManyIterations(int maxIterationsCount, IterationsCountProvider iterationsCountProvider) {
        this.maxIterationsCount = maxIterationsCount;
        this.iterationsCountProvider = iterationsCountProvider;
    }

    @Override
    public void on(TaskQueue task, Object context, AtomicReference<TasksQueueProcessorI.Result> result) {
        if (result.get() == TasksQueueProcessorI.Result.FAILURE && maxIterationsCount > 0) {
            int taskIterationsCount = iterationsCountProvider.getIterationsCount(task.getId());

            if (taskIterationsCount <= maxIterationsCount) {
                loge.info("queue.task.repeat", to.map("t", task, "iterationsTask", taskIterationsCount, "iterationsMax", maxIterationsCount));

                result.set(TasksQueueProcessorI.Result.REPEAT_NOW);
            }
        }
    }

    @Override
    public void onException(TaskQueue task, Object context, Throwable e) {
    }

    public interface IterationsCountProvider {

        int getIterationsCount(int taskId);

    }
}
