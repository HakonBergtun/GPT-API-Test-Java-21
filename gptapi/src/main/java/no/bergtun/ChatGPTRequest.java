package no.bergtun;

import io.micronaut.http.annotation.Get;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ChatGPTRequest (
        String model,
        List <Message> messages
){
    static ChatGPTRequest newFrom (String message) {
        return new ChatGPTRequest("gpt-3.5-turbo",List.of(new Message(message, "user")));
    }
}