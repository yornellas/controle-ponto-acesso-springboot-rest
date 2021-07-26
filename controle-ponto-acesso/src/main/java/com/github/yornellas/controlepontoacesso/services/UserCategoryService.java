package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.UserCategory;
import com.github.yornellas.controlepontoacesso.repositories.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    @Autowired
    UserCategoryRepository userCategoryRepository;

    public List<UserCategory> findAll() {
        return userCategoryRepository.findAll();
    }

    public Optional<UserCategory> findById(Long id) {
        return userCategoryRepository.findById(id);
    }

    public UserCategory insert(UserCategory userCategory) {
        return userCategoryRepository.save(userCategory);
    }

    public UserCategory update(Long id, UserCategory userCategory) {
        UserCategory obj = userCategoryRepository.getById(id);
        return userCategoryRepository.save(obj);
    }

    public void deleteById(Long id) {
        userCategoryRepository.deleteById(id);
    }

}
