package kata_task_2_3_1.dao;

import kata_task_2_3_1.model.User;

import java.util.List;

public interface UserDao {


    List<User> getAllUsers();

    void addUser(User user);

    User getSingleUser(int id);

    void deleteUser(int id);


}
