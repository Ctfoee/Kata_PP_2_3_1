package kata_task_2_3_1.service;

import kata_task_2_3_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getSingleUser(int id);

    void deleteUser(int id);
}
