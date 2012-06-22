package in.co.zybotech.core.jackson.serializer;

import in.co.zybotech.core.DateUtils;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class DateTimeSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if (value != null) {
			jgen.writeString(DateUtils.formatDate(value,
					DateUtils.DATETIME_FORMAT));
		}
	}

}
