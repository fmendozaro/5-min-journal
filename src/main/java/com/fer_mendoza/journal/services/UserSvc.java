package com.fer_mendoza.journal.services;

import com.fer_mendoza.journal.models.User;
import com.fer_mendoza.journal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserSvc {

    @Autowired
    private UserRepository userRepo;

    public List<User> all(){
        return userRepo.findAll();
    }

    public User get(long id){
        return userRepo.getOne(id);
    }

    public User createOrUpdate(User userToBeSaved){
        return userRepo.save(userToBeSaved);
    }

    public void delete(long id){
        userRepo.deleteById(id);
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }

    public User findByUsername(String username){ return userRepo.findByUsername(username); }

}