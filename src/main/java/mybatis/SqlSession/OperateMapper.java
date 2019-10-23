package mybatis.SqlSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mybatis.dao.ShijingMapper;
import mybatis.dao.UserMapper;
import mybatis.entity.Shijing;
import mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.List;

public class OperateMapper {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String resource = "mybatis-cfg.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sessionFactory.openSession();
            ShijingMapper shijingMapper = session.getMapper(ShijingMapper.class);
            List<Shijing> list = getObjs();
            for (Shijing item : list) {
                shijingMapper.insertObj(item);
                //System.out.println(item.getTitle());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Shijing> getObjs() {
        String path = "E:\\shijing.json";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(new File(path));
            StringBuilder sb = new StringBuilder();
            char[] buffer = new char[1024];
            while (fileReader.read(buffer) != -1) {
                sb.append(buffer);
            }

            String json = sb.toString();
            System.out.println(json);
            TypeReference typeReference = new TypeReference<List<Shijing>>() {};
            List<Shijing> shijings = new ObjectMapper().readValue(json, typeReference);
            return shijings;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
