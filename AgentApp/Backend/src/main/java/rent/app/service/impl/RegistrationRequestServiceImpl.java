package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.RegistrationRequest;
import rent.app.repository.RegistrationRequestRepository;
import rent.app.service.RegistrationRequestService;

@Service
@AllArgsConstructor
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    private final RegistrationRequestRepository repository;

    @Override
    public void saveRequest(RegistrationRequest rq) {
        repository.save(rq);
    }
}
