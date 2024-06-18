package no.bergtun;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Tool(
    String type
) {

}
