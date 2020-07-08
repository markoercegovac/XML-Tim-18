package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import rent.app.dto.ClientDto;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;
import rent.app.model.Client;
import rent.app.model.Reservation;
import rent.app.model.ReservationRequest;
import rent.app.repository.ClientRepository;
import rent.app.repository.ReservationRepository;
import rent.app.repository.ReservationRequestRepository;
import rent.app.repository.RoleRepository;
import rent.app.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {


    private final ReservationRequestRepository reservationRequestRepository;
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final DtoUtils dtoUtils;

    @Override
    public List<DTOEntity> allOwnersThatAccepted(String customerEmail) {
        List<ReservationRequest> emailList= new ArrayList<>();
        List<String> emailsForFinds=new ArrayList<>();

        if(reservationRequestRepository.findAllByCustomerEmailAndIsAccepted(customerEmail,true).isEmpty()){
            emailList=reservationRequestRepository.findAllByOwnerEmailAndIsAccepted(customerEmail,true);
            emailList.forEach(r->{emailsForFinds.add(r.getCustomerEmail()); });
        }
        else {
            emailList=reservationRequestRepository.findAllByCustomerEmailAndIsAccepted(customerEmail,true);
            emailList.forEach(r->{emailsForFinds.add(r.getOwnerEmail());});
        }
        List<Client> ownersThatAcceptedRequest=clientRepository.findAllById(emailsForFinds);
        return ownersThatAcceptedRequest.stream().map(c->dtoUtils.convertToDto(c,new ClientDto())).collect(Collectors.toList());
    }
}
