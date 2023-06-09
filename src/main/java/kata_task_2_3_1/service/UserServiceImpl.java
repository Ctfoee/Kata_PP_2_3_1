package kata_task_2_3_1.service;



import kata_task_2_3_1.dao.UserDao;
import kata_task_2_3_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        if (user.validate(validator())) {
            userDao.addUser(user);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getSingleUser(int id) {
        return userDao.getSingleUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public Validator validator() {
        try(ValidatorFactory vf = Validation.buildDefaultValidatorFactory()) {
            return vf.getValidator();
        }
    }
}
