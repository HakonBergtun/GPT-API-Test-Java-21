//package no.bergtun;
//
//import jakarta.inject.Inject;
//import jakarta.inject.Singleton;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import io.micronaut.http.HttpRequest;
//
//class ChatGPTServiceImpl {
//    @Inject
//    ChatGPTClient chatGPTClient;
//
//    public String getResponse(ChatGPTRequest request) {
//        String apiKey = System.getenv("OPENAI_API_KEY");
//        if (apiKey == null || apiKey.isEmpty()) {
//            throw new RuntimeException("API key is missing");
//        }
//
//        String url = "https://api.openai.com/v1/chat/completions";
//        String body = new JSONObject()
//                .put("model", request.model)
//                .put("messages", new JSONArray()
//                        .put(new JSONObject()
//                                .put("role", "user")
//                                .put("content", request.message)))
//                .toString();
//
//        HttpRequest<?> httpRequest = HttpRequest.POST(url, body)
//                .header("Authorization", "Bearer " + apiKey)
//                .header("Content-Type", "application/json");
//
//        // Updating request in ChatGPTRequest object before actual HTTP call
//        request = new ChatGPTRequest(body);
//        return chatGPTClient.getResponse(request);
//    }
//}