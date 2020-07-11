package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CommentClient;
import rent.app.controller.ws.generate.CommentRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Comment;
import rent.app.repository.AdvertRepository;

@Component
@Aspect
@RequiredArgsConstructor
public class CommentAspect {

    private final CommentClient commentClient;
    private final AdvertRepository advertRepository;

    @AfterReturning(pointcut = "execution(* rent.app.service.impl.CommentServiceImpl.addNewComment(..))", returning = "comment")
    public void afterSavedComment(JoinPoint joinPoint, Comment comment){
        CommentRequest request=new CommentRequest();
        request.setId(comment.getId());
        request.setContent(comment.getContent());
        request.setToken("firm@com");
        request.setAdvertId(advertRepository.findByCommentsId(comment.getId()).getId());
        SoapResponse response = commentClient.handleComment(request);
        System.out.println("STATUS: "+ response.getStatus());

    }

}
