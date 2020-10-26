package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.CommentRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  /**
   * Creates a new comment object with the data provided and saves it in database
   *
   * @param text  Comment text
   * @param user  Current logged in user
   * @param image Image for which comment is being added
   */
  public void addComment(String text, User user, Image image) {
    if (text != null && user != null && image != null) {
      Comment newComment = new Comment();
      newComment.setImage(image);
      newComment.setUser(user);
      newComment.setText(text);
      newComment.setCreatedDate(LocalDate.now());
      commentRepository.addComment(newComment);
    }

  }

}
