package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.AdvertRequest;
import rent.app.repository.AdvertRequestRepository;
import rent.app.service.AdvertRequestService;

@Service
@AllArgsConstructor
public class AdvertRequestServiceImp  implements AdvertRequestService {

    private final AdvertRequestRepository advertRequestRepository;

    @Override
    public void saveAdvertRequest(AdvertRequest advertRequest) {
        advertRequestRepository.save(advertRequest);
    }
}
