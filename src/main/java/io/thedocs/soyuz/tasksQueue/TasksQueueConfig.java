package io.thedocs.soyuz.tasksQueue;

import javax.annotation.Nullable;

/**
 * Created by fbelov on 10.02.16.
 */
public class TasksQueueConfig {

    private int delayOverflow;
    private int delayOnEmpty;
    private int delayOnException;
    private int delayOnTask;
    private int delayBeforeInterruptingWorkerThread;
    private int maxTasksToProcessAtTheSameTime;
    private boolean startOnCreation;
    private boolean doNotUseTransactionOnProcessing;

    private String taskType;
    private String queueName;

    public TasksQueueConfig(int delayBeforeInterruptingWorkerThread, int delayOnEmpty, int delayOnTask, int delayOverflow, int delayOnException, int maxTasksToProcessAtTheSameTime, boolean startOnCreation, boolean doNotUseTransactionOnProcessing) {
        this.delayBeforeInterruptingWorkerThread = delayBeforeInterruptingWorkerThread;
        this.delayOnEmpty = delayOnEmpty;
        this.delayOnTask = delayOnTask;
        this.delayOverflow = delayOverflow;
        this.delayOnException = delayOnException;
        this.maxTasksToProcessAtTheSameTime = maxTasksToProcessAtTheSameTime;
        this.startOnCreation = startOnCreation;
        this.doNotUseTransactionOnProcessing = doNotUseTransactionOnProcessing;
    }

    public boolean hasQueueName() {
        return queueName != null;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public boolean isTaskTypeSet() {
        return taskType != null && !taskType.equals("");
    }

    public int getDelayOnEmpty() {
        return delayOnEmpty;
    }

    public int getDelayOnTask() {
        return delayOnTask;
    }

    public int getDelayOverflow() {
        return delayOverflow;
    }

    public int getDelayOnException() {
        return delayOnException;
    }

    public int getDelayBeforeInterruptingWorkerThread() {
        return delayBeforeInterruptingWorkerThread;
    }

    public int getMaxTasksToProcessAtTheSameTime() {
        return maxTasksToProcessAtTheSameTime;
    }

    public boolean isStartOnCreation() {
        return startOnCreation;
    }

    public boolean isDoNotUseTransactionOnProcessing() {
        return doNotUseTransactionOnProcessing;
    }

    @Nullable
    public String getTaskType() {
        return taskType;
    }
}
