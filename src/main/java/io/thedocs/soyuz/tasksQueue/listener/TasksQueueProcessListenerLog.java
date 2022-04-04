package io.thedocs.soyuz.tasksQueue.listener;

import io.thedocs.soyuz.log.LoggerEvents;
import io.thedocs.soyuz.tasksQueue.TasksQueueProcessorI;
import io.thedocs.soyuz.tasksQueue.domain.Task;
import io.thedocs.soyuz.to;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by fbelov on 10.02.16.
 */
public class TasksQueueProcessListenerLog implements TasksQueueProcessListenerI<Object> {

    private static final LoggerEvents loge = LoggerEvents.getInstance(TasksQueueProcessListenerLog.class);

    @Override
    public void on(Task task, Object executionContext, AtomicReference<TasksQueueProcessorI.Result> result) {
        TasksQueueProcessorI.Result r = result.get();
        Map data = to.map("t", task.getId(), "r", result);
        String event = "tq.done";

        if (r == TasksQueueProcessorI.Result.SUCCESS) {
            loge.debug(event, data);
        } else if (r == TasksQueueProcessorI.Result.EXCEPTION) {
            loge.warn(event, data);
        } else {
            loge.info(event, data);
        }
    }

    @Override
    public void onException(Task task, Object executionContext, Throwable e) {
        loge.error("tq.done.exception", to.map("t", task.getId()), e);
    }

}
