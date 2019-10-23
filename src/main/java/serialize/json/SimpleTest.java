package serialize.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import entityDemo.Country;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SimpleTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "china");
        map.put("populatioin", "");
        //map.put("status", "");
        //JsonSelf self = new GsonSelf(new Gson());
        JsonSelf self = new JacksonSelf(new ObjectMapper());
        String json = self.serialize(map);
        System.out.println("序列化结果：" + json);
        Country country = self.deSerialize(json, Country.class);
        System.out.println(country.getPopulatioin());

        // bean 拷贝 空字符串转Integer
        System.out.println("========= bean 拷贝 ============");
        country = new Country();
        BeanUtils.copyProperties(country, map);
        System.out.println(country.getPopulatioin());
    }
}
