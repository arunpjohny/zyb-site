package in.co.zybotech.core.exception.client;

import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;


@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.FORBIDDEN)
public class AccessDeniedException extends ClientException {
	private static final long serialVersionUID = -6175116407718378138L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}

}
