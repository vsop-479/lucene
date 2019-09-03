package training.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.io.IOException;
import java.util.Map;

public class JsonUtil {
    private static ObjectMapper jsonMapper = new ObjectMapper();
    private static ObjectMapper msgPackMapper = new ObjectMapper(new MessagePackFactory());
    private static TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String, Object>>() {};
    private static Logger logger = (Logger) LogManager.getLogger("JsonUtil");


    public static Map<String, Object> parse(byte[] value) {
        try {
            if (value[0] == '{') {
                return jsonMapper.readValue(value, typeReference);
            } else {
                return msgPackMapper.readValue(value, typeReference);
            }
        } catch (IOException e) {
            logger.error("", e);
            return null;
        }
    }

    public static String toString(Object o){
        try {
            if(o == null){
                return null;
            }
            return jsonMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            logger.error("", e);
            return null;
        }
    }
}
