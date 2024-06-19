package no.bergtun;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Message(
        String content,
        String role
) {

}
