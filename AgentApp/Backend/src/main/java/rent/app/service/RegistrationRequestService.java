package rent.app.service;


import rent.app.model.RegistrationRequest;

import java.util.ArrayList;

public interface RegistrationRequestService {

   void saveRequest(RegistrationRequest rq);

   ArrayList<RegistrationRequest> getAll();

   void removeRequestEmail(RegistrationRequest rq);

}
