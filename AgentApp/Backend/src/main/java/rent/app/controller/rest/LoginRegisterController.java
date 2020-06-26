package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.RequestDto;
import rent.app.model.RegistrationRequest;
import rent.app.service.EmailService;
import rent.app.service.RegistrationRequestService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin
public class LoginRegisterController {

    private final EmailService emailService;

    private final RegistrationRequestService service;

    @PostMapping("/register")
    public ResponseEntity registrujSe (@RequestBody RegistrationRequest rq) {

            service.saveRequest(rq);

            return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/admin/all/registration")
    public List<RegistrationRequest> getAll() {

            return service.getAll();
    }

    @PostMapping("/admin/reject")
    public void deleteRequest (@RequestBody RequestDto rq) {
            emailService.sendMail(rq.getEmail(),"Vas zahtev je nazalost odbijen.","Odbijenica");
            service.removeRequestEmail(rq);

    }

    @PostMapping("/admin/request/approve")
    public void aproveRequest(@RequestBody RequestDto rq) {


            String url = "http://localhost:9090/create-client/"+rq.getEmail();
            emailService.sendMail(rq.getEmail(),"Vas aktivacioni link je: " + url, "Uspesno prihvacen zahtev." );

    }

}
