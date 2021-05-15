package textbook.manual.topics;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="topics")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String thesis;
    private String link;
    private int category;
}
