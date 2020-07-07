export interface MessageCreateModel {

	receiverEmail: string;
    senderEmail: string;
    ownerSending: boolean;
    header: string;
    content: string;
}