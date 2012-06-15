package in.co.zybotech.core.exception.client;

import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;

@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ClientException {
	private static final long serialVersionUID = 9222202159771218104L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

}
