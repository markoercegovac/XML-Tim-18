package com.example.request.controller;

import com.example.request.dto.AdRequestDetailedDTO;
import com.example.request.service.TestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final TestService service;

    /**
     * shows detailed view of a requested user advert request
     * @input: in URL request's id
     * @output: detailed request
     **/
    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + MainController.class.getName() +"] ";

    @GetMapping(value = "/{request_id}", produces = "application/json")
    public ResponseEntity<AdRequestDetailedDTO> getDetailedRequestView(
            @PathVariable("request_id") Long requestId) {

        AdRequestDetailedDTO finedAd = service.getSpecificBundleWithoutRequests(requestId);
        logger.debug(className + "Detaljan pregled zahteva oglasa sa id:" + requestId);
        return new ResponseEntity<AdRequestDetailedDTO>(finedAd, HttpStatus.OK);
    }

    /**
     * advert request is canceled; advert request state is CANCEL
     * @input: in URL request's id
     * @output: 200 OK
     **/
    @DeleteMapping(value = "/{request_id}")
    public ResponseEntity deleteRequestIsCanceled(
            @PathVariable("request_id") Long requestId) {
        logger.debug(className + "Brisanje zahteva oglasa sa id:" + requestId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
