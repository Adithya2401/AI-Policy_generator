package com.adithya.ai.controller;

import com.adithya.ai.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

    @Autowired
    private GeminiService geminiService;
@PostMapping("/generate")
public Map<String, String> generatePolicy(@RequestBody Map<String, String> request) {
    String prompt = request.get("prompt");
    String policyType = request.get("policyType");
    String orgName = request.get("orgName");
    String effectiveDate = request.get("effectiveDate");
    String version = request.get("version");
    String response = geminiService.generatePolicy(prompt, policyType, orgName, effectiveDate, version);
    return Map.of("response", response);
}

}
