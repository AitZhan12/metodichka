package textbook.manual.authorization.models.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import textbook.manual.authorization.models.dtos.base.BaseDto;


@Data
@NoArgsConstructor
public class RoleDto extends BaseDto {
    @ApiModelProperty(notes = "Наименование", readOnly = true)
    private String name;
}
