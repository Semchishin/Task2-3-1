package web.service;

import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;
import web.repository.UserRepositoryImpl;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }


    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User showUserById(long id) {
      return userRepository.showUserById(id);
    }
    @Override
    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }
}
