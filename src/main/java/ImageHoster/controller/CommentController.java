package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

  @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
  public String addComment(@RequestParam("comment") String text,
      @PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String title,
      Model model, HttpSession session) {
    Image image = imageService.getImage(imageId);
    Comment comment = new Comment();
    comment.setImage(image);
    User user = (User) session.getAttribute("loggeduser");
    comment.setUser(user);
    comment.setText(text);
    commentService.addComment(comment);
    return setImage(image, model);
  }

  private String setImage(Image image, Model model) {
    model.addAttribute("image", image);
    model.addAttribute("tags", image.getTags());
    model.addAttribute("comments", image.getComments());
    return "redirect:/images/" + image.getId() + "/" + image.getTitle();
  }

}
