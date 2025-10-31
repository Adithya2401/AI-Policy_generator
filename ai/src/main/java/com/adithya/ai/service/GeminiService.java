package com.adithya.ai.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
@Service
public class GeminiService {
    @Value("${gemini.api.key}")
    private String apiKey;

    public String generatePolicy(String prompt, String policyType, String orgName, String effectiveDate, String version) {
    String enrichedPrompt = String.format(
        "Policy Type: %s\nOrganization: %s\nEffective Date: %s\nVersion: %s\n\nRequirement/Context: %s",
        policyType, orgName, effectiveDate, version, prompt
    );

    String apiUrl = "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" + apiKey;
    try {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> requestBody = Map.of(
            "contents", List.of(
                Map.of("parts", List.of(Map.of("text", enrichedPrompt)))
            )
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, requestBody, Map.class);

        List candidates = (List) response.getBody().get("candidates");
        if (candidates != null && !candidates.isEmpty()) {
            Map first = (Map) candidates.get(0);
            Map content = (Map) first.get("content");
            List parts = (List) content.get("parts");
            if (parts != null && !parts.isEmpty()) {
                Map textPart = (Map) parts.get(0);
                return (String) textPart.get("text");
            }
        }

        return "No response from Gemini.";
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

}
