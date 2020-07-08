package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;

import rent.app.principal.UserPrincipal;
import rent.app.service.ClientService;

import java.security.Permission;
import java.security.Principal;
import java.util.List;

@RequestMapping("/api/client")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/all-owners")
    public ResponseEntity<List<DTOEntity>> allClients(Principal principal){
        return new ResponseEntity<>(clientService.allOwnersThatAccepted(principal.getName()), HttpStatus.OK);
    }

}
