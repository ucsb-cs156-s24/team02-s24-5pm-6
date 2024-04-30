package edu.ucsb.cs156.example.controllers;

import edu.ucsb.cs156.example.entities.RecommendationRequest;
import edu.ucsb.cs156.example.entities.UCSBDate;
import edu.ucsb.cs156.example.errors.EntityNotFoundException;
import edu.ucsb.cs156.example.repositories.RecommendationRequestRepository;
import edu.ucsb.cs156.example.repositories.UCSBDateRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.time.LocalDateTime;
@Tag(name = "recommendationreq")
@RequestMapping("/api/recommendationrequest") //where is the proper api name?
@RestController
@Slf4j
public class RecommendationRequestController extends ApiController{
    @Autowired
    RecommendationRequestRepository recommendationRequestRepository;
    @GetMapping("/all")
    public Iterable<RecommendationRequest> allEmails() {
        Iterable<RecommendationRequest> emails = recommendationRequestRepository.findAll();
        return emails;
    }
    /*String requesterEmail;
  String professorEmail;
  String explanation;
  LocalDateTime dateRequested;
  LocalDateTime dateNeeded;
  boolean done; */
    @PostMapping("/post")
    public RecommendationRequest postRecommendationRequest(
            @Parameter(name="requesterEmail") @RequestParam String requesterEmail,
            @Parameter(name="professorEmail") @RequestParam String professorEmail,
            @Parameter(name="explanation") @RequestParam String explanation,
            @Parameter(name="done") @RequestParam boolean done,
            @Parameter(name="dateRequested (in iso format, e.g. YYYY-mm-ddTHH:MM:SS; see https://en.wikipedia.org/wiki/ISO_8601)") @RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateRequested)
            /*throws JsonProcessingException*/, //does this get included?!!
            @Parameter(name="dateNeeded (in iso format, e.g. YYYY-mm-ddTHH:MM:SS; see https://en.wikipedia.org/wiki/ISO_8601)") @RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateNeeded)
            throws JsonProcessingException
            {

        // For an explanation of @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        // See: https://www.baeldung.com/spring-date-parameters

        log.info("localDateTime={}", localDateTime);

        RecommendationRequest recRequest = new RecommendationRequest();
        recRequest.setRequesterEmail(requesterEmail);
        recRequest.setProfessorEmail(professorEmail);
        recRequest.setExplanation(explanation);
        recRequest.setDone(done);
        recRequest.setDateRequested(dateRequested);
        recRequest.setDateNeeded(dateNeeded);

        RecommendationRequest savedRecRequest = RecommendationRequestRepository.save(recRequest);

        return savedUcsbDate;
    }
}

//idk how line 56 will work, can't push this change yet I need that fixed
//finished up to step 5