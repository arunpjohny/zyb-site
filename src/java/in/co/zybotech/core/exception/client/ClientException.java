package in.co.zybotech.core.exception.client;

import in.co.zybotech.core.exception.RequestProcessingException;
import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;


@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.BAD_REQUEST)
public class ClientException extends RequestProcessingException {
	private static final long serialVersionUID = -3490566405110396993L;

	public ClientException() {
		super();
	}

	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientException(String message) {
		super(message);
	}

	public ClientException(Throwable cause) {
		super(cause);
	}

}
