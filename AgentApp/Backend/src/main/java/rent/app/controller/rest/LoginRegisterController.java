package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.RequestDto;
import rent.app.model.RegistrationRequest;
import rent.app.model.enums.RequestStatus;
import rent.app.service.ClientService;
import rent.app.service.EmailService;
import rent.app.service.RegistrationRequestService;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin
public class LoginRegisterController {

    private final EmailService emailService;

    private final RegistrationRequestService RQservice;

    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity registrujSe (@RequestBody RegistrationRequest rq) {

            rq.setStatus(RequestStatus.NEW);
            RQservice.saveRequest(rq);

            return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/admin/all/registration")
    public List<RegistrationRequest> getAll() {

            return RQservice.getAll();
    }

    @PostMapping("/admin/reject")
    public void deleteRequest (@RequestBody RegistrationRequest rq) {

            rq.setStatus(RequestStatus.REJECTED);
            RQservice.saveRequest(rq);
            emailService.sendMail(rq.getEmail(),"Vas zahtev je nazalost odbijen.","Odbijenica");


    }

    @PostMapping("/admin/request/approve")
    public void aproveRequest(@RequestBody RegistrationRequest rq) {

            rq.setStatus(RequestStatus.APPROVED);
            RQservice.saveRequest(rq);
            String url = "http://localhost:4200/create-client/"+rq.getEmail();
            emailService.sendMail(rq.getEmail(),"Vas aktivacioni link je: " + url, "Uspesno prihvacen zahtev." );

    }

    @PostMapping("/create-client/{email}")
    public void createClient(@PathVariable(value ="email") String email) {

        RegistrationRequest rq = RQservice.getByEmail(email);
        clientService.createClientFromRegistration(rq);


    }

}
