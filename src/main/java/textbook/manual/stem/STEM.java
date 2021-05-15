package textbook.manual.stem;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "stem")
public class STEM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;



}
