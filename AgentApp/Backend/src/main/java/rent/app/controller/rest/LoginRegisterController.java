package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import rent.app.model.RegistrationRequest;
import rent.app.service.EmailService;
import rent.app.service.RegistrationRequestService;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LoginRegisterController {

    private final EmailService emailService;

    private final RegistrationRequestService service;

    @PostMapping("/register")
    public ResponseEntity registrujSe (@RequestBody RegistrationRequest rq) {

            service.saveRequest(rq);

            return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/admin/all/registration")
    public ArrayList<RegistrationRequest> getAll() {

            return service.getAll();
    }

    @PostMapping("/admin/reject")
    public void deleteRequest (@RequestBody RegistrationRequest rq) {
            emailService.sendMail(rq.getEmail(),"Vas zahtev je nazalost odbijen.","Odbijenica");
            service.removeRequestEmail(rq);

    }

    @PostMapping("/admin/aprove")
    public  void aproveRequest(@RequestBody RegistrationRequest rq) {

            String url = "http://localhost:9090/create-client/"+rq.getEmail();
            emailService.sendMail(rq.getEmail(),"Vas aktivacioni link je: " + url, "Uspesno prihvacen zahtev." );

    }

}
