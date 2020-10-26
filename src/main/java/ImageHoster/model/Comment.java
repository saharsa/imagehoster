package ImageHoster.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  //@Column annotation specifies that the attribute will be mapped to the column in the database.
  //Here the column name is explicitly mentioned as 'id'
  @Column(name = "id")
  private Integer id;

  @Column(name = "text")
  private String text;

  @Column(name = "created_date")
  private LocalDate createdDate;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "image_id", nullable = false)
  private Image image;

  public Comment() {

  }

  public Comment(Integer id, String text, LocalDate createdDate, User user,
      Image image) {
    this.id = id;
    this.text = text;
    this.createdDate = createdDate;
    this.user = user;
    this.image = image;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
