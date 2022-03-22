package com.example.usersapi;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserService {


    public UserRepository repository;

    public UserService (UserRepository repository){
        this.repository = repository;
    }



    public User createUser( User user) {
        this.repository.save(user);
        return user;
    }
    public List<User> getUserList (){
        List<User> users = new ArrayList<>();
        this.repository.findAll().forEach(users::add);

//        for  (User u :this.repository.findAll()){
//            users.add (u);
//        }
        return users;
    }

    public void deleteUsers (){
        this.repository.deleteAll();
      //  userList.clear();

    }
    public  User getUser(String id) throws Exception {
        return this.repository.findById(id).get();
    }
    public void deleteUser(String id) throws Exception {
        this.repository.deleteById(id);
//        User user = findUser (id);
//        userList.remove(user);
//        return user;
    }
    public User updateUser (String userId, User userToUpdate) throws Exception {
        User user = getUser (userId);
       // User user = findUser (userId);
        user.setEmail(userToUpdate.getEmail());
        user.setGender(userToUpdate.getGender());
        user.setPassword(userToUpdate.getPassword());
        repository.save(user);
        return user;
    }
   /* private User findUser(String userId) throws Exception {
        for (User currentUser : userList){
            if (currentUser.getId().equals(userId)){
                return currentUser;
            }
        }
        throw new Exception();
    }*/
}
