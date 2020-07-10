package rent.app.controller.rest;

import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.DTOEntity;
import rent.app.dto.MessageDto;
import rent.app.service.MessageService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/api/message")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public void sendMessage(@RequestBody MessageDto messageDto, Principal principal){
        messageDto.setSender(principal.getName());
        messageService.saveMessage(messageDto);
    }

    @GetMapping("/inbox")
    public ResponseEntity<List<DTOEntity>> getInbox(Authentication authentication){
        return new ResponseEntity<>(messageService.getInbox(authentication.getName()), HttpStatus.OK);
    }
    @GetMapping("/sent")
    public ResponseEntity<List<DTOEntity>> getSent(Authentication authentication){
        return new ResponseEntity<>(messageService.getSentMessages(authentication.getName()),HttpStatus.OK);
    }

}
