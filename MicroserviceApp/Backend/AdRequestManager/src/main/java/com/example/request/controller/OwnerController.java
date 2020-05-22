package com.example.request.controller;

import com.example.request.dto.AdRequestForOwnerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/advert-request/owner")
public class OwnerController {

    /**
     * finds all advert requests for owner; most important is status PENDING
     * @input: in URL owner's email and optional URL query status for filtering
     * @output: List of requests
     **/
    @GetMapping(value = "/{user_email}", produces = "application/json")
    public ResponseEntity<List<AdRequestForOwnerDTO>> getAllRequestsForOwner(
            @PathVariable("user_email") String ownerEmail,
            @RequestParam(value = "status", required = false) String status) {

        List<AdRequestForOwnerDTO> finedAds = new ArrayList<>();

        return new ResponseEntity<List<AdRequestForOwnerDTO>>(finedAds, HttpStatus.OK);
    }

    /**
     * owner has approved this request; advert request state is APPROVED
     * @input: in URL request's id
     * @output: 200 OK
     **/
    @PutMapping(value = "/{request_id}")
    public ResponseEntity putRequestIsApproved(
            @PathVariable("request_id") Long requestId) {

        return new ResponseEntity(HttpStatus.OK);
    }
}
