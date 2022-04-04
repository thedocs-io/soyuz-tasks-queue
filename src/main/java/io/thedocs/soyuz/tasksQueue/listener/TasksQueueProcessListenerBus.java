package io.thedocs.soyuz.tasksQueue.listener;

import io.thedocs.soyuz.tasksQueue.TasksQueueBusI;
import io.thedocs.soyuz.tasksQueue.TasksQueueProcessorI;
import io.thedocs.soyuz.tasksQueue.domain.Task;
import io.thedocs.soyuz.tasksQueue.event.TasksQueueResultEvent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by fbelov on 10.02.16.
 */
public class TasksQueueProcessListenerBus implements TasksQueueProcessListenerI<Object> {

    private TasksQueueBusI bus;
    private String queueName;

    public TasksQueueProcessListenerBus(TasksQueueBusI bus) {
        this(bus, null);
    }

    public TasksQueueProcessListenerBus(TasksQueueBusI bus, String queueName) {
        this.queueName = queueName;
        this.bus = bus;
    }

    @Override
    public void on(Task task, Object executionContext, AtomicReference<TasksQueueProcessorI.Result> result) {
        bus.post(new TasksQueueResultEvent(queueName, task, executionContext, result.get()));
    }

    @Override
    public void onException(Task task, Object executionContext, Throwable e) {
        bus.post(new TasksQueueResultEvent(queueName, task, executionContext, TasksQueueProcessorI.Result.EXCEPTION, e));
    }

}
