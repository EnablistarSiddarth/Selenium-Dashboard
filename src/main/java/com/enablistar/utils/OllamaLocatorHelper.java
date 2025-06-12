package com.enablistar.utils;

import okhttp3.*;
import org.json.JSONObject;

public class OllamaLocatorHelper {
    private static final OkHttpClient client = new OkHttpClient();
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public static String getDynamicXPath(String prompt) throws Exception {
        JSONObject json = new JSONObject();
        json.put("model", "mistral");
        json.put("prompt", prompt);

        RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));
        Request request = new Request.Builder().url(OLLAMA_URL).post(body).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("Failed: " + response);

            JSONObject resJson = new JSONObject(response.body().string());
            return resJson.getString("response").trim();
        }
    }
}
