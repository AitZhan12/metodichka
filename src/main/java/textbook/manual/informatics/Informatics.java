package textbook.manual.informatics;

import lombok.Data;
import textbook.manual.books.Books;
import textbook.manual.topics.Topics;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "informatics")
public class Informatics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int grade;
}
