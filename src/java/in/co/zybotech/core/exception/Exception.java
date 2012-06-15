package in.co.zybotech.core.exception;

import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;
import in.co.zybotech.core.exception.annotation.ExceptionMetadata;

@ExceptionMetadata(converter = CustomExceptionConverter.class)
public class Exception extends java.lang.Exception implements ZybException {
	private static final long serialVersionUID = 1L;

	public Exception() {
		super();
	}

	public Exception(String message, Throwable cause) {
		super(message, cause);
	}

	public Exception(String message) {
		super(message);
	}

	public Exception(Throwable cause) {
		super(cause);
	}

}
