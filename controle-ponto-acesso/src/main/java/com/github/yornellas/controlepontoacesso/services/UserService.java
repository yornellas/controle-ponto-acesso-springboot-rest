package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.User;
import com.github.yornellas.controlepontoacesso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User obj = userRepository.getById(id);
        return userRepository.save(obj);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
