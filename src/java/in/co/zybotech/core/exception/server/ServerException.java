package in.co.zybotech.core.exception.server;

import in.co.zybotech.core.exception.RequestProcessingException;
import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;

@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RequestProcessingException {
	private static final long serialVersionUID = -4204670287552119243L;

	public ServerException() {
		super();
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable cause) {
		super(cause);
	}

}
