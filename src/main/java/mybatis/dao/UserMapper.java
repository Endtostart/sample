package mybatis.dao;

import mybatis.entity.User;

public interface UserMapper {
    User selectUser(User user);
}
