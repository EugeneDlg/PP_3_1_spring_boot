package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
//    public String getUser(Integer id);
//
//    public List<User> getUsers();
//
//    public void createUser(User user);
//
//    public void updateUser(User user);
//
//    public void deleteUser(User user);

}
