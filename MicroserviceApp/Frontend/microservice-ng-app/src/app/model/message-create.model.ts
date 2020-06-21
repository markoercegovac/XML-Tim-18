export interface MessageCreateModel {

	receiverEmail: string;
    senderEmail: string;
    isOwnerSending: boolean;
    header: string;
    content: string;
}