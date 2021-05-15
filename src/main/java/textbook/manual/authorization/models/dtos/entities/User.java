package textbook.manual.authorization.models.dtos.entities;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import textbook.manual.authorization.models.audits.AuditModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User extends AuditModel {

    @NotNull(message = "first_name is required")
    private String firstName;

    @NotNull(message = "last_name is required")
    private String lastName;

    @NotNull(message = "phone_number is required")
    private String phoneNumber;

    @NotNull(message = "login is required")
    private String login;

    @NotNull(message = "password is required")
    private String password;

    @ManyToOne
    @NotNull(message = "role is required")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Role role;

}
