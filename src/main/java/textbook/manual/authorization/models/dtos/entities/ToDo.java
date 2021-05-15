package textbook.manual.authorization.models.dtos.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean done;
    private Date createdAt;

    @PrePersist
    public void prePersist(){
        this.done = false;
        this.createdAt = new Date();
    }
}
