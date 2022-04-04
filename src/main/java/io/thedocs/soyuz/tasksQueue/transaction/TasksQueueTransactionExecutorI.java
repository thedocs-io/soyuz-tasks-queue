package io.thedocs.soyuz.tasksQueue.transaction;

public interface TasksQueueTransactionExecutorI {

    public <T> T execute(TasksQueueTransactionCallbackI<T> action);

}
