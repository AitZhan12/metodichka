package textbook.manual.authorization.shared.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import textbook.manual.authorization.shared.codes.ErrorCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @JsonProperty("status")
    private String status = "error";

    @JsonProperty("code")
    private ErrorCode code;

    @JsonProperty("message")
    private String message;
}
