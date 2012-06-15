package in.co.zybotech.core.exception.conversion;

import in.co.zybotech.core.exception.ZybException;
import in.co.zybotech.web.utils.RequestUtils;
import in.co.zybotech.web.utils.RequestUtils.MessageType;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

public class CustomExceptionConverter implements
		Converter<ZybException, Map<String, Object>> {

	@Override
	public Map<String, Object> convert(ZybException ex) {
		if (!(ex instanceof Throwable)) {
			throw new IllegalArgumentException("Exception " + ex.getClass()
					+ " must be an instance of " + Throwable.class + ".");
		}
		Throwable e = (Throwable) ex;

		Map<String, Object> map = new HashMap<String, Object>();
		RequestUtils.addAjaxMessage(map, MessageType.ERROR, e.getMessage());
		return map;
	}

}
