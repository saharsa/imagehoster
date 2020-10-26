package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

  @Autowired
  private ImageService imageService;

  @Autowired
  private CommentService commentService;

  /**
   * Controller method for adding a new comment on a image
   *
   * @param text    Comment text
   * @param imageId Image id for which comment is being added
   * @param title   Image title for which comment is being added
   * @param session Session object stores the current logged in user information
   * @return Redirects to the image where the comment was being added
   */
  @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
  public String addComment(@RequestParam("comment") String text,
      @PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String title,
      HttpSession session) {
    Image image = imageService.getImage(imageId);
    User user = (User) session.getAttribute("loggeduser");
    commentService.addComment(text, user, image);
    return "redirect:/images/" + imageId + "/" + title;
  }

}
