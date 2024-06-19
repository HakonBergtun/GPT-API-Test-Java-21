package no.bergtun;

import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public record Tool(
    String type
) {

}
