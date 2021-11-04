package pl.allegro.tech.hermes.api.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.Instant;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

public class InstantIsoDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Instant.from(ISO_INSTANT.parse(p.getText()));
    }
}
