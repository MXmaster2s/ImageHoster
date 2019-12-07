package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void uploadComment(Comment comment) {
        commentRepository.uploadComment(comment);
    }

    public void updateComment (Comment updatedComment) {
        commentRepository.updateComment(updatedComment);
    }

    public void deleteComment (Integer commentId) {
        commentRepository.deleteComment(commentId);
    }

    public List<Comment> getComments (Image image){
        commentRepository.getComment(image);
        return null;
    }


}
