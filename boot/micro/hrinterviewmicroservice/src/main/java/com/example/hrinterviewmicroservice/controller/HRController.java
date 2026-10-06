package com.example.hrinterviewmicroservice.controller;

import com.example.hrinterviewmicroservice.model.Candidate;
import com.example.hrinterviewmicroservice.service.HRService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hr")
public class HRController {

    private final HRService hrService;

    public HRController(HRService hrService) {
        this.hrService = hrService;
    }

    @PostMapping("/interview")
    public ResponseEntity<String> sendInterviewMessage(
            @RequestBody Candidate candidate) {

        String message =
                hrService.sendInterviewMessage(candidate);

        return ResponseEntity.ok(message);
    }
}