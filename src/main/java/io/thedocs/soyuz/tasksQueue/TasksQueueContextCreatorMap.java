package io.thedocs.soyuz.tasksQueue;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fbelov on 18.02.16.
 */
public class TasksQueueContextCreatorMap implements TasksQueueContextCreatorI<Map> {

    @Override
    public Map createContext(TaskQueue task) {
        return new HashMap<>();
    }

}
