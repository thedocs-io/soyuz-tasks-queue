DROP TABLE IF EXISTS "tasks_queue";

CREATE TYPE tasks_queue_status AS ENUM ('NEW', 'IN_PROGRESS', 'SUCCESS', 'FAILURE', 'EXCEPTION');

CREATE TABLE "tasks_queue"
(
    "id"               SERIAL PRIMARY KEY,
    "priority"         SMALLINT                 NOT NULL DEFAULT 10,
    "type"             VARCHAR(64)              NOT NULL,
    "concurrency_key"   VARCHAR(256)             NOT NULL,
    "status"           tasks_queue_status       NOT NULL,
    "posted_at"        TIMESTAMP WITH TIME ZONE NOT NULL,
    "queued_at"        TIMESTAMP WITH TIME ZONE,
    "status_at"        TIMESTAMP WITH TIME ZONE,
    "started_at"       TIMESTAMP WITH TIME ZONE,
    "finished_at"      TIMESTAMP WITH TIME ZONE,
    "iterations_count" INT                      NOT NULL,
    "server"           VARCHAR(64),
    "result"           TEXT,
    "context"          TEXT
);
