package web.Proj311.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.Proj311.model.User;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAllUser() {
        return em
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User findByIdUser(Long id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException(
                    "User with id: " + id + " not found"
            );
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteByIdUser(Long id) {
        User user = findByIdUser(id);
        em.remove(user);
    }
}
