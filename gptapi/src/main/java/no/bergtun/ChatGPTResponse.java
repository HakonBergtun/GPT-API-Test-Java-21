package no.bergtun;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ChatGPTResponse(
        String id,
        String object,
        long created,
        String model,
        List<Choice> choices,
       // Usage usage,
        String system_fingerprint
) {

}
