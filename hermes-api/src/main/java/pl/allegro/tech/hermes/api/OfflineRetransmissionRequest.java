package pl.allegro.tech.hermes.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.Instant;
import pl.allegro.tech.hermes.api.jackson.InstantIsoDeserializer;
import pl.allegro.tech.hermes.api.jackson.InstantIsoSerializer;

public class OfflineRetransmissionRequest {
    private final String sourceTopic;
    private final String targetTopic;
    private final Instant startTimestamp;
    private final Instant endTimestamp;

    @JsonCreator
    public OfflineRetransmissionRequest(
            @JsonProperty("sourceTopic") String sourceTopic,
            @JsonProperty("targetTopic") String targetTopic,
            @JsonProperty("startTimestamp") @JsonDeserialize(using = InstantIsoDeserializer.class) Instant startTimestamp,
            @JsonProperty("endTimestamp") @JsonDeserialize(using = InstantIsoDeserializer.class) Instant endTimestamp) {
        this.sourceTopic = sourceTopic;
        this.targetTopic = targetTopic;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public String getSourceTopic() {
        return sourceTopic;
    }

    public String getTargetTopic() {
        return targetTopic;
    }

    @JsonSerialize(using = InstantIsoSerializer.class)
    public Instant getStartTimestamp() {
        return startTimestamp;
    }

    @JsonSerialize(using = InstantIsoSerializer.class)
    public Instant getEndTimestamp() {
        return endTimestamp;
    }

    @Override
    public String toString() {
        return "OfflineRetransmissionRequest{" +
                "sourceTopic='" + sourceTopic + '\'' +
                ", targetTopic='" + targetTopic + '\'' +
                ", startTimestamp=" + startTimestamp +
                ", endTimestamp=" + endTimestamp +
                '}';
    }
}
