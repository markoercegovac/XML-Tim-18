package chat.convertor;

import chat.dto.LongMessageDTO;
import chat.dto.ShortMessageDTO;
import chat.model.DirectionEnum;
import chat.model.Message;

public abstract class MessageConverter {

    public static ShortMessageDTO messageToShort(Message msg) throws NullPointerException {

        String sender;
        if(msg.getDirection().equals(DirectionEnum.FOR_OWNER)) {
            sender = msg.getValidUserOwnerCommunication().getOwnerEmail();
        } else {
            sender = msg.getValidUserOwnerCommunication().getUserEmail();
        }

        ShortMessageDTO dto = new ShortMessageDTO();
        dto.setCreationDate(msg.getCreationDate());
        dto.setFromUser(sender);
        dto.setHeader(msg.getHeader());
        dto.setMessageId(msg.getMessageId());

        return dto;
    }

    public static LongMessageDTO messageToLong(Message msg) throws NullPointerException {

        String sender;
        String receiver;
        if(msg.getDirection().equals(DirectionEnum.FOR_OWNER)) {
            sender = msg.getValidUserOwnerCommunication().getOwnerEmail();
            receiver = msg.getValidUserOwnerCommunication().getUserEmail();
        } else {
            sender = msg.getValidUserOwnerCommunication().getUserEmail();
            receiver = msg.getValidUserOwnerCommunication().getOwnerEmail();
        }

        LongMessageDTO dto = new LongMessageDTO();
        dto.setCreationDate(msg.getCreationDate());
        dto.setHeader(msg.getHeader());
        dto.setMessageId(msg.getMessageId());
        dto.setContent(msg.getContent());
        dto.setReceiverEmail(receiver);
        dto.setSenderEmail(sender);

        return dto;
    }
}
