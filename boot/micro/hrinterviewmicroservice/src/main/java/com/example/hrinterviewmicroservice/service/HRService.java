package com.example.hrinterviewmicroservice.service;

import com.example.hrinterviewmicroservice.model.Candidate;

import org.springframework.stereotype.Service;

@Service
public class HRService {

    public String sendInterviewMessage(Candidate candidate) {

        return "Hello " + candidate.getName()
                + ", You have been selected for an interview.";
    }
}