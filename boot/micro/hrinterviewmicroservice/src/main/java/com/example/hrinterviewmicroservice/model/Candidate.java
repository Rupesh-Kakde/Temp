package com.example.hrinterviewmicroservice.model;

public class Candidate {

    private int candidateId;
    private String name;
    private String email;

    public Candidate() {
    }

    public Candidate(int candidateId, String name, String email) {
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}