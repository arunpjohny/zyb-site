package in.co.zybotech.core.exception.server;

import in.co.zybotech.core.exception.annotation.ExceptionMetadata;
import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

import org.springframework.http.HttpStatus;

@ExceptionMetadata(converter = CustomExceptionConverter.class, status = HttpStatus.NOT_IMPLEMENTED)
public class OperationNotImplementedException extends ServerException {
	private static final long serialVersionUID = 1732892747400928985L;

	public OperationNotImplementedException() {
		super();
	}

	public OperationNotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationNotImplementedException(String message) {
		super(message);
	}

	public OperationNotImplementedException(Throwable cause) {
		super(cause);
	}

}
