package io.thedocs.soyuz.tasksQueue.event;

import io.thedocs.soyuz.tasksQueue.TasksQueueBusEventI;

/**
 * Created by fbelov on 14.10.16.
 */
public class TasksQueueStoppedEvent implements TasksQueueBusEventI {
    private String queueName;

    public TasksQueueStoppedEvent(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }
}
