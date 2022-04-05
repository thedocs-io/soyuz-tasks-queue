package io.thedocs.soyuz.tasksQueue.transaction;

public class TasksQueueTransactionExecutorStub implements TasksQueueTransactionExecutorI {

    @Override
    public <T> T execute(TasksQueueTransactionCallbackI<T> action) {
        return action.doInTransaction();
    }

}
