package mybatis.SqlSession;

import mybatis.dao.UserMapper;
import mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OperateMapper {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String resource = "mybatis-cfg.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = sessionFactory.openSession();

            User user = new User();
            user.setName("wang");

            UserMapper userMapper = session.getMapper(UserMapper.class);
            user = userMapper.selectUser(user);
            user = userMapper.selectUser(user);
            System.out.println("User: name = "+user.getName() + "addr = "+user.getAddr() + "id = "+user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
