package kata_task_2_3_1.dao;

import kata_task_2_3_1.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getSingleUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getSingleUser(id));
    }
}
