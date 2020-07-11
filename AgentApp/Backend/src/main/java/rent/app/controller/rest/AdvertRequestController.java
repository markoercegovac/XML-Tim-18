package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rent.app.model.AdvertRequest;
import rent.app.service.AdvertRequestService;

import java.security.Principal;

@RequestMapping("/advert-request")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AdvertRequestController {

    private final AdvertRequestService advertRequestService;

    @PostMapping
    public void saveAdvertRequest (@RequestBody AdvertRequest advertRequest, Principal p) {

        advertRequest.setUserEmail(p.getName());
        advertRequestService.saveAdvertRequest(advertRequest);
    }
}
