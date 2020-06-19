package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.AdvertDto;
import rent.app.service.AdvertService;
import rent.app.service.PictureService;

import java.io.IOException;

@RequestMapping("/api/advert")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public void createAdvert(@RequestBody AdvertDto advertDto) throws IOException {

        advertService.saveAdvert(advertDto);
    }
}
