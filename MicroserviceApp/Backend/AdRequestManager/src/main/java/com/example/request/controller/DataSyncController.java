package com.example.request.controller;

import com.example.request.dto.CreateAdvertCopyDTO;
import com.example.request.dto.UpdateAdvertCopyDTO;
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
    @PostMapping(value = "/advert-copy")
    public ResponseEntity postAdvertCopy(@RequestBody CreateAdvertCopyDTO createAdvertCopy) {

        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * ADVERT MANAGER SERVER HAS UPDATED ADVERT
     * FOR DATA SYNC
     * @output: 201 CREATED
     **/
    @PutMapping(value = "/advert-copy")
    public ResponseEntity postAdvertCopy(@RequestBody UpdateAdvertCopyDTO updateAdvertCopy) {

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

        return new ResponseEntity(HttpStatus.OK);
    }
}
