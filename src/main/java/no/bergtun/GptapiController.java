package no.bergtun;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

import java.util.List;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/gpt")
public class GptapiController {

    @Inject
    ChatGPTClient chatGPTClient;
    private final Memory memory;

    public GptapiController(Memory memory) {
        this.memory = memory;
    }

    @Get("/")
    public String index() {
        return "hello world";
    }

    @Get ("/chat")
    public ChatGPTResponse chat(String message) {
        var msg = new Message(message, "user");
        memory.addHistory(msg);
        var svar= chatGPTClient.getResponse(ChatGPTRequest.newFrom(memory.getHistory()));
        memory.addHistory(svar.choices().getFirst().message());
        return svar;
    }

    @Get ("/history")
    public List<Message>  histroy() {
        return memory.getHistory();
    }

    @Get("/clear")
    public HttpResponse clearHistory() {
        memory.clearHistory();
        return HttpResponse.ok();
    }

    @Get("/rename")
    public HttpResponse renameSystemMessage(String message) {
        memory.renameSystemMessage(message);
        return HttpResponse.ok();
    }
}
