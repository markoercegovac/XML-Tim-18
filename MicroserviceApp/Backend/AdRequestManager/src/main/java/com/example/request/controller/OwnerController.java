package com.example.request.controller;

import com.example.request.dto.AdRequestForOwnerDTO;
import com.example.request.model.AdvertStateEnum;
import com.example.request.service.OwnerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/advert-request/owner")
public class OwnerController {

    private final OwnerService ownerService;

    /**
     * finds all advert requests for owner; most important is status PENDING
     * @input: in URL owner's email and optional URL query status for filtering
     * @output: List of requests
     **/
    @GetMapping(value = "/{user_email}", produces = "application/json")
    public ResponseEntity<List<AdRequestForOwnerDTO>> getAllRequestsForOwner(
            @PathVariable("user_email") String ownerEmail,
            @RequestParam(value = "status", required = false) AdvertStateEnum status) {

        List<AdRequestForOwnerDTO> foundAds = new ArrayList<>();

		try {
			foundAds = ownerService.findOwnersAdByState(ownerEmail, status);

			return new ResponseEntity<List<AdRequestForOwnerDTO>>(foundAds, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<List<AdRequestForOwnerDTO>>(HttpStatus.BAD_REQUEST);
		}

    }

    /**
     * owner has approved this request(Bundle); advert request state is APPROVED
     * @input: in URL request's id
     * @output: 200 OK
     **/
    @PutMapping(value = "/{request_id}")
    public ResponseEntity<String> putRequestIsApproved(
            @PathVariable("request_id") Long requestId) {

		try {
			ownerService.approvBundle(requestId);
			return new ResponseEntity<String>("APPROVED", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
    }
}
