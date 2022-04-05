package io.thedocs.soyuz.tasksQueue;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by fbelov on 10.03.16.
 */
public interface TasksQueueStorageI {

    List<TaskQueue> findAllToProcess(@Nullable String type);

    List<Integer> restartTasksMarkedAsInProcess(@Nullable String type, @Nullable String server);

    void markToRepeatNow(int taskId);

    void markAsQueuedAndSetStatus(int taskId, TaskQueue.Status status, @Nullable String server);

}
