package rent.app.service;

import rent.app.dto.DTOEntity;

import java.util.List;

public interface ClientService {
    List<DTOEntity> allOwnersThatAccepted(String customerEmail);
}
