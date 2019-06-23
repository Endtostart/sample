package serialize.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JacksonSelf implements JsonSelf{

    Logger logger = LoggerFactory.getLogger(JacksonSelf.class);

    private ObjectMapper mapper;

    public JacksonSelf(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void init() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
    }

    @Override
    public String serialize(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.info("序列化失败");
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public <T> T deSerialize(String json, TypeTab<T> tab) {
        if (tab != null && tab instanceof TypeReference) {
            try {
                return mapper.readValue(json, tab);
            } catch (IOException e) {
                logger.info("反序列化失败");
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> T deSerialize(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.info("反序列化失败");
            e.printStackTrace();
        }
        return null;
    }
}
