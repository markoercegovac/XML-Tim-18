package com.example.request.controller;

import com.example.request.dto.CreateAdvertCopyDTO;
import com.example.request.dto.UpdateAdvertCopyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/advert-request")
public class DataSyncController {

    /**
     * ADVERT MANAGER SERVER HAS CREATED A NEW ADVERT
     * FOR DATA SYNC
     * @output: 201 CREATED
     **/
    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + DataSyncController.class.getName() +"] ";

    @PostMapping(value = "/advert-copy")
    public ResponseEntity postAdvertCopy(@RequestBody CreateAdvertCopyDTO createAdvertCopy) {
        logger.debug(className + "Kreiranje novog oglasa kopije sa id:" + createAdvertCopy.getAdvertId());

        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * ADVERT MANAGER SERVER HAS UPDATED ADVERT
     * FOR DATA SYNC
     * @output: 201 CREATED
     **/
    @PutMapping(value = "/advert-copy")
    public ResponseEntity postAdvertCopy(@RequestBody UpdateAdvertCopyDTO updateAdvertCopy) {
        logger.debug(className + "Izmena oglasa kopije sa id:" + updateAdvertCopy.getAdvertId());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * ADVERT MANAGER SERVER  HAS DELETED AN ADVERT
     * FOR DATA SYNC
     * @input: advert id
     * @output: 200 OK
     * */
    @DeleteMapping(value = "/advert-copy/{advert_id}")
    public ResponseEntity deleteAdvertInAdvertCopy(@PathVariable("advert_id") Long advertId) {
        logger.debug(className + "Brisanje oglasa kopije sa id:" + advertId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
