package com.SpringwithRest1.RestSpring.Q2;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ttn on 7/3/21.
 */
@Component
public class UsersService {
    static List<User> Users = new ArrayList<>();
    static int idCount =3;
    static {
        Users.add(new User(1,"Akash",23));
        Users.add(new User(2,"Mayank",24));
        Users.add(new User(3,"manoj",25));
    }

    //find all Users
    public List<User> findAll(){

        return Users;
    }
    //add Users to List
    public User save(User employe){
           employe.setId(++idCount);
        Users.add(employe);
        return employe;
    }
    //findOneUsers
    public User findOne(int id){
        for(User list:Users){
            if(list.getId()==id){
                return list;
            }
        }
        return null;
    }
    //delete Users
    public User deleteById(int id){
        Iterator<User>iterator=Users.iterator();
        while(iterator.hasNext()){
            User list = iterator.next();
            if(list.getId()==id){
                iterator.remove();
                return list;
            }

        }
        return null;
    }
    public User updateById(int id, User user){
        Iterator<User>iterator=Users.iterator();
        while(iterator.hasNext()){
            User User1= iterator.next();
            if (User1.getId()==id){
                User1.setName(user.getName());
                return User1;

            }

        }
        return null;
    }
}
