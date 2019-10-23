package temp.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Work {
    public static void main(String[] args) throws ClassNotFoundException, JsonProcessingException {
        Map<String, String> fieldMap = new HashMap<>();
        Field[] fields =PublicClassListResponse.class.getDeclaredFields();
        for (Field field : fields) {
            String valueType = getTypeDesc(field.getType());
            if (field.getName().indexOf("Url") != -1) {
                valueType = "@url";
            }
            System.out.println(field.getName() + ":" + valueType);
            fieldMap.put(field.getName(), valueType);

        }

        System.out.println("==========================================\n\n");
        String json = new ObjectMapper().writeValueAsString(fieldMap);
        System.out.println(json);
        Integer aa = null;
        System.out.println(aa != null);

    }

    private static String getTypeDesc(Type type) {
        String name = type.getTypeName();
        if (String.class.getTypeName().equals(name)) {
            if (name.indexOf("Url") != -1) {
                return "@url";
            }
            return "@string";
        } else if (Integer.class.getTypeName().equals(name) || "int".equals(name)) {
            return "@integer";
        } else if (Date.class.getTypeName().equals(name)) {
            return "@datetime";
        } else if (Boolean.class.getTypeName().equals(name)) {
            return "@boolean";
        }
        return "无法匹配格式";
    }
}
