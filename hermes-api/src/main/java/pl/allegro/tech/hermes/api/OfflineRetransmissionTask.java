package pl.allegro.tech.hermes.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.Instant;
import pl.allegro.tech.hermes.api.jackson.InstantIsoDeserializer;
import pl.allegro.tech.hermes.api.jackson.InstantIsoSerializer;

public class OfflineRetransmissionTask {
    private final String taskId;
    private final OfflineRetransmissionRequest request;
    private final Instant createdAt;

    @JsonCreator
    public OfflineRetransmissionTask(
            @JsonProperty("taskId") String taskId,
            @JsonProperty("sourceTopic") String sourceTopic,
            @JsonProperty("targetTopic") String targetTopic,
            @JsonProperty("startTimestamp") @JsonDeserialize(using = InstantIsoDeserializer.class) Instant startTimestamp,
            @JsonProperty("endTimestamp") @JsonDeserialize(using = InstantIsoDeserializer.class) Instant endTimestamp) {
        this(taskId, new OfflineRetransmissionRequest(sourceTopic, targetTopic, startTimestamp, endTimestamp));
    }

    public OfflineRetransmissionTask(String taskId, OfflineRetransmissionRequest request) {
        this.taskId = taskId;
        this.request = request;
        this.createdAt = Instant.now();
    }

    public String getTaskId() {
        return taskId;
    }

    public String getSourceTopic() {
        return request.getSourceTopic();
    }

    public String getTargetTopic() {
        return request.getTargetTopic();
    }

    @JsonSerialize(using = InstantIsoSerializer.class)
    public Instant getStartTimestamp() {
        return request.getStartTimestamp();
    }

    @JsonSerialize(using = InstantIsoSerializer.class)
    public Instant getEndTimestamp() {
        return request.getEndTimestamp();
    }

    @JsonSerialize(using = InstantIsoSerializer.class)
    public Instant getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public OfflineRetransmissionRequest getRequest() {
        return request;
    }

    @Override
    public String toString() {
        return "OfflineRetransmissionTask{" +
                "taskId='" + taskId + '\'' +
                ", request=" + request +
                '}';
    }
}
