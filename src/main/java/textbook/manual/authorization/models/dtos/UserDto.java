package textbook.manual.authorization.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import textbook.manual.authorization.models.dtos.base.BaseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String login;

    private String password;

    private RoleDto role;
}
