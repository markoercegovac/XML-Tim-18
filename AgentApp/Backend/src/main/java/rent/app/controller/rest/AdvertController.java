package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.*;
import rent.app.model.Reservation;
import rent.app.service.AdvertService;
import rent.app.service.PictureService;
import rent.app.service.ReservationService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RequestMapping("/api/advert")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AdvertController {

    private final AdvertService advertService;
    private final ReservationService reservationService;

    @PostMapping
    public void createAdvert(@RequestBody AdvertDto advertDto,Principal principal) throws IOException {

        advertService.saveAdvert(advertDto,principal.getName());
    }

    @GetMapping("/allAdverts")
    public ResponseEntity<List<AdvertMiniDto>> allAdverts() throws IOException {
        return new ResponseEntity<>(advertService.getAllAdverts(), HttpStatus.OK);
    }

    @GetMapping("/myAdverts")
    public ResponseEntity<List<DTOEntity>> myAdverts(Principal principal) throws IOException {
        return new ResponseEntity<>(advertService.getAllMyAdverts(principal.getName()),HttpStatus.OK);
    }

    @PostMapping("/reservation")
    public void reservation(@RequestBody ReservationDto reservationDto){
        reservationService.reservation(reservationDto);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<List<DTOEntity>> getCarModel(@PathVariable("id") Long id){
        return new ResponseEntity<>(reservationService.allReservationForAdvert(id),HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<AdvertFullDto> getAdvert(@PathVariable("id") Long id) throws IOException {
        return new ResponseEntity<>(advertService.getAdvert(id),HttpStatus.OK);
    }



}
