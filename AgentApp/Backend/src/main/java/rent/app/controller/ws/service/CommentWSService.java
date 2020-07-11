package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.AdvertRequest;
import rent.app.controller.ws.generate.CommentRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Advert;
import rent.app.model.Comment;
import rent.app.repository.AdvertRepository;
import rent.app.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class CommentWSService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AdvertRepository advertRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "commentRequest")
    @ResponsePayload
    public SoapResponse handleComment(@RequestPayload CommentRequest request){
        Comment comment= new Comment();
        comment.setId(request.getId()==0?null:request.getId());
        comment.setAuthor(request.getUserEmail());
        comment.setApproved(true);

        comment.setContent(request.getContent());
        Advert advert=advertRepository.findById(request.getId()).get();
        if(advert.getComments()!=null){
            advert.getComments().add(comment);
        }
        else{
            List<Comment> commentList=new ArrayList<>();
            commentList.add(comment);
            advert.setComments(commentList);
        }
        Comment saved=commentRepository.save(comment);
        advertRepository.save(advert);

        SoapResponse response = new SoapResponse();
        if(request.getId()==0) {
            response.setAgId(saved.getId());
            response.setStatus("CREATED");
        } else {
            response.setAgId(saved.getId());
            response.setStatus("UPDATED");
        }

        return response;
    }
}
