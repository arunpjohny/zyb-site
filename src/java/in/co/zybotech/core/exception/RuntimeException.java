package in.co.zybotech.core.exception;

import in.co.zybotech.core.exception.conversion.CustomExceptionConverter;

@in.co.zybotech.core.exception.annotation.ExceptionMetadata(converter = CustomExceptionConverter.class)
public class RuntimeException extends java.lang.RuntimeException implements
		ZybException {
	private static final long serialVersionUID = 1L;

	public RuntimeException() {
		super();
	}

	public RuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeException(String message) {
		super(message);
	}

	public RuntimeException(Throwable cause) {
		super(cause);
	}

}
