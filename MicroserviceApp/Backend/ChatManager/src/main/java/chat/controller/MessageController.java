package chat.controller;

import chat.dto.LongMessageDTO;
import chat.dto.SeenMessage;
import chat.dto.SendMessageDTO;
import chat.dto.ShortMessageDTO;
import chat.service.CommunicationService;
import chat.service.ReadMessageService;
import chat.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat-server")
// @CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private final ReadMessageService readMessageService;
    private final SendMessageService sendMessageService;
    private final CommunicationService communicationService;

    /**
     * returns all messages that I have send or that I have received
     * @input user's email; and optional request param that has users email for showing only messages that are with that specific user
     * @output all my messages in short form
     * */
    @GetMapping(value = "/message/{user_email}")
    public ResponseEntity<Set<ShortMessageDTO>> getAllMyMessage(
            @PathVariable("user_email") String userEmail,
            @RequestParam(value = "owner", required = true) boolean isOwner,
            @RequestParam(value = "to", required = false) String to) {

        Set<ShortMessageDTO> foundMessages;

        try {
            if (to == null || to.strip().isEmpty()) {
                foundMessages = readMessageService.readAllMessages(userEmail, isOwner);
            } else {
                foundMessages = readMessageService.readAllMessageExchange(userEmail, isOwner, to);
            }
            return new ResponseEntity<Set<ShortMessageDTO>>(foundMessages, HttpStatus.OK);
        } catch(NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<Set<ShortMessageDTO>>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * returns a specific message
     * @input  message id
     * @output concert message with detail
     * */
    @GetMapping(value = "/message/detail/{message_id}")
    public ResponseEntity<LongMessageDTO> getSpecificMessage(@PathVariable("message_id") Long id) {

        try {
            LongMessageDTO message = readMessageService.readDetailMessage(id);
            return new ResponseEntity<LongMessageDTO>(message,HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<LongMessageDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/message/{email}/can-communicate")
    public ResponseEntity<Set<String>> getAllUsersThatICanCommunicateWith(
            @PathVariable("email") String userEmail,
            @RequestParam(value = "owner", required = true) boolean isOwner) {

        try {
            Set<String> ret = communicationService.getAllForCommunication(userEmail, isOwner);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * returns YES if we have an unread message or NO
     * @input user's email;
     * @output string YES or NO
     * */
    @GetMapping(value = "/message/{user_email}/new-messages")
    public ResponseEntity<String> getNewMessages(@PathVariable("user_email") String userEmail) {

        return new ResponseEntity<String>("YES", HttpStatus.OK);
    }

    /**
     * User has seen a message; and sets seen feald
     * @input DTO with messageID and users email
     * @output 201 or 406
     * */
    @PutMapping(value = "/message")
    public ResponseEntity putMessageSeen(@RequestBody SeenMessage seenMessage) {

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Creates a new message
     * @input message
     * @output 201 or 406
     * */
    @PostMapping(value = "/message")
    public ResponseEntity postNewMessages(@RequestBody SendMessageDTO sendMessage) {
        HttpStatus status = HttpStatus.CREATED;

        try {
            sendMessageService.send(sendMessage);
        } catch(Exception e) {
            e.printStackTrace();
            status = HttpStatus.NOT_ACCEPTABLE;
        }

        return new ResponseEntity(status);
    }
}
