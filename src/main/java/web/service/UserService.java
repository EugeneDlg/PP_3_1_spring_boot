package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public User getUser(Integer id);

    public List<User> getUsers();

    public void createUser(String firstName, String lastName, String email, Integer age);

    public void updateUser(Integer id, String firstName, String lastName, String email, Integer age);

    public void deleteUser(Integer id);
}
