package com.example.advertmanagerapp.controller;


import ch.qos.logback.core.net.server.Client;
import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.service.ClientCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("advert-manager/client-copy")
@RestController
@CrossOrigin
public class ClientCopyController {


    private final ClientCopyService service;

    @GetMapping("/all")
    public List<ClientCopy> getAllUsers() {

        //ovo je za sad,inace se radi u bazi,ali nece da prepozna findAllByIsRemoved
        List<ClientCopy> cclist = service.getAllUsers();
        for(ClientCopy cc : cclist) {
            if(cc.isRemoved()==true)
                cclist.remove(cc);
        }
        return cclist;
    }

    @DeleteMapping
    public void logicDeleteOfUser(@RequestBody ClientCopy clientCopy) {

        service.delete(clientCopy);
    }

}
