export interface RegistrationRequestModel {

	email: string;
    username: string;
    name: string;
    surname: string;
    companyName: string;
    companyRegistrationNumber: string;
    state: string;
    street: string;
	streetNumber: string;
	city: string;
    url: string;
    role: string;//USER, FIRM, AGENT
}