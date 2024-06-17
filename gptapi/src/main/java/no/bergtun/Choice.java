package no.bergtun;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Choice(
        int index,
        Message message,
//        LogProbs logprobs,
        String finish_reason
) {
}
