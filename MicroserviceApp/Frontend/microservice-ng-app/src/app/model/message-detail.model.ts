export interface MessageDetailModel {

	messageId: number;
    receiverEmail: string;
    senderEmail: string;
    header: string;
    content: string;
    creationDate: Date;
}