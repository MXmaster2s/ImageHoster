package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit
    @PersistenceUnit(unitName = "commentHoster")
    private EntityManagerFactory emf;

    //method to upload a new comment
    public Comment uploadComment(Comment newComment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;
    }

    //method to update the existing comment
    public void updateComment(Comment updatedComment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //method to delete the existing comment
    public void deleteComment (Integer commentId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Comment comment = em.find(Comment.class, commentId);
            em.remove(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public Comment getComment (Image image) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> typedQuery = em.createQuery("SELECT i from Comment i where i.id =:commentId", Comment.class).setParameter("image", image);
        Comment comment = typedQuery.getSingleResult();
        return comment;
    }
}
