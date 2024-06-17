package no.bergtun;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("https://api.openai.com/v1")
@Header(name = "Authorization", value = "Bearer ${chatGPT.apikey}")
public interface ChatGPTClient {
    @Post("/chat/completions")
    ChatGPTResponse getResponse(@Body ChatGPTRequest request);
}