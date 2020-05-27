package com.example.request.controller;

import com.example.request.dto.AdRequestForClientDTO;
import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.service.ClientRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/advert-request/client")
public class ClientController {

    private final ClientRequestService clientRequestService;

    /**
     * client creates a new advert request
     * @input: createRequestDTO
     * @output: 201 if created or 406
     * */
    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<String> postNewAdvertRequest(@RequestBody CreateAdBundleRequestDTO createBundle) {

        try {
            clientRequestService.createNewRequestBundle(createBundle);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch(Exception e) {
            //e.printStackTrace();
            return  new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * finds all advert requests that client has made and filters them by status
     * @input: in URL user's email and optional URL query status for filtering
     * @output: List of requests
     * */
    @GetMapping(value = "/{user_email}", produces = "application/json")
    public ResponseEntity<List<AdRequestForClientDTO>> getAllRequestsForClient(
            @PathVariable("user_email") String clientEmail,
            @RequestParam(value = "status", required = false) String status) {

        List<AdRequestForClientDTO> finedAds = new ArrayList<>();

        return new ResponseEntity<List<AdRequestForClientDTO>>(finedAds, HttpStatus.OK);
    }

    /**
     * client has paid for request; advert request state is PAID
     * @input: in URL request's id
     * @output: 200 OK
     **/
    @PutMapping(value = "/{request_id}")
    public ResponseEntity putRequestIsPaid(
            @PathVariable("request_id") Long requestId) {

        return new ResponseEntity(HttpStatus.OK);
    }

}
