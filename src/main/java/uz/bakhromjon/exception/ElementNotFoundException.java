package uz.bakhromjon.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 19/10/22, Wed, 09:56
 **/
@Getter
public class ElementNotFoundException extends RuntimeException {
    private HttpStatus status;

    public ElementNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }
}
