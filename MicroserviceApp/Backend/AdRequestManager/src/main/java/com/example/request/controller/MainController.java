package com.example.request.controller;

import com.example.request.dto.AdRequestDetailedDTO;
import com.example.request.service.MainService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/advert-request")
public class MainController {
    /**
     * END POINT FOR CLIENT AND FOR OWNER
     * */

     private final MainService mainService;

    /**
     * shows detailed view of a requested user advert request
     * @input: in URL request's id
     * @output: detailed request
     **/
    @GetMapping(value = "/{request_id}", produces = "application/json")
    public ResponseEntity<AdRequestDetailedDTO> getDetailedRequestView(
            @PathVariable("request_id") Long requestId) {

        return new ResponseEntity<AdRequestDetailedDTO>( HttpStatus.OK);
    }

    /**
     * advert request is canceled; advert request state is CANCEL
     * @input: in URL request's id
     * @output: 200 OK
     **/
    @DeleteMapping(value = "/{request_id}")
    public ResponseEntity<String> deleteRequestIsCanceled(
            @PathVariable("request_id") Long requestId) {

        if(mainService.cancelBundle(requestId) == true) {
            return new ResponseEntity<String>("BUNDLE CANCELED", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("COULD NOT CANCEL REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

}