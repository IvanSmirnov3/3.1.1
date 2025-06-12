package web.Proj311.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Proj311.dao.UserDao;
import web.Proj311.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByIdUser(Long id) {
        return userDao.findByIdUser(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void deleteByIdUser(Long id) {
        userDao.deleteByIdUser(id);
    }
}
