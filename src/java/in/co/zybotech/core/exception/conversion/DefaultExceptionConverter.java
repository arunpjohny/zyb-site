package in.co.zybotech.core.exception.conversion;

import in.co.zybotech.web.utils.RequestUtils;
import in.co.zybotech.web.utils.RequestUtils.MessageType;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

public class DefaultExceptionConverter implements
		Converter<Exception, Map<String, Object>> {

	public static Converter<Exception, Map<String, Object>> getInstance() {
		return new DefaultExceptionConverter();
	};

	@Override
	public Map<String, Object> convert(Exception ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		RequestUtils.addAjaxMessage(map, MessageType.ERROR,
				"Unknown server error occured!");
		return map;
	}

}
