package io.thedocs.soyuz.tasksQueue.listener;

import io.thedocs.soyuz.tasksQueue.TasksQueueProcessorI;
import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import java.util.concurrent.atomic.AtomicReference;

public class TasksQueueProcessListenerDelay implements TasksQueueProcessListenerI<Object> {

    private long delayInMillis;

    @Override
    public void on(TaskQueue task, Object context, AtomicReference<TasksQueueProcessorI.Result> result) {
        doDelay();
    }

    @Override
    public void onException(TaskQueue task, Object context, Throwable e) {
        doDelay();
    }

    private void doDelay() {
        try {
            Thread.sleep(delayInMillis);
        } catch (InterruptedException e) {

        }
    }

}
