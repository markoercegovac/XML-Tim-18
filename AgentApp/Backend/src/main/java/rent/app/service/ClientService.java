package rent.app.service;

import rent.app.model.RegistrationRequest;

public interface ClientService {

    void createClientFromRegistration(RegistrationRequest rq);
}
