package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void createUser(String firstName, String lastName,
                           String email, Integer age) {
        userRepository.save(new User(firstName, lastName, email, age));
    }

    @Transactional
    @Override
    public void updateUser(Integer id, String firstName, String lastName,
                           String email, Integer age) {
        User user = getUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAge(age);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        User user = getUser(id);
        userRepository.delete(user);
    }
}
