package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    void addUser(User user);

    public User showUserById(long id);

    public void updateUser(long id, User user);

    void deleteUser(long id);
}
