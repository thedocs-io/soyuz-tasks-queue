package io.thedocs.soyuz.tasksQueue.transaction;

public interface TasksQueueTransactionCallbackI<T> {

    T doInTransaction();

}
