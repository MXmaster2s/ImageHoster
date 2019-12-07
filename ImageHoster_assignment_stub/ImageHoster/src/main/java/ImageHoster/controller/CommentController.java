package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;


    @RequestMapping("comment")
    public String getImageComments(Image image) {
        List<Comment> comment = commentService.getComments(image);
        return "comment";
    }

    @RequestMapping(value = "/images/comment", method = RequestMethod.POST)
    public String createComment(@RequestParam("file") MultipartFile file, @PathVariable("id") Integer id, Comment newComment, HttpSession session) throws IOException {

        User user = (User) session.getAttribute("loggeduser");
        newComment.setUser(user);
        return "redirect:/images";
    }
}
