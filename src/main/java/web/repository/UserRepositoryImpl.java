package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> getUserList() {
        return em.createQuery("from User ").getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
        em.flush();
    }
    @Override
    public User showUserById(long id) {
        return em.find(User.class, id);
    }
    @Override
    public void updateUser(User user){
       em.merge(user);
       em.flush();
    }

    @Override
    public void deleteUser(long id) {
        em.remove(showUserById(id));
        em.flush();
    }
}
