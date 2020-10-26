package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  public void addComment(Comment newComment) {
    newComment.setCreatedDate(LocalDate.now());
    commentRepository.addComment(newComment);
  }

}
