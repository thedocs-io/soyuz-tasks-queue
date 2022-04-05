package io.thedocs.soyuz.tasksQueue.domain;

import io.thedocs.soyuz.to;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.annotation.Nullable;
import java.time.ZonedDateTime;

/**
 * Created by fbelov on 09.02.16.
 */
@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class TaskQueue {

    private int id;
    private int priority;
    private String type;
    private Status status;
    private ZonedDateTime postedAt;
    private ZonedDateTime queuedAt;
    private ZonedDateTime statusAt;
    private ZonedDateTime startedAt;
    private ZonedDateTime finishedAt;
    private int iterationsCount;
    private String server;
    private String context;
    private String result;

    public boolean hasBeenQueued() {
        return queuedAt != null;
    }

    public enum Status {

        NEW, IN_PROGRESS, SUCCESS, FAILURE, EXCEPTION;

        @Nullable
        public static Status myValueOf(String key) {
            return to.stream(values()).filter(r -> r.toString().equalsIgnoreCase(key)).findFirst().orElse(null);
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }

}
