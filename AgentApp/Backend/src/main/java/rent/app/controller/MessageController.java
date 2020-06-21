package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.DTOEntity;
import rent.app.dto.MessageDto;
import rent.app.service.MessageService;

import java.util.List;

@RequestMapping("/api/message")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public void sendMessage(@RequestBody MessageDto messageDto){
        messageService.saveMessage(messageDto);
    }


    // IZMENITI KAD DODJE SECURITY
    @GetMapping("/inbox")
    public ResponseEntity<List<DTOEntity>> getInbox(){
        return new ResponseEntity<>(messageService.getInbox("erceg"), HttpStatus.OK);
    }
    @GetMapping("/sent")
    public ResponseEntity<List<DTOEntity>> getSent(){
        return new ResponseEntity<>(messageService.getSentMessages("erceg"),HttpStatus.OK);
    }

    @GetMapping("/inbox/test")
    public ResponseEntity<List<DTOEntity>> getInboxTest(){
        return new ResponseEntity<>(messageService.getInbox("test"), HttpStatus.OK);
    }
    @GetMapping("/sent/test")
    public ResponseEntity<List<DTOEntity>> getSentTest(){
        return new ResponseEntity<>(messageService.getSentMessages("test"),HttpStatus.OK);
    }
}
