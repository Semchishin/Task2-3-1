package web.repository;

import web.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUserList();

    void addUser(User user);
    public User showUserById(long id);

    public void updateUser(long id, User user);


    void deleteUser(long id);
}
