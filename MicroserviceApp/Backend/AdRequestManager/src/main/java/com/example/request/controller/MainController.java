package com.example.request.controller;

import com.example.request.dto.AdRequestDetailedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/advert-request")
public class MainController {
    /**
     * END POINT FOR CLIENT AND FOR OWNER
     * */

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
    public ResponseEntity deleteRequestIsCanceled(
            @PathVariable("request_id") Long requestId) {

        return new ResponseEntity(HttpStatus.OK);
    }

}