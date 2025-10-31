package com.adithya.ai.controller;

import com.adithya.ai.model.Policy;
import com.adithya.ai.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/policies/generate")
public class PolicyDatabaseController {

    @Autowired
    private PolicyRepository repository;

    @PostMapping
    public Policy savePolicy(@RequestBody Policy policy) {
        policy.setCreatedAt(LocalDateTime.now().toString());
        return repository.save(policy);
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return repository.findAll();
    }
}
