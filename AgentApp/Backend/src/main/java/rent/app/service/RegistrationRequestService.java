package rent.app.service;


import rent.app.dto.RequestDto;
import rent.app.model.RegistrationRequest;

import java.util.ArrayList;
import java.util.List;

public interface RegistrationRequestService {

   void saveRequest(RegistrationRequest rq);

  List<RegistrationRequest> getAll();

   void removeRequestEmail(RequestDto rq);

}
