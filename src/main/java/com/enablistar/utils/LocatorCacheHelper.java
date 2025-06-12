package com.enablistar.utils;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class LocatorCacheHelper {
    private static final String CACHE_FILE = "locator_cache.json";
    private static Map<String, String> cache = new HashMap<>();

    static {
        try {
            File file = new File(CACHE_FILE);
            if (file.exists()) {
                String content = new String(Files.readAllBytes(file.toPath()));
                JSONObject json = new JSONObject(content);
                for (String key : json.keySet()) {
                    cache.put(key, json.getString(key));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading cache: " + e.getMessage());
        }
    }

    public static String getFromCache(String html) {
        return cache.get(html);
    }

    public static void addToCache(String html, String result) {
        cache.put(html, result);
        try (FileWriter writer = new FileWriter(CACHE_FILE)) {
            JSONObject json = new JSONObject(cache);
            writer.write(json.toString(2));
        } catch (Exception e) {
            System.out.println("Error writing cache: " + e.getMessage());
        }
    }
}
