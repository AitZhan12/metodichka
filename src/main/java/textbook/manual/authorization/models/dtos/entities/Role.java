package textbook.manual.authorization.models.dtos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import textbook.manual.authorization.models.audits.AuditModel;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AuditModel {
    public final static Long ROLE_ADMIN = 1L;
    public final static Long ROLE_USER = 2L;

    public final static String ROLE_USER_NAME = "USER_NAME";
    public final static String ROLE_ADMIN_NAME = "ADMIN_NAME";

    @Column(unique = true)
    private String name;
}
