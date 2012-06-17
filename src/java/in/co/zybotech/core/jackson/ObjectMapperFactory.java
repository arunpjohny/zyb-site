package in.co.zybotech.core.jackson;

import in.co.zybotech.core.jackson.deserializer.DateDeserializer;
import in.co.zybotech.core.jackson.serializer.DateSerializer;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ObjectMapperFactory implements FactoryBean<ObjectMapper> {

	Collection<JsonSerializerProvider> providers = null;

	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		Map<String, JsonSerializerProvider> beans = applicationContext
				.getBeansOfType(JsonSerializerProvider.class);
		providers = beans.values();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObjectMapper getObject() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
		AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
		AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary,
				secondary);

		mapper.getDeserializationConfig().setAnnotationIntrospector(pair);
		mapper.getSerializationConfig().setAnnotationIntrospector(pair);

		SimpleModule module = new SimpleModule("Core", new Version(1, 0, 0,
				"Base"));
		module.addSerializer(Date.class, new DateSerializer());

		module.addDeserializer(Date.class, new DateDeserializer());

		mapper.registerModule(module);

		for (JsonSerializerProvider provider : providers) {
			module = new SimpleModule(provider.getModuleName(), new Version(1,
					0, 0, "Base"));
			List<JacksonSerializer<? extends Object>> serializers = provider
					.getSerializers();
			if (CollectionUtils.isNotEmpty(serializers)) {
				for (JacksonSerializer<? extends Object> jacksonSerializer : serializers) {
					if (jacksonSerializer.getSerializer() != null) {
						module.addSerializer((Class) jacksonSerializer
								.getTargetClass(),
								(JsonSerializer) jacksonSerializer
										.getSerializer());
					}
					if (jacksonSerializer.getDeserializer() != null) {
						module.addDeserializer((Class) jacksonSerializer
								.getTargetClass(),
								(JsonDeserializer) jacksonSerializer
										.getDeserializer());
					}
				}
			}
			mapper.registerModule(module);
		}

		return mapper;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
