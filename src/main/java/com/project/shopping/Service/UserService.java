package com.project.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.shopping.model.Users;
import com.project.shopping.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository user;

    public void create(Users use) {

        user.save(use);
    }

    public List<Users> retrive() {
        return user.findAll();
    }

    public Optional<Users> retriveOne(int userId) {
        return user.findById(userId);
    }

    public List<Users> getName(String name) {
        return user.findByName(name);
    }

    public void delete(int id) {
        user.deleteById(id);
    }

    // public Users updateById(int id, Users updateuser) {
    //     Optional<Users> userId=user.findById(id);
    //     if(userId.isPresent()){
    //         Users userUpdate=userId.get();
    //         userUpdate.setName(updateuser.getName());
    //         userUpdate.setGender(updateuser.getGender());
    //         userUpdate.setEmail(updateuser.getEmail());
    //         userUpdate.setAddress(updateuser.getAddress());
    //         userUpdate.setPassword(updateuser.getPassword());
    //         userUpdate.setPhoneNumber(updateuser.getPhoneNumber());

          
    //         return(user.save(userUpdate));

    //     }
    //     else{
    //         return null;
    //     }
    // }

}
