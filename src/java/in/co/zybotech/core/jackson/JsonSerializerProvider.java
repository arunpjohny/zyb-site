package in.co.zybotech.core.jackson;

import java.util.List;

public interface JsonSerializerProvider {
	String getModuleName();

	List<JacksonSerializer<? extends Object>> getSerializers();
}
