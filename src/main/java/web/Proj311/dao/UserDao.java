package web.Proj311.dao;

import web.Proj311.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();
    void addUser(User user);
    void deleteByIdUser(Long id);
    void updateUser(User user);
    User findByIdUser(Long id);
}
