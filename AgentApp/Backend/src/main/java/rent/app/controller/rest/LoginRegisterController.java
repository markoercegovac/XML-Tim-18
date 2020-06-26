package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import rent.app.model.RegistrationRequest;
import rent.app.service.RegistrationRequestService;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class LoginRegisterController {

    private final RegistrationRequestService service;

    @PostMapping("/register")
    public ResponseEntity registrujSe (@RequestBody RegistrationRequest rq) {

            service.saveRequest(rq);

            return new ResponseEntity(HttpStatus.OK);

    }

}
