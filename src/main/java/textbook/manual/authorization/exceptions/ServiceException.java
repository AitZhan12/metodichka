package textbook.manual.authorization.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import textbook.manual.authorization.shared.codes.ErrorCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends Exception {
    protected String message;
    protected ErrorCode errorCode;
}
