package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.DTOEntity;
import rent.app.dto.PriceDto;
import rent.app.service.PriceService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/api/price")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class PriceController {

    private final PriceService priceService;

    @PostMapping
    public void createPrice(@RequestBody PriceDto priceDto, Principal principal){
        priceService.createPrice(priceDto,principal.getName());
    }

    @GetMapping("/allPrices")
    public ResponseEntity<List<DTOEntity>> getAllPrices(Principal principal){
        return new ResponseEntity<>(priceService.allPrices(principal.getName()), HttpStatus.OK);
    }
}
