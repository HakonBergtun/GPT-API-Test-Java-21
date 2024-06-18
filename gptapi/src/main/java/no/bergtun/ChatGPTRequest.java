package no.bergtun;

import io.micronaut.http.annotation.Get;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ChatGPTRequest (
        String model,
        List<Message> messages,
        List<Tool> tools
){
    static ChatGPTRequest newFrom (List<Message> messages) {
        return new ChatGPTRequest("gpt-3.5-turbo", messages, List.of(new Tool("")));
    }
}