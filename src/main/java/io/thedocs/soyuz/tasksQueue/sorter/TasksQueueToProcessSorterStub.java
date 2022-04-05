package io.thedocs.soyuz.tasksQueue.sorter;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import java.util.List;

public class TasksQueueToProcessSorterStub implements TasksQueueToProcessSorterI {
    @Override
    public List<TaskQueue> sort(List<TaskQueue> tasks) {
        return tasks;
    }
}
