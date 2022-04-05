package io.thedocs.soyuz.tasksQueue.sorter;

import io.thedocs.soyuz.tasksQueue.domain.TaskQueue;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fbelov on 18.03.16.
 */
public class TasksQueueToProcessSorterByPriority implements TasksQueueToProcessSorterI {
    private static final Comparator<TaskQueue> comparator = new TasksComparator();

    @Override
    public List<TaskQueue> sort(List<TaskQueue> tasks) {
        return tasks.stream().sorted(comparator).collect(Collectors.toList());
    }

    private static class TasksComparator implements Comparator<TaskQueue> {

        @Override
        public int compare(TaskQueue b, TaskQueue a) {
            int sortDifference = getSortValue(a) - getSortValue(b);

            if (sortDifference != 0) {
                return sortDifference;
            } else {
                if (a.hasBeenQueued()) {
                    return b.getQueuedAt().compareTo(a.getQueuedAt());
                } else {
                    return b.getPostedAt().compareTo(a.getPostedAt());
                }
            }
        }

        private int getSortValue(TaskQueue task) {
            int answer = task.getPriority() * 100;

            if (!task.hasBeenQueued()) {
                answer += 10;
            }

            return answer;
        }
    }
}
