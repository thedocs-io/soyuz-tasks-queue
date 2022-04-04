package io.thedocs.soyuz.tasksQueue.domain;

import io.thedocs.soyuz.to;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * Created by fbelov on 09.02.16.
 */
@EqualsAndHashCode
@Getter
public class Task {

    private int id;
    private int priority;
    private String type;
    private Status status;
    private Date postedOn;
    private Date queuedOn;
    private String context;

    public Task(int id, int priority, String type, Date postedOn, Date queuedOn, Status status, String context) {
        this.id = id;
        this.priority = priority;
        this.type = type;
        this.postedOn = postedOn;
        this.queuedOn = queuedOn;
        this.status = status;
        this.context = context;
    }

    public boolean hasBeenQueued() {
        return queuedOn != null;
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
