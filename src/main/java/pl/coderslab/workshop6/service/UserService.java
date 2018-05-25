package pl.coderslab.workshop6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop6.entity.User;
import pl.coderslab.workshop6.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
