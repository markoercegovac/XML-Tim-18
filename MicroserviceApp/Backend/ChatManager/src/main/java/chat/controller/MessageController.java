package chat.controller;

import chat.dto.LongMessageDTO;
import chat.dto.SeenMessage;
import chat.dto.SendMessageDTO;
import chat.dto.ShortMessageDTO;
import chat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat-server")
public class MessageController {


    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + MessageController.class.getName() +"] ";
    private final MessageService messageService;

    /**
     * JUST A TEST END POINT FOR DOCKER
     * */
    @GetMapping(value = "/test", produces = "application/text")
    public ResponseEntity<String> getTest() {
        logger.debug(className + "Test");
        System.out.println("TEST");
        return new ResponseEntity<>("TEST PORUKA JE POSLATA :)", HttpStatus.CREATED);
    }

    /**
     * returns all messages that I have send or that I have received
     * @input user's email; and optional request param that has users email for showing only messages that are with that specific user
     * @output all my messages in short form
     * */
    @GetMapping(value = "/message/{user_email}")
    public ResponseEntity<ShortMessageDTO> getAllMyMessage(@PathVariable("user_email") String userEmail, @RequestParam(value = "to", required = false) String to) {
        logger.debug(className + "Preuzmi poruke sa id: "+ userEmail);
        return new ResponseEntity<ShortMessageDTO>(HttpStatus.OK);
    }

    /**
     * returns a specific message
     * @input user's email and message id
     * @output concert message with detail
     * */
    @GetMapping(value = "/message/{user_email}/{message_id}")
    public ResponseEntity<LongMessageDTO> getSpecificMessage(@PathVariable("user_email") String userEmail, @PathVariable("message_id") Long id) {
        logger.debug(className + "Preuzmi specijalne poruke sa id: "+ userEmail);
        //hardcoded; for docker test
        return new ResponseEntity<LongMessageDTO>(messageService.getSpecificMessage(userEmail, id),HttpStatus.OK);
    }

    /**
     * returns YES if we have an unread message or NO
     * @input user's email;
     * @output string YES or NO
     * */
    @GetMapping(value = "/message/{user_email}/new-messages")
    public ResponseEntity<String> getNewMessages(@PathVariable("user_email") String userEmail) {
        logger.debug(className + "Preuzmi nove poruke sa id: "+ userEmail);
        return new ResponseEntity<String>("YES", HttpStatus.OK);
    }

    /**
     * User has seen a message; and sets seen feald
     * @input DTO with messageID and users email
     * @output 201 or 406
     * */
    @PutMapping(value = "/message")
    public ResponseEntity putMessageSeen(@RequestBody SeenMessage seenMessage) {
        logger.debug(className + "Poruka seen");
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Creates a new message
     * @input message
     * @output 201 or 406
     * */
    @PostMapping(value = "/message")
    public ResponseEntity postNewMessages(@RequestBody SendMessageDTO sendMessage) {
        logger.debug(className + "Kreiraj novu poruku");
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
