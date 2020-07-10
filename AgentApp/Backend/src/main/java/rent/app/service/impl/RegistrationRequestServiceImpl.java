package rent.app.service.impl;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.RequestDto;
import rent.app.model.RegistrationRequest;
import rent.app.model.enums.RequestStatus;
import rent.app.repository.RegistrationRequestRepository;
import rent.app.service.RegistrationRequestService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    private final RegistrationRequestRepository repository;

    @Override
    public void saveRequest(RegistrationRequest rq) {

            rq.setUsername(rq.getEmail());

            repository.save(rq);

    }

    @Override
    public List<RegistrationRequest> getAll() {
        return repository.findAllByStatus(RequestStatus.NEW);
    }


    @Override
    public void removeRequestEmail(RequestDto rq) {
        repository.deleteById(rq.getEmail());
    }

    @Override
    public RegistrationRequest getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
