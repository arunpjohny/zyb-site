package in.co.zybotech.core.jackson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

public class JacksonUtils {

	private static JacksonUtils me;

	private ObjectMapper mapper;

	public JacksonUtils(ObjectMapper mapper) {
		super();
		this.mapper = mapper;

		JacksonUtils.me = this;
	}

	public static JacksonUtils getInstance() {
		return me;
	}

	public <P, Q> void registerModule(String moduleName,
			Map<Class<? extends P>, JsonSerializer<P>> serializerMap,
			Map<Class<Q>, JsonDeserializer<? extends Q>> deserializerMap) {
		SimpleModule module = new SimpleModule(moduleName, new Version(1, 0, 0,
				"Base"));

		Set<Entry<Class<? extends P>, JsonSerializer<P>>> serializerEntrySet = serializerMap
				.entrySet();
		for (Entry<Class<? extends P>, JsonSerializer<P>> entry : serializerEntrySet) {
			module.addSerializer(entry.getKey(), entry.getValue());
		}

		Set<Entry<Class<Q>, JsonDeserializer<? extends Q>>> deserializerEntrySet = deserializerMap
				.entrySet();
		for (Entry<Class<Q>, JsonDeserializer<? extends Q>> entry : deserializerEntrySet) {
			module.addDeserializer(entry.getKey(), entry.getValue());
		}
		registerModule(module);
	}

	public void registerModule(SimpleModule module) {
		mapper.registerModule(module);
	}

	public void writeValue(Object value, Writer writer)
			throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(writer, value);
	}

	public <T> T readValue(Reader reader, Class<T> requiredType)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(reader, requiredType);
	}
}
