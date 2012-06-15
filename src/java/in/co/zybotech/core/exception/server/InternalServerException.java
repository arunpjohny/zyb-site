package in.co.zybotech.core.exception.server;

import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;

@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends ServerException {
	private static final long serialVersionUID = 755387186340229594L;

	public InternalServerException() {
		super();
	}

	public InternalServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public InternalServerException(String message) {
		super(message);
	}

	public InternalServerException(Throwable cause) {
		super(cause);
	}

}
