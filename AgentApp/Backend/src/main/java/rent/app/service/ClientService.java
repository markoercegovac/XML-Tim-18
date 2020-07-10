package rent.app.service;

import rent.app.dto.DTOEntity;
import rent.app.model.RegistrationRequest;

import java.util.List;

public interface ClientService {

    void createClientFromRegistration(RegistrationRequest rq);
    List<DTOEntity> allOwnersThatAccepted(String customerEmail);
}
