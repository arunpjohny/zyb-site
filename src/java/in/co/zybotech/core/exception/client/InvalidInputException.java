package in.co.zybotech.core.exception.client;

import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;


@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.BAD_REQUEST)
public class InvalidInputException extends ClientException {
	private static final long serialVersionUID = -8402179475459192649L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
	}

}
