package rent.app.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.RegistrationRequest;
import rent.app.repository.RegistrationRequestRepository;
import rent.app.service.RegistrationRequestService;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    private final RegistrationRequestRepository repository;

    @Override
    public void saveRequest(RegistrationRequest rq) {

            rq.setUsername(rq.getEmail());
            repository.save(rq);

    }

    @Override
    public ArrayList<RegistrationRequest> getAll() {
        return (ArrayList<RegistrationRequest>) repository.findAll();
    }

    @Override
    public void removeRequestEmail(RegistrationRequest rq) {
        repository.deleteById(rq.getEmail());
    }
}
