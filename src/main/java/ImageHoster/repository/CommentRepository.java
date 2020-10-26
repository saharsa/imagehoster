package ImageHoster.repository;

import ImageHoster.model.Comment;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

  //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
  @PersistenceUnit(unitName = "imageHoster")
  private EntityManagerFactory emf;

  /**
   * Creates a new row in the 'comment' table
   * @param newComment New comment object that should be saved in the database
   * @return
   */
  public Comment addComment(Comment newComment) {
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

}
