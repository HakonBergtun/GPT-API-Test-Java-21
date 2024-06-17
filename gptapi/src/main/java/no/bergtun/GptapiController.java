package no.bergtun;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/gpt")
public class GptapiController {

    @Inject
    ChatGPTClient chatGPTClient;

    @Get("/")
    public String index() {
        return "hello world";
    }


    @Get ("/chat")
    public String chat(String message) {
        return chatGPTClient.getResponse(ChatGPTRequest.newFrom(message));
    }
}
