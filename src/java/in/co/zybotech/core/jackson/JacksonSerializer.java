package in.co.zybotech.core.jackson;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;

public class JacksonSerializer<T> {
	private Class<? extends T> targetClass;

	private JsonSerializer<? extends T> serializer;

	private JsonDeserializer<? extends T> deserializer;

	public JacksonSerializer() {
	}

	public JacksonSerializer(Class<? extends T> targetClass,
			JsonSerializer<? extends T> serializer,
			JsonDeserializer<? extends T> deserializer) {
		super();
		this.targetClass = targetClass;
		this.serializer = serializer;
		this.deserializer = deserializer;
	}

	public Class<? extends T> getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(Class<? extends T> targetClass) {
		this.targetClass = targetClass;
	}

	public JsonSerializer<? extends T> getSerializer() {
		return serializer;
	}

	public void setSerializer(JsonSerializer<? extends T> serializer) {
		this.serializer = serializer;
	}

	public JsonDeserializer<? extends T> getDeserializer() {
		return deserializer;
	}

	public void setDeserializer(JsonDeserializer<? extends T> deserializer) {
		this.deserializer = deserializer;
	}

}
