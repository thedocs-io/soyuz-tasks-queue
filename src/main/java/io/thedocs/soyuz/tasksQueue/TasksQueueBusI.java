package io.thedocs.soyuz.tasksQueue;

public interface TasksQueueBusI {

    void post(TasksQueueBusEventI event);

}
