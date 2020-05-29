package com.example.request.controller;

import com.example.request.dto.AdRequestForClientDTO;
import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.service.ClientRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/advert-request/client")
@CrossOrigin(origins = "http://localhost:4200")
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
            return new ResponseEntity("SUCCESSFULLY CREATED REQUEST BUNDLE", HttpStatus.CREATED);
        } catch(Exception e) {
            String errorMessage = e.getMessage();
            if(errorMessage == null || errorMessage.isEmpty()) {
                errorMessage = "TRIED TO RESERVED AN UN-EXISTING ADVERT ";
            }

            return  new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
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

        return new ResponseEntity<List<AdRequestForClientDTO>>(
                clientRequestService.findAllBunlesByStatus(clientEmail, status),
                HttpStatus.OK);
    }

    /**
     * client has paid for request; advert request state is PAID
     * @input: in URL request's id
     * @output: 200 OK
     **/
    @PutMapping(value = "/{request_id}")
    public ResponseEntity putRequestIsPaid(
            @PathVariable("request_id") Long requestId) {

        try {
            clientRequestService.clientPaid(requestId);
            return new ResponseEntity(HttpStatus.OK);
        } catch(NullPointerException e) {
            return new ResponseEntity("COULD NOT FIND ADVERT REQUEST", HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
